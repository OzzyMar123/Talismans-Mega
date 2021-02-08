package com.github.ozzymar.talismansmega.utils.eco;

import com.cryptomorin.xseries.XSound;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.entity.Player;

public class PlayerEconomyManager {

    private final ServerEconomyManager serverEconomyManager;

    public PlayerEconomyManager(ServerEconomyManager serverEconomyManager) {
        this.serverEconomyManager = serverEconomyManager;
    }

    private boolean canAffordTalisman(Player player, AbstractTalisman abstractTalisman) {
        return serverEconomyManager.getEconomy().getBalance(player) >= abstractTalisman.price();
    }

    public void handlePurchase(Player player, AbstractTalisman abstractTalisman) {
        if (!canAffordTalisman(player, abstractTalisman) || player.getInventory().firstEmpty() == -1) {
            player.closeInventory();
            player.playSound(player.getLocation(), XSound.ENTITY_VILLAGER_HURT.parseSound(), 2.0F, 1.0F);
        } else {
            serverEconomyManager.getEconomy().withdrawPlayer(player, abstractTalisman.price());
            player.getInventory().addItem(abstractTalisman.getItem());
            player.playSound(player.getLocation(), XSound.BLOCK_NOTE_BLOCK_PLING.parseSound(), 1.0F, 1.0F);
        }
    }
}
