package com.github.ozzymar.talismansmega.items.types;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

public class MOLTENSKIN_TALISMAN extends AbstractTalisman {
    public MOLTENSKIN_TALISMAN(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public ItemStack getItem() {
        return item();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getMoltenskinTalismanConfig().getYaml();
    }

    @Override
    public String skullValue() {
        return "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNGYwMWVjNjMzMWEzYmMzMGE4MjA0ZWM1NjM5OGQwOGNhMzg3ODg1NTZiY2E5YjgxZDc3NmY2MjM4ZDU2NzM2NyJ9fX0=";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_MOLTENSKIN_TALISMAN;
    }
}
