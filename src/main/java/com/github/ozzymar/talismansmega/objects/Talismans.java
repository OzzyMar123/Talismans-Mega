package com.github.ozzymar.talismansmega.objects;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.models.*;

public class Talismans {

    private final TalismansMega talismansMega;
    private FLASH_TALISMAN flashTalisman;
    private HEALTH_TALISMAN healthTalisman;
    private WARRIOR_TALISMAN warriorTalisman;
    private IRONSKIN_TALISMAN ironskinTalisman;
    private MOLTENSKIN_TALISMAN moltenskinTalisman;
    private QUICKHANDS_TALISMAN quickhandsTalisman;
    private WORKBENCH_TALISMAN workbenchTalisman;
    private ENDER_TALISMAN enderTalisman;
    public Talismans(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    public void loadTalismans() {
        this.flashTalisman = new FLASH_TALISMAN(talismansMega);
        this.healthTalisman = new HEALTH_TALISMAN(talismansMega);
        this.warriorTalisman = new WARRIOR_TALISMAN(talismansMega);
        this.ironskinTalisman = new IRONSKIN_TALISMAN(talismansMega);
        this.moltenskinTalisman = new MOLTENSKIN_TALISMAN(talismansMega);
        this.quickhandsTalisman = new QUICKHANDS_TALISMAN(talismansMega);
        this.workbenchTalisman = new WORKBENCH_TALISMAN(talismansMega);
        this.enderTalisman = new ENDER_TALISMAN(talismansMega);
    }

    public void unloadTalismans() {
        this.flashTalisman = null;
        this.healthTalisman = null;
        this.warriorTalisman = null;
        this.ironskinTalisman = null;
        this.moltenskinTalisman = null;
        this.quickhandsTalisman = null;
        this.workbenchTalisman = null;
        this.enderTalisman = null;
    }

    public FLASH_TALISMAN getFlashTalisman() {
        return flashTalisman;
    }

    public HEALTH_TALISMAN getHealthTalisman() {
        return healthTalisman;
    }

    public WARRIOR_TALISMAN getWarriorTalisman() {
        return warriorTalisman;
    }

    public IRONSKIN_TALISMAN getIronskinTalisman() {
        return ironskinTalisman;
    }

    public MOLTENSKIN_TALISMAN getMoltenskinTalisman() {
        return moltenskinTalisman;
    }

    public QUICKHANDS_TALISMAN getQuickhandsTalisman() {
        return quickhandsTalisman;
    }

    public WORKBENCH_TALISMAN getWorkbenchTalisman() {
        return workbenchTalisman;
    }

    public ENDER_TALISMAN getEnderTalisman() {
        return enderTalisman;
    }
}