package com.example.mackanrishastv.question6;

import android.util.Log;

public class Programmer extends Employee {

    protected int numberOfProject;



    protected char rank;

    public Programmer(String name, int age, boolean sex, String address, double baseSalary, int numberOfProject, char rank){
        super();
        this.numberOfProject = numberOfProject;
        this.rank = rank;
    }

    @Override
    public void computeYearlyPay() {
        double salary;
        salary = baseSalary + (10000*numberOfProject) + getBonusByRank();
        Log.d("ManhHung6", "This month's salary of " + this.name + " : " + salary);
    }

    public int getBonusByRank(){
        char rankTemp = this.getRank();
        switch (rankTemp){
            case 'A':
                return 10000;
            case 'B':
                return 7000;
            case 'C':
                return 4000;
                default: return 0;
        }

    }

    public char getRank() {
        return rank;
    }

    public void setRank(char rank) {
        this.rank = rank;
    }
}
