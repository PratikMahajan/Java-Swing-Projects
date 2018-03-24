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
public class SeatCatalogue 
{
    private ArrayList<Seat> seatCat;
    
    public SeatCatalogue()
    {
        seatCat=new ArrayList<Seat>();
    }

    public ArrayList<Seat> getSeatCat() {
        return seatCat;
    }

    public void setSeatCat(ArrayList<Seat> seatCat) {
        this.seatCat = seatCat;
    }
    
    public void addSeat(Seat seat)
    {
        this.seatCat.add(seat);
        
    }
    
    public void delSeat(Seat seat)
    {
        this.seatCat.remove(seat);
                
    }
    
    public Seat searchSeat(int custID)
    {
        for (Seat cc:seatCat)
        {
            if(cc.getCustomerID()==custID)
            {
                return cc;
            }
                    
        }
        return null;
    }
    
    
    
    
}
