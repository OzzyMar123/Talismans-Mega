package com.github.ozzymar.talismansmega.tasks.interact;

import com.github.ozzymar.talismansmega.config.talismans.items.WorkbenchConfiguration;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import com.github.ozzymar.talismansmega.items.models.WORKBENCH_TALISMAN;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class WORKBENCH_EFFECT extends AbstractInteractiveEffect {
    public WORKBENCH_EFFECT(Plugin plugin) {
        super(plugin);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return new WORKBENCH_TALISMAN();
    }

    @Override
    public YamlConfiguration config() {
        return WorkbenchConfiguration.getYaml();
    }

    @Override
    public void interactHandler(PlayerInteractEvent event) {
        event.getPlayer().openWorkbench(event.getPlayer().getLocation(), true);
    }
}
