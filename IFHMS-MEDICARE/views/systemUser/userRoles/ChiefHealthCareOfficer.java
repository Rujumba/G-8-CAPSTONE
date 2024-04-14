package views.systemUser.userRoles;

import models.systemUsers.SystemUser;
import views.logger.services.DebugLogger;
import views.messages.services.MessageProcessor;

// HealthCareProvider extends user as part of Factory Pattern
// HealthCareProvider implements Dashboard as part of Decorator Pattern
// Decorator Pattern: Allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class.
public class ChiefHealthCareOfficer extends SystemUser {

    DebugLogger logger = DebugLogger.getLogger();
    MessageProcessor messageProcessor = MessageProcessor.getMessageProcessor();


    // Provides health care services
    public void provideService() {
        System.out.println("Providing health care services");
    }

    // @Override
    public void createReport() {
       logger. printInfo("Generating Chief HealthCare Officer report");
        System.out.println("--- Chief HealthCare Officer Report ---");
        System.out.println("\n Report Contents \n");
        System.out.println("\n 1 \n");
        System.out.println("\n 2 \n");
        System.out.println("\n 3 \n");
        System.out.println("-------------");
        logger.logSuccess("Chief HealthCare Officer report generated successfully");
    }

    // @Override
    public void printReport() {
        // Generate and print report
        createReport();
        System.out.println("Chief HealthCare Officer report printed successfully");
    }

   
 

  
 
}