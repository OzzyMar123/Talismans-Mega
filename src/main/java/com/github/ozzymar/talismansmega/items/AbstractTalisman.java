package com.github.ozzymar.talismansmega.items;

import com.cryptomorin.xseries.SkullUtils;
import com.cryptomorin.xseries.XMaterial;
import com.github.ozzymar.talismansmega.config.MenusConfiguration;
import com.github.ozzymar.talismansmega.utils.string.StringUtil;
import com.github.ozzymar.talismansmega.utils.string.UUIDUtils;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTalisman {

    public abstract ItemStack getItem();

    public abstract YamlConfiguration config();

    public abstract String skullValue();

    public abstract String talismanType();

    public abstract double price();

    protected ItemStack item() {
        NBTItem item = new NBTItem(XMaterial.PLAYER_HEAD.parseItem());
        ItemMeta meta = item.getItem().getItemMeta();
        meta.setDisplayName(StringUtil.format(config().getString("item.name")));
        SkullUtils.applySkin(meta, skullValue());
        item.getItem().setItemMeta(meta);
        // NBT
        item.setString(NBT_KEYS.TALISMAN_UUID, UUIDUtils.randomUUID(16));
        item.setString(NBT_KEYS.IS_TALISMAN, "");

        item.setString(talismanType(), "");
        item.applyNBT(item.getItem());
        return item.getItem();
    }

    public ItemStack itemWithPriceLore() {
        ItemStack item = getItem();
        ItemMeta meta = item.getItemMeta();

        List<String> lore = new ArrayList<>();
        MenusConfiguration.getYaml().getStringList("shop-menu.price-lore-of-talismans")
            .forEach(str -> lore.add(StringUtil.format(str.replace("!price!", String.valueOf(price())))));

        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
