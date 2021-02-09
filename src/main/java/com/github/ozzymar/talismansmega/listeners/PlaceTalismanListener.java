package com.github.ozzymar.talismansmega.listeners;

import com.github.ozzymar.talismansmega.TalismansMega;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class PlaceTalismanListener implements Listener {

    private final TalismansMega talismansMega;

    public PlaceTalismanListener(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    @EventHandler
    public void onBlockMainPlaceMain(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ItemStack hand = player.getInventory().getItemInHand();
        if (!(event.getHand() == EquipmentSlot.HAND)) return;
        if (talismansMega.getUtilities().getTUtils().isTalisman(hand)) event.setCancelled(true);
    }
}
