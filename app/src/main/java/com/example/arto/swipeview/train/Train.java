
package com.example.arto.swipeview.train;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Train {

    @SerializedName("trainNumber")
    @Expose
    private Integer trainNumber;
    @SerializedName("departureDate")
    @Expose
    private String departureDate;
    @SerializedName("operatorUICCode")
    @Expose
    private Integer operatorUICCode;
    @SerializedName("operatorShortCode")
    @Expose
    private String operatorShortCode;
    @SerializedName("trainType")
    @Expose
    private String trainType;
    @SerializedName("trainCategory")
    @Expose
    private String trainCategory;
    @SerializedName("commuterLineID")
    @Expose
    private String commuterLineID;
    @SerializedName("runningCurrently")
    @Expose
    private Boolean runningCurrently;
    @SerializedName("cancelled")
    @Expose
    private Boolean cancelled;
    @SerializedName("version")
    @Expose
    private Long version;
    @SerializedName("timeTableRows")
    @Expose
    private List<TimeTableRow> timeTableRows = new ArrayList<TimeTableRow>();

    /**
     * 
     * @return
     *     The trainNumber
     */
    public Integer getTrainNumber() {
        return trainNumber;
    }

    /**
     * 
     * @param trainNumber
     *     The trainNumber
     */
    public void setTrainNumber(Integer trainNumber) {
        this.trainNumber = trainNumber;
    }

    /**
     * 
     * @return
     *     The departureDate
     */
    public String getDepartureDate() {
        return departureDate;
    }

    /**
     * 
     * @param departureDate
     *     The departureDate
     */
    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    /**
     * 
     * @return
     *     The operatorUICCode
     */
    public Integer getOperatorUICCode() {
        return operatorUICCode;
    }

    /**
     * 
     * @param operatorUICCode
     *     The operatorUICCode
     */
    public void setOperatorUICCode(Integer operatorUICCode) {
        this.operatorUICCode = operatorUICCode;
    }

    /**
     * 
     * @return
     *     The operatorShortCode
     */
    public String getOperatorShortCode() {
        return operatorShortCode;
    }

    /**
     * 
     * @param operatorShortCode
     *     The operatorShortCode
     */
    public void setOperatorShortCode(String operatorShortCode) {
        this.operatorShortCode = operatorShortCode;
    }

    /**
     * 
     * @return
     *     The trainType
     */
    public String getTrainType() {
        return trainType;
    }

    /**
     * 
     * @param trainType
     *     The trainType
     */
    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    /**
     * 
     * @return
     *     The trainCategory
     */
    public String getTrainCategory() {
        return trainCategory;
    }

    /**
     * 
     * @param trainCategory
     *     The trainCategory
     */
    public void setTrainCategory(String trainCategory) {
        this.trainCategory = trainCategory;
    }

    /**
     * 
     * @return
     *     The commuterLineID
     */
    public String getCommuterLineID() {
        return commuterLineID;
    }

    /**
     * 
     * @param commuterLineID
     *     The commuterLineID
     */
    public void setCommuterLineID(String commuterLineID) {
        this.commuterLineID = commuterLineID;
    }

    /**
     * 
     * @return
     *     The runningCurrently
     */
    public Boolean getRunningCurrently() {
        return runningCurrently;
    }

    /**
     * 
     * @param runningCurrently
     *     The runningCurrently
     */
    public void setRunningCurrently(Boolean runningCurrently) {
        this.runningCurrently = runningCurrently;
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
     *     The version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The timeTableRows
     */
    public List<TimeTableRow> getTimeTableRows() {
        return timeTableRows;
    }

    /**
     * 
     * @param timeTableRows
     *     The timeTableRows
     */
    public void setTimeTableRows(List<TimeTableRow> timeTableRows) {
        this.timeTableRows = timeTableRows;
    }

}
