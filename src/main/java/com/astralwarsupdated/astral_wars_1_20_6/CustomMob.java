package com.astralwarsupdated.astral_wars_1_20_6;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.inventory.ItemStack;

public class CustomMob {
    
    private Player player;
    //private String mob;
    private String name;
    private double health;
    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;




    public CustomMob(Player playerSent, String mobName, double mobHealth, ItemStack helm, ItemStack chest, ItemStack leg, ItemStack shoes) {

        player = playerSent;
        //mob = mobType;
        name = mobName;
        health = mobHealth;
        helmet = helm;
        chestplate = chest;
        leggings = leg;
        boots = shoes;


    }

    public void createCustomZombie() {
            
            Zombie zombie = (Zombie) player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
            // Customize the zombie
            zombie.setCustomName(name);
            zombie.setCustomNameVisible(true);
            zombie.setHealth(health); // Double the health
            
            //zombie.setLootTable
            // Set the armor
            // zombie.getEquipment().setHelmet(helmet);
            // zombie.getEquipment().setHelmet(chestplate);
            // zombie.getEquipment().setHelmet(leggings);
            // zombie.getEquipment().setHelmet(boots);
    }



}
