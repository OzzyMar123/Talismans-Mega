package com.github.ozzymar.talismansmega.items.models;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class HEALTH_TALISMAN extends AbstractTalisman {
    public HEALTH_TALISMAN(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getHealthTalismanConfig().getYaml();
    }

    @Override
    public String skullValue() {
        return "2c1c179ad51955f1522c48ea9931f09c162741b45e22e9d3feb682c7e5ed8274";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_HEALTH_TALISMAN;
    }
}
