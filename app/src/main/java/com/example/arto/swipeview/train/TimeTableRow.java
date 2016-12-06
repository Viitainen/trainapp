
package com.example.arto.swipeview.train;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TimeTableRow {

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
    @SerializedName("trainStopping")
    @Expose
    private Boolean trainStopping;
    @SerializedName("commercialStop")
    @Expose
    private Boolean commercialStop;
    @SerializedName("commercialTrack")
    @Expose
    private String commercialTrack;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("scheduledTime")
    @Expose
    private String scheduledTime;
    @SerializedName("actualTime")
    @Expose
    private String actualTime;
    @SerializedName("differenceInMinutes")
    @Expose
    private Integer differenceInMinutes;
    @SerializedName("causes")
    @Expose
    private List<Object> causes = new ArrayList<Object>();
    @SerializedName("liveEstimateTime")
    @Expose
    private String liveEstimateTime;

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
     *     The trainStopping
     */
    public Boolean getTrainStopping() {
        return trainStopping;
    }

    /**
     * 
     * @param trainStopping
     *     The trainStopping
     */
    public void setTrainStopping(Boolean trainStopping) {
        this.trainStopping = trainStopping;
    }

    /**
     * 
     * @return
     *     The commercialStop
     */
    public Boolean getCommercialStop() {
        return commercialStop;
    }

    /**
     * 
     * @param commercialStop
     *     The commercialStop
     */
    public void setCommercialStop(Boolean commercialStop) {
        this.commercialStop = commercialStop;
    }

    /**
     * 
     * @return
     *     The commercialTrack
     */
    public String getCommercialTrack() {
        return commercialTrack;
    }

    /**
     * 
     * @param commercialTrack
     *     The commercialTrack
     */
    public void setCommercialTrack(String commercialTrack) {
        this.commercialTrack = commercialTrack;
    }

    /**
     * 
     * @return
     *     The cancelled
     */
    public Boolean getCancelled() {
        return cancelled;
    }

    /**
     * 
     * @param cancelled
     *     The cancelled
     */
    public void setCancelled(Boolean cancelled) {
        this.cancelled = cancelled;
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

    /**
     * 
     * @return
     *     The actualTime
     */
    public String getActualTime() {
        return actualTime;
    }

    /**
     * 
     * @param actualTime
     *     The actualTime
     */
    public void setActualTime(String actualTime) {
        this.actualTime = actualTime;
    }

    /**
     * 
     * @return
     *     The differenceInMinutes
     */
    public Integer getDifferenceInMinutes() {
        return differenceInMinutes;
    }

    /**
     * 
     * @param differenceInMinutes
     *     The differenceInMinutes
     */
    public void setDifferenceInMinutes(Integer differenceInMinutes) {
        this.differenceInMinutes = differenceInMinutes;
    }

    /**
     * 
     * @return
     *     The causes
     */
    public List<Object> getCauses() {
        return causes;
    }

    /**
     * 
     * @param causes
     *     The causes
     */
    public void setCauses(List<Object> causes) {
        this.causes = causes;
    }

    /**
     * 
     * @return
     *     The liveEstimateTime
     */
    public String getLiveEstimateTime() {
        return liveEstimateTime;
    }

    /**
     * 
     * @param liveEstimateTime
     *     The liveEstimateTime
     */
    public void setLiveEstimateTime(String liveEstimateTime) {
        this.liveEstimateTime = liveEstimateTime;
    }

}
