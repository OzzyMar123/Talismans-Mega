package com.github.ozzymar.talismansmega;

import com.github.ozzymar.marsapi.api.colors.ColorFormatter;
import com.github.ozzymar.marsapi.api.enums.VersionChecker;
import com.github.ozzymar.talismansmega.commands.TalismansCommand;
import com.github.ozzymar.talismansmega.config.Configs;
import com.github.ozzymar.talismansmega.effects.Effects;
import com.github.ozzymar.talismansmega.items.Talismans;
import com.github.ozzymar.talismansmega.listeners.connection.JoinListener;
import com.github.ozzymar.talismansmega.listeners.place.OffPlaceTalismanListener;
import com.github.ozzymar.talismansmega.listeners.place.PlaceTalismanListener;
import com.github.ozzymar.talismansmega.listeners.wear.WearHelmetListener;
import com.github.ozzymar.talismansmega.ui.Menus;
import com.github.ozzymar.talismansmega.utils.Utilities;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import org.bukkit.plugin.java.JavaPlugin;

public class TalismansMega extends JavaPlugin {

    private final Configs configs = new Configs(this);
    private final Talismans talismans = new Talismans(this);
    private final Utilities utilities = new Utilities(this);
    private final Menus menus = new Menus(this);
    private final Effects effects = new Effects(this);

    @Override
    public void onLoad() {
        MinecraftVersion.disableBStats();
        MinecraftVersion.disablePackageWarning();
        MinecraftVersion.disableUpdateCheck();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        configs.load();
        talismans.load();
        utilities.load();
        menus.load();
        effects.load();

        if (!utilities.getServerEconomyManager().setupEconomy(this)) {
            System.out.println(ColorFormatter.format("[TALISMANS-MEGA] You are missing vault and/or an economy plugin, please install then restart!"));
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.getServer().getPluginCommand("talismans").setExecutor(new TalismansCommand(this));

        this.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        this.getServer().getPluginManager().registerEvents(new WearHelmetListener(this), this);
        this.getServer().getPluginManager().registerEvents(new PlaceTalismanListener(this), this);
        if (VersionChecker.isVersionNewer(VersionChecker.MC1_8_R3))
            this.getServer().getPluginManager().registerEvents(new OffPlaceTalismanListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        effects.unload();
        menus.unload();
        utilities.unload();
        talismans.unload();
        configs.unload();
    }

    public Configs getConfigs() {
        return configs;
    }

    public Talismans getTalismans() {
        return talismans;
    }

    public Utilities getUtilities() {
        return utilities;
    }

    public Menus getMenus() {
        return menus;
    }
}
