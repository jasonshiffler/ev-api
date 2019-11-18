package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.tesla.springboot.evapi.views.VehicleView;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="climate_state")
@Data
@JsonView(VehicleView.detail.class)
public class ClimateState extends AbstractEntity {

    @OneToOne(mappedBy="climateState") //name of the ChargeState field in the Vehicle object
    @JoinColumn(name="id")
    @JsonIgnore
    private Vehicle vehicle;

    @Column(name="inside_temp")
    @JsonProperty("inside_temp")
    Float insideTemp;

    @Column(name="outside_temp")
    @JsonProperty("outside_temp")
    Float outsideTemp;

    @Column(name="driver_temp_setting")
    @JsonProperty("driver_temp_setting")
    Float driverTempSetting;

    @Column(name="passenger_temp_setting")
    @JsonProperty("passenger_temp_setting")
    Float passengerTempSetting;

    @Column(name="left_temp_direction")
    @JsonProperty("left_temp_direction")
    String leftTempDirection;

    @Column(name="right_temp_direction")
    @JsonProperty("right_temp_direction")
    String rightTempDirection;

    @Column(name="is_front_defroster_on")
    @JsonProperty("is_front_defroster_on")
    Boolean isFrontDefrosterOn;

    @Column(name="is_rear_defroster_on")
    @JsonProperty("is_rear_defroster_on")
    Boolean isRearDefrosterOn;

    @Column(name="fan_status")
    @JsonProperty("fan_status")
    Integer fanStatus;

    @Column(name="is_climate_on")
    @JsonProperty("is_climate_on")
    Boolean isClimateOn;

    @Column(name="min_avail_temp")
    @JsonProperty("min_avail_temp")
    Float minAvailTemp;

    @Column(name="max_avail_temp")
    @JsonProperty("max_avail_temp")
    Float maxAvailTemp;

    @Column(name="seat_heater_left")
    @JsonProperty("seat_heater_left")
    Boolean seatHeaterLeft;

    @Column(name="seat_heater_right")
    @JsonProperty("seat_heater_right")
    Boolean seatHeaterRight;

    @Column(name="seat_heater_rear_left")
    @JsonProperty("seat_heater_rear_left")
    Boolean seatHeaterRearLeft;

    @Column(name="seat_heater_rear_right")
    @JsonProperty("seat_heater_rear_right")
    Boolean seatHeaterRearRight;

    @Column(name="seat_heater_rear_center")
    @JsonProperty("seat_heater_rear_center")
    Boolean seatHeaterRearCenter;

    @Column(name="seat_heater_rear_right_back")
    @JsonProperty("seat_heater_rear_right_back")
    Integer seatHeaterRearRightBack;

    @Column(name="seat_heater_rear_left_back")
    @JsonProperty("seat_heater_rear_left_back")
    Integer seatHeaterRearLeftBack;

    @Column(name="battery_heater")
    @JsonProperty("battery_heater")
    Boolean batteryHeater;

    @Column(name="battery_heater_no_power")
    @JsonProperty("battery_heater_no_power")
    Boolean batteryHeaterNoPower;

    @Column(name="steering_wheel_heater")
    @JsonProperty("steering_wheel_heater")
    Boolean steeringWheelHeater;

    @Column(name="wiper_blade_heater")
    @JsonProperty("wiper_blade_heater")
    Boolean wiperBladeHeater;

    @Column(name="side_mirror_heaters")
    @JsonProperty("side_mirror_heaters")
    Boolean sideMirrorHeaters;

    @Column(name="is_preconditioning")
    @JsonProperty("is_preconditioning")
    Boolean isPreconditioning;

    @Column(name="smart_preconditioning")
    @JsonProperty("smart_preconditioning")
    Boolean smartPreconditioning;

    @Column(name="is_auto_conditioning_on")
    @JsonProperty("is_auto_conditioning_on")
    Boolean isAutoConditioningOn;

    @Column(name="time_stamp")
    @JsonProperty("timestamp")
    Long timestamp;

}
