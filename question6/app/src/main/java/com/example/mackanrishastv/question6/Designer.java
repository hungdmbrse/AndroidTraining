package com.example.mackanrishastv.question6;

import android.util.Log;

public class Designer extends Employee {

    protected int numberOfProject;

    public Designer(String name, int age, boolean sex, String address, double baseSalary, int numberOfProject) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.baseSalary = baseSalary;
        this.numberOfProject = numberOfProject;
    }

    @Override
    public void computeYearlyPay() {
        double salary;
        salary = baseSalary + (10000*numberOfProject);
        Log.d("ManhHung6", "This month's salary of " + this.name + " : " + salary);
    }
}
