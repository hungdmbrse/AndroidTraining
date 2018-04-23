package com.example.mackanrishastv.question5;

public class FiveYearTeacher extends Teacher {
    public FiveYearTeacher(String name, int age, boolean sex, double salary){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }

    public double calculateSalary(){
        return salary*1.1;
    }
}
