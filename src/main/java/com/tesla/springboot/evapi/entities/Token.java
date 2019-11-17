/**
 * The entity definition of the token array that is part of vehicle object
 *
 */

package com.tesla.springboot.evapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "token")
@Data
public class Token extends AbstractEntity {


    @Id
    @Column(nullable = false,updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    protected Long id;

    @Column(name="token_name")
    @JsonProperty("token_name")
    String tokenName;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(referencedColumnName = "id")
    @JsonIgnore
    private Vehicle vehicle;

    /**
     * This method allows us to control how the object is displayed when it passes through the
     * JSON serializer
     * @return - the String value of the token name.
     */

    @JsonValue
    public String toJson(){
        return tokenName;
    }

}
