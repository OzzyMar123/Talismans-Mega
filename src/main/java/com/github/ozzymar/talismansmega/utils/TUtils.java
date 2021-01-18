package com.github.ozzymar.talismansmega.utils;

import com.github.ozzymar.talismansmega.config.LangConfiguration;
import com.github.ozzymar.talismansmega.config.MenusConfiguration;
import com.github.ozzymar.talismansmega.config.talismans.items.*;
import com.github.ozzymar.talismansmega.items.NBT_KEYS;
import com.github.ozzymar.talismansmega.items.models.*;
import com.github.ozzymar.talismansmega.utils.string.StringUtil;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class TUtils {
    public static void reload(Player player) {
        LangConfiguration.reload();
        MenusConfiguration.reload();

        FlashConfiguration.reload();
        HealthConfiguration.reload();
        WarriorConfiguration.reload();
        IronskinConfiguration.reload();
        MoltenskinConfiguration.reload();
        QuickhandsConfiguration.reload();
        WorkbenchConfiguration.reload();
        EnderConfiguration.reload();

        Bukkit.getOnlinePlayers().stream()
            .map(p -> (Player) p)
            .forEach(p -> {
                for (ItemStack item : p.getInventory().getContents()) {
                    if (item == null) return;
                    update(item);
                }
            });
        player.sendMessage(StringUtil.format(LangConfiguration.getYaml().getString("messages.reloaded")));
    }

    public static List<ItemStack> talismans() {
        List<ItemStack> t = new ArrayList<>();
        t.add(new FLASH_TALISMAN().getItem());
        t.add(new HEALTH_TALISMAN().getItem());
        t.add(new WARRIOR_TALISMAN().getItem());
        t.add(new IRONSKIN_TALISMAN().getItem());
        t.add(new MOLTENSKIN_TALISMAN().getItem());
        t.add(new QUICKHANDS_TALISMAN().getItem());
        t.add(new WORKBENCH_TALISMAN().getItem());
        t.add(new ENDER_TALISMAN().getItem());
        return t;
    }

    public static void update(ItemStack item) {
        if (item == null) return;
        NBTItem nbti = new NBTItem(item);
        if (nbti.hasKey(NBT_KEYS.IS_FLASH_TALISMAN)) {
            item.setItemMeta(new FLASH_TALISMAN().getItem().getItemMeta());
        }
        if (nbti.hasKey(NBT_KEYS.IS_HEALTH_TALISMAN)) {
            item.setItemMeta(new HEALTH_TALISMAN().getItem().getItemMeta());
        }
        if (nbti.hasKey(NBT_KEYS.IS_WARRIOR_TALISMAN)) {
            item.setItemMeta(new WARRIOR_TALISMAN().getItem().getItemMeta());
        }
        if (nbti.hasKey(NBT_KEYS.IS_IRONSKIN_TALISMAN)) {
            item.setItemMeta(new IRONSKIN_TALISMAN().getItem().getItemMeta());
        }
        if (nbti.hasKey(NBT_KEYS.IS_MOLTENSKIN_TALISMAN)) {
            item.setItemMeta(new MOLTENSKIN_TALISMAN().getItem().getItemMeta());
        }
        if (nbti.hasKey(NBT_KEYS.IS_QUICKHANDS_TALISMAN)) {
            item.setItemMeta(new QUICKHANDS_TALISMAN().getItem().getItemMeta());
        }
        if (nbti.hasKey(NBT_KEYS.IS_WORKBENCH_TALISMAN)) {
            item.setItemMeta(new WORKBENCH_TALISMAN().getItem().getItemMeta());
        }
        if (nbti.hasKey(NBT_KEYS.IS_ENDER_TALISMAN)) {
            item.setItemMeta(new ENDER_TALISMAN().getItem().getItemMeta());
        }
    }

    public static boolean isTalisman(ItemStack item) {
        NBTItem nbti = new NBTItem(item);
        return nbti.hasKey(NBT_KEYS.IS_TALISMAN);
    }
}
