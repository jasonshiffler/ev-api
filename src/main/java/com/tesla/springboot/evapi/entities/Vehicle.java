package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonView;
import com.tesla.springboot.evapi.views.VehicleView;
import lombok.Data;
import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="vehicle")
@Data
public class Vehicle extends AbstractEntity{

    @JsonView(VehicleView.summary.class)
    @Column(name="user_id")
    @JsonProperty("user_id")
    String userId;

    @JsonView(VehicleView.summary.class)
    @Column(name="vehicle_id")
    @JsonProperty("vehicle_id")
    String vehicleId;

    @JsonView(VehicleView.summary.class)
    String vin;

    @JsonView(VehicleView.summary.class)
    @Column(name="display_name")
    @JsonProperty("display_name")
    String displayName;

    @JsonView(VehicleView.summary.class)
    @Column(name="option_codes")
    @JsonProperty("option_codes")
    String optionCodes;

    @JsonView(VehicleView.summary.class)
    String color;

    @JsonView(VehicleView.summary.class)
    @Column(name="state")
    @JsonProperty("state")
    String state;

    @JsonView(VehicleView.summary.class)
    @Column(name="in_service")
    @JsonProperty("in_service")
    Boolean inService;

    @JsonView(VehicleView.summary.class)
    @Column(name="id_s")
    @JsonProperty("id_s")
    String ids;

    @JsonView(VehicleView.summary.class)
    @Column(name="calendar_enabled")
    @JsonProperty("calendar_enabled")
    Boolean calendarEnabled;

    @JsonView(VehicleView.summary.class)
    @Column(name="backseat_token")
    @JsonProperty("backseat_token")
    String backseatToken;

    @JsonView(VehicleView.summary.class)
    @Column(name="backseat_token_updated_at")
    @JsonProperty("backseat_token_updated_at")
    Instant backseatTokenUpdatedAt;

    @JsonView(VehicleView.detail.class)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty("charge_state")
    private  ChargeState chargeState;

    @JsonView(VehicleView.detail.class)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty("drive_state")
    private  DriveState driveState;

    @JsonView(VehicleView.detail.class)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty("vehicle_config")
    private  VehicleConfig vehicleConfig;

    @JsonView(VehicleView.detail.class)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty("climate_state")
    private  ClimateState climateState;

    @JsonView(VehicleView.summary.class)
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="vehicle_id")
    private List<Token> tokens = new ArrayList<>();

}
