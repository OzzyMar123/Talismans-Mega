package com.github.ozzymar.talismansmega.items.types;

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
        return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmMxYzE3OWFkNTE5NTVmMTUyMmM0OGVhOTkzMWYwOWMxNjI3NDFiNDVlMjJlOWQzZmViNjgyYzdlNWVkODI3NCJ9fX0=";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_HEALTH_TALISMAN;
    }
}
