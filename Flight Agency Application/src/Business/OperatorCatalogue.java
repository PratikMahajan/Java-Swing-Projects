/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Customer.Customer;
import java.util.ArrayList;

/**
 *
 * @author mahajan
 */
public class OperatorCatalogue 
{
    private ArrayList<Operator> opCat;
    
    public OperatorCatalogue()
    {
        opCat=new ArrayList<Operator>();
    }

    public ArrayList<Operator> getOpCat() {
        return opCat;
    }

    public void setOpCat(ArrayList<Operator> opCat) {
        this.opCat = opCat;
    }
    
    public void addOperator(Operator op)
    {
        this.opCat.add(op);
        
    }
    
    public void removeOperator(Operator op)
    {
        this.opCat.remove(op);
        
    }
    
    
    public ArrayList<Object[]> SearchFlightSingle(String From, String To)
    {
        String oper;
        //ArrayList<Flight> opres= new ArrayList<Flight>();
        ArrayList<Object[]> res=new ArrayList<Object[]>();
        for(Operator op:opCat)
        {
            oper=op.getOpName();
            for(Flight ff: op.getFleetCat().getFleetCat())
            {
                if(ff.getFromLoc().equals(From) && ff.getToLoc().equals(To))
                {
                    Object[] ob= new Object[2];
                    ob[0]=op;
                    ob[1]=ff;
                    res.add(ob);
                }
            }
        }
        return res;
    }
    
    
      public ArrayList<Object[]> getAllBookings(Customer cust)
    {
        ArrayList<Object[]> res=new ArrayList<Object[]>();
        SeatCatalogue sccust=cust.getSeatCatol();
        ArrayList<Integer> flightid=new ArrayList<Integer>();
        for(Seat ss:sccust.getSeatCat())
        {
            flightid.add(ss.getFlightID());
        }
        String oper;
        
        for(Operator op:opCat)
        {
            oper=op.getOpName();
            for(Flight ff: op.getFleetCat().getFleetCat())
            {   
                if(flightid.contains(ff.getFlightId()))
                {
                    Object[] ob= new Object[2];
                    ob[0]=op;
                    ob[1]=ff;
                    res.add(ob);
                }
            }
        }
        return res;
   
    }
    
    
    
    
    
    
    
}
