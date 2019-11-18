package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.tesla.springboot.evapi.views.VehicleView;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(VehicleView.summary.class)
    protected Long id;

    //Keeps this field from showing up in JSON data
    @JsonIgnore
    @CreationTimestamp
    @Column(updatable = false)
    protected Instant created;

}
