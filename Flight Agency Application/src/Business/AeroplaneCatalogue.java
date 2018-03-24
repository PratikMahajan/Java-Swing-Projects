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
public class AeroplaneCatalogue 
{
    private ArrayList<Aeroplane> airCat;
    
    public AeroplaneCatalogue()
    {
        this.airCat=new ArrayList <Aeroplane>();
    }

    public ArrayList<Aeroplane> getAirCat() {
        return airCat;
    }

    public void setAirCat(ArrayList<Aeroplane> airCat) {
        this.airCat = airCat;
    }
    
    public void addAeroplane(Aeroplane arp)
    {
        airCat.add(arp);
        
    }
    
    public void removeAeroplane(Aeroplane arp)
    {
        airCat.remove(arp);
        
    }
    
    
    
}
