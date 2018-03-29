/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Retailer;

import java.util.ArrayList;

/**
 *
 * @author karanracca
 */
public class RetailerInvoiceList {
    private ArrayList<RetailerInvoice> invoiceList;

    public RetailerInvoiceList() {
        this.invoiceList = new ArrayList<>();
    }

    public ArrayList<RetailerInvoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(ArrayList<RetailerInvoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
    
    public RetailerInvoice addInvoice () {
        RetailerInvoice ri = new RetailerInvoice();
        invoiceList.add(ri);
        return ri;
    }
    
    public boolean pay (String invoiceNumber, Double amount) {
        for (RetailerInvoice ri : this.invoiceList) {
            if ((ri.getInvoiceNumber().equals(invoiceNumber))) {
                ri.setPaid(true);
                return true;
            }
        }
        return false;
    }
    
}
