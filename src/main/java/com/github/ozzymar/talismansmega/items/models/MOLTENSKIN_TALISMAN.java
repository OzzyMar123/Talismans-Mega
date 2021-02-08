package com.github.ozzymar.talismansmega.items.models;

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
        return "4f01ec6331a3bc30a8204ec56398d08ca38788556bca9b81d776f6238d567367";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_MOLTENSKIN_TALISMAN;
    }
}
