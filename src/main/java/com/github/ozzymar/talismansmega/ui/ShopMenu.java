package com.github.ozzymar.talismansmega.ui;

import com.cryptomorin.xseries.XMaterial;
import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.utils.string.ColorUtil;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ShopMenu {

    private final TalismansMega talismansMega;

    public ShopMenu(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
        talismansMega.getServer().getPluginManager().registerEvents(new ClickListener(), talismansMega);
    }

    public Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(
            null, 36, ColorUtil.format(talismansMega.getConfigs().getMenusConfig().getYaml().getString("shop-menu.title")));

        for (int emptySlot = 0; emptySlot < inv.getSize(); emptySlot++) {
            if (inv.getItem(emptySlot) == null) {
                ItemStack filler = XMaterial.GRAY_STAINED_GLASS_PANE.parseItem();
                if (filler == null) return null;
                ItemMeta fillerMeta = filler.getItemMeta();
                if (fillerMeta == null) return null;
                fillerMeta.setDisplayName(" ");
                filler.setItemMeta(fillerMeta);
                inv.setItem(emptySlot, filler);
            }
        }

        inv.setItem(10, talismansMega.getTalismans().getFlashTalisman().itemWithPriceLore());
        inv.setItem(12, talismansMega.getTalismans().getHealthTalisman().itemWithPriceLore());
        inv.setItem(14, talismansMega.getTalismans().getWarriorTalisman().itemWithPriceLore());
        inv.setItem(16, talismansMega.getTalismans().getIronskinTalisman().itemWithPriceLore());
        inv.setItem(18, talismansMega.getTalismans().getMoltenskinTalisman().itemWithPriceLore());
        inv.setItem(20, talismansMega.getTalismans().getQuickhandsTalisman().itemWithPriceLore());

        inv.setItem(24, talismansMega.getTalismans().getWorkbenchTalisman().itemWithPriceLore());
        inv.setItem(26, talismansMega.getTalismans().getEnderTalisman().itemWithPriceLore());

        return inv;
    }

    public class ClickListener implements Listener {
        @EventHandler
        public void onShopClick(InventoryClickEvent event) {

            if (!event.getView().getTitle().equalsIgnoreCase(
                ChatColor.stripColor(ColorUtil.format(talismansMega.getConfigs().getMenusConfig().getYaml().getString("shop-menu.title")))))
                return;

            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() == null) return;

            event.setCancelled(true);

            NBTItem nbti = new NBTItem(event.getCurrentItem());
            if (nbti.hasKey(talismansMega.getTalismans().getFlashTalisman().talismanType())) {
                talismansMega.getUtilities().getPlayerEconomyManager()
                    .handlePurchase(player, talismansMega.getTalismans().getFlashTalisman());
            }
            if (nbti.hasKey(talismansMega.getTalismans().getHealthTalisman().talismanType())) {
                talismansMega.getUtilities().getPlayerEconomyManager()
                    .handlePurchase(player, talismansMega.getTalismans().getHealthTalisman());
            }
            if (nbti.hasKey(talismansMega.getTalismans().getWarriorTalisman().talismanType())) {
                talismansMega.getUtilities().getPlayerEconomyManager()
                    .handlePurchase(player, talismansMega.getTalismans().getWarriorTalisman());
            }
            if (nbti.hasKey(talismansMega.getTalismans().getIronskinTalisman().talismanType())) {
                talismansMega.getUtilities().getPlayerEconomyManager()
                    .handlePurchase(player, talismansMega.getTalismans().getIronskinTalisman());
            }
            if (nbti.hasKey(talismansMega.getTalismans().getMoltenskinTalisman().talismanType())) {
                talismansMega.getUtilities().getPlayerEconomyManager()
                    .handlePurchase(player, talismansMega.getTalismans().getMoltenskinTalisman());
            }
            if (nbti.hasKey(talismansMega.getTalismans().getQuickhandsTalisman().talismanType())) {
                talismansMega.getUtilities().getPlayerEconomyManager()
                    .handlePurchase(player, talismansMega.getTalismans().getQuickhandsTalisman());
            }
            if (nbti.hasKey(talismansMega.getTalismans().getWorkbenchTalisman().talismanType())) {
                talismansMega.getUtilities().getPlayerEconomyManager()
                    .handlePurchase(player, talismansMega.getTalismans().getWorkbenchTalisman());
            }
            if (nbti.hasKey(talismansMega.getTalismans().getEnderTalisman().talismanType())) {
                talismansMega.getUtilities().getPlayerEconomyManager()
                    .handlePurchase(player, talismansMega.getTalismans().getEnderTalisman());
            }
        }
    }
}
