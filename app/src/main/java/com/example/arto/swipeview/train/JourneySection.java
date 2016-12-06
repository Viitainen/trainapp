
package com.example.arto.swipeview.train;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class JourneySection {

    @SerializedName("beginTimeTableRow")
    @Expose
    private BeginTimeTableRow beginTimeTableRow;
    @SerializedName("endTimeTableRow")
    @Expose
    private EndTimeTableRow endTimeTableRow;
    @SerializedName("locomotives")
    @Expose
    private List<Locomotive> locomotives = new ArrayList<Locomotive>();
    @SerializedName("wagons")
    @Expose
    private List<Wagon> wagons = new ArrayList<Wagon>();
    @SerializedName("totalLength")
    @Expose
    private Integer totalLength;
    @SerializedName("maximumSpeed")
    @Expose
    private Integer maximumSpeed;

    /**
     * 
     * @return
     *     The beginTimeTableRow
     */
    public BeginTimeTableRow getBeginTimeTableRow() {
        return beginTimeTableRow;
    }

    /**
     * 
     * @param beginTimeTableRow
     *     The beginTimeTableRow
     */
    public void setBeginTimeTableRow(BeginTimeTableRow beginTimeTableRow) {
        this.beginTimeTableRow = beginTimeTableRow;
    }

    /**
     * 
     * @return
     *     The endTimeTableRow
     */
    public EndTimeTableRow getEndTimeTableRow() {
        return endTimeTableRow;
    }

    /**
     * 
     * @param endTimeTableRow
     *     The endTimeTableRow
     */
    public void setEndTimeTableRow(EndTimeTableRow endTimeTableRow) {
        this.endTimeTableRow = endTimeTableRow;
    }

    /**
     * 
     * @return
     *     The locomotives
     */
    public List<Locomotive> getLocomotives() {
        return locomotives;
    }

    /**
     * 
     * @param locomotives
     *     The locomotives
     */
    public void setLocomotives(List<Locomotive> locomotives) {
        this.locomotives = locomotives;
    }

    /**
     * 
     * @return
     *     The wagons
     */
    public List<Wagon> getWagons() {
        return wagons;
    }

    /**
     * 
     * @param wagons
     *     The wagons
     */
    public void setWagons(List<Wagon> wagons) {
        this.wagons = wagons;
    }

    /**
     * 
     * @return
     *     The totalLength
     */
    public Integer getTotalLength() {
        return totalLength;
    }

    /**
     * 
     * @param totalLength
     *     The totalLength
     */
    public void setTotalLength(Integer totalLength) {
        this.totalLength = totalLength;
    }

    /**
     * 
     * @return
     *     The maximumSpeed
     */
    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    /**
     * 
     * @param maximumSpeed
     *     The maximumSpeed
     */
    public void setMaximumSpeed(Integer maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

}
