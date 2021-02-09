package com.github.ozzymar.talismansmega.effects.interact;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class AbstractInteractiveEffect {

    protected TalismansMega talismansMega;

    public AbstractInteractiveEffect(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
        talismansMega.getServer().getPluginManager().registerEvents(new HandleInteract(), talismansMega);
    }

    public abstract AbstractTalisman talismanNeeded();

    public abstract YamlConfiguration config();

    public abstract void interactHandler(PlayerInteractEvent event);

    public class HandleInteract implements Listener {
        @EventHandler
        public void onPlayerInteract(PlayerInteractEvent event) {
            try {
                if (!event.getAction().equals(Action.RIGHT_CLICK_AIR)) return;

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
