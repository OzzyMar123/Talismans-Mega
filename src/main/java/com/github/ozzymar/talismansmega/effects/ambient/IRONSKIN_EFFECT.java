package com.github.ozzymar.talismansmega.effects.ambient;

import com.cryptomorin.xseries.XPotion;
import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.potion.PotionEffect;

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
                makePotion(XPotion.DAMAGE_RESISTANCE.parsePotionEffectType(), 2)
        };
    }

    @Override
    public int everyTickToCheck() {
        return 1;
    }
}
