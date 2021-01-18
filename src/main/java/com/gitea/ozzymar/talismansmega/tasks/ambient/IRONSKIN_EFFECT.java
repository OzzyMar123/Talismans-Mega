package com.gitea.ozzymar.talismansmega.tasks.ambient;

import com.gitea.ozzymar.talismansmega.config.talismans.items.IronskinConfiguration;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.models.IRONSKIN_TALISMAN;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IRONSKIN_EFFECT extends AbstractPassiveEffect {

    public IRONSKIN_EFFECT(Plugin plugin) {
        super(plugin);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return new IRONSKIN_TALISMAN();
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
        return IronskinConfiguration.getYaml();
    }
}
