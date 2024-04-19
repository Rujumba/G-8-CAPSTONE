import java.util.Map;
import java.util.Scanner;
import models.systemUsers.SystemUser;
import repository.systemUsersRepository.SystemUserRepository;
import views.accountReconcilation.AccountReconciliationView;
import views.messages.ChatView;
import views.patient.PatientView;
import views.systemUser.SystemUserView;





public class IHFMS {
          public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_BOLD = "\u001B[1m";

    public static void main(String[] args) {
        SystemUserRepository systemUserRepository = SystemUserRepository.getInstance();

      Map<String, SystemUser> users = systemUserRepository.users;
  
      Scanner scanner = new Scanner(System.in);
        


System.out.println(ANSI_CYAN + ANSI_BOLD + "Welcome to the Integrated Health Finance Management System (IHFMS) - Medicare" + ANSI_RESET);
System.out.println("--------------------------------------------------");
System.out.println("This system integrates health information systems with finance, accounts, and messaging functionalities to streamline operations and enhance internal communication.");
System.out.println("--------------------------------------------------");
System.out.println("Please select an option from the menu:");

        boolean exit = false;

        while (!exit) {
            System.out.println("\033[0;34m"); // Blue color
            System.out.println("-----------------------------------------------------");
            System.out.println("|                  Main Menu                          |");
            System.out.println("-----------------------------------------------------");
            System.out.println("|                                                   |");
            System.out.println("| Choose an option:                                 |");
            System.out.println("|                                                   |");
            System.out.println("| \033[0;32m1. System Users\033[0;34m");
            System.out.println("| \033[0;32m2. Patients\033[0;34m");
            System.out.println("| \033[0;32m3. Services Offered\033[0;34m");          
            System.out.println("| \033[0;32m4. Payments\033[0;34m");
            System.out.println("| \033[0;32m5. Chat\033[0;34m");
            System.out.println("| \033[0;32m6. Accounts\033[0;34m");
            System.out.println("| \033[0;32m7. Exit\033[0;34m");
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
                        SystemUserView systemUserView = new SystemUserView();
                        systemUserView.showMenu();
                        break;
                    case 2:
//                        System.out.println("You chose Patients.");
                       PatientView patientView = new PatientView();
                       patientView.choosePatientOption();
                        break;
                    case 3:
                        System.out.println("You chose Services Offered.");

                        // Add your Services Offered functionality here
                        break;
                    case 4:
                        System.out.println("You chose Payments.");

                        // Add your Payments functionality here
                        break;
                    case 5:
                     SystemUser adminUser = users.values().stream().filter(user -> user.getRole().equalsIgnoreCase("AD")).findFirst()
                .orElse(null);

        if (adminUser != null) {
            System.out.println("Admin User found: " + adminUser.getName());
        } 
                        ChatView chatView = new ChatView(adminUser);
                        chatView.getMenu();

                        break;
                    case 6:
                        System.out.println("You chose Accounts.");
                        AccountReconciliationView accountReconciliationView = new AccountReconciliationView();
                        accountReconciliationView.displayReconciliationView();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a number between 1 and 7.");
                }
            } else {
                System.out.println("Invalid choice. Please enter a valid number.");
                scanner.next(); // Consume invalid input
            }
        }
        scanner.close();
    }

}
