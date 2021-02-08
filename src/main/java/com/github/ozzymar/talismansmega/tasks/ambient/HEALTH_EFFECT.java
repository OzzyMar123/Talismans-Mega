package com.github.ozzymar.talismansmega.tasks.ambient;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HEALTH_EFFECT extends AbstractPassiveEffect {


    public HEALTH_EFFECT(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return talismansMega.getTalismans().getHealthTalisman();
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
        return talismansMega.getConfigs().getHealthTalismanConfig().getYaml();
    }
}
