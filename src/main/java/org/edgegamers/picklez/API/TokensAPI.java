package org.edgegamers.picklez.API;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.edgegamers.picklez.Storage.PlayerCache;

import java.util.UUID;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TokensAPI {

    public static PlayerCache getCache(UUID uuid) {
        return PlayerCache.getCache(uuid);
    }
}
