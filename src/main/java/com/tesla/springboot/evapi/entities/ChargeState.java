package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name="charge_state")
@Data
public class ChargeState extends AbstractEntity{

    @OneToOne(mappedBy="chargeState") //name of the ChargeState field in the Vehicle object
    @JoinColumn(name="id")
    @JsonIgnore
    private Vehicle vehicle;

    @Column(name="charging_state")
    @JsonProperty("charging_state")
    String chargingState;

    @Column(name="fast_charger_type")
    @JsonProperty("fast_charger_type")
    String fastChargerType;

    @Column(name="fast_charger_brand")
    @JsonProperty("fast_charger_brand")
    String fastChargerBrand;

    @Column(name="charge_limit_soc")
    @JsonProperty("charge_limit_soc")
    Integer chargeLimitSoc;

    @Column(name="charge_limit_soc_std")
    @JsonProperty("charge_limit_soc_std")
    Integer chargeLimitSocStd;

    @Column(name="charge_limit_soc_min")
    @JsonProperty("charge_limit_soc_min")
    Integer chargeLimitSocMin;

    @Column(name="charge_limit_soc_max")
    @JsonProperty("charge_limit_soc_max")
    Integer chargeLimitSocMax;

    @Column(name="charge_to_max_range")
    @JsonProperty("charge_to_max_range")
    Boolean chargeToMaxRange;

    @Column(name="max_range_charge_counter")
    @JsonProperty("max_range_charge_counter")
    Integer maxRangeChargeCounter;

    @Column(name="fast_charger_present")
    @JsonProperty("fast_charger_present")
    Boolean fastChargerPresent;

    @Column(name="battery_range")
    @JsonProperty("battery_range")
    Float batteryRange;

    @Column(name="est_battery_range")
    @JsonProperty("est_battery_range")
    Float estBatteryRange;

    @Column(name="ideal_battery_range")
    @JsonProperty("ideal_battery_range")
    Float idealBatteryRange;

    @Column(name="battery_level")
    @JsonProperty("battery_level")
    Integer batteryLevel;

    @Column(name="usable_battery_level")
    @JsonProperty("usable_battery_level")
    Integer usableBatteryLevel;

    @Column(name="charge_energy_added")
    @JsonProperty("charge_energy_added")
    Float chargeEnergyAdded;

    @Column(name="charge_miles_added_rated")
    @JsonProperty("charge_miles_added_rated")
    Float chargeMilesAddedRated;

    @Column(name="charge_miles_added_ideal")
    @JsonProperty("charge_miles_added_ideal")
    Float chargeMilesAddedIdeal;

    @Column(name="charger_voltage")
    @JsonProperty("charger_voltage")
    Integer chargerVoltage;

    @Column(name="charger_pilot_current")
    @JsonProperty("charger_pilot_current")
    Integer chargerPilotCurrent;

    @Column(name="charger_actual_current")
    @JsonProperty("charger_actual_current")
    Integer chargerActualCurrent;

    @Column(name="charger_power")
    @JsonProperty("charger_power")
    Integer chargerPower;

    @Column(name="time_to_full_charge")
    @JsonProperty("time_to_full_charge")
    Float timeToFullCharge;

    @Column(name="trip_charging")
    @JsonProperty("trip_charging")
    Float tripCharging;

    @Column(name="charge_rate")
    @JsonProperty("charge_rate")
    Float chargeRate;

    @Column(name="charge_port_door_open")
    @JsonProperty("charge_port_door_open")
    Boolean chargePortDoorOpen;

    @Column(name="conn_charge_cable")
    @JsonProperty("conn_charge_cable")
    String connChargeCable;

    @Column(name="scheduled_charging_start_time")
    @JsonProperty("scheduled_charging_start_time")
    Double scheduledChargingTime;

    @Column(name="scheduled_charging_pending")
    @JsonProperty("scheduled_charging_pending")
    Boolean scheduledChargingPending;

    @Column(name="user_charge_enable_request")
    @JsonProperty("user_charge_enable_request")
    Boolean userChargeEnableRequest;

    @Column(name="charge_enable_request")
    @JsonProperty("charge_enable_request")
    Boolean chargeEnableRequest;

    @Column(name="charger_phases")
    @JsonProperty("charger_phases")
    Integer chargerPhases;

    @Column(name="charge_port_latch")
    @JsonProperty("charge_port_latch")
    String chargePortLatch;

    @Column(name="charge_current_request")
    @JsonProperty("charge_current_request")
    Integer chargeCurrentRequest;

    @Column(name="charge_current_request_max")
    @JsonProperty("charge_current_request_max")
    Integer chargeCurrentRequestMax;

    @Column(name="managed_charging_active")
    @JsonProperty("managed_charging_active")
    Boolean managedChargingActive;

    @Column(name="managed_charging_user_canceled")
    @JsonProperty("managed_charging_user_canceled")
    Boolean managedChargingUserCanceled;

    @Column(name="managed_charging_start_time")
    @JsonProperty("managed_charging_start_time")
    Double managedChargingStartTime;

    @Column(name="battery_heater_on")
    @JsonProperty("battery_heater_on")
    Boolean batteryHeaterOn;

    @Column(name="not_enough_power_to_heat")
    @JsonProperty("not_enough_power_to_heat")
    Boolean notEnoughPowerToHeat;

    @Column(name="time_stamp")
    @JsonProperty("timestamp")
    Double timestamp;
}
