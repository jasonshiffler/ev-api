package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="vehicle")
@Data
public class Vehicle extends AbstractEntity{

    String vin;
    String color;

    @Column(name="display_name")
    @JsonProperty("display_name")
    String displayName;

    @Column(name="vehicle_id")
    @JsonProperty("vehicle_id")
    String vehicleId;

    @Column(name="option_codes")
    @JsonProperty("option_codes")
    String optionCodes;

    @Column(name="user_id")
    @JsonProperty("user_id")
    String userId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty("charge_state")
    private  ChargeState chargeState;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty("drive_state")
    private  DriveState driveState;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty("vehicle_config")
    private  VehicleConfig vehicleConfig;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    @JsonProperty("climate_state")
    private  ClimateState climateState;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="vehicle_id")
    private List<Token> tokens = new ArrayList<>();

}
