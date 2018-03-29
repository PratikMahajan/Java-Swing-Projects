/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;

/**
 *
 * @author mahajan
 */
public class CustomerCatalogue 
{
    
    private ArrayList<Customer> custCat;
    
    public CustomerCatalogue()
    {
        this.custCat=new ArrayList<Customer>();
        
    }

    public ArrayList<Customer> getCustCat() {
        return custCat;
    }

    public void setCustCat(ArrayList<Customer> custCat) {
        this.custCat = custCat;
    }
    
    public void addCustomer(Customer cust)
    {
        custCat.add(cust);
        
    }
    
    public void delCustomer(Customer cust)
    {
        custCat.remove(cust);
    }
    
    
}
