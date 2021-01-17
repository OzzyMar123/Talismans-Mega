package com.gitea.ozzymar.talismansmega.tasks.passive;

import com.gitea.ozzymar.talismansmega.config.talismans.items.QuickhandsConfiguration;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.models.QUICKHANDS_TALISMAN;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class QUICKHANDS_EFFECT extends AbstractPassiveEffect {

    public QUICKHANDS_EFFECT(Plugin plugin) {
        super(plugin);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return new QUICKHANDS_TALISMAN();
    }

    @Override
    public PotionEffect[] effects() {
        return new PotionEffect[]{
            makePotion(PotionEffectType.FAST_DIGGING, 35, 2)
        };
    }

    @Override
    public int everyTickToCheck() {
        return 1;
    }

    @Override
    public YamlConfiguration config() {
        return QuickhandsConfiguration.getYaml();
    }
}
