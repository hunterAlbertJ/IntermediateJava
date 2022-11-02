package com.javatunes.personnel;

class EmployeeClient {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.work();
        emp.pay();
        long begin = System.nanoTime();
        emp.work();
        emp.pay();
        long end = System.nanoTime();

        double elapsedMillis = (end - begin) / 1_000_000.0;
        System.out.println(elapsedMillis);
    }

}