/**
 * This controller handles any requests related to vehicle charging
 *
 */

package com.tesla.springboot.evapi.controllers;

import com.tesla.springboot.evapi.entities.ChargeState;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import com.tesla.springboot.evapi.services.ChargeStateService;
import com.tesla.springboot.evapi.utility.LogFormat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@RestController
@Secured("ROLE_USER") //We only want authenticated users to be able to access the controller
@Slf4j
public class ChargeStateController {

    private final ChargeStateService chargeStateService;

    @Autowired
    public ChargeStateController(ChargeStateService chargeStateService) {
        this.chargeStateService = chargeStateService;
    }

    @GetMapping("/vehicles/{id}/data_request/charge_state")
    public ChargeState findChargeStateById(@PathVariable Long id, Principal principal,
                                           HttpServletRequest request) throws ItemNotFoundException {

        log.info(LogFormat.urlLogFormat(request,principal.getName()));
        return chargeStateService.findChargeStateById(id, principal);
    }

}
