package views.messages.services;

import java.util.ArrayList;
import java.util.List;
import models.message.Message;
import models.systemUsers.SystemUser;
import views.logger.services.DebugLogger;


public class MessageProcessor implements MessageSender, GroupMessaginObserver {
    public static MessageProcessor messageProcessorSingleton = null;
     
    private MessageProcessor() {
        
    }

    public static MessageProcessor getMessageProcessor() {
        if (messageProcessorSingleton == null) {
            return new MessageProcessor();
        }
        else {
            return messageProcessorSingleton;
    }
   }


    DebugLogger logger = DebugLogger.getLogger();

    // Message to be sent
    private Message message =new Message();

    // List of message observers (group members)
    private List<SystemUser> messageObservers = new ArrayList<>();


    // Get the current message
    public Message getMessage() {
        return message;
    }

    @Override
    public void notifyGroupMembers(List <SystemUser> groupMessageObservers){

        for (var groupMember : groupMessageObservers) {

            // sendMessageToMember(groupMember,"There is a new message");

            System.out.println("Group member has been been notified" + groupMember.toString());
            
        }

    }
    // method to set message
    public void setMessage(String sender, String messageString) {
        this.message.setSender(sender);
        this.message.setMessageString(messageString);
    }
    
    @Override
    public void sendGroupMessage(String messageString1, String sender) {
        // set message
        setMessage(sender,messageString1);

        System.out.println("Messaged Received (SystemAdministrator): " + messageString1);
    }
@Override
    
public void sendMessageToMember(SystemUser messageObserver, String sender, String message) {
        setMessage(sender, message);
        System.out.println("Message has been sent to " + messageObserver.toString());
        
    }

    @Override
    public void onMessageReceived(Message message){
        System.out.print("You have receeived a message" + message);
    }
    
    @Override
    public void onMessageUpdated(Message message){
        System.out.print("This message " + message + "has been updated");
    
    }

    // Add an observer (group member) to the group
    public void addObserverToGroup(SystemUser groupMember) {
        messageObservers.add(groupMember);
        logger.logSuccess(groupMember + " has been added to the group.");
    }

    // Remove an observer (group member) from the group
    public void removeObserverFromGroup(SystemUser observer) {
        messageObservers.remove(observer);
        logger.logSuccess(observer + " has been removed from the group.");
    }


  

    
}
