package com.github.ozzymar.talismansmega.items.models;

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
        return "26660b016d05645fffd1f48b792d1abe5d8f30dc96567569ae1d982d250b693c";
    }

    @Override
    public String talismanType() {
        return talismansMega.getUtilities().getNBTKeys().IS_WARRIOR_TALISMAN;
    }
}
