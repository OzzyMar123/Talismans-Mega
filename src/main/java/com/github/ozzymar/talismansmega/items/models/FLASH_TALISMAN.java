package com.github.ozzymar.talismansmega.items.models;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class FLASH_TALISMAN extends AbstractTalisman {
    public FLASH_TALISMAN(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getFlashTalismanConfig().getYaml();
    }

    @Override
    public String skullValue() {
        return "734fb3203233efbae82628bd4fca7348cd071e5b7b52407f1d1d2794e31799ff";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_FLASH_TALISMAN;
    }
}
