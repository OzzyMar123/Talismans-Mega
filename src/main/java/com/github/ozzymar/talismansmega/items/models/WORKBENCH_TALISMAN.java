package com.github.ozzymar.talismansmega.items.models;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class WORKBENCH_TALISMAN extends AbstractTalisman {
    public WORKBENCH_TALISMAN(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getWorkbenchTalismanConfig().getYaml();
    }

    @Override
    public String skullValue() {
        return "ce7d8c242d2e4f8028f930be76f35014b21b5255208b1c04181b2574131b75a";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_WORKBENCH_TALISMAN;
    }
}
