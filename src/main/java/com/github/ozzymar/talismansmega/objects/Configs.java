package com.github.ozzymar.talismansmega.objects;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.config.YamlConfig;

public class Configs {

    private final TalismansMega talismansMega;
    private YamlConfig langConfig;
    private YamlConfig menusConfig;
    private YamlConfig flashTalismanConfig;
    private YamlConfig healthTalismanConfig;
    private YamlConfig warriorTalismanConfig;
    private YamlConfig ironskinTalismanConfig;
    private YamlConfig moltenskinTalismanConfig;
    private YamlConfig quickhandsTalismanConfig;
    private YamlConfig workbenchTalismanConfig;
    private YamlConfig enderchestTalismanConfig;
    public Configs(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    public void load() {
        this.langConfig = new YamlConfig(talismansMega, "lang.yml");
        this.menusConfig = new YamlConfig(talismansMega, "menus.yml");
        this.flashTalismanConfig = new YamlConfig(talismansMega, "items/talismans/flash.yml");
        this.healthTalismanConfig = new YamlConfig(talismansMega, "items/talismans/health.yml");
        this.warriorTalismanConfig = new YamlConfig(talismansMega, "items/talismans/warrior.yml");
        this.ironskinTalismanConfig = new YamlConfig(talismansMega, "items/talismans/ironskin.yml");
        this.moltenskinTalismanConfig = new YamlConfig(talismansMega, "items/talismans/moltenskin.yml");
        this.quickhandsTalismanConfig = new YamlConfig(talismansMega, "items/talismans/quickhands.yml");
        this.workbenchTalismanConfig = new YamlConfig(talismansMega, "items/talismans/workbench.yml");
        this.enderchestTalismanConfig = new YamlConfig(talismansMega, "items/talismans/enderchest.yml");
    }

    public void unload() {
        this.langConfig = null;
        this.menusConfig = null;
        this.flashTalismanConfig = null;
        this.healthTalismanConfig = null;
        this.warriorTalismanConfig = null;
        this.ironskinTalismanConfig = null;
        this.moltenskinTalismanConfig = null;
        this.quickhandsTalismanConfig = null;
        this.workbenchTalismanConfig = null;
        this.enderchestTalismanConfig = null;
    }

    public YamlConfig getLangConfig() {
        return langConfig;
    }

    public YamlConfig getMenusConfig() {
        return menusConfig;
    }

    public YamlConfig getFlashTalismanConfig() {
        return flashTalismanConfig;
    }

    public YamlConfig getHealthTalismanConfig() {
        return healthTalismanConfig;
    }

    public YamlConfig getWarriorTalismanConfig() {
        return warriorTalismanConfig;
    }

    public YamlConfig getIronskinTalismanConfig() {
        return ironskinTalismanConfig;
    }

    public YamlConfig getMoltenskinTalismanConfig() {
        return moltenskinTalismanConfig;
    }

    public YamlConfig getQuickhandsTalismanConfig() {
        return quickhandsTalismanConfig;
    }

    public YamlConfig getWorkbenchTalismanConfig() {
        return workbenchTalismanConfig;
    }

    public YamlConfig getEnderchestTalismanConfig() {
        return enderchestTalismanConfig;
    }
}
