package org.edgegamers.picklez.Storage;

import org.edgegamers.picklez.API.TokensPlayerCacheAPI;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.settings.YamlSectionConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerCache extends YamlSectionConfig implements TokensPlayerCacheAPI {

    private static Map<UUID, PlayerCache> cacheMap = new HashMap<>();

    private int tokens;

    protected PlayerCache(UUID uuid) {
        super(uuid.toString());

        loadConfiguration(null, "data.db");
    }

    @Override
    protected void onLoadFinish() {
        if(isSet("Tokens")) {
            tokens = getInteger("Tokens");
        }
        else {
            tokens = 0;
        }
    }

    @Override
    public void setTokens(int tokens) {
        this.tokens = tokens;

        save();
    }

    @Override
    public int getTokens() {
        return tokens;
    }

    @Override
    public SerializedMap serialize() {
        SerializedMap map = new SerializedMap();
        map.put("Tokens", tokens);
        return map;
    }

    public static int deserialize(SerializedMap map) {
        return map.getInteger("Tokens");
    }

    public static PlayerCache getCache(final UUID uuid) {
        if(cacheMap.containsKey(uuid)) {
            PlayerCache cache = cacheMap.get(uuid);
            return cache;
        }
        else {
            PlayerCache cache = new PlayerCache(uuid);
            cacheMap.put(uuid, cache);
            return cache;
        }
    }
}
