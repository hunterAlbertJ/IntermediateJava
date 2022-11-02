package org.stats;

import org.junit.Before;
import org.junit.Test;
import org.stats.RatingAnalyzer;

import java.util.Arrays;

import static org.junit.Assert.*;

public class RatingAnalyzerTest {
    //create private fields that will be reassigned at every test run
    private RatingAnalyzer standardDataset;
    private RatingAnalyzer negativeDataset;
    private RatingAnalyzer mixedPositiveNegativeDataset;
    private RatingAnalyzer zeroLengthDataset;
    private RatingAnalyzer oneLengthDataset;
    private RatingAnalyzer decendingDataset;
    private RatingAnalyzer equalOccurenceDataset;

    //Using the before annotation allows us to prevent a lot of redundancy
    @Before
    public void setUp() throws Exception {
        decendingDataset = RatingAnalyzer.newInstance(new int[] {10, 10, 9, 8, 7, 6, 5, 4, 3, 2,1});
        standardDataset = RatingAnalyzer.newInstance(new int[] {3, 5, 2, 3, 4, 1, 3, 4, 3});
        negativeDataset = RatingAnalyzer.newInstance(new int[] { -3, -5, -2, -3, -4, -1, -3, -4, -3 });
        mixedPositiveNegativeDataset = RatingAnalyzer.newInstance(new int[] {3, -5, 2, -3, 4, -1, 3, -4, 3});
        zeroLengthDataset = RatingAnalyzer.newInstance(new int[] {});
        oneLengthDataset = RatingAnalyzer.newInstance(new int[] {10});
        equalOccurenceDataset = RatingAnalyzer.newInstance(new int[]{1, 1, 3, 3, 4, 4});
    }

    @Test
    public void mean_correctAverageReturned_ValidOneLengthArrayPassed() throws IllegalArgumentException {
        assertEquals(10, oneLengthDataset.mean(), .001);
        oneLengthDataset.mean();
    }

    @Test
    public void mean_correctAverageReturned_ValidMixedIntArrayPassed() throws IllegalArgumentException {
        assertEquals(.222222222222, mixedPositiveNegativeDataset.mean(), .001);
    }

    @Test
    public void mean_correctAverageReturned_ValidPositiveIntArrayPassed() throws IllegalArgumentException {
        assertEquals(3.1111111111, standardDataset.mean(), .001);
    }

    @Test
    public void mean_correctAverageReturned_ValidNegativeIntArrayPassed() throws IllegalArgumentException {
        assertEquals(-3.1111111111, negativeDataset.mean(), .001);
    }

    @Test
    public void mean_correctAverageReturned_ValidEqualOccurrenceArrayPassed() {
        assertEquals(2.666666666666, equalOccurenceDataset.mean(), .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void mean_illegalArgumentExceptionReturned_emptyArrayPassed() throws IllegalArgumentException{
        zeroLengthDataset.mean();
    }

    @Test
    public void median_correctMiddleReturned_ValidOneLengthArrayPassed() throws IllegalArgumentException {
        assertEquals(10, oneLengthDataset.median(), .001);
    }

    @Test
    public void median_correctMiddleReturned_ValidMixedIntArrayPassed() {
        assertEquals(2, mixedPositiveNegativeDataset.median(), .001);
    }

    @Test
    public void median_correctMiddleReturned_ValidPositiveIntArrayPassed() {
        assertEquals(3, standardDataset.median(), .001);
    }

    @Test
    public void median_correctMiddleReturned_ValidNegativeIntArrayPassed() {
        assertEquals(-3, negativeDataset.median(), .001);
    }

    @Test
    public void median_correctMiddleReturned_ValidEqualOccurrenceArrayPassed() {
        assertEquals(3, equalOccurenceDataset.median(), .001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void median_illegalArgumentExceptionReturned_emptyArrayPassed() {
        zeroLengthDataset.median();
    }

    @Test
    public void mode_mostFrequentReturned_ValidOneLengthArrayPassed() {
        assertArrayEquals(new int[] {10}, oneLengthDataset.mode());
    }

    @Test
    public void mode_mostFrequentReturned_ValidMixedIntArrayPassed(){
        assertArrayEquals(new int[] {3}, mixedPositiveNegativeDataset.mode());
    }

    @Test
    public void mode_mostFrequentReturned_ValidPositiveIntArrayPassed(){
        assertArrayEquals(new int[] {3}, standardDataset.mode());
    }

    @Test
    public void mode_mostFrequentReturned_ValidNegativeIntArrayPassed(){
        assertArrayEquals(new int[] {-3}, negativeDataset.mode());
    }

    @Test
    public void mode_mostFrequentReturned_ValidEqualOccurrenceArrayPassed(){
        assertArrayEquals(new int[] {1,3,4}, equalOccurenceDataset.mode());
    }

    @Test(expected = IllegalArgumentException.class)
    public void mode_illegalArgumentExceptionReturned_emptyArrayPassed(){
        zeroLengthDataset.mode();
    }
}