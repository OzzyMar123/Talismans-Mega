package com.github.ozzymar.talismansmega.effects.ambient;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import de.tr7zw.nbtapi.NBTItem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public abstract class AbstractPassiveEffect extends BukkitRunnable {

    protected TalismansMega talismansMega;

    public AbstractPassiveEffect(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
        this.runTaskTimer(talismansMega, 0, everyTickToCheck());
    }

    public abstract AbstractTalisman talismanNeeded();

    public abstract PotionEffect[] effects();

    public abstract int everyTickToCheck();

    @Override
    public void run() {
        Bukkit.getOnlinePlayers()
                .stream()
                .map((player) -> (Player) player)
                .forEach(player ->
                        Arrays.stream(player.getInventory().getContents())
                                .forEach(itemStack ->
                                {
                                    if (itemStack == null) return;
                                    NBTItem nbti = new NBTItem(itemStack);
                                    if (!nbti.hasKey(talismanNeeded().talismanType())) return;

                                    if (!talismanNeeded().config().getStringList("enabled-worlds").contains(player.getWorld().getName()))
                                        return;
                                    Arrays.stream(effects())
                                            .forEach(player::addPotionEffect);
                                }));
    }

    protected PotionEffect makePotion(PotionEffectType type, int duration, int amplifier) {
        return new PotionEffect(type, duration, amplifier - 1, false, false);
    }
}
