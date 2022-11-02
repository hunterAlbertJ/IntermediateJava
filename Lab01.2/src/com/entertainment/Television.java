package com.entertainment;

import java.util.Comparator;
import java.util.Objects;
/*
 * Natural order is defined by brand then by volume when tied on brand.
 * two part comparison is required
 * This makes "Television" consistent with equals. ie...
 * whatever fields are used in equals and hashcode,
 * those same fields are used in compareTo
 */
public class Television implements Comparable<Television> {
    private String brand;
    private int volume;

    private Tuner tuner = new Tuner();

    public Television(){
        //no-op
    }

    public Television(String brand, int volume){
        this.setBrand(brand);
        this.setVolume(volume);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getCurrentChannel(){
       return tuner.getChannel();
    }

    public void changeChannel(int channel){
        tuner.setChannel(channel);
    }

    @Override
    public int hashCode(){
        //this is a poorly written hash function because it easily results in
        //hash collisions which is when different objects coincidentally have the same hashcode
        //return getBrand().length() + getVolume();
        //delegate to Objects.hash() for a scientifically correct hash function
        //this is one that minimizes the probability of a hash collision
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj){
        boolean result = false;

        //proceed only if 'obj' is really an instance of Television
        if(this.getClass() == obj.getClass()){
            //downcast obj to more specific reference type Television
            //NOTE: Objects.equals() does a null-safe equality check for us
            Television other = (Television) obj;
            result = Objects.equals(this.getBrand(), other.getBrand()) &&
                    this.getVolume() == other.getVolume();
        }

        return result;


    }

    @Override
    public String toString(){
        return (this.getClass().getSimpleName() + " Brand= " + getBrand() + " Volume=" + getVolume() + " Channel=" + getCurrentChannel());
    }
    //Natural order is defined by 'brand' (String), then by 'volume' (int) when tied on brand
    @Override
    public int compareTo(Television o) {
        int result = this.getBrand().compareTo(o.getBrand());
        if(result == 0){
            result = Integer.compare(this.getVolume(), o.getVolume());
        }
        return result;
    }
}