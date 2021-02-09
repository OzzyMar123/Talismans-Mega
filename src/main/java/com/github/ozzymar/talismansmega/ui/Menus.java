package com.github.ozzymar.talismansmega.ui;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.ui.guis.ShopMenu;

public class Menus {

    private final TalismansMega talismansMega;
    private ShopMenu shopMenu;

    public Menus(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    public void load() {
        this.shopMenu = new ShopMenu(talismansMega);
    }

    public void unload() {
        this.shopMenu = null;
    }

    public ShopMenu getShopMenu() {
        return shopMenu;
    }
}
