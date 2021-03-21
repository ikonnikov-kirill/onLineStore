/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

/**
 *
 * @author workway
 */
public class Client {
   private String name;
   private String surname;
   private String adress;
   private int phone;
   private String email;
      
   public Client (String name1, String surname1, String address1, int phone1, String email1) {
        this.name = name1;
        this.surname = surname1;
        this.adress = address1;
        this.phone = phone1;
        this.email = email1;
    }
   
   public String getEmail () {
       return email;
   }
   
   public void editClient (String name1, String surname1, String address1, int phone1, String email1) {
      this.name = name1;
        this.surname = surname1;
        this.adress = address1;
        this.phone = phone1;
        this.email = email1; 
   }
   
}
