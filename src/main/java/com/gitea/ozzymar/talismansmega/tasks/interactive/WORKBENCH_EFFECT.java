package com.gitea.ozzymar.talismansmega.tasks.interactive;

import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.models.WORKBENCH_TALISMAN;
import com.gitea.ozzymar.talismansmega.config.talismans.items.WorkbenchConfiguration;
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
