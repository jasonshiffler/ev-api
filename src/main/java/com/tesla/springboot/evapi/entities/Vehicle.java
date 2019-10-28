package com.tesla.springboot.evapi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="vehicle")
@Data
public class Vehicle extends AbstractEntity{

    String vin;
    String color;
    String display_name;
    String user_id;

}
