/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Validation;

import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author mahajan
 */
public class Validate 
{
    private static int error=0;
    public Validate()
    {
    
    }
    
    public static boolean doubleCheck(String checkThis, String field)
    {
        error=0;
        boolean ret;
        try
        {
           Double.parseDouble(checkThis);
        }
        catch(Exception e)
        {
            error=1;
            JOptionPane.showMessageDialog(null, field+" should be in Number format","ERR0R",0);       
        }
        
        if(error==1)
            ret=false;
        else
            ret=true;
        
        return ret;
    }
    
    public static boolean integerCheck(String checkThis, String field)
    {
        error=0;
        boolean ret;
        try
        {
            if(Double.parseDouble(checkThis)%1!=0)
            {
                error=1;
                JOptionPane.showMessageDialog(null, field+" should not be in fraction","ERROR",0);
            }
            
        }
        catch(Exception e)
        {
            error=1;
            JOptionPane.showMessageDialog(null, field+" should be in Number format","ERR0R",0);       
        }
        
        if(error==1)
            ret=false;
        else
            ret=true;
        
        return ret;
    }
    
    
    public static boolean stringCheck(String checkThis, String field)
    {
        error=0;
        boolean ret;
        try
        {
            if(Double.valueOf(Double.parseDouble(checkThis))>=0);
            {
                error=1;
                JOptionPane.showMessageDialog(null,"Please enter "+field +" in proper format", "Error", 0);
            }
        }
        catch(Exception e){}
        if(error==1)
            ret=false;
        else
            ret=true;
        
        return ret;
            
        
    }
    
    public static boolean dateCheckTillToday(String checkThis, String field)
    {
        error=0;
        boolean ret;
         try
        {
            if(Double.valueOf(Double.parseDouble(checkThis))>=0);
            {
                error=1;
                JOptionPane.showMessageDialog(null,"Please enter "+field +"Date in proper format", "Error", 0);
            }
        }
        catch(Exception e)
        {
            if (!getDateRegex(checkThis)) {
                error=1;
                JOptionPane.showMessageDialog(null,"Please Enter "+field+"date in format MM-DD-YYYY","ERROR",0);
            }    
        }
        if(error==1)
            ret=false;
        else
            ret=true;
        
        return ret;
        
    }
    
    private static boolean getDateRegex(String date)
    {
        //String regex= "\\d{2}\\-\\d{2}\\-\\d{4}";
        String dRegex="^(0[0-9]|1[0-2])\\-(0[1-9]|1[0-9]|2[0-9]|3[0-1])\\-(199[0-9]|20[0-1][0-8])";
        final Pattern pattern = Pattern.compile(dRegex);
        boolean bool=pattern.matcher(date).matches();
        return bool;
    }
}
