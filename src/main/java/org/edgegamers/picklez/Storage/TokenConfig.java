package org.edgegamers.picklez.Storage;

import org.mineacademy.fo.settings.YamlConfig;

public class TokenConfig extends YamlConfig {

    private String host;
    private int port;
    private String db;
    private String user;
    private String password;
    private String table;

    public TokenConfig() {
        loadConfiguration("config.yml", "config.yml");
    }

    @Override
    public void onLoadFinish() {
        host = getString("mySQL.host");
        port = getInteger("mySQL.port");
        db = getString("mySQL.databaseName");
        user = getString("mySQL.username");
        password = getString("mySQL.password");
        table = getString("mySQL.table");
    }

    public String getHost() {
        return getString("mySQL.host");
    }

    public int getPort() {
        return getInteger("mySQL.port");
    }

    public String getDatabase() {
        return getString("mySQL.databaseName");
    }

    public String getUsername() {
        return getString("mySQL.username");
    }

    public String getPassword() {
        return getString("mySQL.password");
    }

    public String getTable() {
        return getString("mySQL.table");
    }
}
