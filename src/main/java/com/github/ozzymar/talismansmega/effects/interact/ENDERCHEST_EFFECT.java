package com.github.ozzymar.talismansmega.effects.interact;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.PlayerInteractEvent;

public class ENDERCHEST_EFFECT extends AbstractInteractiveEffect {


    public ENDERCHEST_EFFECT(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return talismansMega.getTalismans().getEnderTalisman();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getEnderchestTalismanConfig().getYaml();
    }

    @Override
    public void interactHandler(PlayerInteractEvent event) {
        event.getPlayer().openInventory(event.getPlayer().getEnderChest());
    }
}
