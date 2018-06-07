
package com.example.mackanrishastv.question32.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Temperature {

    public Min getMin() {
        return min;
    }

    public void setMin(Min min) {
        this.min = min;
    }

    public Max getMax() {
        return max;
    }

    public void setMax(Max max) {
        this.max = max;
    }

    @SerializedName("min")
    @Expose
    private Min min;
    @SerializedName("max")
    @Expose
    private Max max;

}
