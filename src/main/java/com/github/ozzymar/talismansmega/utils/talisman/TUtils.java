package com.github.ozzymar.talismansmega.utils.talisman;

import com.github.ozzymar.marsapi.api.colors.ColorFormatter;
import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import com.github.ozzymar.talismansmega.items.types.*;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TUtils {

    private final TalismansMega talismansMega;

    public TUtils(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    public void reload(Player player) {
        try {
            talismansMega.getConfigs().getLangConfig().reload();
            talismansMega.getConfigs().getMenusConfig().reload();

            talismansMega.getConfigs().getFlashTalismanConfig().reload();
            talismansMega.getConfigs().getHealthTalismanConfig().reload();
            talismansMega.getConfigs().getWarriorTalismanConfig().reload();
            talismansMega.getConfigs().getIronskinTalismanConfig().reload();
            talismansMega.getConfigs().getMoltenskinTalismanConfig().reload();
            talismansMega.getConfigs().getQuickhandsTalismanConfig().reload();
            talismansMega.getConfigs().getWaterbreathTalismanConfig().reload();
            talismansMega.getConfigs().getWorkbenchTalismanConfig().reload();
            talismansMega.getConfigs().getEnderchestTalismanConfig().reload();

            Bukkit.getOnlinePlayers().stream()
                .map(p -> (Player) p)
                .forEach(p -> {
                    for (ItemStack item : p.getInventory().getContents()) {
                        if (item == null) return;
                        update(item);
                    }
                });
            player.sendMessage(ColorFormatter.format(talismansMega.getConfigs().getLangConfig().getYaml().getString("messages.reloaded")));
        } catch (Exception ex) {
            talismansMega.getConfigs().load();
        }
    }


    public List<ItemStack> talismans() {
        return new ArrayList<>(Arrays.asList(
            talismansMega.getTalismans().getFlashTalisman().getItem(),
            talismansMega.getTalismans().getHealthTalisman().getItem(),
            talismansMega.getTalismans().getWarriorTalisman().getItem(),
            talismansMega.getTalismans().getIronskinTalisman().getItem(),
            talismansMega.getTalismans().getMoltenskinTalisman().getItem(),
            talismansMega.getTalismans().getQuickhandsTalisman().getItem(),
            talismansMega.getTalismans().getWaterbreathTalisman().getItem(),
            talismansMega.getTalismans().getWorkbenchTalisman().getItem(),
            talismansMega.getTalismans().getEnderTalisman().getItem()
        ));
    }

    public void update(ItemStack item) {
        if (item == null) return;
        NBTItem nbti = new NBTItem(item);
        if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_FLASH_TALISMAN)) {
            item.setItemMeta(talismansMega.getTalismans().getFlashTalisman().getItem().getItemMeta());
        }
        if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_HEALTH_TALISMAN)) {
            item.setItemMeta(talismansMega.getTalismans().getHealthTalisman().getItem().getItemMeta());
        }
        if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_WARRIOR_TALISMAN)) {
            item.setItemMeta(talismansMega.getTalismans().getWarriorTalisman().getItem().getItemMeta());
        }
        if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_IRONSKIN_TALISMAN)) {
            item.setItemMeta(talismansMega.getTalismans().getIronskinTalisman().getItem().getItemMeta());
        }
        if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_MOLTENSKIN_TALISMAN)) {
            item.setItemMeta(talismansMega.getTalismans().getMoltenskinTalisman().getItem().getItemMeta());
        }
        if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_QUICKHANDS_TALISMAN)) {
            item.setItemMeta(talismansMega.getTalismans().getQuickhandsTalisman().getItem().getItemMeta());
        }
        if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_WATERBREATH_TALISMAN)) {
            item.setItemMeta(talismansMega.getTalismans().getWaterbreathTalisman().getItem().getItemMeta());
        }
        if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_WORKBENCH_TALISMAN)) {
            item.setItemMeta(talismansMega.getTalismans().getWorkbenchTalisman().getItem().getItemMeta());
        }
        if (nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_ENDER_TALISMAN)) {
            item.setItemMeta(talismansMega.getTalismans().getEnderTalisman().getItem().getItemMeta());
        }
    }

    public boolean isTalisman(ItemStack item) {
        NBTItem nbti = new NBTItem(item);
        return nbti.hasKey(talismansMega.getUtilities().getNBTKeys().IS_TALISMAN);
    }
}
