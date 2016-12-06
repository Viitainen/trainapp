
package com.example.arto.swipeview.train;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Locomotive {

    @SerializedName("location")
    @Expose
    private Integer location;
    @SerializedName("locomotiveType")
    @Expose
    private String locomotiveType;
    @SerializedName("powerType")
    @Expose
    private String powerType;

    /**
     * 
     * @return
     *     The location
     */
    public Integer getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Integer location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The locomotiveType
     */
    public String getLocomotiveType() {
        return locomotiveType;
    }

    /**
     * 
     * @param locomotiveType
     *     The locomotiveType
     */
    public void setLocomotiveType(String locomotiveType) {
        this.locomotiveType = locomotiveType;
    }

    /**
     * 
     * @return
     *     The powerType
     */
    public String getPowerType() {
        return powerType;
    }

    /**
     * 
     * @param powerType
     *     The powerType
     */
    public void setPowerType(String powerType) {
        this.powerType = powerType;
    }

}
