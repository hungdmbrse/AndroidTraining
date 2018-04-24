package com.example.mackanrishastv.question4;

import android.util.Log;

import java.util.ArrayList;

public class Account {
    //氏名
    private String name;
    //年齢
    private int age;
    //性別
    private String sex;
    //得意な言語
    private String language;

    public Account(String name, int age, String sex, String language){
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.language = language;
    }

    public Account(){

    }

    public void showAccount(ArrayList<Account> lstAccount){
        Account accTemp = null;
        for(int i = 0; i < lstAccount.size(); i++){
            accTemp = lstAccount.get(i);
            if (accTemp.getSex().equals("Male")){
                Log.d("ManhHung4", accTemp.name + "君は、" + accTemp.getLanguage() + "が得意な" +
                        "な"+ String.valueOf(accTemp.getAge()) + "歳です");
            } else {
                Log.d("ManhHung4", accTemp.name + "さんは、"+ accTemp.getLanguage() + "が得意な" + "な"+ String.valueOf(accTemp.getAge()) + "歳です");
            };
        }

        Log.d("ManhHung4", "Done");
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }







}
