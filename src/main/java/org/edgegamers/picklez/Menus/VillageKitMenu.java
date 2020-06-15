package org.edgegamers.picklez.Menus;

import net.luckperms.api.LuckPerms;
import net.luckperms.api.context.DefaultContextKeys;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.PermissionNode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.edgegamers.picklez.Main.EdgeTokens;
import org.edgegamers.picklez.Storage.PlayerCache;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class VillageKitMenu extends Menu {

    private Button lightTank;
    private Button teleporter;
    private Button heavyTank;
    private Button shotbowMaster;
    private Button dogFriend;
    private Button hardcoreMaster;
    private Button tornado;
    private Button blocker;
    private Button medic;
    private Button naked;
    private Button wizard;

    public VillageKitMenu() {
        setTitle("&2Village Defense Kit Shop");
        setSize(9 * 5);

        this.lightTank = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 1000) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.lighttank", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 1000);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fLight Tank Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.IRON_CHESTPLATE, "&a&lLight Tank", "&7", "&2Information:", "&8- &7Full iron armor", "&8- &7Wooden Sword (Unbreaking 10)", "&8- &78 Porkchops", "&7", "&2Price: &71,000 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };

        this.teleporter = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 1500) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.teleporter", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 1500);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fTeleporter Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.ENDER_PEARL, "&a&lTeleporter", "&7", "&2Information:", "&8- &7Full gold armor", "&8- &7Stone Sword (Unbreaking 10)", "&8- &710 Steak", "&8- &7Teleportation Menu Ghast Tear", "&7", "&2Price: &71,500 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };

        this.heavyTank = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 2000) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.heavytank", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 2000);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fHeavy Tank Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.DIAMOND_CHESTPLATE, "&a&lHeavy Tank", "&7", "&2Information:", "&8- &7Full iron armor", "&8- &7Sharpness II Stick", "&8- &78 Porkchops", "&8- &710 extra hearts", "&7", "&2Price: &72,000 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };

        this.shotbowMaster = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 2500) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.shotbowmaster", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 2500);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fShotbow Master Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.BOW, "&a&lShotbow Master", "&7", "&2Information:", "&8- &7Full leather armor", "&8- &7Punch I Bow", "&8- &78 Steak", "&8- &7192 Arrows", "&7", "&2Price: &72,500 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };

        this.dogFriend = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 3000) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.dogfriend", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 3000);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fDog Friend Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.BONE, "&a&lDog Friend", "&7", "&2Information:", "&8- &7Full Leather Armor", "&8- &7Three dogs (+1 every round)", "&8- &78 Porkchops", "&8- &7Stone Sword", "&7", "&2Price: &73,000 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };

        this.hardcoreMaster = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 3500) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.premiumhardcoremaster", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 3500);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fHardcore Master Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.DIAMOND_SWORD, "&a&lHardcore Master", "&7", "&2Information:", "&8- &73 Hearts", "&8- &7Sharpness 11 Diamond Sword", "&8- &7Saddle", "&7", "&2Price: &73,500 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };

        this.tornado = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 4000) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.tornado", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 4000);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fTornado Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.COBWEB, "&a&lTornado", "&7", "&2Information:", "&8- &7Full Gold Armor", "&8- &75 Tornado Items (+5 each round)", "&8- &710 Steak", "&8- &7Stone Sword (Unbreaking 10)", "&7", "&2Price: &74,000 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };

        this.blocker = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 4500) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.blocker", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 4500);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fBlocker Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.BARRIER, "&a&lBlocker", "&7", "&2Information:", "&8- &7Full Leather Armor", "&8- &75 Wooden Fences (+3 each round)", "&8- &7Stone Sword (Unbreaking 10)", "&7", "&2Price: &74,500 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };

        this.medic = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 5000) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.medic", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 5000);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fMedic Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.GOLDEN_APPLE, "&a&lMedic", "&7", "&2Information:", "&8- &7Full Leather Armor", "&8- &7Splash Potion of Regeneration", "&8- &78 Porkchops", "&8- &7Stone Sword (Unbreaking 10)", "&8- &7Ability to passively heal nearby allies", "&7", "&2Price: &75,000 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };

        this.naked = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 5500) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.wildnaked", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 5500);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fNaked Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.TURTLE_HELMET, "&a&lNaked", "&7", "&2Information:", "&8- &7Iron Sword (Sharp 6, Smite 2, Unbreaking 10)", "&8- &7Splash Healing Potion (+1 every round)", "&7", "&2Price: &75,500 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };


        this.wizard = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if (cache.getTokens() >= 6000) {
                    //Has enough coin, give them ware
                    try {
                        addPermission("villagedefense.kit.wizard", player);
                    } catch (InterruptedException | ExecutionException | TimeoutException e) {
                        e.printStackTrace();
                    }
                    cache.setTokens(cache.getTokens() - 6000);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &fWizard Kit &bfrom the token shop!");
                } else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.BLAZE_ROD, "&a&lWizard", "&7", "&2Information:", "&8- &7Full Leather Armor", "&8- &75 Blaze Rod Wand (Shoots particle projectiles)", "&8- &75 Ink Sacs (Temporary Thorn Shield)", "&7", "&2Price: &76,000 tokens", "&7", "&8(( &7Click to Purchase &8))").build().make();
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {
        if(slot == 10) {
            return lightTank.getItem();
        }
        else if(slot == 11) {
            return teleporter.getItem();
        }
        else if(slot == 12) {
            return heavyTank.getItem();
        }
        else if(slot == 13) {
            return shotbowMaster.getItem();
        }
        else if(slot == 14) {
            return dogFriend.getItem();
        }
        else if(slot == 15) {
            return hardcoreMaster.getItem();
        }
        else if(slot == 16) {
            return tornado.getItem();
        }
        else if(slot == 21) {
            return blocker.getItem();
        }
        else if(slot == 22) {
            return medic.getItem();
        }
        else if(slot == 23) {
            return naked.getItem();
        }
        else if(slot == 31) {
            return wizard.getItem();
        }
        else {
            return ItemCreator.of(CompMaterial.GRAY_STAINED_GLASS_PANE, "&7").build().make();
        }
    }

    @Override
    protected String[] getInfo() {
        return null;
    }


    private static void addPermission(String permission, Player player) throws InterruptedException, ExecutionException, TimeoutException {

        PermissionNode node = PermissionNode.builder(permission)
                .withContext(DefaultContextKeys.SERVER_KEY, "events")
                .value(true)
                .build();

        LuckPerms api = EdgeTokens.getPerms();

        CompletableFuture<User> userFuture = api.getUserManager().loadUser(player.getUniqueId());

        userFuture.thenAcceptAsync(user -> {
            user.data().add(node);
            api.getUserManager().saveUser(user);
        }).get(15, TimeUnit.SECONDS);
    }


}
