package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

public class Weapons {



    public static ItemStack wand;
    public static ItemStack pulsarcannon;
    public static ItemStack solarsystem;
    public static ItemStack blackholesword;
    public static ItemStack minorgravityfield;
    public static ItemStack zomhelmet;
    public static ItemStack zomchestplate;
    public static ItemStack zomleggings;
    public static ItemStack zomboots;
    public static ItemStack statgui;

    // Add custom metadata using the plugin instance
    public static Plugin plugin = Plugin.getInstance();

    //custom modifiers
    public static NamespacedKey key = new NamespacedKey(plugin, "GENERIC_STRENGTH");

    public static NamespacedKey key2 = new NamespacedKey(plugin, "GENERIC_CRIT_DAMAGE");

    public static NamespacedKey key3 = new NamespacedKey(plugin, "GENERIC_CRIT_CHANCE");




    public static void init() {
        createWand();
        createpulsar();
        createsolarsys();
        createblackholesword();
        minorgravityfield();
        customhelm();
        customchest();
        customleg();
        customboot();
        customStatgui();

    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.FEATHER,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Rocket Thruster");
        List<String> lore = new ArrayList<>();
        lore.add("§fHop to the moon!\n");
        lore.add("§c5 Second Cooldown");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        wand = item;
    }

    private static void createpulsar() {
        ItemStack item = new ItemStack(Material.GOLDEN_HOE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Pulsar Cannon");
        List<String> lore = new ArrayList<>();
        lore.add("§fBlast your enemy to another galaxy!\n");
        lore.add("§c5 Second Cooldown");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        pulsarcannon = item;
    }

    private static void createsolarsys() {
        ItemStack item = new ItemStack(Material.DIAMOND_SWORD,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§bOrbital Planet Strike");
        List<String> lore = new ArrayList<>();
        
        lore.add("§7Damage: " + "§c+40");
        lore.add("§7Strength: " + "§c+150");
        lore.add("§7Crit Damage: " + "§c75%");
        lore.add("§7Crit Chance: " + "§c25%");
        lore.add("");
        lore.add("§7Shoots spinning planets that orbit around the player!");
        //lore.add("");
        lore.add("");
        lore.add("§8Cooldown: §a10s");
        lore.add("§l§bCelestial Sword");
        //lore.add("§fCool spinny planets!\n");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.setUnbreakable(true);


        AttributeModifier damageModifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 40.0, AttributeModifier.Operation.ADD_NUMBER);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);

        PersistentDataContainer dataContainer = meta.getPersistentDataContainer();
        dataContainer.set(key, PersistentDataType.INTEGER, 150);

        PersistentDataContainer dataContainer2 = meta.getPersistentDataContainer();
        dataContainer2.set(key2, PersistentDataType.INTEGER, 75);

        PersistentDataContainer dataContainer3 = meta.getPersistentDataContainer();
        dataContainer3.set(key3, PersistentDataType.INTEGER, 25);

        item.setItemMeta(meta);
        solarsystem = item;
    }

