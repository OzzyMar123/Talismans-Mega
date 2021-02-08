package com.github.ozzymar.talismansmega.items.models;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class ENDER_TALISMAN extends AbstractTalisman {
    public ENDER_TALISMAN(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getEnderchestTalismanConfig().getYaml();
    }

    @Override
    public String skullValue() {
        return "ddcc189633c789cb6d5e78d13a5043b26e7b40cdb7cfc4e23aa2279574967b4";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_ENDER_TALISMAN;
    }
}
