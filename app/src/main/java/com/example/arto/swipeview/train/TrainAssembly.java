
package com.example.arto.swipeview.train;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class TrainAssembly {

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
    @SerializedName("trainCategory")
    @Expose
    private String trainCategory;
    @SerializedName("trainType")
    @Expose
    private String trainType;
    @SerializedName("version")
    @Expose
    private Long version;
    @SerializedName("journeySections")
    @Expose
    private List<JourneySection> journeySections = new ArrayList<JourneySection>();

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
     *     The journeySections
     */
    public List<JourneySection> getJourneySections() {
        return journeySections;
    }

    /**
     * 
     * @param journeySections
     *     The journeySections
     */
    public void setJourneySections(List<JourneySection> journeySections) {
        this.journeySections = journeySections;
    }

}
