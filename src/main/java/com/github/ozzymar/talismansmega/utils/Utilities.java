package com.github.ozzymar.talismansmega.utils;

import com.github.ozzymar.marsapi.api.item.ItemSerializer;
import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.interfaces.IInitialise;
import com.github.ozzymar.talismansmega.items.NBT_KEYS;
import com.github.ozzymar.talismansmega.utils.economy.PlayerEconomyManager;
import com.github.ozzymar.talismansmega.utils.economy.ServerEconomyManager;
import com.github.ozzymar.talismansmega.utils.talisman.TUtils;

public class Utilities implements IInitialise {

    private final TalismansMega talismansMega;
    private ItemSerializer itemSerializer;
    private PlayerEconomyManager playerEconomyManager;
    private ServerEconomyManager serverEconomyManager;
    private TUtils tUtils;
    private NBT_KEYS nbt_keys;

    public Utilities(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    @Override
    public void load() {
        this.itemSerializer = new ItemSerializer();
        this.serverEconomyManager = new ServerEconomyManager();
        this.playerEconomyManager = new PlayerEconomyManager(serverEconomyManager);
        this.nbt_keys = new NBT_KEYS();
        this.tUtils = new TUtils(talismansMega);
    }

    @Override
    public void unload() {
        this.itemSerializer = null;
        this.tUtils = null;
        this.nbt_keys = null;
        this.playerEconomyManager = null;
        this.serverEconomyManager = null;
    }

    public ItemSerializer getItemSerializer() {
        return itemSerializer;
    }

    public PlayerEconomyManager getPlayerEconomyManager() {
        return playerEconomyManager;
    }

    public ServerEconomyManager getServerEconomyManager() {
        return serverEconomyManager;
    }

    public TUtils getTUtils() {
        return tUtils;
    }

    public NBT_KEYS getNBTKeys() {
        return nbt_keys;
    }
}
