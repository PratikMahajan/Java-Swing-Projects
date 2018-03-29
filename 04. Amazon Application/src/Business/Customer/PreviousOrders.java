/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;
import java.util.ArrayList;

/**
 *
 * @author mahajan
 */
public class PreviousOrders 
{
    private ArrayList<CartProduct> cartCat;
    
    public PreviousOrders()
    {
        this.cartCat= new ArrayList<CartProduct>();
    }
    
    public void addCartToPrev(ArrayList<CartProduct> cpp)
    {
        cartCat.addAll(cpp);
    }

    public ArrayList<CartProduct> getCartCat() {
        return cartCat;
    }
    
    public void addCartCat(CartProduct cartCatal)
    {
        this.cartCat.add(cartCatal);
    }
    
    public void remCartCat(CartProduct cartCatal)
    {
        this.cartCat.remove(cartCatal);
    }
    
    public int totalProducts() {
        int total = 0;
        for (CartProduct cp : this.cartCat) {
            total += cp.getItemNo();
        }
        return total;
    }
    
    public int totalPrice() {
        int total = 0;
        for (CartProduct cp : this.cartCat) {
            total += cp.getPrice();
        }
        return total;
    }
    
    
    
}
