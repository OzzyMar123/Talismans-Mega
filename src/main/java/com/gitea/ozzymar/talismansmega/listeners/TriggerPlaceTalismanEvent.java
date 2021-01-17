package com.gitea.ozzymar.talismansmega.listeners;

import com.gitea.ozzymar.talismansmega.utils.TUtils;
import com.gitea.ozzymar.talismansmega.utils.VersionUtils;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class TriggerPlaceTalismanEvent implements Listener {
    @EventHandler
    public void onBlockMainPlaceMain(BlockPlaceEvent event) {
        try {
            Player player = event.getPlayer();
            ItemStack hand = player.getInventory().getItemInOffHand();
            if (TUtils.isTalisman(hand)) event.setCancelled(true);
        } catch (Error | Exception ignored) {
        }
    }

    @EventHandler
    public void onBlockOffPlaceMain(BlockPlaceEvent event) {
        try {
            if (MinecraftVersion.isNewerThan(MinecraftVersion.MC1_8_R3)) {
                Player player = event.getPlayer();
                ItemStack hand = player.getInventory().getItemInOffHand();
                if (TUtils.isTalisman(hand)) event.setCancelled(true);
            }
        } catch (Error | Exception ignored) {
        }
    }
}
