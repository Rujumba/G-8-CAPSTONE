package repository.systemUsersRepository;

import java.util.HashMap;
import java.util.Map;
import models.systemUsers.SystemUser;


public class SystemUserRepository {
    private static SystemUserRepository instance;
    private Map<String, SystemUser> users;

    private SystemUserRepository() {
        users = new HashMap<>();
    }

    public static SystemUserRepository getInstance() {
        if (instance == null) {
            instance = new SystemUserRepository();
        }
        return instance;
    }

    public void addUser(SystemUser user) {
        users.put(user.getName(), user);
    }

    public void removeUser(SystemUser user) {
        users.remove(user.getName());
    }

    public SystemUser getUserByUsername(String username) {
        return users.get(username);
    }

  

    public void printUsers() {
        for (SystemUser user : users.values()) {
            System.out.println(user);
        }
    }
}
   