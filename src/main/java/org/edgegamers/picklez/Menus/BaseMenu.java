package org.edgegamers.picklez.Menus;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.edgegamers.picklez.Storage.PlayerCache;
import org.mineacademy.fo.Common;
import org.mineacademy.fo.menu.Menu;
import org.mineacademy.fo.menu.button.Button;
import org.mineacademy.fo.menu.model.ItemCreator;
import org.mineacademy.fo.remain.CompMaterial;

public class BaseMenu extends Menu {

    private Button dragonHead; //No price //1,000 tokens  //1 token == 10000?
    private Button dragonEgg; //5 mil for 1 //750 tokens
    private Button enchantedGoldenApple; //2 mil for 16 //500 tokens
    private Button enchantBottle; //75000 for 1 //250
    private Button bedrock; //75000 for 4 //200
    private Button endPortal; //No price //175
    private Button elytra; //No price //150
    private Button witherRose; //No price //125
    private Button beacon; //No price //100
    private Button witherHead; //No price //75
    private Button saddle; //No price //50

    public BaseMenu() {
        setTitle("&9Token Shop");
        setSize(9*3);

        this.dragonHead = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 1000) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.DRAGON_HEAD));
                    cache.setTokens(cache.getTokens() - 1000);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Dragon Head &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.DRAGON_HEAD, "&9&lDragon Head", "&7", "&bPrice: &f1,000 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.dragonEgg = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 750) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.DRAGON_EGG));
                    cache.setTokens(cache.getTokens() - 750);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Dragon Egg &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.DRAGON_EGG, "&9&lDragon Egg", "&7", "&bPrice: &f750 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.enchantedGoldenApple = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 500) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.ENCHANTED_GOLDEN_APPLE));
                    cache.setTokens(cache.getTokens() - 500);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Enchanted Golden Apple &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.ENCHANTED_GOLDEN_APPLE, "&9&lEnchanted Golden Apple", "&7", "&bPrice: &f500 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.enchantBottle = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 250) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.EXPERIENCE_BOTTLE));
                    cache.setTokens(cache.getTokens() - 250);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Experience Bottle &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.EXPERIENCE_BOTTLE, "&9&lExperience Bottle", "&7", "&bPrice: &f250 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.bedrock = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 200) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.BEDROCK));
                    cache.setTokens(cache.getTokens() - 200);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Bedrock &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.BEDROCK, "&9&lBedrock", "&7", "&bPrice: &f200 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.endPortal = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 175) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.END_PORTAL_FRAME));
                    cache.setTokens(cache.getTokens() - 175);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x End Portal Frame &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.END_PORTAL_FRAME, "&9&lEnd Portal Frame", "&7", "&bPrice: &f175 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.elytra = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 150) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.ELYTRA));
                    cache.setTokens(cache.getTokens() - 150);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Elytra &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.ELYTRA, "&9&lElytra", "&7", "&bPrice: &f150 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.witherRose = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 125) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.WITHER_ROSE));
                    cache.setTokens(cache.getTokens() - 125);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Wither Rose &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.ROSE_BUSH, "&9&lWither Rose", "&7", "&bPrice: &f125 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.beacon = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 100) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.BEACON));
                    cache.setTokens(cache.getTokens() - 100);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Beacon &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.BEACON, "&9&lBeacon", "&7", "&bPrice: &f100 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.witherHead = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 75) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.WITHER_SKELETON_SKULL));
                    cache.setTokens(cache.getTokens() - 75);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Wither Skeleton Head &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.WITHER_SKELETON_SKULL, "&9&lWither Skeleton Head", "&7", "&bPrice: &f75 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };

        this.saddle = new Button() {

            @Override
            public void onClickedInMenu(Player player, Menu menu, ClickType clickType) {
                PlayerCache cache = PlayerCache.getCache(player.getUniqueId());
                if(cache.getTokens() >= 50) {
                    //Has enough coin, give them ware
                    player.getInventory().addItem(new ItemStack(Material.SADDLE));
                    cache.setTokens(cache.getTokens() - 50);
                    player.closeInventory();
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou have bought &f1x Saddle &bfrom the token shop!");
                }
                else {
                    Common.tell(player, "&1&lE&9&lG&f&lO &9&lTokens &f&l\u00BB &bYou don't have enough tokens! Current balance: &F" + cache.getTokens() + " &btokens!");
                    player.closeInventory();
                }
            }

            @Override
            public ItemStack getItem() {
                return ItemCreator.of(CompMaterial.SADDLE, "&9&lSaddle", "&7", "&bPrice: &f50 Tokens", "&7","&7((Click to Purchase))").build().make();
            }
        };
    }

    @Override
    public ItemStack getItemAt(int slot) {
        if(slot == 1) {
            return dragonHead.getItem();
        }
        else if(slot == 3) {
            return dragonEgg.getItem();
        }
        else if(slot == 5) {
            return enchantedGoldenApple.getItem();
        }
        else if(slot == 7) {
            return enchantBottle.getItem();
        }
        else if(slot == 11) {
            return bedrock.getItem();
        }
        else if(slot == 13) {
            return endPortal.getItem();
        }
        else if(slot == 15) {
            return elytra.getItem();
        }
        else if(slot == 19) {
            return witherRose.getItem();
        }
        else if(slot == 21) {
            return beacon.getItem();
        }
        else if(slot == 23) {
            return witherHead.getItem();
        }
        else if(slot == 25) {
            return saddle.getItem();
        }
        else {
            return null;
        }
    }

    @Override
    protected String[] getInfo() {
        return null;
    }



}
