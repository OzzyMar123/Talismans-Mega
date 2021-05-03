package com.github.ozzymar.talismansmega.effects.ambient;

import com.cryptomorin.xseries.XPotion;
import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.AbstractTalisman;
import org.bukkit.potion.PotionEffect;

public class WARRIOR_EFFECT extends AbstractPassiveEffect {

    public WARRIOR_EFFECT(TalismansMega talismansMega) {
        super(talismansMega);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return talismansMega.getTalismans().getWarriorTalisman();
    }

    @Override
    public PotionEffect[] effects() {
        return new PotionEffect[]{
                makePotion(XPotion.INCREASE_DAMAGE.parsePotionEffectType(), 2)
        };
    }

    @Override
    public int everyTickToCheck() {
        return 1;
    }
}
