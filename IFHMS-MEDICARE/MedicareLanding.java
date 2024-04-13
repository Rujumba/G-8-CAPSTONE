import java.util.Map;
import java.util.Scanner;
import models.systemUsers.SystemUser;
import repository.systemUsersRepository.SystemUserRepository;
import views.accountReconcilation.AccountReconciliationView;
import views.logger.services.DebugLogger;
import views.messages.ChatView;
import views.patient.PatientView;
import views.systemUser.services.SystemUserCreator;



public class MedicareLanding {

    public static void main(String[] args) {
        SystemUserRepository userRepository = SystemUserRepository.getInstance();
        Map<String, SystemUser> users = userRepository.users;


SystemUserCreator userCreator = SystemUserCreator.getSystemUserCreator();
DebugLogger logger = DebugLogger.getLogger();

int userNumber;

Scanner scanner = new Scanner(System.in);
 logger.printInfo("-------- IHFMS MEDICARE--------");

        System.out.println("Thanks for choosing IHFMS");
        System.out.println();
        System.out.println("As a system admin, enter how mnay users you want to create");
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
                userRepository.addUser(user);
            }

        }
        SystemUser adminUser = users.values().stream()
            .filter(user -> user.getRole().equalsIgnoreCase("AD"))
            .findFirst()
            .orElse(null);

        if (adminUser != null) {
            System.out.println("Admin User found: " + adminUser.getName());
        } else {
            System.out.println("No Admin User found.");
        }




        System.out.println("List of Users:");

        userRepository.printUsers();
        
        boolean exit = false;

        while (!exit) {
            System.out.println("\033[0;34m"); // Blue color
System.out.println("-----------------------------------------------------");
System.out.println("|                  Main Menu                          |");
System.out.println("-----------------------------------------------------");
System.out.println("|                                                   |");
System.out.println("| Choose an option:                                 |");
System.out.println("|                                                   |");
System.out.println("| \033[0;32m1. Patients\033[0;34m");
System.out.println("| \033[0;32m2. Services Offered\033[0;34m");          
System.out.println("| \033[0;32m3. Payments\033[0;34m");
System.out.println("| \033[0;32m4. Chat\033[0;34m");
System.out.println("| \033[0;32m5. Accounts\033[0;34m");
System.out.println("| \033[0;32m6. Exit\033[0;34m");
System.out.println("|                                                   |");
System.out.println("-----------------------------------------------------");
System.out.print("\033[0m"); // Reset color
System.out.print("Enter your choice: ");

            int choice;

            // Validate input to ensure it's an integer
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                switch (choice) {
                    case 1:
                        PatientView patientView = new PatientView();
                        patientView.choosePatientOption();
                        break;
                    case 2:
//                        System.out.println("You chose Services Offered.");
//                        MedicalServiceView newView = new MedicalServiceView();
//                        newView.displayMedicalService();
                        break;
                    case 3:
                        System.out.println("You chose Payments.");

                        // Add your Payments functionality here
                        break;
                    case 4:
                        ChatView chatView = new ChatView(adminUser);
                        chatView.getMenu();

 
                        break;
                    case 5:
                        System.out.println("You chose Accounts.");
                        AccountReconciliationView accountReconciliationView = new AccountReconciliationView();
                        accountReconciliationView.displayReconciliationView();
                        break;
                    case 6:
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 6.");
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
                scanner.next(); // Consume invalid input
            }
        }
        scanner.close();
    }

}
