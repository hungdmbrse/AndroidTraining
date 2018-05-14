package com.example.mackanrishastv.question5;

public class TenYearTeacher extends Teacher {

    public TenYearTeacher(String name, int age, boolean sex, double salary){
        super(name, age, sex, salary);
    }

    public double calculateSalary(){
        return salary*1.3;
    }
}
