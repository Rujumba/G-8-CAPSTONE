package views.messages;

import java.util.Scanner;

import models.systemUsers.SystemUser;
import repository.systemUsersRepository.SystemUserRepository;
import views.messages.services.MessageProcessor;
import views.systemUser.SystemUserView;
import views.systemUser.SystemUserView;
import repository.systemUsersRepository.SystemUserRepository;

/**
 * ChatView
 */
public class ChatView {
      public ChatView(SystemUser user) {
        System.out.println("we have a user" + user.toString());
        this.user = user;
        senderName= user.getName();

    }

    SystemUser user;

    String senderName;

  
    

    SystemUserRepository systemUserRepository = SystemUserRepository.getInstance();
    MessageProcessor messageProcessor = MessageProcessor.getMessageProcessor();

        Scanner scanner = new Scanner(System.in);

        public void getMenu() {
            System.out.println("\u001B[33m╔══════════════════════════════╗");
            System.out.println("║        Message Options        ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ \u001B[0m1. \u001B[33mSend message to a group   \u001B[33m║");
            System.out.println("║ \u001B[0m2. \u001B[33mSend message to an individual \u001B[33m║");
            System.out.println("║ \u001B[0m3. \u001B[33mExit                      \u001B[33m║");
            System.out.println("╚══════════════════════════════╝\u001B[0m");
            System.out.print("Enter your choice: ");
            String message;
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter the message: ");
                    message = scanner.next();
                    messageProcessor.sendGroupMessage(message, senderName);
                    messageProcessor.notifyAll();
                    break;
                case 2:
                    System.out.print("Enter the recipient's name: ");
                    String recipientName = scanner.nextLine();
                    System.out.print("Enter the message: ");
                    message = scanner.nextLine();
                    SystemUserView systemUserView = new SystemUserView();
                    SystemUserRepository systemUserRepository = SystemUserRepository.getInstance();
                    systemUserView.displayUsers();
                    System.out.print("Choose a name from the list: ");
                    String receiver = scanner.next();
                    user = systemUserRepository.getUserByUsername(receiver);
                    messageProcessor.sendMessageToMember(user, recipientName, message);
                    messageProcessor.notify();
                    break;
                case 3:
                    // Add code here to handle exiting the chat
                    System.out.println("Exiting chat........");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            
            }

            // Add code here to handle user input and perform corresponding actions
        }


        
    




}
