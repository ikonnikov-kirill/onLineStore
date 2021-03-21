/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.util.Random;

/**
 *
 * @author workway
 */
public enum Product {
    PEN, PHONE, DVD, BOOK, FOLDER, CUP;
    static private int price;
    Random random = new Random();
    
    public void setPrice (Product product) {
    this.price=random.nextInt(5-2)+2;
    }
    
    public int getPrice (Product product) {
        return price;
    }
}
