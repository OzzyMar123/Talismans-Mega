package com.gitea.ozzymar.talismansmega.items.models;

import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.NBT_KEYS;
import com.gitea.ozzymar.talismansmega.config.talismans.items.HealthConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class HEALTH_TALISMAN extends AbstractTalisman {
    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return HealthConfiguration.getYaml();
    }

    @Override
    public String skullValue() {
        return "2c1c179ad51955f1522c48ea9931f09c162741b45e22e9d3feb682c7e5ed8274";
    }

    @Override
    public String talismanType() {
        return NBT_KEYS.IS_HEALTH_TALISMAN;
    }

    @Override
    public double price() {
        return HealthConfiguration.getYaml().getLong("price");
    }
}
