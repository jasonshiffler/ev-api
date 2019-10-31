package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="drive_state")
@Data
public class DriveState extends AbstractEntity {

    Integer heading;
    Float longitude;
    Float latitude;

    @OneToOne(mappedBy="driveState") //name of the ChargeState field in the Vehicle object
    @JoinColumn(name="id")
    @JsonIgnore
    private Vehicle vehicle;

}
