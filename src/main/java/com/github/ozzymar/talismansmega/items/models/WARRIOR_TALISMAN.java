package com.github.ozzymar.talismansmega.items.models;

import com.github.ozzymar.talismansmega.config.talismans.items.WarriorConfiguration;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import com.github.ozzymar.talismansmega.items.NBT_KEYS;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class WARRIOR_TALISMAN extends AbstractTalisman {
    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return WarriorConfiguration.getYaml();
    }

    @Override
    public String skullValue() {
        return "26660b016d05645fffd1f48b792d1abe5d8f30dc96567569ae1d982d250b693c";
    }

    @Override
    public String talismanType() {
        return NBT_KEYS.IS_WARRIOR_TALISMAN;
    }

    @Override
    public double price() {
        return WarriorConfiguration.getYaml().getLong("price");
    }
}
