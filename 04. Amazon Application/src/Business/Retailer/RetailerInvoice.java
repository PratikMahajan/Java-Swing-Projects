/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Retailer;

import Business.Customer.CartCatalogue;
import Business.Customer.CartProduct;
import java.util.ArrayList;

/**
 *
 * @author karanracca
 */
public class RetailerInvoice {
    private CartCatalogue cartProductsSold;
    private double totalPriceToBePaid;
    private static int counter = 5000;
    private String invoiceNumber;
    private boolean paid = false;

    public RetailerInvoice() {
        this.counter++;
        this.cartProductsSold = new CartCatalogue();
        this.invoiceNumber = String.valueOf(this.counter);
    }
    
    @Override
    public String toString() {
        return this.invoiceNumber;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public double getTotalPriceToBePaid() {
        return totalPriceToBePaid;
    }

    public void setTotalPriceToBePaid(double totalPriceToBePaid) {
        this.totalPriceToBePaid = totalPriceToBePaid;
    }

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }
    
    public void addCartProductSold (ArrayList<CartProduct> list) {
        this.cartProductsSold.getCartCat().addAll(list);
    } 

    public CartCatalogue getCartProductsSold() {
        return cartProductsSold;
    }
    
    
    
}
