package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemMaterials {

    public static ItemStack meteoriteOre;


    // Add custom metadata using the plugin instance
    public static Plugin plugin = Plugin.getInstance();

    //custom modifiers
    // public static NamespacedKey key = new NamespacedKey(plugin, "GENERIC_STRENGTH");

    // public static NamespacedKey key2 = new NamespacedKey(plugin, "GENERIC_CRIT_DAMAGE");

    // public static NamespacedKey key3 = new NamespacedKey(plugin, "GENERIC_CRIT_CHANCE");




    public static void init() {

        metoriteOre();

    }

    private static void metoriteOre() {
        ItemStack item = new ItemStack(Material.MAGMA_BLOCK,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§2Meteorite Ore");
        List<String> lore = new ArrayList<>();
        lore.add("§7Be Careful! This rock is hot!\n");
        //lore.add("§c5 Second Cooldown");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.INFINITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        item.setItemMeta(meta);
        meteoriteOre = item;
    }

}
