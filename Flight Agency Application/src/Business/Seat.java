/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author mahajan
 */
public class Seat 
{
    private int CustomerID;
    private int FlightID;
    private String seatNo;
    private static int counter=19301;
    private int seatId;
    
   
    
    public Seat(int fId, int cId, String seat)
    {
        this.CustomerID=cId;
        this.FlightID=fId;
        this.seatNo=seat;
        counter++;
        this.seatId=counter;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getFlightID() {
        return FlightID;
    }

    public void setFlightID(int FlightID) {
        this.FlightID = FlightID;
    }

    public String getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(String seatNo) {
        this.seatNo = seatNo;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
    
    @Override
    public String toString()
    {
        return this.seatNo;
    }
    
    
    
}
