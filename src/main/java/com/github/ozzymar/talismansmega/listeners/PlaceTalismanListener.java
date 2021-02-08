package com.github.ozzymar.talismansmega.listeners;

import com.github.ozzymar.talismansmega.TalismansMega;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class PlaceTalismanListener implements Listener {

    private final TalismansMega talismansMega;

    public PlaceTalismanListener(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    @EventHandler
    public void onBlockMainPlaceMain(BlockPlaceEvent event) {
        try {
            Player player = event.getPlayer();
            ItemStack hand = player.getInventory().getItemInHand();
            if (talismansMega.getUtilities().getTUtils().isTalisman(hand)) event.setCancelled(true);
        } catch (Error | Exception ignored) {
        }
    }

    @EventHandler
    public void onBlockOffPlaceMain(BlockPlaceEvent event) {
        try {
            Player player = event.getPlayer();
            ItemStack hand = player.getInventory().getItemInOffHand();
            if (talismansMega.getUtilities().getTUtils().isTalisman(hand)) event.setCancelled(true);
        } catch (Error | Exception ignored) {
        }
    }
}
