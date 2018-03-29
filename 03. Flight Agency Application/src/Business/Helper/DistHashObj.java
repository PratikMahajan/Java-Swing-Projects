/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Helper;

/**
 *
 * @author mahajan
 */
public class DistHashObj 
{
    private String toD;
    private double kmD;

    public DistHashObj(String to, double km)
    {
        this.toD=to;
        this.kmD=km;
        
    }
    public String getToD() {
        return toD;
    }

    public void setToD(String toD) {
        this.toD = toD;
    }

    public double getKmD() {
        return kmD;
    }

    public void setKmD(double kmD) {
        this.kmD = kmD;
    }
    
    
}
