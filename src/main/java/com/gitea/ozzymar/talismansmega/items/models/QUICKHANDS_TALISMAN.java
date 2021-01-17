package com.gitea.ozzymar.talismansmega.items.models;

import com.gitea.ozzymar.talismansmega.config.talismans.items.QuickhandsConfiguration;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.NBT_KEYS;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class QUICKHANDS_TALISMAN extends AbstractTalisman {
    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return QuickhandsConfiguration.getYaml();
    }

    @Override
    public String skullValue() {
        return "e4d8a8d527f65a4f434f894f7ee42eb843015bda7927c63c6ea8a754afe9bb1b";
    }

    @Override
    public String talismanType() {
        return NBT_KEYS.IS_QUICKHANDS_TALISMAN;
    }

    @Override
    public double price() {
        return QuickhandsConfiguration.getYaml().getLong("price");
    }
}
