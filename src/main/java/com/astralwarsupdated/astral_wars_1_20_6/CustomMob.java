package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class CustomMob implements Listener{
    
    private Player player;
    private Location location;
    private EntityType mob;
    private String name;
    //private double health;
    private ItemStack helmet;
    private ItemStack chestplate;
    private ItemStack leggings;
    private ItemStack boots;
    private double health;
    private double attackDamage;
    private double scale;
    private double movementSpeed;
    private double attackSpeed;
    

    public static Plugin plugin = Plugin.getInstance();
    //public static NamespacedKey key4 = new NamespacedKey(plugin, "GENERIC_NAME");



    public CustomMob() {

    }

    public CustomMob(Player playerSent,Location loc, EntityType mobType, String mobName, ItemStack helm, ItemStack chest, ItemStack leg, ItemStack shoes, double mobHealth, double mobAttackDamage, double mobScale, double mobMovementSpeed, double mobAttackSpeed) {

        player = playerSent;
        location = loc;
        mob = mobType;
        name = mobName;
        health = mobHealth;
        attackDamage = mobAttackDamage;
        scale = mobScale;
        movementSpeed = mobMovementSpeed;
        attackSpeed = mobAttackSpeed;
        helmet = helm;
        chestplate = chest;
        leggings = leg;
        boots = shoes;


    }

    @SuppressWarnings("deprecation")
    public void createCustomMob() {
            
            LivingEntity customEntity = (LivingEntity) player.getWorld().spawnEntity(location, mob);
            // Customize the zombie
            
            //customEntity.setHealth(health); // Double the health
            //Entity meta = zombie.getMetadata();
            //PersistentDataContainer dataContainer = meta.getPersistentDataContainer();
                // Set custom metadata

            customEntity.setMetadata("GENERIC_NAME", new FixedMetadataValue(plugin, name));
            //setAttribute(customEntity, Attribute.GENERIC_MAX_HEALTH, health);
            //customEntity.setHealth(health);
            EntityHealth healthval = new EntityHealth();
            
            healthval.setMaxHealth(customEntity, health);
            healthval.setHealth(customEntity);
            //healthval.setHealthRegen(customEntity, (health / 50.0));
            setAttribute(customEntity, Attribute.GENERIC_ATTACK_DAMAGE, attackDamage); //standard damage
            setAttribute(customEntity, Attribute.GENERIC_ATTACK_SPEED, attackSpeed); //standard damage
            setAttribute(customEntity, Attribute.GENERIC_SCALE, scale); //standard damage
            setAttribute(customEntity, Attribute.GENERIC_MOVEMENT_SPEED, movementSpeed); //standard damage
            //setAttribute(customEntity, Attribute.GENERIC_ATTACK_DAMAGE, attackDamage); //standard damage
            //AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "customDamageModifier", 100, AttributeModifier.Operation.ADD_NUMBER);
            //attributeInstance.addModifier(modifier);
            customEntity.setCustomName("§3" + name + " §c❤ " + String.format("%.2f", healthval.getHealth(customEntity)) + " / " + String.format("%.2f",  healthval.getMaxHealth(customEntity)));
            customEntity.setCustomNameVisible(true);
            //zombie.setLootTable
            // Set the armor
            customEntity.getEquipment().setHelmet(helmet);
            customEntity.getEquipment().setChestplate(chestplate);
            customEntity.getEquipment().setLeggings(leggings);
            customEntity.getEquipment().setBoots(boots);
            //return customEntity;
    }
    
    public void setAttribute(LivingEntity entity, Attribute attribute, double value) {
        AttributeInstance attributeInstance = entity.getAttribute(attribute);
        if (attributeInstance != null) {
            attributeInstance.setBaseValue(value);
        }
    }

    public String getName(Entity entity) {
        //if (entity != null) {
            for (MetadataValue value : entity.getMetadata("GENERIC_NAME")) {

                //player.sendMessage(value.asString() + "");
                return value.asString(); // or a default value

            }
        //}
            return "";

        // ItemMeta meta = item.getItemMeta();

        // PersistentDataContainer dataContainer = meta.getPersistentDataContainer();

        // if (dataContainer.has(key4, PersistentDataType.STRING)) {
        //     return dataContainer.get(key4, PersistentDataType.STRING);
        // }

        // return ""; // or a default value
    }


    // @SuppressWarnings("deprecation")
    // @EventHandler
    // public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event) {


        
    //     if (event.getDamager() instanceof Player) {
    //         Player player = (Player) event.getDamager();

            

    //         LivingEntity entity = (LivingEntity) event.getEntity();
    //         //ItemStack weapon = player.getInventory().getItemInMainHand();



    //         //if (entity != player && getName(entity).toString() != null) {
    //             entity.setCustomName("§3" + getName(entity, player) + " §c❤ " + String.format("%.2f", entity.getHealth()) + " / " + String.format("%.2f", entity.getMaxHealth()));
    //         //}
    //     }
    // }

    // public AttributeInstance getAttribute(Attribute genericGravity) {
    //     // TODO Auto-generated method stub
    //     throw new UnsupportedOperationException("Unimplemented method 'getAttribute'");
    // }
    
}
