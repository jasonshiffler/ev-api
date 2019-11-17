/**
 * The purpose of this class is to return a response for the different commands issued through the various controllers
 *
 */

package com.tesla.springboot.evapi.controllers;

import lombok.Data;

@Data
public class ControllerResponse {

    Boolean result = true;
    String reason = "";

}
