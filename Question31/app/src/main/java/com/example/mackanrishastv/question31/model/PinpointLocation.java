
package com.example.mackanrishastv.question31.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PinpointLocation {

    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("name")
    @Expose
    private String name;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
