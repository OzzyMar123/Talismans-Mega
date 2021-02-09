package com.github.ozzymar.talismansmega.items.types;

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
        return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGRjYzE4OTYzM2M3ODljYjZkNWU3OGQxM2E1MDQzYjI2ZTdiNDBjZGI3Y2ZjNGUyM2FhMjI3OTU3NDk2N2I0In19fQ==";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_ENDER_TALISMAN;
    }
}
