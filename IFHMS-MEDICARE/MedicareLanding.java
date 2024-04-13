import java.util.Scanner;
import models.systemUsers.SystemUser;
import repository.systemUsersRepository.SystemUserRepository;
import views.accountReconcilation.AccountReconciliationView;
import views.logger.services.DebugLogger;
import views.patient.PatientView;
import views.systemUser.services.SystemUserCreator;



public class MedicareLanding {

    public static void main(String[] args) {
        SystemUserRepository userRepository = SystemUserRepository.getInstance();


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


        System.out.println("List of Users:");

        userRepository.printUsers();
        
        boolean exit = false;

        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Patients");
            System.out.println("2. Services Offered");
            System.out.println("3. Payments");
            System.out.println("4. Chat");
            System.out.println("5. Accounts");
            System.out.println("6. Exit");
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
//                        chatView=new ChatView();
//                        chatView.show();
//                        InvoiceView invoiceView  = InvoiceView.getInstance();
//                        invoiceView.displayInvoice();
//                        System.out.println("You chose Chat.");
                        // Add your Chat functionality here

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
