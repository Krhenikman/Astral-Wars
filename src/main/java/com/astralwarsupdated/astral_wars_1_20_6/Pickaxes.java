package com.astralwarsupdated.astral_wars_1_20_6;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Pickaxes {
    public static ItemStack rustycopperdrill;
    public static ItemStack copperdrill;
    public static ItemStack steeldrill;
    public static ItemStack colbaltdrill;
    //public static ItemStack adamanitumdrill;
    //public static ItemStack mythrildrill;
    //public static ItemStack titaniumdrill;
    public static ItemStack celestialdrill;
    //public static ItemStack ;

    public static void init() {
        createRustyCopperDrill();
        createCopperDrill();
        createSteelDrill();
        createColbaltdrill();
        createCelestialDrill();
    }

    private static void createRustyCopperDrill() {
        ItemStack item = new ItemStack(Material.WOODEN_PICKAXE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Rusty Copper Drill");
        List<String> lore = new ArrayList<>();
        lore.add("§fIts a bit of a fixer upper, but its a start!\n");
        //lore.add("§c5 Second Cooldown");
        meta.setLore(lore);
        //meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        rustycopperdrill = item;
    }

    private static void createCopperDrill() {
        ItemStack item = new ItemStack(Material.WOODEN_PICKAXE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Copper Drill");
        List<String> lore = new ArrayList<>();
        lore.add("§fNow were getting somewhere!\n");
        //lore.add("§c5 Second Cooldown");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.EFFICIENCY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        copperdrill = item;
    }

    private static void createSteelDrill() {
        ItemStack item = new ItemStack(Material.STONE_PICKAXE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Steel Drill");
        List<String> lore = new ArrayList<>();
        lore.add("§fNice Pickaxe!\n");
        //lore.add("§c5 Second Cooldown");
        meta.setLore(lore);
        //meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        steeldrill = item;
    }

    private static void createColbaltdrill() {
        ItemStack item = new ItemStack(Material.IRON_PICKAXE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Colbalt Drill");
        List<String> lore = new ArrayList<>();
        lore.add("§fAlmost there!\n");
        //lore.add("§c5 Second Cooldown");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.EFFICIENCY, 3, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        colbaltdrill = item;
    }

    private static void createCelestialDrill() {
        ItemStack item = new ItemStack(Material.NETHERITE_PICKAXE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Celestial Drill");
        List<String> lore = new ArrayList<>();
        lore.add("§fBest Pick!\n");
        //lore.add("§c5 Second Cooldown");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.EFFICIENCY, 5, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        celestialdrill = item;
    }





}

