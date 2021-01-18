package com.github.ozzymar.talismansmega.config;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class MenusConfiguration {
    // The .yml file itself
    private static File file;

    // The configuration field for 'reading' the file
    private static YamlConfiguration yaml;

    public MenusConfiguration(Plugin plugin, String fileLocation) {

        // The data folder directory
        File dir = plugin.getDataFolder();

        // I generally ignore the boolean result
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // Creates a file in the data folder directory called 'fileLocation'.
        file = new File(dir, fileLocation);

        // If it is not located in here, find the file in the resources
        // directory in the project and save it to the data directory.
        if (!file.exists()) {
            plugin.saveResource(fileLocation, false);
        }

        // Making a new configuration
        yaml = new YamlConfiguration();

        // Loading the file's data into the configuration field
        try {
            yaml.load(file);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    // Saves the configuration data
    public static void save() {
        try {
            yaml.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reloads the data already there
    public static void reload() {
        yaml = YamlConfiguration.loadConfiguration(file);
    }

    // Basic getter for retrieving the configuration data
    public static YamlConfiguration getYaml() {
        return yaml;
    }
}
