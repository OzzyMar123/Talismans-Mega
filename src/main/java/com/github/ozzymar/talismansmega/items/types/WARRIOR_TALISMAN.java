package com.github.ozzymar.talismansmega.items.types;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class WARRIOR_TALISMAN extends AbstractTalisman {
    public WARRIOR_TALISMAN(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getWarriorTalismanConfig().getYaml();
    }

    @Override
    public String skullValue() {
        return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjY2NjBiMDE2ZDA1NjQ1ZmZmZDFmNDhiNzkyZDFhYmU1ZDhmMzBkYzk2NTY3NTY5YWUxZDk4MmQyNTBiNjkzYyJ9fX0=";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_WARRIOR_TALISMAN;
    }
}
