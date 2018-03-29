/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Retailer.RetailerCatalogue;
import Business.Customer.CustomerCatalogue;
import Business.Retailer.RetailerInvoice;

/**
 *
 * @author mahajan
 */
public class Admin {
    

    public static Admin masterClass;
    private RetailerCatalogue retailerCatalogue;
    private CustomerCatalogue customerCatalogue;
    private UserAccountDirectory userAccountDirectory;
    private static double treasury = 0.0;
    
    private Admin()
    {
        this.retailerCatalogue=new RetailerCatalogue();
        this.customerCatalogue=new CustomerCatalogue();
        this.userAccountDirectory = new UserAccountDirectory();
    }
    
    public static Admin getInstance() {
        if (masterClass == null) {
            masterClass = new Admin();
        }
        return masterClass;
    }

    /**
     *
     * @return
     */
    public RetailerCatalogue getRetailerCatalogue() {
        return retailerCatalogue;
    }

    /**
     *
     * @return
     */
    public CustomerCatalogue getCustomerCatalogue() {
        return customerCatalogue;
    }

    /**
     *
     * @return
     */
    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    /**
     *
     * @param userAccountDirectory
     */
    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }
    
    public static void pay(Double amount) {
        treasury += amount;
    }
    
    public static double getTreasury() {
        return treasury;
    }
    
    public static double payRetailer (RetailerInvoice ri) {
        System.out.println("Tresury $" + Admin.getTreasury());
        double toBePaid = ri.getTotalPriceToBePaid() - (ri.getTotalPriceToBePaid() * 0.1);
        treasury -= toBePaid;
        System.out.println("Tresury $" + Admin.getTreasury());
        return toBePaid;
    }
    
}
