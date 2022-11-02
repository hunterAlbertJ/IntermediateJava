package com.entertainment;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TelevisionTest {
    private Television tv;
    private Television tvA;
    private Television tvB;


    @Before
    public void setUp()  {
        tv = new Television();
        tvA = new Television("LG", 50, DisplayType.LED);
        tvB = new Television("Samsung", 50, DisplayType.LED);


    }
    @Test
    public void hashcode_shouldReturnSame_sameValues(){
        tvA.setBrand("Samsung");
        assertEquals(tvA.hashCode(), tvB.hashCode());
    }

    @Test
    public void hashcode_shouldReturnDifferent_differentValues(){
        assertNotEquals(tvA.hashCode(), tvB.hashCode());
    }

    @Test
    public void equals_shouldReturnTrue_allValuesSame(){
        tvA.setBrand("Samsung");
        assertEquals(tvA,tvB);
    }

    @Test
    public void equals_shouldReturnFalse_differentDisplayType(){
        tvA.setBrand("Samsung");
        tvA.setDisplay(DisplayType.CRT);
        assertNotEquals(tvA, tvB);
    }

    @Test
    public void equals_shouldReturnFalse_differentVolume(){
        tvA.setBrand("Samsung");
        tvA.setVolume(55);
        assertNotEquals(tvA, tvB);
    }

    @Test
    public void equals_shouldReturnFalse_differentName(){
        assertNotEquals(tvA, tvB);
    }

    @Test
    public void compareTo_shouldReturnEqual_whenTv1IsTheSameAsTv2(){
        Television tv1 = new Television("Zoink", 50);
        Television tv2 = new Television("Zoink", 50);
        assertTrue(tv1.compareTo(tv2) == 0);
    }

    @Test
    public void compareTo_shouldReturnPositive_whenTv1IsGreaterThanTv2(){
        Television tv1 = new Television("Zoink", 50);
        Television tv2 = new Television("Samsung", 50);
        assertTrue(tv1.compareTo(tv2) > 0);
    }


    @Test
    public void compareTo_shouldReturnNegative_whenTvAIsLessThanTvB(){
        assertTrue(tvA.compareTo(tvB) < 0);
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValidValue_upperBound() throws InvalidChannelException {
        tv.changeChannel(999);
        assertEquals(999, tv.getCurrentChannel());
    }

    @Test(expected = InvalidChannelException.class)
    public void changeChannel_shouldThrowInvalidChannelException_invalidValue_upperBound() throws InvalidChannelException {
        tv.changeChannel(1000);

    }

    @Test
    public void changeChannel_shouldThrowInvalidChannelException_invalidValue_lowerBound(){
        try{
            tv.changeChannel(0);//should trigger exception
            fail("Should have thrown InvalidChannelException");
        } catch(InvalidChannelException e){
            //verify that the exception's message is what I excpect
            assertEquals("Invalid channel: 0. Allowed range: [1,999].", e.getMessage());
        }
    }

    @Test
    public void changeChannel_shouldStoreValue_whenValidValue_lowerBound()
    throws InvalidChannelException{
        tv.changeChannel(1);
        assertEquals(1, tv.getCurrentChannel());
    }


    @Test
    public void setVolume_shouldStoreVolume_whenValid_upperBound() {
        tv.setVolume(100);
        assertEquals(100, tv.getVolume());
    }

    @Test
    public void setVolume_shouldStoreVolume_whenValid_lowerBound() {
        tv.setVolume(0);
        assertEquals(0, tv.getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalidValue_upperBound() {
        tv.setVolume(101);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setVolume_shouldThrowIllegalArgumentException_whenInvalidValue_lowerBound(){
        tv.setVolume(-1);
    }

}