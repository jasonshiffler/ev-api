package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.tesla.springboot.evapi.views.VehicleView;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="vehicle_state")
@Data
@JsonView(VehicleView.detail.class)
public class VehicleState extends AbstractEntity {

    @OneToOne(mappedBy="vehicleState") //name of the VehicleState field in the Vehicle object
    @JoinColumn(name="id")
    @JsonIgnore
    private Vehicle vehicle;

    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    protected Long id;


    @Column(name="api_version")
    @JsonProperty("api_version")
    Integer apiVersion;

    @Column(name="autopark_state_v2")
    @JsonProperty("autopark_state_v2")
    String autoParkStateV2;

    @Column(name="autopark_style")
    @JsonProperty("autopark_style")
    String autoParkStyle;

    @Column(name="calendar_supported")
    @JsonProperty("calendar_supported")
    Boolean calendarSupported;

    @Column(name="car_version")
    @JsonProperty("car_version")
    String carVersion;

    @Column(name="center_display_state")
    @JsonProperty("center_display_state")
    Integer centerDisplayState;

    @Column(name="df")
    @JsonProperty("df")
    Integer df;

    @Column(name="dr")
    @JsonProperty("dr")
    Integer dr;

    @Column(name="ft")
    @JsonProperty("ft")
    Integer ft;


    @Column(name="homelink_nearby")
    @JsonProperty("homelink_nearby")
    Boolean homeLinkNearby;


    @Column(name="is_user_present")
    @JsonProperty("is_user_present")
    Boolean isUserPresent;

    @Column(name="last_autopark_error")
    @JsonProperty("last_autopark_error")
    String lastAutoParkError;

    @Column(name="locked")
    @JsonProperty("locked")
    Boolean locked;

    @Column(name="notifications_supported")
    @JsonProperty("notifications_supported")
    Boolean notificationsSupported;

    @Column(name="odometer")
    @JsonProperty("odometer")
    Float odometer;

    @Column(name="parsed_calendar_supported")
    @JsonProperty("parsed_calendar_supported")
    Boolean parsedCalendarSupported;

    @Column(name="pf")
    @JsonProperty("pf")
    Integer pf;

    @Column(name="pr")
    @JsonProperty("pr")
    Integer pr;

    @Column(name="remote_start")
    @JsonProperty("remote_start")
    Boolean remoteStart;

    @Column(name="remote_start_enabled")
    @JsonProperty("remote_start_enabled")
    Boolean remoteStartEnabled;

    @Column(name="remote_start_supported")
    @JsonProperty("remote_start_supported")
    Boolean remoteStartSupported;

    @Column(name="rt")
    @JsonProperty("rt")
    Integer rt;

    @Column(name="sentry_mode")
    @JsonProperty("sentry_mode")
    Boolean sentryMode;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty("speed_limit_mode")
    private SpeedLimitMode speedLimitMode;

    @Column(name="sun_roof_percent_open")
    @JsonProperty("sun_roof_percent_open")
    Integer sunRoofPercentOpen;

    @Column(name="sun_roof_state")
    @JsonProperty("sun_roof_state")
    String sunRoofState;

    @Column(name="time_stamp")
    @JsonProperty("timestamp")
    Long timestamp;

    @Column(name="valet_mode")
    @JsonProperty("valet_mode")
    Boolean valetMode;

    @Column(name="vehicle_name")
    @JsonProperty("vehicle_name")
    String vehicleName;


}
