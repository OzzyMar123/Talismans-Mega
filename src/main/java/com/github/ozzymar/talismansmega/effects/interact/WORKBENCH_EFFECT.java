package com.github.ozzymar.talismansmega.effects.interact;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.PlayerInteractEvent;

public class WORKBENCH_EFFECT extends AbstractInteractiveEffect {

    public WORKBENCH_EFFECT(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return talismansMega.getTalismans().getWorkbenchTalisman();
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getWorkbenchTalismanConfig().getYaml();
    }

    @Override
    public void interactHandler(PlayerInteractEvent event) {
        event.getPlayer().openWorkbench(event.getPlayer().getLocation(), true);
    }
}
