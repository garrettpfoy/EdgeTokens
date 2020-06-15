package org.edgegamers.picklez.Storage;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mineacademy.fo.collection.SerializedMap;
import org.mineacademy.fo.database.SimpleFlatDatabase;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TokenDatabase extends SimpleFlatDatabase<PlayerCache> {

    @Getter
    private final static TokenDatabase instance = new TokenDatabase();

    public static TokenDatabase getInstance() {
        return instance;
    }

    @Override
    protected void onLoad(SerializedMap serializedMap, PlayerCache playerCache) {

        int tokens = serializedMap.getInteger("Tokens");

        playerCache.setTokens(tokens);

    }

    @Override
    protected SerializedMap onSave(PlayerCache playerCache) {
        SerializedMap map = new SerializedMap();

        map.put("Tokens", playerCache.getTokens());

        return map;
    }
}
