package com.github.ozzymar.talismansmega.objects;

import com.github.ozzymar.talismansmega.TalismansMega;
import com.github.ozzymar.talismansmega.items.NBT_KEYS;
import com.github.ozzymar.talismansmega.utils.TUtils;
import com.github.ozzymar.talismansmega.utils.eco.PlayerEconomyManager;
import com.github.ozzymar.talismansmega.utils.eco.ServerEconomyManager;
import com.github.ozzymar.talismansmega.utils.string.UUIDUtils;

public class Utilities {

    private final TalismansMega talismansMega;
    private PlayerEconomyManager playerEconomyManager;
    private ServerEconomyManager serverEconomyManager;
    private UUIDUtils uuidUtils;
    private TUtils tUtils;
    private NBT_KEYS nbt_keys;
    public Utilities(TalismansMega talismansMega) {
        this.talismansMega = talismansMega;
    }

    public void loadUtilities() {
        this.nbt_keys = new NBT_KEYS();
        this.serverEconomyManager = new ServerEconomyManager();
        this.playerEconomyManager = new PlayerEconomyManager(serverEconomyManager);
        this.uuidUtils = new UUIDUtils();
        this.tUtils = new TUtils(talismansMega);
    }

    public void unloadUtilities() {
        this.nbt_keys = null;
        this.playerEconomyManager = null;
        this.serverEconomyManager = null;
        this.uuidUtils = null;
        this.tUtils = null;
    }

    public PlayerEconomyManager getPlayerEconomyManager() {
        return playerEconomyManager;
    }

    public ServerEconomyManager getServerEconomyManager() {
        return serverEconomyManager;
    }

    public UUIDUtils getUUIDUtils() {
        return uuidUtils;
    }

    public TUtils getTUtils() {
        return tUtils;
    }

    public NBT_KEYS getNBTKeys() {
        return nbt_keys;
    }
}
