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
public class FleetCatalogue 
{
    private ArrayList<Flight> fleetCat;
    
    public FleetCatalogue()
    {
        this.fleetCat=new ArrayList <Flight>();
    }

    public ArrayList<Flight> getFleetCat() {
        return fleetCat;
    }

    public void setFleetCat(ArrayList<Flight> fleetCat) {
        this.fleetCat = fleetCat;
    }
    
    public void addAeroplane(Flight arp)
    {
        fleetCat.add(arp);
        
    }
    
    public void removeAeroplane(Flight arp)
    {
        fleetCat.remove(arp);
        
    }
    
}
