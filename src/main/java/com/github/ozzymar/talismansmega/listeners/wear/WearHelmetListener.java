package com.github.ozzymar.talismansmega.listeners.wear;

import com.github.ozzymar.talismansmega.TalismansMega;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDispenseEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class WearHelmetListener implements Listener {

    private final TalismansMega talismansMega;

    public WearHelmetListener(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    @EventHandler
    public void onLeftClicked(InventoryClickEvent event) {
        try {
            if (event.getCursor() == null) return;
            if (event.getWhoClicked() instanceof Player) {
                if (event.getWhoClicked().getGameMode() == GameMode.SURVIVAL) {
                    NBTItem nbti = new NBTItem(event.getCursor());
                    if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_TALISMAN) && event.getSlotType() == InventoryType.SlotType.ARMOR && event.getClick().isLeftClick()) {
                        event.setCancelled(true);
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onRightClicked(InventoryClickEvent event) {
        try {
            if (event.getCursor() == null) return;
            if (event.getWhoClicked() instanceof Player) {
                if (event.getWhoClicked().getGameMode() == GameMode.SURVIVAL) {
                    NBTItem nbti = new NBTItem(event.getCursor());
                    if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_TALISMAN) && event.getSlotType() == InventoryType.SlotType.ARMOR && event.getClick().isRightClick()) {
                        event.setCancelled(true);
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onShiftClicked(InventoryClickEvent event) {
        try {
            if (event.getCurrentItem() == null) return;
            NBTItem nbti = new NBTItem(event.getCurrentItem());
            if (event.getWhoClicked() instanceof Player) {
                if (event.getWhoClicked().getGameMode() == GameMode.SURVIVAL) {
                    if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_TALISMAN) && event.getClick().isShiftClick()) {
                        event.setCancelled(true);
                    }
                }
            }
        } catch (Exception ignored) {
        }
    }

    @EventHandler
    public void onBlockDispense(BlockDispenseEvent event) {
        try {
            ItemStack item = event.getItem();
            NBTItem nbti = new NBTItem(item);
            if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_TALISMAN)) {
                event.setCancelled(true);
            }
        } catch (Exception ignored) {
        }
    }
}
