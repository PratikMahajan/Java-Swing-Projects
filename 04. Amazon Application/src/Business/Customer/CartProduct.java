/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.Product;
import java.util.Comparator;
import java.util.Calendar;

/**
 *
 * @author mahajan
 */
public class CartProduct 
{
    private Product product;
    private int itemNos;
    private int price;
    private Calendar diliveryTime;

    public CartProduct(){}

    public CartProduct(Product prod, int numbers)
    {
        this.product=prod;
        this.itemNos=numbers;
    }
    
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getItemNo() {
        return itemNos;
    }

    public void setItemNo(int itemNo) {
        this.itemNos = itemNo;
    }
    
    public int getPrice() {
        return price = product.getPrice()*itemNos;
    }

    public Calendar getDiliveryTime() {
        return diliveryTime;
    }

    public void setDiliveryTime(Calendar diliveryTime) {
        this.diliveryTime = diliveryTime;
    } 

    @Override
    public String toString() {
        return String.valueOf(itemNos);
    }
    
    public static Comparator<CartProduct> ByItemNo = new Comparator<CartProduct> () {
        @Override
        public int compare(CartProduct cp1, CartProduct cp2) {
             return (int) (cp1.getItemNo() - cp2.getItemNo());
        }
    };
    
    public static Comparator<CartProduct> ByPrice = new Comparator<CartProduct> () {
        @Override
        public int compare(CartProduct cp1, CartProduct cp2) {
             return (int) (cp1.getPrice()- cp2.getPrice());
        }
    };
}
