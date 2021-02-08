package com.github.ozzymar.talismansmega.items.models;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class IRONSKIN_TALISMAN extends AbstractTalisman {
    public IRONSKIN_TALISMAN(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getIronskinTalismanConfig().getYaml();
    }

    @Override
    public String skullValue() {
        return "3b481c31dc683bdcb7d375a7c5db7ac7adf9e9fe8b6c04a64931613e29fe470e";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_IRONSKIN_TALISMAN;
    }
}
