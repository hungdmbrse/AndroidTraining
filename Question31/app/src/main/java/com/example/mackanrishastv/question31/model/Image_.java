
package com.example.mackanrishastv.question31.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Image_ {

    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("height")
    @Expose
    private Integer height;

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

}
