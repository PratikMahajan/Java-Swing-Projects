/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author mahajan
 */
public class Flight 
{
    private String fromLoc;
    private String toLoc;
    private Aeroplane aeroplane;
    private double distance;
    DistanceHash distH;
    private int flightId;
    private static int counter=28000;
    
    private String deptT;
    private String arrT;
    private SeatCatalogue seatCat;

    
    
    
    public Flight()
    {
        
    }
    public Flight(String fromL, String toL, double distance)
    {
        counter++;
        flightId=counter;
        distH= new DistanceHash();
        distH.addDistHash(fromL, toL, distance);
        this.fromLoc=fromL;
        this.toLoc=toL;
        this.distance=distance;
        seatCat=new SeatCatalogue();
    }
    
    
    
    public SeatCatalogue getSeatCat() {
        return seatCat;
    }

    public void setSeatCat(SeatCatalogue seatCat) {
        this.seatCat = seatCat;
    }

    public Aeroplane getAeroplane() {
        return aeroplane;
    }

    public void setAeroplane(Aeroplane aeroplane) {
        this.aeroplane = aeroplane;
    }

    public String getFromLoc() {
        return fromLoc;
    }

    public void setFromLoc(String fromLoc) {
        this.fromLoc = fromLoc;
    }

    public String getToLoc() {
        return toLoc;
    }

    public void setToLoc(String toLoc) {
        this.toLoc = toLoc;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getDeptT() {
        return deptT;
    }

    public void setDeptT(String deptT) {
        this.deptT = deptT;
    }

    public String getArrT() {
        return arrT;
    }

    public void setArrT(String arrT) {
        this.arrT = arrT;
    }
    
    
    public ArrayList<Object[]> getSeatDetails()
    {
        ArrayList<Object[]> res= new ArrayList<Object[]>();
        for (Seat ss:seatCat.getSeatCat())
        {
            Object[] tmp= new Object[3];
            tmp[0]= ss.getSeatNo();
            tmp[1]=ss.getFlightID();
            tmp[2]=ss.getCustomerID();
            res.add(tmp);
        }
        
        return res;
    }
    
    
    
    
    
    
    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }
    
    
    
    
    
    @Override
    public String toString()
    {
        return ""+flightId;
    }
    
    
    
}
