
package com.example.mackanrishastv.question31.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Copyright {

    @SerializedName("provider")
    @Expose
    private List<Provider> provider = null;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("image")
    @Expose
    private Image_ image;

    public List<Provider> getProvider() {
        return provider;
    }

    public void setProvider(List<Provider> provider) {
        this.provider = provider;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Image_ getImage() {
        return image;
    }

    public void setImage(Image_ image) {
        this.image = image;
    }

}
