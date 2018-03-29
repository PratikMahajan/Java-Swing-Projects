/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Retailer;

import Business.Customer.CartProduct;
import java.util.ArrayList;

/**
 *
 * @author mahajan
 */
public class Retailer 
{
    private String retailerName;
    private String zipCode;
    private ProductCatalogue productCatalogue;
    private String retailerNumber;
    private static int counter = 345001;
    private double earnings;
    private ArrayList<CartProduct> productSoldList;
    private RetailerInvoiceList retailerInvoiceList;
    
    
    public Retailer()
    {
        counter++;
        this.productCatalogue = new ProductCatalogue();
        this.productSoldList = new ArrayList<>();
        this.retailerNumber = String.valueOf(counter);
        this.retailerInvoiceList = new RetailerInvoiceList();
    }

    public String getRetailerNumber() {
        return retailerNumber;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    public ProductCatalogue getProductCatalogue() {
        return productCatalogue;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public ArrayList<CartProduct> getProductSoldList() {
        return productSoldList;
    }

    public RetailerInvoiceList getRetailerInvoiceList() {
        return retailerInvoiceList;
    }

    public void addToProductSoldList(CartProduct cp) {
        this.productSoldList.add(cp);
    }

    public double getEarnings() {
        return earnings;
    }
    
    public RetailerInvoice genrateInvoice() {
        if (this.productSoldList.size() > 0) {
            RetailerInvoice ri = retailerInvoiceList.addInvoice();
            ri.addCartProductSold(this.getProductSoldList());
            this.productSoldList.clear();
            ri.setTotalPriceToBePaid(ri.getCartProductsSold().getCartTotal());
            return ri;
        } else {
            return null;
        }
    }
    
    public boolean payRetailer (String invoiceNumber, Double amount) {
        if (this.retailerInvoiceList.pay(invoiceNumber, amount)) {
            this.earnings += amount;
            return true;
        } else {
            return false;
        }
    } 
    
    @Override
    public String toString()
    {
        return this.retailerName;
    }
}
