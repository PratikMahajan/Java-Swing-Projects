/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author mahajan
 */
public class Customer {
    private String custName;
    private String custDOB;
    private String customerId;
    private String zipCode;
    private static int counter=3874001;

    private CartCatalogue cartCatalogue;
    private PreviousOrders prevOrders;
    
    public Customer()
    {
        counter++;
        this.customerId=String.valueOf(counter);
        cartCatalogue= new CartCatalogue();
        prevOrders=new PreviousOrders();
        
    }
    
    public Customer(String DOB, String Name, String zipC)
    {
        this.custName=Name;
        this.custDOB=DOB;
        counter++;
        this.customerId=String.valueOf(counter);
        cartCatalogue= new CartCatalogue();
        prevOrders=new PreviousOrders();
        this.zipCode= zipC;
    }
    
    
    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustDOB() {
        return custDOB;
    }

    public void setCustDOB(String custDOB) {
        this.custDOB = custDOB;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public CartCatalogue getCartCatalogue() {
        return cartCatalogue;
    }

    public PreviousOrders getPrevOrders() {
        return prevOrders;
    }

    public void setCartCatalogue(CartCatalogue cartCatalogue) {
        this.cartCatalogue = cartCatalogue;
    }
    
    @Override
    public String toString()
    {
        return this.custName;
    }
    
    public ArrayList<Object[]> getCart()
    {
        ArrayList<Object[]> res=new ArrayList<Object[]>();
        
        for(CartProduct cp: cartCatalogue.getCartCat())
        {
            Object[] ob= new Object[2];
            ob[0]=(Object)cp.getProduct();
            //ob[0]=(Object)cp;
            ob[1]=(Object)cp;
            
            res.add(ob);
        }

        return res;
   
    }
    
    public ArrayList<Object[]> getPrevCart()
    {
        ArrayList<Object[]> res = new ArrayList<Object[]>();
        
        for(CartProduct cp: prevOrders.getCartCat())
        {
            Object[] ob= new Object[2];
            ob[0]=(Object)cp.getProduct();
            ob[1]=cp;
            //ob[1]=cp.getItemNo();
            res.add(ob);
            
        }
        return res;
   
    }

   public static Comparator<Customer> ByProducts = new Comparator<Customer>() {

        @Override
        public int compare(Customer o1, Customer o2) {
            return (int) (o1.getPrevOrders().totalProducts() - o2.getPrevOrders().totalProducts());
        }
    };
   
   public static Comparator<Customer> ByTotalCost = new Comparator<Customer>() {

        @Override
        public int compare(Customer o1, Customer o2) {
            return (int) (o1.getPrevOrders().totalPrice() - o2.getPrevOrders().totalPrice());
        }
    };
    
    
    
}
