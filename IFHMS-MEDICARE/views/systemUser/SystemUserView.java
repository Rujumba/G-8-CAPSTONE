package views.systemUser;

import java.util.Map;

import models.systemUsers.SystemUser;
import repository.systemUsersRepository.SystemUserRepository;

public class SystemUserView {
    public static final String ANSI_RESET = "\u001B[0m";
public static final String ANSI_CYAN = "\u001B[36m";
public static final String ANSI_YELLOW = "\u001B[33m";
    SystemUserRepository systemUserRepository = SystemUserRepository.getInstance();

    private Map<String, SystemUser> users = systemUserRepository.users;


    // create a function that displays the users in the map,users
    public void displayUsers() {
        System.out.println(ANSI_CYAN + "Available users:" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "-----------------" + ANSI_RESET);
        for (SystemUser user : users.values()) {
            String username = user.getName();
            System.out.println(ANSI_YELLOW + "- " + username + ANSI_RESET);
        }
        System.out.println(ANSI_YELLOW + "-----------------" + ANSI_RESET);
    }
    

    // create a function that gets a user by name
    public SystemUser getUserByName(String name) {
        for (SystemUser user : users.values()) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null; // return null if no matching user is found
    }
    


}
