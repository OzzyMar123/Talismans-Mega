package com.github.ozzymar.talismansmega.listeners;

import com.github.ozzymar.talismansmega.TalismansMega;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class JoinListener implements Listener {

    private final TalismansMega talismansMega;

    public JoinListener(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        for (ItemStack item : player.getInventory().getContents()) {
            if (item == null) return;
            talismansMega.getUtilities().getTUtils().update(item);
        }
    }
}
