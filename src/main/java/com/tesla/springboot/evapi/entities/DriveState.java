package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="drive_state")
@Data
public class DriveState extends AbstractEntity {


    @Column(name="shift_state")
    @JsonProperty("shift_state")
    String shiftState;

    @Column(name="speed")
    @JsonProperty("speed")
    Integer speed;

    @Column(name="power")
    @JsonProperty("power")
    Integer power;

    @Column(name="latitude")
    @JsonProperty("latitude")
    Float latitude;

    @Column(name="longitude")
    @JsonProperty("longitude")
    Float longitude;

    @Column(name="heading")
    @JsonProperty("heading")
    Integer heading;

    @Column(name="gps_as_of")
    @JsonProperty("gps_as_of")
    Double gpsAsOf;

    @Column(name="native_location_supported")
    @JsonProperty("native_location_supported")
    Integer nativeLocationSupported;

    @Column(name="native_latitude")
    @JsonProperty("native_latitude")
    Float nativeLatitude;

    @Column(name="native_longitude")
    @JsonProperty("native_longitude")
    Float nativeLongitude;

    @Column(name="native_type")
    @JsonProperty("native_type")
    String nativeType;

    @Column(name="time_stamp")
    @JsonProperty("time_stamp")
    Double timestamp;


    @OneToOne(mappedBy="driveState") //name of the ChargeState field in the Vehicle object
    @JoinColumn(name="id")
    @JsonIgnore
    private Vehicle vehicle;

}
