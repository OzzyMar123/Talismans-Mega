package com.github.ozzymar.talismansmega.ui;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.interfaces.IInitialise;
import com.github.ozzymar.talismansmega.ui.guis.ShopMenu;

public class Menus implements IInitialise {

    private final TalismansMega talismansMega;
    private ShopMenu shopMenu;

    public Menus(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    @Override
    public void load() {
        this.shopMenu = new ShopMenu(talismansMega);
    }

    @Override
    public void unload() {
        this.shopMenu = null;
    }

    public ShopMenu getShopMenu() {
        return shopMenu;
    }
}
