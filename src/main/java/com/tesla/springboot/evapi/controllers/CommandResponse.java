/**
 * The purpose of this class is to allow the various controllers to return a response to the user for the various
 * commands they receive. A command would be something like honk horn or turn up the temperature and not just a query
 * for information.
 *
 */

package com.tesla.springboot.evapi.controllers;

import lombok.Data;

@Data
public class CommandResponse {

    Boolean result = true;
    String reason = "";

}
