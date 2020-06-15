package org.edgegamers.picklez.Commands;

import net.milkbowl.vault.economy.Economy;
import org.edgegamers.picklez.Hooks.VaultEconomy;
import org.edgegamers.picklez.Main.EdgeTokens;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.command.SimpleCommand;

public class BalanceCommand extends SimpleCommand {

    public BalanceCommand() {
        super("bal");
        setPermission("tokens.balance");
        setUsage("/bal");
        setDescription("Fetch Token count via Vault");
        setAutoHandleHelp(true);
    }

    @Override
    public void onCommand() {
        VaultEconomy econ = new VaultEconomy();

        Common.tell(getPlayer(), "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYour tokens count is: &f" + econ.getBalance(getPlayer()));
    }
}
