package com.github.ozzymar.talismansmega.items.models;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class QUICKHANDS_TALISMAN extends AbstractTalisman {
    public QUICKHANDS_TALISMAN(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getQuickhandsTalismanConfig().getYaml();
    }

    @Override
    public String skullValue() {
        return "e4d8a8d527f65a4f434f894f7ee42eb843015bda7927c63c6ea8a754afe9bb1b";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_QUICKHANDS_TALISMAN;
    }
}
