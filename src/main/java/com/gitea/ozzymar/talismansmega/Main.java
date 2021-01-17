package com.gitea.ozzymar.talismansmega;

import com.gitea.ozzymar.talismansmega.commands.Command;
import com.gitea.ozzymar.talismansmega.tasks.interactive.ENDERCHEST_EFFECT;
import com.gitea.ozzymar.talismansmega.tasks.interactive.WORKBENCH_EFFECT;
import com.gitea.ozzymar.talismansmega.tasks.passive.*;
import com.gitea.ozzymar.talismansmega.events.JoinListener;
import com.gitea.ozzymar.talismansmega.events.PlaceTalismanListener;
import com.gitea.ozzymar.talismansmega.events.WearHelmetListener;
import com.gitea.ozzymar.talismansmega.menusystem.ShopMenu;
import com.gitea.ozzymar.talismansmega.config.LangConfiguration;
import com.gitea.ozzymar.talismansmega.config.MenusConfiguration;
import com.gitea.ozzymar.talismansmega.config.talismans.items.*;
import com.gitea.ozzymar.talismansmega.utils.eco.ServerEconomyManager;
import com.gitea.ozzymar.talismansmega.utils.string.StringUtil;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Plugin plugin;

    public static Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void onLoad() {
        MinecraftVersion.disableBStats();
        MinecraftVersion.disablePackageWarning();
        MinecraftVersion.disableUpdateCheck();


        new LangConfiguration(this, "lang.yml");
        new MenusConfiguration(this, "menus.yml");
        new FlashConfiguration(this, "items/talismans/flash.yml");
        new HealthConfiguration(this, "items/talismans/health.yml");
        new WarriorConfiguration(this, "items/talismans/warrior.yml");
        new IronskinConfiguration(this, "items/talismans/ironskin.yml");
        new MoltenskinConfiguration(this, "items/talismans/moltenskin.yml");
        new QuickhandsConfiguration(this, "items/talismans/quickhands.yml");
        new WorkbenchConfiguration(this, "items/talismans/workbench.yml");
        new EnderConfiguration(this, "items/talismans/enderchest.yml");
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        if (!ServerEconomyManager.setupEconomy(this)) {
            System.out.println(StringUtil.format("[TALISMANS-MEGA] You are missing vault and/or an economy plugin, please install then restart!"));
            this.getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.getServer().getPluginCommand("talismans").setExecutor(new Command());

        this.getServer().getPluginManager().registerEvents(new PlaceTalismanListener(), this);
        this.getServer().getPluginManager().registerEvents(new WearHelmetListener(), this);
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);

        new FLASH_EFFECT(this);
        new HEALTH_EFFECT(this);
        new WARRIOR_EFFECT(this);
        new IRONSKIN_EFFECT(this);
        new MOLTENSKIN_EFFECT(this);
        new QUICKHANDS_EFFECT(this);

        new WORKBENCH_EFFECT(this);
        new ENDERCHEST_EFFECT(this);

        new ShopMenu(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        plugin = null;
    }
}
