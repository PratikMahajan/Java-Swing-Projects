/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Seat;
import Business.SeatCatalogue;
import java.util.ArrayList;

/**
 *
 * @author mahajan
 */
public class Customer 
{
    private String customerName;
    private String dob;
    private String passportNo;
    private static int counter=13718;
    private int customerId;
    private SeatCatalogue seatCatol;
    
    
    public Customer(String st)
    {
        
    }
    public Customer()
    {
        counter++;
        customerId=counter;
        seatCatol=new SeatCatalogue();
    }

    public SeatCatalogue getSeatCatol() {
        return seatCatol;
    }

    public void setSeatCatol(SeatCatalogue seatCatol) {
        this.seatCatol = seatCatol;
    }
    
    
    

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    @Override 
    public String toString()
    {
        return this.customerName;
    }
    
  

}
