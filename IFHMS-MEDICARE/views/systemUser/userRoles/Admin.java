package views.systemUser.userRoles;

import models.systemUsers.SystemUser;
import views.logger.services.DebugLogger;
import views.messages.services.MessageProcessor;

public class Admin extends SystemUser{

    DebugLogger logger = DebugLogger.getLogger();
    MessageProcessor messageProcessor = MessageProcessor.getMessageProcessor();
        

    // @Override
    public void createReport() {
        logger.printInfo("Generating System Admin Report");
        System.out.println("-----------------------------------------------------");
        System.out.println("|                  System Admin Report               |");
        System.out.println("-----------------------------------------------------");
        System.out.println("|                                                   |");
        System.out.println("| Report Contents:                                  |");
        System.out.println("| 1. User Management                                |");
        System.out.println("| 2. Security Analysis                              |");
        System.out.println("| 3. System Performance Overview                    |");
        System.out.println("|                                                   |");
        System.out.println("-----------------------------------------------------");
        logger.logSuccess("System Admin report generated successfully");
    }
    
    // @Override
    @Override
    public void printMyDetails() {
        System.out.println("SystemAdministrator: I am an" +  super.getRole() + "admin.");
    }

    // @Override
    public void printReport() {
        // call genreate report
        createReport();

        // connect printer
        System.out.println("Admin connected to printer");

        // print report
        System.out.println("Admin printed report");

        // log
        logger.printInfo("Printed Admin report");
    }
    
}
