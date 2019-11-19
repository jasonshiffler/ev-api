/**
 * This Entity defines the Gui Setting info that is part of a vehicle record
 */

package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import com.tesla.springboot.evapi.views.VehicleView;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="gui_settings")
@Data
@JsonView(VehicleView.detail.class)
public class GuiSettings extends AbstractEntity {

    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    protected Long id;

    @Column(name="gui_distance_units")
    @JsonProperty("gui_distance_units")
    String guiDistanceUnits;

    @Column(name="gui_temperature_units")
    @JsonProperty("gui_temperature_units")
    String guiTemperatureUnits;

    @Column(name="gui_charge_rate_units")
    @JsonProperty("gui_charge_rate_units")
    String guiChargeRateUnits;

    @Column(name="gui_24_hour_time")
    @JsonProperty("gui_24_hour_time")
    Boolean gui24HourTime;

    @Column(name="gui_range_display")
    @JsonProperty("gui_range_display")
    String guiRangeDisplay;

    @Column(name="time_stamp")
    @JsonProperty("timestamp")
    Long timestamp;

    @OneToOne(mappedBy="guiSettings") //name of the GuiSettings field in the Vehicle object
    @JoinColumn(name="id")
    @JsonIgnore
    private Vehicle vehicle;

}
