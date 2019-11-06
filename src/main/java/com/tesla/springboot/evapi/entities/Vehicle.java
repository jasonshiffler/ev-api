package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="vehicle")
@Data
public class Vehicle extends AbstractEntity{


    String vin;
    String color;

    @Column(name="display_name")
    @JsonProperty("display_name")
    String displayName;

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
}
