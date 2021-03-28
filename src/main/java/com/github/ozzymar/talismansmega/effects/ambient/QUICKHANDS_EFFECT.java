package com.github.ozzymar.talismansmega.effects.ambient;

import com.cryptomorin.xseries.XPotion;
import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.potion.PotionEffect;

public class QUICKHANDS_EFFECT extends AbstractPassiveEffect {

    public QUICKHANDS_EFFECT(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return talismansMega.getTalismans().getQuickhandsTalisman();
    }

    @Override
    public PotionEffect[] effects() {
        return new PotionEffect[]{
                makePotion(XPotion.FAST_DIGGING.parsePotionEffectType(), 35, 2)
        };
    }

    @Override
    public int everyTickToCheck() {
        return 1;
    }
}
