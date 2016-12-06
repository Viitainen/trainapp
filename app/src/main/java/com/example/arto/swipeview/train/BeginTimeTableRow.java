
package com.example.arto.swipeview.train;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class BeginTimeTableRow {

    @SerializedName("stationShortCode")
    @Expose
    private String stationShortCode;
    @SerializedName("stationUICCode")
    @Expose
    private Integer stationUICCode;
    @SerializedName("countryCode")
    @Expose
    private String countryCode;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("scheduledTime")
    @Expose
    private String scheduledTime;

    /**
     * 
     * @return
     *     The stationShortCode
     */
    public String getStationShortCode() {
        return stationShortCode;
    }

    /**
     * 
     * @param stationShortCode
     *     The stationShortCode
     */
    public void setStationShortCode(String stationShortCode) {
        this.stationShortCode = stationShortCode;
    }

    /**
     * 
     * @return
     *     The stationUICCode
     */
    public Integer getStationUICCode() {
        return stationUICCode;
    }

    /**
     * 
     * @param stationUICCode
     *     The stationUICCode
     */
    public void setStationUICCode(Integer stationUICCode) {
        this.stationUICCode = stationUICCode;
    }

    /**
     * 
     * @return
     *     The countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param countryCode
     *     The countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * 
     * @return
     *     The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The scheduledTime
     */
    public String getScheduledTime() {
        return scheduledTime;
    }

    /**
     * 
     * @param scheduledTime
     *     The scheduledTime
     */
    public void setScheduledTime(String scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

}
