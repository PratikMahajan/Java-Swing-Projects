/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Helper.DistHashObj;
import java.util.ArrayList;
import java.util.HashMap;


/**
 *
 * @author mahajan
 */
public class DistanceHash {
   
    private HashMap<String, ArrayList<DistHashObj>> distH;
    private ArrayList<DistHashObj> objArray;
    //private DistHashObj obj;
    
    public DistanceHash()
    {
        distH= new HashMap<String, ArrayList<DistHashObj>>();
        objArray=new ArrayList<DistHashObj>();
    }

    
    public void addDistHash(String fromD, String toD, double kmD )
    {
        DistHashObj obj=new DistHashObj(toD, kmD);
        if(distH.containsKey(fromD))
        {
            ArrayList<DistHashObj> pre= distH.get(fromD);
            pre.add(obj);
            
        }
        else
        {
            objArray=new ArrayList<DistHashObj>();
            objArray.add(obj);
            distH.put(fromD, objArray);
        }
    }
    
    public double getDistance(String fromD, String toD)
    {
        if(distH.containsKey(fromD))
        {
            ArrayList<DistHashObj> pre= distH.get(fromD);
            for(DistHashObj dho :pre)
            {
                if(dho.getToD().equals(toD))
                {
                    return dho.getKmD();
                }
                
            }
        }
        return -0.1111;
    }
   
    
    
}
