package com.github.ozzymar.talismansmega;

import com.github.ozzymar.talismansmega.commands.Command;
import com.github.ozzymar.talismansmega.listeners.JoinListener;
import com.github.ozzymar.talismansmega.listeners.PlaceTalismanListener;
import com.github.ozzymar.talismansmega.listeners.WearHelmetListener;
import com.github.ozzymar.talismansmega.objects.*;
import com.github.ozzymar.talismansmega.utils.string.ColorUtil;
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
        talismans.loadTalismans();
        utilities.loadUtilities();
        menus.loadMenus();
        effects.loadEffects();

        if (!utilities.getServerEconomyManager().setupEconomy(this)) {
            System.out.println(ColorUtil.format("[TALISMANS-MEGA] You are missing vault and/or an economy plugin, please install then restart!"));
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.getServer().getPluginCommand("talismans").setExecutor(new Command(this));

        this.getServer().getPluginManager().registerEvents(new PlaceTalismanListener(this), this);
        this.getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        this.getServer().getPluginManager().registerEvents(new WearHelmetListener(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        effects.unloadEffects();
        menus.unloadMenus();
        utilities.unloadUtilities();
        talismans.unloadTalismans();
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
