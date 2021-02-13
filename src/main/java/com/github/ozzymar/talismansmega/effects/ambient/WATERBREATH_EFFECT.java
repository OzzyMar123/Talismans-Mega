package com.github.ozzymar.talismansmega.effects.ambient;

import com.cryptomorin.xseries.XPotion;
import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.potion.PotionEffect;

public class WATERBREATH_EFFECT extends AbstractPassiveEffect {

    public WATERBREATH_EFFECT(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return talismansMega.getTalismans().getWaterbreathTalisman();
    }

    @Override
    public PotionEffect[] effects() {
        return new PotionEffect[]{
            makePotion(XPotion.WATER_BREATHING.parsePotionEffectType(), 35, 2)
        };
    }

    @Override
    public int everyTickToCheck() {
        return 1;
    }
}
