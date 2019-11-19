package com.tesla.springboot.evapi.repositories;

import com.tesla.springboot.evapi.entities.GuiSettings;
import org.springframework.data.repository.CrudRepository;

public interface GuiSettingsRepository extends CrudRepository<GuiSettings, Long> {
}
