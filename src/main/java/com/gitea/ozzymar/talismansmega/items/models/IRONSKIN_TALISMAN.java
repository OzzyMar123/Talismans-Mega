package com.gitea.ozzymar.talismansmega.items.models;

import com.gitea.ozzymar.talismansmega.config.talismans.items.IronskinConfiguration;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.NBT_KEYS;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class IRONSKIN_TALISMAN extends AbstractTalisman {
    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return IronskinConfiguration.getYaml();
    }

    @Override
    public String skullValue() {
        return "3b481c31dc683bdcb7d375a7c5db7ac7adf9e9fe8b6c04a64931613e29fe470e";
    }

    @Override
    public String talismanType() {
        return NBT_KEYS.IS_IRONSKIN_TALISMAN;
    }

    @Override
    public double price() {
        return IronskinConfiguration.getYaml().getLong("price");
    }
}
