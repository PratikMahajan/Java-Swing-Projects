/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author mahajan
 */
public class CarsArray 
{
    
    private ArrayList<Cars> CarsArray;
    private Date date;

    public String getDate() {
        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        return ft.format(date);
    }

    public void setDate() {
        this.date = new Date();
    }
    
    public CarsArray()
    {
        CarsArray= new ArrayList<Cars>();
        setDate();
    }

    public ArrayList<Cars> getCarsArray() {
        return CarsArray;
    }

    public void setCarsArray(ArrayList<Cars> CarsArray) {
        this.CarsArray = CarsArray;
        setDate();
    }
    
    public void addCarsArray(Cars car)
    {
        CarsArray.add(car);
        setDate();
    }
    
   
    
    
}
