package views.systemUser.userRoles;

import models.systemUsers.SystemUser;
import views.messages.services.MessageProcessor;

public class ChiefFinanceOfficer extends SystemUser {
    MessageProcessor messageProcessor = MessageProcessor.getMessageProcessor();

      @Override
    public void printMyDetails() {
        System.out.println("Chief Finance Officer: I am a" + super.getName() + "Chief Finance Officer.");
    }

    // @Override
    public void runAutomatedFinancialProcesses() {
        // Automate financial transactions ....
        System.out.println("Automating financial transactions");
    }

    // @Override
    public void generateInvoicesAutomatically() {
        // Automate invoicing ....
        System.out.println("Automating invoicing");
    }

    // @Override
    public void executeAutomatedBilling() {
        // Automate billing ....
        System.out.println("Automating billing");
    }

    // @Override
    public void processPaymentsAutomatically() {
        // Automate payment processing ....
        System.out.println("Automating payment processing");
    }

    // @Override
    public void receivePayments() {
        // print
        System.out.println("Chief Finance Officer received payments");
    }

    // @Override
    public void processPayments() {
        // print
        System.out.println("Chief Finance Officer made payments");
    }

    // @Override
    public void performAccountReconciliation() {
        // print
        System.out.println("Chief Finance Officer reconciled accounts");
    }
 

     
    
}
