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
public class Operator 
{
    
    private String opName;
    private double costKm;
    private static int count = 10000;
    private int operatorId;
    private FleetCatalogue fleetCat;
    
    public Operator(String st)
    {
        
    }
    public Operator()
    {
        count++;
        this.operatorId=count;
        fleetCat= new FleetCatalogue();
    }

    public FleetCatalogue getFleetCat() {
        return fleetCat;
    }

    public void setFleetCat(FleetCatalogue fleetCat) {
        this.fleetCat = fleetCat;
    }

    public String getOpName() {
        return opName;
    }

    public void setOpName(String opName) {
        this.opName = opName;
    }

    
    public String getClassAir()
    {
        if(this.costKm<10)
            return "Low Budget";
        if(this.costKm<20)
            return "Budget";
        else
            return "Premium";
            
    }
    
    
    
    public double getCostKm() {
        return costKm;
    }

    public void setCostKm(double costKm) {
        this.costKm = costKm;
    }
    
    public int getOperatorId() {
        return operatorId;
    }
    
    @Override
    public String toString()
    {
        return opName;
    }
    
}
