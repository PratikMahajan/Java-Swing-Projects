/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author karanracca
 */
public class UserAccount {
    
    public static String ADMIN_ROLE = "admin";
    public static String RETAILER_ROLE = "retailer";
    public static String CUSTOMER_ROLE = "customer";
    
    private static int count = 10000;
    private int userID;
    private String username;
    private String password;
    private String role;
    private Object userType;
    
    public UserAccount (String un, String pwd, String role, Object ut ) {
        this.username = un;
        this.password = pwd;
        this.role = role;
        this.userType = ut;
        userID = count++;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Object getUserType() {
        return userType;
    }

    public void setUserType(Object userType) {
        this.userType = userType;
    }

    public int getUserID() {
        return userID;
    }
    
    
}
