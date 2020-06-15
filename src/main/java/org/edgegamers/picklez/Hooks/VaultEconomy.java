package org.edgegamers.picklez.Hooks;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.OfflinePlayer;
import org.edgegamers.picklez.Main.EdgeTokens;
import org.edgegamers.picklez.Storage.PlayerCache;

import java.util.List;

public class VaultEconomy implements Economy {
    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getName() {
        return "EdgeTokens";
    }

    @Override
    public boolean hasBankSupport() {
        return false;
    }

    @Override
    public int fractionalDigits() {
        return -1;
    }

    @Override
    public String format(double v) {
        return v + " Token(s)";
    }

    @Override
    public String currencyNamePlural() {
        return "Tokens";
    }

    @Override
    public String currencyNameSingular() {
        return "Token";
    }

    @Override
    public boolean hasAccount(String s) {
        //Deprecated
        return false;
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer) {
        try {
            PlayerCache.getCache(offlinePlayer.getUniqueId());
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public boolean hasAccount(String s, String s1) {
        //deprecated
        return false;
    }

    @Override
    public boolean hasAccount(OfflinePlayer offlinePlayer, String s) {
        try {
            PlayerCache.getCache(offlinePlayer.getUniqueId());
            return true;
        } catch(Exception e) {
            return false;
        }
    }

    @Override
    public double getBalance(String s) {
        //deprecated
        return 0;
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer) {
        PlayerCache cache = PlayerCache.getCache(offlinePlayer.getUniqueId());
        return cache.getTokens();
    }

    @Override
    public double getBalance(String s, String s1) {
        //deprecated
        return 0;
    }

    @Override
    public double getBalance(OfflinePlayer offlinePlayer, String s) {
        PlayerCache cache = PlayerCache.getCache(offlinePlayer.getUniqueId());
        return cache.getTokens();
    }

    @Override
    public boolean has(String s, double v) {
        //deprecated
        return false;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, double v) {
        if(getBalance(offlinePlayer) >= v) {
            return true;
        }
        return false;
    }

    @Override
    public boolean has(String s, String s1, double v) {
        //deprecated
        return false;
    }

    @Override
    public boolean has(OfflinePlayer offlinePlayer, String s, double v) {
        if(getBalance(offlinePlayer) >= v) {
            return true;
        }
        return false;
    }

    @Override
    public EconomyResponse withdrawPlayer(String s, double v) {
        //deprecated
        return null;
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, double v) {
        int bal = PlayerCache.getCache(offlinePlayer.getUniqueId()).getTokens();

        if(offlinePlayer == null) {
            return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Player is not online");
        }

        if(bal < v) {
            return new EconomyResponse(v, bal, EconomyResponse.ResponseType.FAILURE, "Not enough tokens");
        }

        if(v == 0) {
            return new EconomyResponse(v, bal, EconomyResponse.ResponseType.SUCCESS, "");
        }

        bal = bal - (int) v;

        PlayerCache.getCache(offlinePlayer.getUniqueId()).setTokens(bal);

        return new EconomyResponse(v, bal, EconomyResponse.ResponseType.SUCCESS, "");

    }

    @Override
    public EconomyResponse withdrawPlayer(String s, String s1, double v) {
        //deprecated
        return null;
    }

    @Override
    public EconomyResponse withdrawPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        int bal = PlayerCache.getCache(offlinePlayer.getUniqueId()).getTokens();

        if(offlinePlayer == null) {
            return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Player is not online");
        }

        if(bal < v) {
            return new EconomyResponse(v, bal, EconomyResponse.ResponseType.FAILURE, "Not enough tokens");
        }

        if(v == 0) {
            return new EconomyResponse(v, bal, EconomyResponse.ResponseType.SUCCESS, "");
        }

        bal = bal - (int) v;

        PlayerCache.getCache(offlinePlayer.getUniqueId()).setTokens(bal);

        return new EconomyResponse(v, bal, EconomyResponse.ResponseType.SUCCESS, "");
    }

    @Override
    public EconomyResponse depositPlayer(String s, double v) {
        //deprecated
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, double v) {
        if(offlinePlayer == null) {
            return new EconomyResponse(0, 0, EconomyResponse.ResponseType.FAILURE, "Player is not online");
        }

        int bal = PlayerCache.getCache(offlinePlayer.getUniqueId()).getTokens();

        if(v == 0) {
            return new EconomyResponse(v, bal, EconomyResponse.ResponseType.SUCCESS, "");
        }

        bal = bal + (int) v;

        PlayerCache.getCache(offlinePlayer.getUniqueId()).setTokens(bal);
        return new EconomyResponse(v, bal, EconomyResponse.ResponseType.SUCCESS, "");
    }

    @Override
    public EconomyResponse depositPlayer(String s, String s1, double v) {
        //deprecated
        return null;
    }

    @Override
    public EconomyResponse depositPlayer(OfflinePlayer offlinePlayer, String s, double v) {
        return depositPlayer(offlinePlayer, v);
    }

    @Override
    public EconomyResponse createBank(String s, String s1) {
        //deprecated
        return null;
    }

    @Override
    public EconomyResponse createBank(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public EconomyResponse deleteBank(String s) {
        return null;
    }

    @Override
    public EconomyResponse bankBalance(String s) {
        return null;
    }

    @Override
    public EconomyResponse bankHas(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse bankWithdraw(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse bankDeposit(String s, double v) {
        return null;
    }

    @Override
    public EconomyResponse isBankOwner(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse isBankOwner(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String s, String s1) {
        return null;
    }

    @Override
    public EconomyResponse isBankMember(String s, OfflinePlayer offlinePlayer) {
        return null;
    }

    @Override
    public List<String> getBanks() {
        return null;
    }

    @Override
    public boolean createPlayerAccount(String s) {
        return true;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer) {
        return true;
    }

    @Override
    public boolean createPlayerAccount(String s, String s1) {
        return true;
    }

    @Override
    public boolean createPlayerAccount(OfflinePlayer offlinePlayer, String s) {
        return true;
    }



    //DEPRECATED METHODS



}
