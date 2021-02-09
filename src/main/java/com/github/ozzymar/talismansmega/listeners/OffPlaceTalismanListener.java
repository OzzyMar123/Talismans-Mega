package com.github.ozzymar.talismansmega.listeners;

import com.github.ozzymar.talismansmega.TalismansMega;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class OffPlaceTalismanListener implements Listener {

    private final TalismansMega talismansMega;

    public OffPlaceTalismanListener(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    @EventHandler
    public void onBlockOffPlaceMain(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        ItemStack hand = player.getInventory().getItemInOffHand();
        if (!(event.getHand() == EquipmentSlot.OFF_HAND)) return;
        if (talismansMega.getUtilities().getTUtils().isTalisman(hand)) event.setCancelled(true);
    }
}
