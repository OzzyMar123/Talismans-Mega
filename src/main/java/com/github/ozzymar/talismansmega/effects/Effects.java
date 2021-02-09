package com.github.ozzymar.talismansmega.effects;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.effects.ambient.*;
import com.github.ozzymar.talismansmega.effects.interact.ENDERCHEST_EFFECT;
import com.github.ozzymar.talismansmega.effects.interact.WORKBENCH_EFFECT;

public class Effects {

    private final TalismansMega talismansMega;
    private FLASH_EFFECT flash_effect;
    private HEALTH_EFFECT health_effect;
    private WARRIOR_EFFECT warrior_effect;
    private IRONSKIN_EFFECT ironskin_effect;
    private MOLTENSKIN_EFFECT moltenskin_effect;
    private QUICKHANDS_EFFECT quickhands_effect;
    private WORKBENCH_EFFECT workbench_effect;
    private ENDERCHEST_EFFECT enderchest_effect;

    public Effects(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    public void load() {
        this.flash_effect = new FLASH_EFFECT(talismansMega);
        this.health_effect = new HEALTH_EFFECT(talismansMega);
        this.warrior_effect = new WARRIOR_EFFECT(talismansMega);
        this.ironskin_effect = new IRONSKIN_EFFECT(talismansMega);
        this.moltenskin_effect = new MOLTENSKIN_EFFECT(talismansMega);
        this.quickhands_effect = new QUICKHANDS_EFFECT(talismansMega);
        this.workbench_effect = new WORKBENCH_EFFECT(talismansMega);
        this.enderchest_effect = new ENDERCHEST_EFFECT(talismansMega);
    }

    public void unload() {
        this.flash_effect = null;
        this.health_effect = null;
        this.warrior_effect = null;
        this.ironskin_effect = null;
        this.moltenskin_effect = null;
        this.quickhands_effect = null;
        this.workbench_effect = null;
        this.enderchest_effect = null;
    }

    public FLASH_EFFECT getFlashEffect() {
        return flash_effect;
    }

    public HEALTH_EFFECT getHealthEffect() {
        return health_effect;
    }

    public WARRIOR_EFFECT getWarriorEffect() {
        return warrior_effect;
    }

    public IRONSKIN_EFFECT getIronskinEffect() {
        return ironskin_effect;
    }

    public MOLTENSKIN_EFFECT getMoltenskinEffect() {
        return moltenskin_effect;
    }

    public QUICKHANDS_EFFECT getQuickhandsEffect() {
        return quickhands_effect;
    }

    public WORKBENCH_EFFECT getWorkbenchEffect() {
        return workbench_effect;
    }

    public ENDERCHEST_EFFECT getEnderchestEffect() {
        return enderchest_effect;
    }
}
