package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.GuiSettings;
import com.tesla.springboot.evapi.exceptions.ItemNotFoundException;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public interface GuiSettingsService {
    GuiSettings findGUISettingsById(Long id, Principal principal) throws ItemNotFoundException;
}
