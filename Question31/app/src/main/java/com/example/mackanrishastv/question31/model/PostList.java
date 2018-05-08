
package com.example.mackanrishastv.question31.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PostList {

    @SerializedName("pinpointLocations")
    @Expose
    private List<PinpointLocation> pinpointLocations = null;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("forecasts")
    @Expose
    private List<Forecast> forecasts = null;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("publicTime")
    @Expose
    private String publicTime;
    @SerializedName("copyright")
    @Expose
    private Copyright copyright;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("description")
    @Expose
    private Description description;

    public List<PinpointLocation> getPinpointLocations() {
        return pinpointLocations;
    }

    public void setPinpointLocations(List<PinpointLocation> pinpointLocations) {
        this.pinpointLocations = pinpointLocations;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(String publicTime) {
        this.publicTime = publicTime;
    }

    public Copyright getCopyright() {
        return copyright;
    }

    public void setCopyright(Copyright copyright) {
        this.copyright = copyright;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

}
