/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author karanracca
 */
public class UserAccountDirectory {
    private ArrayList<UserAccount> userAccountDirectory;

    public UserAccountDirectory() {
        this.userAccountDirectory = new ArrayList<UserAccount>();
    }
    
    public ArrayList<UserAccount> getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(ArrayList<UserAccount> userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }
    
    public void addUserAccount(UserAccount ua) {
        userAccountDirectory.add(ua);
    }
    
    public void removeUserAccount(UserAccount userAccount){
        userAccountDirectory.remove(userAccount);
    }
    
    public UserAccount getUserAccount(String userName) {
        for (UserAccount ua: userAccountDirectory) {
            if (ua.getUsername().equals(userName)) {
                return ua;
            }
        }
        return null;
    }
    
}
