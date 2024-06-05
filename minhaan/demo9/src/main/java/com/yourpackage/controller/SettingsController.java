package com.yourpackage.controller;

import com.yourpackage.entity.Settings;
import com.yourpackage.service.SettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settings")
public class SettingsController {
    @Autowired
    private SettingsService service;

    @GetMapping
    public List<Settings> getAllSettings() {
        return service.getAllSettings();
    }

    @GetMapping("/{id}")
    public Settings getSettingsById(@PathVariable Integer id) {
        return service.getSettingsById(id);
    }

    @PostMapping
    public Settings createSettings(@RequestBody Settings settings) {
        return service.saveSettings(settings);
    }

    @PutMapping("/{id}")
    public Settings updateSettings(@PathVariable Integer id, @RequestBody Settings settings) {
        settings.setId(id);
        return service.saveSettings(settings);
    }

    @DeleteMapping("/{id}")
    public void deleteSettings(@PathVariable Integer id) {
        service.deleteSettings(id);
    }
}
