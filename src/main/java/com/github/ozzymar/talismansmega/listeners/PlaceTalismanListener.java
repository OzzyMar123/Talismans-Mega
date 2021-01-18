package com.github.ozzymar.talismansmega.listeners;

import com.github.ozzymar.talismansmega.utils.TUtils;
import com.github.ozzymar.talismansmega.utils.VersionUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PlaceTalismanListener implements Listener {
    @EventHandler
    public void onBlockMainPlaceMain(BlockPlaceEvent event) {
        try {
            Player player = event.getPlayer();
            ItemStack hand = player.getInventory().getItemInHand();
            if (TUtils.isTalisman(hand)) event.setCancelled(true);
        } catch (Error | Exception ignored) {
        }
    }

    @EventHandler
    public void onBlockOffPlaceMain(BlockPlaceEvent event) {
        try {
            if (VersionUtils.isAbove1_8()) {
                Player player = event.getPlayer();
                ItemStack hand = player.getInventory().getItemInOffHand();
                if (TUtils.isTalisman(hand)) event.setCancelled(true);
            }
        } catch (Error | Exception ignored) {
        }
    }
}