    public static void createblackholesword() {
        ItemStack item = new ItemStack(Material.STONE_SWORD,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Black Hole Sword");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: " + "§c+10");
        lore.add("§7Strength: " + "§c+50");
        lore.add("§7Crit Damage: " + "§c75%");
        lore.add("§7Crit Chance: " + "§c15%");
        lore.add("");
        lore.add("§7Cross travel throught space and time to the closest player within 30 blocks of you!");
        lore.add("§7Gain §l§6Absorption II§r§7 for 7 Seconds and give your victim §l§8Blindness I §r§7for 4 seconds.");
        lore.add("");
        lore.add("§8Cooldown: §a30s");
        lore.add("§l§5Galactic Sword");
        meta.setLore(lore);
        meta.setUnbreakable(true);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        


        // Add custom attributes to the weapon
        AttributeModifier damageModifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 10.0, AttributeModifier.Operation.ADD_NUMBER);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);

        // Add custom metadata
         // Add custom metadata using the plugin instance
         
         //Plugin plugin = Plugin.getInstance();
        
         
         
         PersistentDataContainer dataContainer = meta.getPersistentDataContainer();
         dataContainer.set(key, PersistentDataType.INTEGER, 50);

         PersistentDataContainer dataContainer2 = meta.getPersistentDataContainer();
         dataContainer2.set(key2, PersistentDataType.INTEGER, 75);

         PersistentDataContainer dataContainer3 = meta.getPersistentDataContainer();
         dataContainer3.set(key3, PersistentDataType.INTEGER, 15);


        // Add item flags to hide the attributes
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);


        item.setItemMeta(meta);
        blackholesword = item;
    }

    private static void minorgravityfield() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD,1); //Medium Cluster //Large Block // they will all spin upwards
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Minor Gravity Field");
        List<String> lore = new ArrayList<>();
        lore.add("§fChange your gravity and give yourself buffs!");
        lore.add("§c45 Second Cooldown");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        minorgravityfield = item;
    }

    private static void customhelm() {
        ItemStack item = new ItemStack(Material.DIAMOND_HELMET,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("&2Zombie Helmet");
        // List<String> lore = new ArrayList<>();
        // lore.add("§fChange your gravity and give yourself buffs!");
        // lore.add("§c45 Second Cooldown");
        // meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        zomhelmet = item;
    }

    private static void customchest() {
        ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("&2Zombie Chestplate");
        // List<String> lore = new ArrayList<>();
        // lore.add("§fChange your gravity and give yourself buffs!");
        // lore.add("§c45 Second Cooldown");
        // meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        zomchestplate = item;
    }

    private static void customleg() {
        ItemStack item = new ItemStack(Material.DIAMOND_LEGGINGS,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("&2Zombie Leggings");
        // List<String> lore = new ArrayList<>();
        // lore.add("§fChange your gravity and give yourself buffs!");
        // lore.add("§c45 Second Cooldown");
        // meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        zomleggings = item;
    }

    private static void customboot() {
        ItemStack item = new ItemStack(Material.DIAMOND_BOOTS,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("&2Zombie Boots");
        // List<String> lore = new ArrayList<>();
        // lore.add("§fChange your gravity and give yourself buffs!");
        // lore.add("§c45 Second Cooldown");
        // meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        zomboots = item;
    }

    private static void customStatgui() {
        ItemStack item = new ItemStack(Material.NETHER_STAR,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Menu");
        List<String> lore = new ArrayList<>();

        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        statgui = item;
    }

    public static int getCustomStrength(ItemStack item) {
        if (item == null || !item.hasItemMeta()) {
            return 0; // or a default value
        }

        ItemMeta meta = item.getItemMeta();

        PersistentDataContainer dataContainer = meta.getPersistentDataContainer();

        if (dataContainer.has(key, PersistentDataType.INTEGER)) {
            return dataContainer.get(key, PersistentDataType.INTEGER);
        }

        return 0; // or a default value
    }

    public static int getCustomCritChance(ItemStack item) {
        if (item == null || !item.hasItemMeta()) {
            return 0; // or a default value
        }

        ItemMeta meta = item.getItemMeta();

        PersistentDataContainer dataContainer = meta.getPersistentDataContainer();

        if (dataContainer.has(key3, PersistentDataType.INTEGER)) {
            return dataContainer.get(key3, PersistentDataType.INTEGER);
        }

        return 0; // or a default value
    }

    public static int getCustomCritDamage(ItemStack item) {
        if (item == null || !item.hasItemMeta()) {
            return 0; // or a default value
        }

        ItemMeta meta = item.getItemMeta();

        PersistentDataContainer dataContainer = meta.getPersistentDataContainer();

        if (dataContainer.has(key2, PersistentDataType.INTEGER)) {
            return dataContainer.get(key2, PersistentDataType.INTEGER);
        }

        return 0; // or a default value
    }
}
