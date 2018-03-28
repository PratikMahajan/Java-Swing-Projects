/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Retailer;

import Business.Product;
import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author mahajan
 */
public class ProductCatalogue {

    private ArrayList<Product> productCatalogue;

    public ProductCatalogue() {
        productCatalogue = new ArrayList<Product>();
    }

    public ArrayList<Product> getProductCatalogue() {
        return productCatalogue;
    }

    public void addProduct(Product prod) {
        this.productCatalogue.add(prod);
    }

    public void removeProduct(Product prod) {
        this.productCatalogue.remove(prod);
    }

    public ArrayList<Product> searchByName(String Name) {
        ArrayList<Product> temp = new ArrayList<Product>();

        for (Product res : productCatalogue) {
            if (res.getProductName().equals(Name)) {
                temp.add(res);
            }
        }

        if (temp != null) {
            return temp;
        } else {
            return null;
        }
    }

    public Product searchByNumber(String no) {
        for (Product prod : productCatalogue) {
            if (prod.getProductNumber().equals(no)) {
                return prod;
            }
        }
        return null;
    }
    
    public ArrayList<Product> getProductsSold () {
        if (this.getTotalSoldCount() > 0) {
            ArrayList<Product> productsSold = new ArrayList<>();
            for (Product p : productCatalogue) {
                if (p.getSoldNumber() > 0) {
                    productsSold.add(p);
                }
            }
            return productsSold;
        } else {
            return null;
        }
    }

    public Product getMostProductSold() {
        if (productCatalogue.size() > 0) {
            Product max = productCatalogue.get(0);
            for (Product p : productCatalogue) {
                if (p.getSoldNumber() > max.getSoldNumber()) {
                    max = p;
                }
            }
            return max.getSoldNumber() == 0 ? null : max;
        } else {
            return null;
        }
    }

    public Product getLeastProductSold() {
        if (productCatalogue.size() > 0) {
            Product min = productCatalogue.get(0);
            for (Product p : productCatalogue) {
                if (p.getSoldNumber() < min.getSoldNumber()) {
                    min = p;
                }
            }
            return min.getSoldNumber() == 0 ? null : min;
        } else {
            return null;
        }
    }

    public int getTotalSoldCount() {
        int total = 0;
        for (Product p : productCatalogue) {
            total += p.getSoldNumber();
        }
        return total;
    }
    
     public int getTotalSoldPrice() {
        int total = 0;
        for (Product p : productCatalogue) {
            total += (p.getSoldNumber()*p.getPrice());
        }
        return total;
    }

    public static Comparator<Product> ByProductsSold = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return (int) (p1.getSoldNumber() - p2.getSoldNumber());
        }

    };

    public static Comparator<Product> BySalePrice = new Comparator<Product>() {
        @Override
        public int compare(Product p1, Product p2) {
            return (int) ((p1.getSoldNumber() * p1.getPrice()) - (p2.getSoldNumber() * p2.getPrice()));
        }
    };

}
