package com.james.stats;

import org.stats.RatingAnalyzer;

import java.util.*;

/*
 * WELCOME! This is James' Nifty Number Machine.
 * This machine solves all your mean, median and mode needs.
 *
 * NOTE: James and JamesCorp do not condone the use of this tool
 * to solve your 6th grade Pre-Algebra homework.
 * This tool is for verification purposes only.
 */
public class JamesNiftyNumberMachine implements RatingAnalyzer {
    /*
     * This number machine IS-A RatingAnalyzer, so we are implementing RatingAnalyzer
     * Which signs the contract that we must implement the below methods
     */

    //private field that will be referenced from methods
    private int[] inputArray;

    //CTOR that will allow us to accept an array of numbers to perform operations on.
    public JamesNiftyNumberMachine(int[] ratings) throws IllegalArgumentException{
        //I do not believe a setter is a requirement here as this class is already ab
        setInputArray(ratings);
    }

    //Getter/Setter to avoid directly touching private field.
    public void setInputArray(int[] inputArray) {
        this.inputArray = inputArray;
    }
    public int[] getInputArray() {
        return inputArray;
    }

    //Mean is the average of all the numbers in the dataset
    @Override
    public double mean() throws IllegalArgumentException{
        //Verify array is of valid length
        if(getInputArray().length == 0 || getInputArray().equals(null)){
            throw new IllegalArgumentException();
        } else {
            //Calculated with total accumulated value divided by passed array length
            //Verify that the input array is of valid length
            double accumulatedValue = 0.0;
            for (int valueOfIndex : getInputArray()) {
                accumulatedValue += valueOfIndex;
            }
            return accumulatedValue / getInputArray().length;
        }
    }

    //Median is the middle most value in the dataset.
    @Override
    public double median() throws IllegalArgumentException{
        //Verify input array is of valid length
        if(getInputArray().length == 0 || getInputArray().equals(null)){
            throw new IllegalArgumentException();
        } else {
            //Simply easier to add to an ArrayList, also for the very convenient sort method.
            ArrayList<Integer> numberList = new ArrayList<>();
            double result;
            //Iterate over the input array and add each digit to ArrayList
            for(int digit : getInputArray()){
                numberList.add(digit);
            }
            //Median must be sorted from least to greatest
            Collections.sort(numberList);
            //Determine where to select the middle is determined by if the input array length is even or odd.
            if(getInputArray().length % 2 != 0) {
                result = (double) numberList.get((getInputArray().length) / 2);
            } else {
                //Split the calculation into three lines for readability
                int temp1 = numberList.get((getInputArray().length) / 2);
                int temp2 = numberList.get((getInputArray().length / 2) - 1);
                result = (double) (temp1 + temp2) / 2;
            }
            return result;
        }
    }

    //Mode is the integer that occurs most in the dataset.
    @Override
    public int[] mode() {
        if(getInputArray().length == 0 || getInputArray().equals(null)){
            throw new IllegalArgumentException();
        } else {
            /*
             * When we build the logic of the current greatest value into the
             * first forEach we can avoid a follow-up forEach that would exist
             * purely to find the greatest value of the key value pairs.
             */
            int mostOccurrences = 1;
            //There is definitely a better way to build the result array than this. Office hours, JR?
            List<Integer> tempArrayList = new ArrayList<>();
            Map<Integer, Integer> OccurrenceMap = new HashMap<>();
            //Input array already verified to be array of int.
            for(int number : getInputArray()){
                //Checking to see if the loop has already seen key before.
                if(OccurrenceMap.containsKey(number)){
                    //Assigning temporary holding field because .replace wants a variable.
                    int tempNum = OccurrenceMap.get(number);
                    OccurrenceMap.replace(number, tempNum, ++tempNum);
                    //Checking if the newly assigned value of the key is the largest seen yet.
                    if(OccurrenceMap.get(number) > mostOccurrences){
                        mostOccurrences = OccurrenceMap.get(number);
                    }
                } else {
                    //If loop has not seen number yet, add to map.
                    OccurrenceMap.put(number, 1);
                }
            }
            /*
             * After we have iterated through the array we can now do so
             * again however this time knowing what key to pull via the known largest value
             */
            for(Map.Entry<Integer, Integer> item : OccurrenceMap.entrySet()) {
                if (item.getValue() == mostOccurrences) {
                    tempArrayList.add(item.getKey());
                }
            }
            /*
             * Conversion from ArrayList to Array as that is what the compiler demands.
             * Trying to build the return array in the previous forEach loop leaves you
             * with trailing zeros as when you instantiate the array beforehand you can not
             * assume the amount of most frequent integers and so must make the return array the size
             * of the input. If the amount of frequent integers is less than the size of the input array,
             * there are trailing zeros. However, you can not truncate them as there is nothing saying the
             * int "0" is not itself a most frequent integer.
             */
            int[] resultArray = new int[tempArrayList.size()];
            //use of regular for loop as if you used forEach you would have to keep track of index externally.
            for(int i = 0; i < tempArrayList.size(); i++){
                //Ah. this brings me back to my javascript roots
                resultArray[i] = tempArrayList.get(i);
            }
            return resultArray;
        }
    }
}