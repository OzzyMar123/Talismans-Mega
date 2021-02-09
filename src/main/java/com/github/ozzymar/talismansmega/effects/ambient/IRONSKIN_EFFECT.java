package com.github.ozzymar.talismansmega.effects.ambient;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IRONSKIN_EFFECT extends AbstractPassiveEffect {

    public IRONSKIN_EFFECT(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return talismansMega.getTalismans().getIronskinTalisman();
    }

    @Override
    public PotionEffect[] effects() {
        return new PotionEffect[]{
            makePotion(PotionEffectType.DAMAGE_RESISTANCE, 35, 2)
        };
    }

    @Override
    public int everyTickToCheck() {
        return 1;
    }

    @Override
    public YamlConfiguration config() {
        return talismansMega.getConfigs().getIronskinTalismanConfig().getYaml();
    }
}
