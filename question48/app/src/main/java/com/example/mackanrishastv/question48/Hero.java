package com.example.mackanrishastv.question48;

public class Hero {
    public Hero(){
        //Mac dinh khi nhan data ru firebase
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    private String name;
    private String discription;

    public Hero(String name, String discription) {
        this.name = name;
        this.discription = discription;
    }
}
