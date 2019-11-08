package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="vehicle_config")
@Data
public class VehicleConfig extends AbstractEntity{

    @Column(name="can_accept_navigation_requests")
    @JsonProperty("can_accept_navigation_requests")
    Boolean canAcceptNavigationRequests;

    @Column(name="can_actuate_trunks")
    @JsonProperty("can_actuate_trunks")
    Boolean canActuateTrunks;

    @Column(name="car_special_type")
    @JsonProperty("car_special_type")
    String carSpecialType;

    @Column(name="car_type")
    @JsonProperty("car_type")
    String carType;

    @Column(name="charge_port_type")
    @JsonProperty("charge_port_type")
    String chargePortType;

    @Column(name="eu_vehicle")
    @JsonProperty("eu_vehicle")
    Boolean euVehicle;

    @Column(name="exterior_color")
    @JsonProperty("exterior_color")
    String exteriorColor;

    @Column(name="has_air_suspension")
    @JsonProperty("has_air_suspension")
    Boolean hasAirSuspension;

    @Column(name="has_ludicrous_mode")
    @JsonProperty("has_ludicrous_mode")
    Boolean hasLudicrousMode;

    @Column(name="motorized_charge_port")
    @JsonProperty("motorized_charge_port")
    Boolean motorizedChargePort;

    @Column(name="perf_config")
    @JsonProperty("perf_config")
    String perfConfig;

    @Column(name="plg")
    @JsonProperty("plg")
    Boolean plg;

    @Column(name="rear_seat_heaters")
    @JsonProperty("rear_seat_heaters")
    Integer rearSeatHeaters;

    @Column(name="rear_seat_type")
    @JsonProperty("rear_seat_type")
    Integer rearSeatType;

    @Column(name="rhd")
    @JsonProperty("rhd")
    Boolean rhd;

    @Column(name="roof_color")
    @JsonProperty("roof_color")
    String roofColor;

    @Column(name="seat_type")
    @JsonProperty("seat_type")
    Integer seatType;

    @Column(name="spoiler_type")
    @JsonProperty("spoiler_type")
    String spoilerType;

    @Column(name="sun_roof_installed")
    @JsonProperty("sun_roof_installed")
    Integer sunRoofInstalled;

    @Column(name="third_row_seats")
    @JsonProperty("third_row_seats")
    String thirdRowSeats;

    @Column(name="time_stamp")
    @JsonProperty("time_stamp")
    Long timestamp;

    @Column(name="trim_badging")
    @JsonProperty("trim_badging")
    String trimBadging;

    @Column(name="wheel_type")
    @JsonProperty("wheel_type")
    String wheelType;

    @OneToOne(mappedBy="vehicleConfig") //name of the VehicleConfig field in the Vehicle object
    @JoinColumn(name="id")
    @JsonIgnore
    private Vehicle vehicle;


}
