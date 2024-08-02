package com.astralwarsupdated.astral_wars_1_20_6;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.scheduler.BukkitRunnable;

public class EntityHealth {
    
    public static Plugin plugin = Plugin.getInstance();


    public double setHealth(Entity player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_HEALTH")) {

                player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, getMaxHealth(player))); //no value found means that this is the players first join 
            
            return getMaxHealth(player);

    }
    public double getHealth(Entity player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_HEALTH")) {

                //player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, setMaxHealth(player))); //no value found means that this is the players first join 
            //player.sendMessage("null1");
            return 100.0;

    }
    public double setMaxHealth(Entity player, double maxHealth) {
        //if (entity != null) {
            //for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_MAX_HEALTH")) {

                //player.sendMessage(value.asString() + "");
            player.setMetadata("GENERIC_ENTITY_MAX_HEALTH", new FixedMetadataValue(plugin, maxHealth)); //no value found means that this is the players first join
            setHealthRegen(player, (maxHealth/50)); 
            return maxHealth;
                //return value.asDouble(); // or a default value

            //}
            //player.setMetadata("GENERIC_ENTITY_MAX_HEALTH", new FixedMetadataValue(plugin, maxHealth)); //no value found means that this is the players first join 
            
            //return maxHealth;

    }

    public double getMaxHealth(Entity player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_MAX_HEALTH")) {

                //player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, 100)); //no value found means that this is the players first join 
            //player.sendMessage("null2");
            if (player instanceof Player) {
                player.sendMessage("Scenario problem");
            }
            return 100.0;

            

    }

    public double setHealthRegen(Entity player, double maxRegen) {
        //if (entity != null) {
            // for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_HEALTH_REGEN")) {

            //     //player.sendMessage(value.asString() + "");
            //     return value.asDouble(); // or a default value

            // }
        player.setMetadata("GENERIC_ENTITY_HEALTH_REGEN", new FixedMetadataValue(plugin, maxRegen)); //no value found means that this is the players first join 
            
        return maxRegen;

    }

    public double getHeathRegen(Entity player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_HEALTH_REGEN")) {

                //player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, 100)); //no value found means that this is the players first join 
            //player.sendMessage("null3");
            return 0;

    }

    public double setDamageResistance(Entity player, double maxDamageResist) {
        //if (entity != null) {
            //for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_DAMAGE_RESISTANCE")) {
        player.setMetadata("GENERIC_ENTITY_DAMAGE_RESISTANCE", new FixedMetadataValue(plugin, maxDamageResist));
                //player.sendMessage(value.asString() + "");
        return maxDamageResist; // or a default value

            //}
            //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, 100)); //no value found means that this is the players first join 
            //player.sendMessage("null3");
            //return maxDamageResist;

    }

    public double getDamageResistance(Entity player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_DAMAGE_RESISTANCE")) {

                //player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, 100)); //no value found means that this is the players first join 
            //player.sendMessage("null3");
            return 0;

    }

    public void entityHpRunnable(LivingEntity player) {
        final LivingEntity players = player;
        final EntityHealth health = new EntityHealth();
        new BukkitRunnable() {
            @SuppressWarnings("deprecation")
            @Override
            public void run() {
                if ((health.getHealth(players)/health.getMaxHealth(players) <= 0)) {
                    //players.sendMessage("your ded dmubass");
                    players.setHealth(0);
                }
                else {
                    players.setHealth((health.getHealth(players)/health.getMaxHealth(players)) * players.getMaxHealth());
                }
            }
        }.runTaskLater(plugin, 10); // 100L is the delay in ticks (100 ticks = 5 seconds)
    }

}
