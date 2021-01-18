package com.gitea.ozzymar.talismansmega.tasks.interact;

import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

public abstract class AbstractInteractiveEffect {

    public AbstractInteractiveEffect(Plugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new handleInteract(), plugin);
    }

    public abstract AbstractTalisman talismanNeeded();

    public abstract YamlConfiguration config();

    public abstract void interactHandler(PlayerInteractEvent event);

    public class handleInteract implements Listener {
        @EventHandler
        public void onPlayerInteract(PlayerInteractEvent event) {
            try {
                if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) return;

                if (event.getPlayer() == null) return;
                if (event.getPlayer().getItemInHand() == null) return;

                NBTItem nbti = new NBTItem(event.getPlayer().getItemInHand());
                if (!nbti.hasKey(talismanNeeded().talismanType())) return;

                if (!config().getStringList("enabled-worlds").contains(event.getPlayer().getWorld().getName())) return;
                interactHandler(event);
            } catch (NullPointerException ignored) {
                // Catch exception caused by NBTApi
            }
        }
    }
}
