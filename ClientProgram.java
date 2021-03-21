/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author workway
 */
public class ClientProgram {

    private Client customer;
    Scanner scanner = new Scanner(System.in);
    private Store blankStore;
    HashMap<Product, Integer> tempProductList = new HashMap<>();
    private Cart newCart;

    public ClientProgram(Store store1) {
        blankStore = store1;
        tempProductList = blankStore.getProducList();

        while (true) {
            System.out.println("Select from the menu");
            System.out.println("Press 1 to show products"); //done
            System.out.println("Press 2 to login"); //done
            System.out.println("Press 3 profile edit");//done
            System.out.println("Press 4 to register"); //done
            System.out.println("Press 5 to log out"); //done
            System.out.println("Press 6 to exit"); //done

            int select = scanner.nextInt();
            if (select == 1) {
                clientShowProducts();
            }
       
            if (select == 2) {
                login();
            }

            if (select == 3) { // profile edit hashmap email client
                System.out.println("to edit client details");
                System.out.println("enter client email");
                String tempEmail = scanner.next();
                Client tempClient = blankStore.getClient(tempEmail);
                System.out.println("Enter client name");
                String name = scanner.next();
                System.out.println("Enter client surname");
                String surname = scanner.next();;
                System.out.println("Enter client address");
                String adress = scanner.next();;
                System.out.println("Enter client phone");
                int phone = scanner.nextInt();

                Client one = new Client(name, surname, adress, phone, tempEmail);
                blankStore.setClient(tempEmail, tempClient);
                System.out.println("client details updated");

            }

            if (select == 4) {
                registration();
            }

            if (select == 5) {
                logout();
            }

            if (select == 6) {
                System.exit(0);
            }
        }
    }

    public void clientShowProducts() {
//

        for (Product key : tempProductList.keySet()) {
            if (tempProductList.get(key) > 0) {
                System.out.println(key);
            }
            System.out.println("you ready to order");
            newCart = new Cart();
            while (true) {
                System.out.println("to check you cart press 1");
                System.out.println("to add new product press 2");
                System.out.println("to remove product press 3");
                System.out.println("to proceed to checkout press 4");
                System.out.println("to exit press 8");
                int cartSelect = scanner.nextInt();

                if (cartSelect == 8) {
                    System.out.println("bye bye");
                    System.exit(0);
                }

                if (cartSelect == 1) {
                    newCart.cartInfo();
                }

                if (cartSelect == 2) {
                    newCart.addProduct(key);
                }

                if (cartSelect == 3) {
                    newCart.removeProduct(key);
                }

                if (cartSelect == 4) {
                    Order newOrder = new Order(blankStore.newOrderId(), LocalDateTime.now(), newCart.getCartInfo());
                    blankStore.addOrder(newOrder);
                    
                    newCart = null;
                    break;
                }
            }
        }
    }

    public void login() {
        System.out.println("enter customer email to login");
        String login = scanner.next();
        customer = blankStore.checkClient(login);
        if (customer != null) {

            System.out.println("logged in");
        } else {
            System.out.println("customer does not exist");
            return;
        }
    }

    public void registration() {
        System.out.println("Enter client data");
        System.out.println("Enter client email");
        String email = scanner.next();
        if (blankStore.checkClient(email) != null) {
            System.out.println("client already registered");
            login();
            return;
        }
        System.out.println("Enter client name");
        String name = scanner.next();
        System.out.println("Enter client surname");
        String surname = scanner.next();;
        System.out.println("Enter client address");
        String adress = scanner.next();;
        System.out.println("Enter client phone");
        int phone = scanner.nextInt();

        customer = new Client(name, surname, adress, phone, email);
        blankStore.addClient(email, customer);
        System.out.println("new client registered");
    }

    public void logout() {

        if (customer != null) {
            customer = null;
            System.out.println("you logged out");
        } else {
            System.out.println("you are not logged on");
        }
    }

    public class Cart {

        private int orderPrice;
        HashMap<Product, Integer> cartList = new HashMap<>();

        public void cartInfo() {
            orderPrice = 0;
            for (Product key : cartList.keySet()) {
                System.out.println("Product " + key + "; quantaty " + cartList.get(key)
                        + "; price " + key.getPrice(key));
                orderPrice = orderPrice + key.getPrice(key);
            }
            System.out.println("total order price " + orderPrice);
        }

        public void addProduct(Product product1) {
            for (Product key : cartList.keySet()) {
                if (cartList.get(key) > 0) {
                    cartList.replace(product1, Integer.MIN_VALUE, Integer.MIN_VALUE+1);
                } else {
                    cartList.put(product1, 1);
                }
            }
        }

        public void removeProduct(Product product1) {
            for (Product key : cartList.keySet()) {
                if (cartList.get(key) > 1) {
                    cartList.replace(product1, Integer.MIN_VALUE, Integer.MIN_VALUE - 1);
                } else {
                    cartList.remove(product1);
                }
            }
        }
        public HashMap<Product, Integer> getCartInfo () {
        return cartList;
        }
    }
}
//                ArrayList<Product> one = blankStore.showProducts();
//                ArrayList<Product> cart = new ArrayList<>();
//                while (true) {
//                    System.out.println("select product to add to cart");
//                    for (int i = 0; i < one.size(); i++) {
//                        System.out.println("to buy " + one.get(i) + " press " + i);
//                    }
//                    System.out.println("Press 7 to proceed to check out");
//                    System.out.println("Press 8 to exit");
//
//                    int cartSelect = scanner.nextInt();
//
//                    if (cartSelect == 7) {
//                        if (customer == null) {
//                            login();
//                        }
//
//                        System.out.println("enter order nu");
//                        //shop generated
//                        int id = scanner.nextInt();
//                        System.out.println("enter date");
//                        //store generated
//                        int date = scanner.nextInt();
//                        Order newOrder = new Order(id, date, cart);
//                        blankStore.addOrder(newOrder);
//                        break;
//
//                    }
//
//                    if (cartSelect == 8) {
//                        System.exit(0);
//                    }
//                    cart.add(one.get(cartSelect));
//                    // add right after selection
//                    //if added existing item, need to change qty only not create separate product
//                    // delete from cart edit and qty
//
//                    System.out.println("you have added " + one.get(cartSelect) + " to the cart");
//                    System.out.println("");
//                }

