package com.example.mackanrishastv.question6;

public abstract class Employee {
    public Employee(String name, int age, boolean sex, String address, double baseSalary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.baseSalary = baseSalary;
    }

    protected String name;
    protected int age;
    protected boolean  sex;
    protected String address;
    protected double baseSalary;

    public abstract void computeYearlyPay();
}
