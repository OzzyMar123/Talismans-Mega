package com.github.ozzymar.talismansmega.items;

import com.cryptomorin.xseries.XMaterial;
import com.github.ozzymar.marsapi.api.colors.ColorFormatter;
import com.github.ozzymar.marsapi.api.item.SkullItemStack;
import com.github.ozzymar.marsapi.api.util.Identifier;
import com.github.ozzymar.talismansmega.TalismansMega;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractTalisman {

    protected TalismansMega talismansMega;

    public AbstractTalisman(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    public abstract ItemStack getItem();

    public abstract YamlConfiguration config();

    public abstract String skullValue();

    public abstract String talismanType();

    public double price() {
        return config().getDouble("price");
    }

    protected ItemStack item() {
        NBTItem item = new NBTItem(new SkullItemStack(skullValue()).getItem());
        ItemMeta meta = item.getItem().getItemMeta();
        if (meta == null) return XMaterial.AIR.parseItem();
        meta.setDisplayName(ColorFormatter.format(config().getString("item.name")));
        item.getItem().setItemMeta(meta);
        // NBT
        item.setString(talismansMega.getUtilities().getNBTKeys().TALISMAN_UUID,
            new Identifier(16, 2).build());
        item.setString(talismansMega.getUtilities().getNBTKeys().IS_TALISMAN, "");

        item.setString(talismanType(), "");
        item.applyNBT(item.getItem());
        return item.getItem();
    }

    public ItemStack itemWithPriceLore() {
        ItemStack item = getItem();
        ItemMeta meta = item.getItemMeta();
        if (meta == null) return XMaterial.AIR.parseItem();
        List<String> lore = new ArrayList<>();
        talismansMega.getConfigs().getMenusConfig().getYaml().getStringList("shop-menu.price-lore-of-talismans")
            .forEach(str -> lore.add(ColorFormatter.format(str.replace("!price!", String.valueOf(price())))));
        meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}
