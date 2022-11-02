package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class SalariedEmployeeTest {
    //business object(s) under test -this is called the fixture
    private SalariedEmployee emp1;
    private SalariedEmployee emp2;
    @Before
    public void setUp() {
        emp1 = new SalariedEmployee("Morgan", Date.valueOf("2022-10-03"), 1445.0);
        emp2 = new SalariedEmployee("Morgan", Date.valueOf("2022-10-03"), 1445.0);

    }


    @Test
    public void hashCode_shouldReturnSameValue_equalsObjects() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate_sameSalary() {
        emp2.setName("Hunter");
        assertNotEquals(emp1, emp2);

    }

    @Test
    public void equals_shouldReturnFalse_sameName_differentHireDate_sameSalary() {
        emp2.setHireDate(Date.valueOf("2022-10-25"));
        assertNotEquals(emp1, emp2);
    }

    @Test
    public void equals_shouldReturnFalse_sameName_sameHireDate_sifferentSalary() {
        emp2.setSalary(500.0);
        assertNotEquals(emp1,emp2);

    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1,emp2); //calls equals when object is passed in
    }

    @Test
    public void testPay() {
        assertEquals(1445.0, emp1.pay(), .001);

    }

    @Test
    public void testPayTaxes() {
        assertEquals(433.5, emp1.payTaxes(), .001);

    }
}