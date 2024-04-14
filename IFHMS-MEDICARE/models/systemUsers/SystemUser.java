package models.systemUsers;

/**
 * Represents a system user.
 */
public abstract class SystemUser {


    // The name of the user
    private String name;

    // The role of the user
    private String role;

    /**
     * Sets the role of the user.
     * 
     * @param role The role of the user.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * Gets the role of the user.
     * 
     * @return The role of the user.
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the name of the user.
     * 
     * @param name The name of the user.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the user.
     * 
     * @return The name of the user.
     */
    public String getName() {
        return name;
    }

    /**
     * Prints the details of the user.
     */
    public void printMyDetails() {
        System.out.println("Name: " + name);
        System.out.println("Role: " + role + ".");
    }

    @Override
    public String toString(){
        return name + " is a  user of type " + role;

    }

}
