package com.gitea.ozzymar.talismansmega.utils.eco;

import com.cryptomorin.xseries.XSound;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;

public class PlayerEconomyManager {
    private static final Economy economy = ServerEconomyManager.getEconomy();

    private static boolean canAffordTalisman(Player player, AbstractTalisman abstractTalisman) {
        return economy.getBalance(player) >= abstractTalisman.price();
    }

    public static void handlePurchase(Player player, AbstractTalisman abstractTalisman) {
        if (!canAffordTalisman(player, abstractTalisman) || player.getInventory().firstEmpty() == -1) {
            player.closeInventory();
            player.playSound(player.getLocation(), XSound.ENTITY_VILLAGER_HURT.parseSound(), 2.0F, 1.0F);
        } else {
            economy.withdrawPlayer(player, abstractTalisman.price());
            player.getInventory().addItem(abstractTalisman.getItem());
            player.playSound(player.getLocation(), XSound.BLOCK_NOTE_BLOCK_PLING.parseSound(), 1.0F, 1.0F);
        }
    }
}
