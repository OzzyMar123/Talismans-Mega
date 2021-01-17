package com.gitea.ozzymar.talismansmega.tasks.passive;

import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.models.HEALTH_TALISMAN;
import com.gitea.ozzymar.talismansmega.config.talismans.items.HealthConfiguration;
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
