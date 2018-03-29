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
public class Product {

    private String productName;
    private String productNumber;
    private static int counter = 100001;
    private int price;
    private int availableUnits;
    private int sold = 0;
    

    public Product(String prodName, int price, int availableUnits) {
        counter++;
        this.productNumber = String.valueOf(counter);
        this.productName = prodName;
        this.price = price;
        this.availableUnits = availableUnits;
    }

    public Product() {
        counter++;
        this.productNumber = String.valueOf(counter);

    }

    public int getSoldNumber() {
        return sold;
    }

    public void sold(int qty) {
        this.sold += qty;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public int getAvailableUnits() {
        return availableUnits;
    }

    public void setAvailableUnits(int availableUnits) {
        this.availableUnits = availableUnits;
    }

    @Override
    public String toString() {
        return this.productName;
    }

}
