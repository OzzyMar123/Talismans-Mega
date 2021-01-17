package com.gitea.ozzymar.talismansmega.items.models;

import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.NBT_KEYS;
import com.gitea.ozzymar.talismansmega.config.talismans.items.FlashConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class FLASH_TALISMAN extends AbstractTalisman {
    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return FlashConfiguration.getYaml();
    }

    @Override
    public String skullValue() {
        return "734fb3203233efbae82628bd4fca7348cd071e5b7b52407f1d1d2794e31799ff";
    }

    @Override
    public String talismanType() {
        return NBT_KEYS.IS_FLASH_TALISMAN;
    }

    @Override
    public double price() {
        return FlashConfiguration.getYaml().getLong("price");
    }
}
