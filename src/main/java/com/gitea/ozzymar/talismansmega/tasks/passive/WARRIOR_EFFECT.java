package com.gitea.ozzymar.talismansmega.tasks.passive;

import com.gitea.ozzymar.talismansmega.config.talismans.items.WarriorConfiguration;
import com.gitea.ozzymar.talismansmega.items.AbstractTalisman;
import com.gitea.ozzymar.talismansmega.items.models.WARRIOR_TALISMAN;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WARRIOR_EFFECT extends AbstractPassiveEffect {

    public WARRIOR_EFFECT(Plugin plugin) {
        super(plugin);
    }

    @Override
    public AbstractTalisman talismanNeeded() {
        return new WARRIOR_TALISMAN();
    }

    @Override
    public PotionEffect[] effects() {
        return new PotionEffect[]{
            makePotion(PotionEffectType.INCREASE_DAMAGE, 35, 2)
        };
    }

    @Override
    public int everyTickToCheck() {
        return 1;
    }

    @Override
    public YamlConfiguration config() {
        return WarriorConfiguration.getYaml();
    }
}
