
package com.example.arto.swipeview.train;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("org.jsonschema2pojo")
public class Wagon {

    @SerializedName("wagonType")
    @Expose
    private String wagonType;
    @SerializedName("location")
    @Expose
    private Integer location;
    @SerializedName("salesNumber")
    @Expose
    private Integer salesNumber;
    @SerializedName("length")
    @Expose
    private Integer length;
    @SerializedName("playground")
    @Expose
    private Boolean playground;
    @SerializedName("video")
    @Expose
    private Boolean video;
    @SerializedName("disabled")
    @Expose
    private Boolean disabled;
    @SerializedName("catering")
    @Expose
    private Boolean catering;
    @SerializedName("pet")
    @Expose
    private Boolean pet;
    @SerializedName("luggage")
    @Expose
    private Boolean luggage;
    @SerializedName("smoking")
    @Expose
    private Boolean smoking;

    /**
     * 
     * @return
     *     The wagonType
     */
    public String getWagonType() {
        return wagonType;
    }

    /**
     * 
     * @param wagonType
     *     The wagonType
     */
    public void setWagonType(String wagonType) {
        this.wagonType = wagonType;
    }

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
     *     The salesNumber
     */
    public Integer getSalesNumber() {
        return salesNumber;
    }

    /**
     * 
     * @param salesNumber
     *     The salesNumber
     */
    public void setSalesNumber(Integer salesNumber) {
        this.salesNumber = salesNumber;
    }

    /**
     * 
     * @return
     *     The length
     */
    public Integer getLength() {
        return length;
    }

    /**
     * 
     * @param length
     *     The length
     */
    public void setLength(Integer length) {
        this.length = length;
    }

    /**
     * 
     * @return
     *     The playground
     */
    public Boolean getPlayground() {
        return playground;
    }

    /**
     * 
     * @param playground
     *     The playground
     */
    public void setPlayground(Boolean playground) {
        this.playground = playground;
    }

    /**
     * 
     * @return
     *     The video
     */
    public Boolean getVideo() {
        return video;
    }

    /**
     * 
     * @param video
     *     The video
     */
    public void setVideo(Boolean video) {
        this.video = video;
    }

    /**
     * 
     * @return
     *     The disabled
     */
    public Boolean getDisabled() {
        return disabled;
    }

    /**
     * 
     * @param disabled
     *     The disabled
     */
    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

    /**
     * 
     * @return
     *     The catering
     */
    public Boolean getCatering() {
        return catering;
    }

    /**
     * 
     * @param catering
     *     The catering
     */
    public void setCatering(Boolean catering) {
        this.catering = catering;
    }

    /**
     * 
     * @return
     *     The pet
     */
    public Boolean getPet() {
        return pet;
    }

    /**
     * 
     * @param pet
     *     The pet
     */
    public void setPet(Boolean pet) {
        this.pet = pet;
    }

    public Boolean getLuggage() { return luggage; }

    public void setLuggage(Boolean luggage) { this.luggage = luggage; }



    public Boolean getSmoking() { return smoking; }

    public void setSmoking(Boolean smoking) { this.smoking = smoking; }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append(location);
        builder.append(". Wagon: ");
        builder.append("Salesnumber ");
        builder.append(salesNumber);
        builder.append(System.lineSeparator());
        builder.append("Playground: ");
        builder.append(playground == null ? "✘" : "✓");
        builder.append(System.lineSeparator());
        builder.append("Pet: ");
        builder.append(pet == null ? "✘" : "✓");
        builder.append(System.lineSeparator());
        builder.append("Catering: ");
        builder.append(catering == null ? "✘" : "✓");
        builder.append(System.lineSeparator());
        builder.append("Video: ");
        builder.append(video == null ? "✘" : "✓");
        builder.append(System.lineSeparator());
        builder.append("Luggage: ");
        builder.append(luggage == null ? "✘" : "✓");
        builder.append(System.lineSeparator());
        builder.append("Smoking: ");
        builder.append(smoking == null ? "✘" : "✓");
        builder.append(System.lineSeparator());
        builder.append("Disabled: ");
        builder.append(disabled == null ? "✘" : "✓");

        return builder.toString();
    }

}
