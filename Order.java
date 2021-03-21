/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author workway
 */
public class Order {
    private int id;
    private LocalDateTime date;
    private Client client;
    private int sum;
    private HashMap <Product, Integer> blankCart = new HashMap();
    Random random = new Random();
    
    public Order (int id1, LocalDateTime date1, HashMap<Product, Integer> cart1 ) {
        this.id= id1;
        this.date=date1;
        this.blankCart=cart1;
    }
    
    public HashMap<Product, Integer> getCart () {
    return blankCart;
    }
    
    public void removeFromOrder (Product product1) {
    blankCart.replace(product1, blankCart.get(product1), blankCart.get(product1)-1);
    }    
    
    public int getOrderId () {
        return id;
    }
}