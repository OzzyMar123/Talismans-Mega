package com.gitea.ozzymar.talismansmega.items.models;

import com.gitea.ozzymar.talismansmega.config.talismans.items.EnderConfiguration;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.NBT_KEYS;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class ENDER_TALISMAN extends AbstractTalisman {
    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return EnderConfiguration.getYaml();
    }

    @Override
    public String skullValue() {
        return "ddcc189633c789cb6d5e78d13a5043b26e7b40cdb7cfc4e23aa2279574967b4";
    }

    @Override
    public String talismanType() {
        return NBT_KEYS.IS_ENDER_TALISMAN;
    }

    @Override
    public double price() {
        return EnderConfiguration.getYaml().getLong("price");
    }
}
