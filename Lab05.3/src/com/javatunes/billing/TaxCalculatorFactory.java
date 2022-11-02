package com.javatunes.billing;

import java.util.HashMap;
import java.util.Map;

public class TaxCalculatorFactory {
    /*
     * we could impliment a chache of TaxCalculator instances
     * Everytime a new one is created we store it in a cache
     * then when we are asked for one, the cache is consulted first and
     * if it is there we fetch and return it
     * if its not we create a new on and add it to the cache and then return it
     */
    private static Map<Location, TaxCalculator> calcMap = new HashMap<>();
       private TaxCalculatorFactory(){
        }
    public static TaxCalculator getTaxCalculator(Location location) {
        //prevent instantiation - this is an all static class

        //declare return value
        TaxCalculator calc = null;
        if(calcMap.containsKey(location)){//theres one already in there
            calc = calcMap.get(location);
        }else {


        switch(location){
            case ONLINE:
                calc = new OnlineTax();
                break;
            case USA:
                calc = new USATax();
                break;
            case EUROPE:
                calc = new EuropeTax();
        }
        calcMap.put(location, calc);

        }
        return calc;
    }
}