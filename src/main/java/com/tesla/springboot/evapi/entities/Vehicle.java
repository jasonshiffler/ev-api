package com.tesla.springboot.evapi.entities;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
