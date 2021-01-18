package com.github.ozzymar.talismansmega.tasks.ambient;

import com.github.ozzymar.talismansmega.config.talismans.items.HealthConfiguration;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import com.github.ozzymar.talismansmega.items.models.HEALTH_TALISMAN;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HEALTH_EFFECT extends AbstractPassiveEffect {

    public HEALTH_EFFECT(Plugin plugin) {
        super(plugin);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return new HEALTH_TALISMAN();
    }

    @Override
    public PotionEffect[] effects() {
        return new PotionEffect[]{
            makePotion(PotionEffectType.REGENERATION, 35, 2)
        };
    }

    @Override
    public int everyTickToCheck() {
        return 1;
    }

    @Override
    public YamlConfiguration config() {
        return HealthConfiguration.getYaml();
    }
}
