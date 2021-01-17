package com.gitea.ozzymar.talismansmega.tasks.interactive;

import com.gitea.ozzymar.talismansmega.config.talismans.items.EnderConfiguration;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.models.ENDER_TALISMAN;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public class ENDERCHEST_EFFECT extends AbstractInteractiveEffect {
    public ENDERCHEST_EFFECT(Plugin plugin) {
        super(plugin);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return new ENDER_TALISMAN();
    }

    @Override
    public YamlConfiguration config() {
        return EnderConfiguration.getYaml();
    }

    @Override
    public void interactHandler(PlayerInteractEvent event) {
        event.getPlayer().openInventory(event.getPlayer().getEnderChest());
    }
}
