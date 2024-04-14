package views.systemUser;

import java.util.Map;

import models.systemUsers.SystemUser;
import repository.systemUsersRepository.SystemUserRepository;
import views.logger.services.DebugLogger;
import views.systemUser.services.SystemUserCreator;

import java.util.Scanner;

public class SystemUserView {
    public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_YELLOW = "\u001B[33m";

    SystemUserRepository systemUserRepository = SystemUserRepository.getInstance();

    private Map<String, SystemUser> users = systemUserRepository.users;


SystemUserCreator userCreator = SystemUserCreator.getSystemUserCreator();
DebugLogger logger = DebugLogger.getLogger();

        Scanner scanner = new Scanner(System.in);




    public void showMenu() {

        boolean exit = false;

        
        while (!exit) {
            System.out.println(ANSI_CYAN + "Menu:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "1. Display users" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "2. Create users" + ANSI_RESET);

            System.out.println(ANSI_YELLOW + "3. Get user by name" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "4. Exit\n\n" + ANSI_RESET);
            logger.printInfo("Enter your choice from the menu: ");
            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please choose a number between 1 and 4.");
                scanner.nextLine(); // Consume newline character
                continue;
            }
            // ...

            switch (choice) {
            case 1:
                displayUsers();
                break;

            case 2:

                createUsers();
                showMenu();
                break;
            case 3:

                System.out.print("Enter the name of the user: ");
                String name = scanner.next();
                SystemUser user = getUserByName(name);
                if (user != null) {
                    logger.logSuccess("User found: " + user.getName());
                } else {
                    logger.logError("User not found.");
                }

                showMenu();
                break;
            case 4:
                exit = true;
                logger.printInfo("Exiting...");
                break;
            default:
                logger.logError("Invalid choice. Please try again.");
                break;
            }
        }

        

    }


    // create a function that displays the users in the map,users
    public void displayUsers() {

        if (!users.isEmpty()) {
            System.out.println(ANSI_CYAN + "Available users:" + ANSI_RESET);
            System.out.println(ANSI_YELLOW + "-----------------" + ANSI_RESET);
            for (SystemUser user : users.values()) {
                String username = user.getName();
                System.out.println(ANSI_YELLOW + "- " + username + ANSI_RESET);
            }
            System.out.println(ANSI_YELLOW + "-----------------" + ANSI_RESET);
        }
        else {
            logger.logError("No users found!");
        }
    }
    

    // create a function that gets a user by name
    public SystemUser getUserByName(String name) {
        for (SystemUser user : users.values()) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null; // return null if no matching user is found
    }
    


    public void createUsers() {

        int userNumber;


        System.out.println("As a system admin, enter how many users you want to create");
        userNumber = scanner.nextInt();
        if (userNumber > 0 && userNumber < 4) {
            for (var i = 0; i < userNumber; i++) {
                SystemUser user = null;

                while (user == null) {
                    System.out.println(
                            "Enter the type of user you want to create (AD for admin, HC for Healthcare provider, FI for Chief Finance Officer):");
                    String userType = scanner.next();
                    user = userCreator.createUser(userType);
                }
                System.out.println("Enter username please........");

                String username = scanner.next();
                user.setName(username);
                systemUserRepository.addUser(user);
            }

        }
       
        else {
            logger.logError("No Admin User found.");
        }

        logger.printInfo("List of Users:");

        displayUsers();
    }

}
