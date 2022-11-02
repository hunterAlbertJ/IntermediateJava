/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.Location;
import com.javatunes.billing.TaxCalculator;
import com.javatunes.billing.TaxCalculatorFactory;

import java.util.Collection;

public class Order {
    private String id;
    private Location location;

    private double cost;

    public double getCost() {
        return cost;
    }


    public Order(String id, Location location) {
        this.location = location;
        this.id = id;
    }
    /*
     * TODO: Friday morning
     *  Tax is a function of location and we have three ways of doing it
     * Online
     * USA
     * Europe
     * NOTE: we could do a massive if/else-if/else-if
     * but that would be really gross
     * so
     * we wont.
     *
     * BETTER: "find what varries and encapsulate it (into some hierarchy)
     * We have a family of TaxCalculators, with 3 members of the family
     * we will DELEGATE this work to one of those TaxCalculators
     * we will "fetch" (pull) the right one from a factory instead of saying "new" here.
     *
     */
    public double getTax(){
        //fetch the TaxCalculator from the factory
        TaxCalculator calc = TaxCalculatorFactory.getTaxCalculator(getLocation());
        //delegate here for actual tax calculation given this orders cost
        return calc.taxAmount(getCost());
    }
    /**
     * DONE:
     * get the items from the cart and iterate over them, print each item's product code
     * get cart total and print
     */
    public void processCart(ShoppingCart<? extends Product> cart) {
        System.out.println("Order: " + getId() + " contains the following:");

        Collection<? extends Product> cartItems = cart.allItems();
        for (Product product : cartItems) {
            System.out.println(product.getCode());
        }
        System.out.println("Order Total: " + cart.total());
    }

    public String getId() {
        return id;
    }
    public Location getLocation(){
        return location;
    }
}