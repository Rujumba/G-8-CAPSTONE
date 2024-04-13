package views.systemUser.services;

import models.systemUsers.SystemUser;
import views.logger.services.DebugLogger;
import views.systemUser.userRoles.ChiefFinanceOfficer;

// Factory class for creating different types of system users
public class SystemUserCreator {
    DebugLogger logger = DebugLogger.getLogger();

    private static SystemUserCreator systemUserSingleton = null;

    public static SystemUserCreator getSystemUserCreator() {
        if (systemUserSingleton == null) {
            return new SystemUserCreator();
        }
        else {
            return systemUserSingleton;
        }
    }


    // Create a team member based on user type
  
    // Create a user based on user type
    public SystemUser createUser(String userType) {


        SystemUser user;

        switch (userType.toUpperCase()) {
        case "AD":
        logger.logSuccess("You have created a system admin");
        //      SystemUser systemAdmin = new SystemAdministrator();
        // systemAdmin.setRole(userType.toUpperCase());
        user = new Aadmin();
        user.setRole(userType.toUpperCase());
        return user;
    case "HC":
    logger.logSuccess("You have created a chief health care officer  ");
    

    user = new ChiefFinanceOfficer();
    user.setRole(userType.toUpperCase());
        return user;
    case "FI":
        logger.logSuccess("You have created a chief finance officer  ");

       
        user = new ChiefFinanceOfficer();
        user.setRole(userType.toUpperCase());
            return user;
        default:
            return null;
        }

    }
 
}
