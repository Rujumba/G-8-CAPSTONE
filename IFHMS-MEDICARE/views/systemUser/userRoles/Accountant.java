package views.systemUser.userRoles;
import java.util.List;
import models.systemUsers.SystemUser;
import views.messages.services.MessageProcessor;




public class Accountant extends SystemUser {
    MessageProcessor messageProcessor = MessageProcessor.getMessageProcessor();
    public void createLedgerEntries() {
        System.out.println("Generating ledger entries");
    }

    // receive payments to cater for the accounts receivable
    // @Override
    public void receivePayments() {
        System.out.println("Receiving payments");
    }


    public void notifyAnotherMember(SystemUser member) {
        // send message to another member
        // messageProcessor.sendGroupMessage("Accountant sent you a message.");
    }

    // reconcile accounts for automatic accounts reconciliation
    // @Override
    public void performAccountReconciliation() {
        System.out.println("Reconciling accounts");
    }

    // private message
    private String message;

    // method to get message
    public String getMessage() {
        return message;
    }

    // method to set message
    public void setMessage(String message) {
        this.message = message;
    }

    // method to update team message
  

    // make payments to cater for the accounts payable
    // @Override
    public void processPayments() {
        System.out.println("Making payments");
    }

    // send a group message

    public void sendGroupMessage(String message) {
        // messageProcessor.sendGroupMessage(message);
        System.out.println("Sending message: " + message);
    }

    public void sendMessageToMember(SystemUser messageObserver){
        System.out.print("The message has been sent to the member");
    }
    public void notifyGroupMembers(List <SystemUser> groupMessageObservers){
    //   messageProcessor.notifyGroupMembers(groupMessageObservers);
    }

  

}
