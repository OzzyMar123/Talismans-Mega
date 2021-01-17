package com.gitea.ozzymar.talismansmega.menusystem;

import com.cryptomorin.xseries.XMaterial;
import com.gitea.ozzymar.talismansmega.items.models.*;
import com.gitea.ozzymar.talismansmega.config.MenusConfiguration;
import com.gitea.ozzymar.talismansmega.utils.eco.PlayerEconomyManager;
import com.gitea.ozzymar.talismansmega.utils.string.StringUtil;
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
import org.bukkit.plugin.java.JavaPlugin;

public class ShopMenu {

    public ShopMenu(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(new ClickListener(), plugin);
    }

    public static Inventory getInventory() {
        Inventory inv = Bukkit.createInventory(
            null, 36, StringUtil.format(MenusConfiguration.getYaml().getString("shop-menu.title")));

        for (int emptySlot = 0; emptySlot < inv.getSize(); emptySlot++) {
            if (inv.getItem(emptySlot) == null) {
                ItemStack filler = XMaterial.GRAY_STAINED_GLASS_PANE.parseItem();
                if (filler == null) return null;
                ItemMeta fillerMeta = filler.getItemMeta();
                fillerMeta.setDisplayName(" ");
                filler.setItemMeta(fillerMeta);
                inv.setItem(emptySlot, filler);
            }
        }

        inv.setItem(10, new FLASH_TALISMAN().itemWithPriceLore());
        inv.setItem(12, new HEALTH_TALISMAN().itemWithPriceLore());
        inv.setItem(14, new WARRIOR_TALISMAN().itemWithPriceLore());
        inv.setItem(16, new IRONSKIN_TALISMAN().itemWithPriceLore());
        inv.setItem(18, new WORKBENCH_TALISMAN().itemWithPriceLore());
        inv.setItem(20, new QUICKHANDS_TALISMAN().itemWithPriceLore());

        inv.setItem(24, new MOLTENSKIN_TALISMAN().itemWithPriceLore());
        inv.setItem(26, new ENDER_TALISMAN().itemWithPriceLore());

        return inv;
    }

    public static class ClickListener implements Listener {
        @EventHandler
        public void onShopClick(InventoryClickEvent event) {

            if (!event.getView().getTitle().equalsIgnoreCase(
                ChatColor.stripColor(StringUtil.format(MenusConfiguration.getYaml().getString("shop-menu.title")))))
                return;

            Player player = (Player) event.getWhoClicked();
            if (event.getCurrentItem() == null) return;

            event.setCancelled(true);

            NBTItem nbti = new NBTItem(event.getCurrentItem());
            if (nbti.hasKey(new FLASH_TALISMAN().talismanType())) {
                PlayerEconomyManager.handlePurchase(player, new FLASH_TALISMAN());
            }
            if (nbti.hasKey(new HEALTH_TALISMAN().talismanType())) {
                PlayerEconomyManager.handlePurchase(player, new HEALTH_TALISMAN());
            }
            if (nbti.hasKey(new WARRIOR_TALISMAN().talismanType())) {
                PlayerEconomyManager.handlePurchase(player, new WARRIOR_TALISMAN());
            }
            if (nbti.hasKey(new IRONSKIN_TALISMAN().talismanType())) {
                PlayerEconomyManager.handlePurchase(player, new IRONSKIN_TALISMAN());
            }
            if (nbti.hasKey(new MOLTENSKIN_TALISMAN().talismanType())) {
                PlayerEconomyManager.handlePurchase(player, new MOLTENSKIN_TALISMAN());
            }
            if (nbti.hasKey(new QUICKHANDS_TALISMAN().talismanType())) {
                PlayerEconomyManager.handlePurchase(player, new QUICKHANDS_TALISMAN());
            }
            if (nbti.hasKey(new WORKBENCH_TALISMAN().talismanType())) {
                PlayerEconomyManager.handlePurchase(player, new WORKBENCH_TALISMAN());
            }
            if (nbti.hasKey(new ENDER_TALISMAN().talismanType())) {
                PlayerEconomyManager.handlePurchase(player, new ENDER_TALISMAN());
            }
        }
    }
}
