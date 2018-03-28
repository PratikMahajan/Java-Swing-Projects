/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Retailer;

import Business.Customer.CartProduct;
import Business.Product;
import java.util.ArrayList;

/**
 *
 * @author mahajan
 */
public class RetailerCatalogue 
{
    private ArrayList<Retailer> retailerCatalogue;

    public RetailerCatalogue()
    {
        this.retailerCatalogue= new ArrayList<Retailer>();
    }
    
    public RetailerCatalogue(ArrayList<Retailer> ret)
    {
        this.retailerCatalogue = ret;
    }
    
    public ArrayList<Retailer> getRetailerCatalogue() {
        return retailerCatalogue;
    }
    
    public void addRetailer(Retailer ret)
    {
        this.retailerCatalogue.add(ret);
    }
    
    public void removeRetailer(Retailer ret)
    {
        this.retailerCatalogue.remove(ret);
    }
    
    public ArrayList<Retailer> searchByZip(String zipC)
    {
        ArrayList<Retailer> ret= new ArrayList<>();
        
        for(Retailer ser:retailerCatalogue)
        {
            if(ser.getZipCode().equals(zipC))
            {
                ret.add(ser);
            }
        }
        if(ret.isEmpty())
            return null;
        if(ret!=null)
            return ret;
        else
            return null;
    }
    

    public ArrayList<Object[]> getAllProducts()
    {
        ArrayList<Object[]> res= new ArrayList<Object[]>();
        for(Retailer rs: retailerCatalogue)
        {
            
            Retailer smm = rs;
            for(Product pr : rs.getProductCatalogue().getProductCatalogue())
            {
                Object[] tmp= new Object[5];
                tmp[0]=smm;
                tmp[1]=pr.getProductNumber();
                tmp[2]=pr;
                tmp[3]=pr.getPrice();
                tmp[4]=pr.getAvailableUnits();
                
                res.add(tmp);
                
            }
        }
        
        return res;
    }
    
    public ArrayList<Retailer> searchByRetailer(Retailer searchq)
    {
        ArrayList<Retailer> ret= new ArrayList<>();
        
        for(Retailer ser : retailerCatalogue)
        {
            if(ser.getRetailerName().equals(searchq.getRetailerName()))
            {
                ret.add(ser);
            }
        }
        if(ret.isEmpty())
            return null;
        if(ret!=null)
            return ret;
        else
            return null;
    }
    
    public void addToSoldList(CartProduct cp) {
        for (Retailer r : retailerCatalogue) {
            if (r.getProductCatalogue().getProductCatalogue().contains(cp.getProduct())) {
                r.addToProductSoldList(cp);
            }
        }
    }
    
    
    
}
