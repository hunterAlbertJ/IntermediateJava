package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {

        //verify sameness does not equal same object in memory
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);

        Television tvC = new Television("Sony", 52);
        Television tvD = new Television("Sony", 12);

        //use == to show if tvA and tvB refer to same physical object
        System.out.println((tvA == tvB) + " tvA and tvB are the same object ");
        //use .equals to show if tvA and tvB are "equal"
        System.out.println((tvA.equals(tvB)) + " tvA and tvB exhibit sameness");

        System.out.println();

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvC);
        tvs.add(tvB);
        tvs.add(tvD);
        tvs.add(tvA);

        System.out.println("The size of the set is " + tvs.size()); //should be one

        for(Television tv : tvs){
            System.out.println(tv);
        }
    }
}