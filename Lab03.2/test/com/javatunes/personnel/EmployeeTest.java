package com.javatunes.personnel;

import org.junit.Before;
import org.junit.Test;

import java.sql.Date;

import static org.junit.Assert.*;

public class EmployeeTest {
    //business objects under test - called the "fixture"
    private Employee emp1;
    private Employee emp2;

    @Before
    public void setUp() {
        //emp1 = new SalariedEmployee("Kevin", Date.valueOf("2002-02-02"));
        //emp2 = new SalariedEmployee("Kevin", Date.valueOf("2002-02-02"));
        //emp1 = new DummyEmployee("Kevin", Date.valueOf("2002-02-02"));
        //emp2 = new DummyEmployee("Kevin", Date.valueOf("2002-02-02"));

        //instance of unnamed subclass
        /*
        emp1 = new Employee("Kevin", Date.valueOf("2002-02-02")) {
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };
        emp2 = new Employee("Kevin", Date.valueOf("2002-02-02")) {
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };
        */
         emp1 = getEmployee();
    }

    private Employee getEmployee() {
        return new Employee("Kevin", Date.valueOf("2002-02-02")) {
            @Override
            public double pay() {
                return 0;
            }

            @Override
            public double payTaxes() {
                return 0;
            }
        };
    }

    @Test
    public void hashCode_shouldReturnSameValue_equalObjects() {
        assertEquals(emp1.hashCode(), emp2.hashCode());
    }

    @Test
    public void equals_shouldReturnFalse_differentName_sameHireDate() {
        emp2.setName("James");

        assertNotEquals(emp1, emp2);

    }

    @Test
    public void equals_shouldReturnTrue_allPropertiesSame() {
        assertEquals(emp1,emp2);  //uses equals()
        assertTrue(emp1.equals(emp2));
    }

    @Test
    public void equals_ShouldReturnFalse_sameName_differentHireDate() {
        emp2.setHireDate(Date.valueOf("2004-04-04"));
        assertNotEquals(emp1, emp2);
    }
    //NAMED MEMBER-LEVEL INNER CLASS
    private class DummyEmployee extends Employee{

        public DummyEmployee(String name, Date hireDate) {
            super(name, hireDate);
        }

        @Override
        public double pay() {
            return 0;
        }

        @Override
        public double payTaxes() {
            return 0;
        }
    }
}