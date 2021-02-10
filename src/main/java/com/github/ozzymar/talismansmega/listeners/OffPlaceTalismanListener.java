package com.github.ozzymar.talismansmega.listeners;

import com.github.ozzymar.talismansmega.TalismansMega;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class OffPlaceTalismanListener implements Listener {

    private final TalismansMega talismansMega;

    public OffPlaceTalismanListener(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    @EventHandler
    public void onBlockOffPlaceMain(BlockPlaceEvent event) {
        try {
            Player player = event.getPlayer();
            ItemStack hand = player.getInventory().getItemInOffHand();
            if (talismansMega.getUtilities().getTUtils().isTalisman(hand)) event.setCancelled(true);
        } catch (Exception ex) {
            // Ignore exception as its due to multi version support
        }
    }
}
