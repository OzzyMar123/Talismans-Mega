package com.gitea.ozzymar.talismansmega.items.models;

import com.gitea.ozzymar.talismansmega.config.talismans.items.MoltenskinConfiguration;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.NBT_KEYS;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class MOLTENSKIN_TALISMAN extends AbstractTalisman {
    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return MoltenskinConfiguration.getYaml();
    }

    @Override
    public String skullValue() {
        return "4f01ec6331a3bc30a8204ec56398d08ca38788556bca9b81d776f6238d567367";
    }

    @Override
    public String talismanType() {
        return NBT_KEYS.IS_MOLTENSKIN_TALISMAN;
    }

    @Override
    public double price() {
        return MoltenskinConfiguration.getYaml().getLong("price");
    }
}
