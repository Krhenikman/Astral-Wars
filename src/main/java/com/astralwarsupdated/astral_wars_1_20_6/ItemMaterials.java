package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemMaterials {

    public static ItemStack meteoriteOre;
    public static ItemStack compressedmeteoriteOre;
    public static ItemStack moltencore;
    public static ItemStack darkmatter;
    public static ItemStack concentrateddarkmatter;

    // Add custom metadata using the plugin instance
    public static Plugin plugin = Plugin.getInstance();

    //custom modifiers
    // public static NamespacedKey key = new NamespacedKey(plugin, "GENERIC_STRENGTH");

    // public static NamespacedKey key2 = new NamespacedKey(plugin, "GENERIC_CRIT_DAMAGE");

    // public static NamespacedKey key3 = new NamespacedKey(plugin, "GENERIC_CRIT_CHANCE");




    public static void init() {

        metoriteOre();
        compressedmetoriteOre();
        moltencore();

        darkmatter();
        concentrateddarkmatter();
    }

    private static void metoriteOre() {
        ItemStack item = new ItemStack(Material.MAGMA_BLOCK,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§aMeteorite Ore");
        List<String> lore = new ArrayList<>();
        lore.add("§7Be Careful! This rock is hot!\n");
        lore.add("");
        lore.add("§a§lUncommon Material");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        meteoriteOre = item;
    }

    private static void compressedmetoriteOre() {
        //ItemStack item = new ItemStack(Material.MAGMA_BLOCK,1);
        CustomHead head = new CustomHead();
        ItemStack item = head.getCustomTextureSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvN2IwODJhOTFjZjRkM2M2YThjNmM5YjQwNzQzZmMwNzlhY2JhYWE0YzczMDM0YTQ3Mjc0MzA4NzIyY2QxZmNiOSJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Compressed Meteorite Ore");
        List<String> lore = new ArrayList<>();
        lore.add("§7This meteorite is more like a meteor now!\n");
        lore.add("");
        lore.add("§9§lRare Material");
       
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        compressedmeteoriteOre = item;
    }

    private static void moltencore() {
        //ItemStack item = new ItemStack(Material.MAGMA_BLOCK,1);
        CustomHead head = new CustomHead();
        ItemStack item = head.getCustomTextureSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMjQ0MmExZTA4ZWE3N2ZkMTQ0YzhmZjRjZGFlZjZlMGE5YWFmYjgzZmRjZjM5OGQxNDhkOGYxNzQ0NGM4ZmE2NyJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Molten Core");
        List<String> lore = new ArrayList<>();
        lore.add("§7The heart of the molten fiend!\n");
        lore.add("");
        lore.add("§5§lGalactic Material");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        moltencore = item;
    }

    private static void darkmatter() {
        //ItemStack item = new ItemStack(Material.MAGMA_BLOCK,1);
        CustomHead head = new CustomHead();
        ItemStack item = head.getCustomTextureSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZGQzZWNlNTdmODYyZmUxNGIxZmVkY2Y4Zjc5NmNmMzE3NGU5MGNhY2ZiMDIwYTIxYjU5OWY4NDE2N2E2NjVkNyJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§9Dark Matter");
        List<String> lore = new ArrayList<>();
        lore.add("§7Quite dark and dense inside.\n");
        lore.add("");
        lore.add("§9§lRare Material");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        darkmatter = item;
    }

    private static void concentrateddarkmatter() {
        //ItemStack item = new ItemStack(Material.MAGMA_BLOCK,1);
        CustomHead head = new CustomHead();
        ItemStack item = head.getCustomTextureSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjIwMWFlMWE4YTA0ZGY1MjY1NmY1ZTQ4MTNlMWZiY2Y5Nzg3N2RiYmZiYzQyNjhkMDQzMTZkNmY5Zjc1MyJ9fX0=");
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§5Concentrated Dark Matter");
        List<String> lore = new ArrayList<>();
        lore.add("§7Carries the gravitation of the sun!\n");
        lore.add("");
        lore.add("§5§lGalactic Material");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        concentrateddarkmatter = item;
    }

}
