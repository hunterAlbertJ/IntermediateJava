package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;
import java.sql.Date;

import static org.junit.Assert.*;

public class HourlyEmployeeTest {
    private HourlyEmployee emp;

    @Before
    public void setUp() {
        emp = new HourlyEmployee("James", Date.valueOf("2021-12-12"), 50.0,53.13 );
    }

    @Test
    public void testPay() {
        assertEquals(2656.5, emp.pay(), .001);
    }

    @Test
    public void testPayTaxes() {
        assertEquals(664.125, emp.payTaxes(), .001);
    }
}