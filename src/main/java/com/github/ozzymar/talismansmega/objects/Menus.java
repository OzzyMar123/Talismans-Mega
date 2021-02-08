package com.github.ozzymar.talismansmega.objects;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.ui.ShopMenu;

public class Menus {

    private final TalismansMega talismansMega;
    private ShopMenu shopMenu;

    public Menus(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    public void loadMenus() {
        this.shopMenu = new ShopMenu(talismansMega);
    }

    public void unloadMenus() {
        this.shopMenu = null;
    }

    public ShopMenu getShopMenu() {
        return shopMenu;
    }
}
