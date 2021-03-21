/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author workway
 */
public class Store {

    Random random = new Random();
    private HashMap<String, Client> clientList = new HashMap<>();
    private HashMap<Product, Integer> productList = new HashMap<>();
    private ArrayList<Order> orderList = new ArrayList<>();

    public Store() {
        productRestock();
    }

    public void connector() {

    }

    private void productRestock() {
        Product.BOOK.setPrice(Product.BOOK);
        Integer qty = random.nextInt(7 - 3) + 3;
        productList.put(Product.BOOK, qty);

        Product.CUP.setPrice(Product.CUP);
        qty = random.nextInt(7 - 3) + 3;
        productList.put(Product.CUP, qty);

        Product.DVD.setPrice(Product.DVD);
        qty = random.nextInt(7 - 3) + 3;
        productList.put(Product.DVD, qty);

        Product.FOLDER.setPrice(Product.FOLDER);
        qty = random.nextInt(7 - 3) + 3;
        productList.put(Product.FOLDER, qty);

        Product.PEN.setPrice(Product.PEN);
        qty = random.nextInt(7 - 3) + 3;
        productList.put(Product.PEN, qty);

        Product.PHONE.setPrice(Product.PHONE);
        qty = random.nextInt(7 - 3) + 3;
        productList.put(Product.PHONE, qty);
    }

    public void addClient(String key1, Client value1) {
        clientList.put(key1, value1);
    }

    public ArrayList showProducts() {
        ArrayList<Product> showProduct = new ArrayList<>();
        for (Product key : productList.keySet()) {
            if (productList.get(key) > 0) {
                showProduct.add(key);
            }
        }
        return showProduct;
    }

    public HashMap getProducList() {
        return productList;
    }

    public Client checkClient(String email1) {
        return clientList.get(email1);
    }

    public void addOrder(Order order1) {
        for(Product key: order1.getCart().keySet()){
        
            if (productList.get(key)>=0){
            productList.replace(key, productList.get(key), productList.get(key)-1);
            
            } else {
         order1.removeFromOrder(key);
         System.out.println("Product "+key+" not in stock, removed from order");

            }
            }
        orderList.add(order1);
        order1.getOrderId();        
    }

    public int newOrderId() {
        int id = orderList.size() + 1;;
        return id;
    }

    public Client getClient(String email1) {
        return clientList.get(email1);
    }

    public void setClient(String email1, Client client1) {
        clientList.replace(email1, client1);
    }

}
