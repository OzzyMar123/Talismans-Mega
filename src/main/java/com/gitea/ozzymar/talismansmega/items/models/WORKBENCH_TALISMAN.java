package com.gitea.ozzymar.talismansmega.items.models;

import com.gitea.ozzymar.talismansmega.config.talismans.items.WorkbenchConfiguration;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.NBT_KEYS;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class WORKBENCH_TALISMAN extends AbstractTalisman {
    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return WorkbenchConfiguration.getYaml();
    }

    @Override
    public String skullValue() {
        return "ce7d8c242d2e4f8028f930be76f35014b21b5255208b1c04181b2574131b75a";
    }

    @Override
    public String talismanType() {
        return NBT_KEYS.IS_WORKBENCH_TALISMAN;
    }

    @Override
    public double price() {
        return WorkbenchConfiguration.getYaml().getLong("price");
    }
}
