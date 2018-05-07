package com.example.mackanrishastv.question19;

public class SocialNetwork  {

    public String getNameSocical() {
        return nameSocical;
    }

    public void setNameSocical(String nameSocical) {
        this.nameSocical = nameSocical;
    }

    public int getImgSocial() {
        return imgSocial;
    }

    public void setImgSocial(int imgSocial) {
        this.imgSocial = imgSocial;
    }

    private String nameSocical;
    private int imgSocial;

    public SocialNetwork(String nameSocical, int imgSocial) {
        this.nameSocical = nameSocical;
        this.imgSocial = imgSocial;
    }
}
