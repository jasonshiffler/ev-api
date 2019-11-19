package com.tesla.springboot.evapi.services;

import com.tesla.springboot.evapi.entities.GuiSettings;

import java.security.Principal;

public interface GuiSettingsService {
    GuiSettings findGUISettingsById(Long id, Principal principal);
}
