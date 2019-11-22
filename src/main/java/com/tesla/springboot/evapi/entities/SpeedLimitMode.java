/**
 * The Entity definition of the speed limit mode that is part of the vehicle state object
 */

package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.tesla.springboot.evapi.views.VehicleView;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="speed_limit_mode")
@Data
@JsonView(VehicleView.detail.class)
public class SpeedLimitMode extends AbstractEntity{

    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    protected Long id;

    @OneToOne(mappedBy="speedLimitMode")
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private VehicleState vehicleState;

    @Column(name="active")
    @JsonProperty("active")
    Boolean active;

    @Column(name="current_limit_mph")
    @JsonProperty("current_limit_mph")
    Float currentLimitMph;

    @Column(name="max_limit_mph")
    @JsonProperty("max_limit_mph")
    Float maxLimitMph;

    @Column(name="min_limit_mph")
    @JsonProperty("min_limit_mph")
    Float minLimitMph;

    @Column(name="pin_code_set")
    @JsonProperty("pin_code_set")
    Boolean pinCodeSet;

}
