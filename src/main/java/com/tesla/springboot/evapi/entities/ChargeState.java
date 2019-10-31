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

    @Column(name="percent_charged")
    @JsonProperty("percent_charged")
    Integer percentCharged;


}
