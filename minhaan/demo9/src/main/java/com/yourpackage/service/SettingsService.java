package com.yourpackage.service;

import com.yourpackage.entity.Settings;
import com.yourpackage.repository.SettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingsService {
    @Autowired
    private SettingsRepository repository;

    public List<Settings> getAllSettings() {
        return repository.findAll();
    }

    public Settings getSettingsById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Settings saveSettings(Settings settings) {
        return repository.save(settings);
    }

    public void deleteSettings(Integer id) {
        repository.deleteById(id);
    }
}
