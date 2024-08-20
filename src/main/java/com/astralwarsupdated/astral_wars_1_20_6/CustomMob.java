package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

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
    private double knockbackResistance;

    public static Plugin plugin = Plugin.getInstance();
    //public static NamespacedKey key4 = new NamespacedKey(plugin, "GENERIC_NAME");



    public CustomMob() {

    }

    public CustomMob(Player playerSent,Location loc, EntityType mobType, String mobName, ItemStack helm, ItemStack chest, ItemStack leg, ItemStack shoes, double mobHealth, double mobAttackDamage, double mobScale, double mobMovementSpeed, double mobAttackSpeed, double knockBackRes) {

        player = playerSent;
        location = loc;
        mob = mobType;
        name = mobName;
        health = mobHealth;
        attackDamage = mobAttackDamage;
        scale = mobScale;
        movementSpeed = mobMovementSpeed;
        attackSpeed = mobAttackSpeed;
        knockbackResistance = knockBackRes;
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
            healthval.setDamageResistance(customEntity, 100);
            //healthval.setHealthRegen(customEntity, (health / 50.0));
            setAttribute(customEntity, Attribute.GENERIC_ATTACK_DAMAGE, attackDamage); //standard damage
            setAttribute(customEntity, Attribute.GENERIC_ATTACK_SPEED, attackSpeed); //standard damage
            setAttribute(customEntity, Attribute.GENERIC_SCALE, scale); //standard damage
            setAttribute(customEntity, Attribute.GENERIC_MOVEMENT_SPEED, movementSpeed); //standard damage
            setAttribute(customEntity, Attribute.GENERIC_SAFE_FALL_DISTANCE, 1000);
            setAttribute(customEntity, Attribute.GENERIC_KNOCKBACK_RESISTANCE, knockbackResistance);
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

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (getName(event.getEntity()).equals("Molten Fiend")) { // Specify the entity type
            Random random = new Random();

            // Clear the default drops
            event.getDrops().clear();

            // Add custom loot
            if (random.nextDouble() <= 0.5) { // 50% chance to drop an Molten Core
                event.getDrops().add(ItemMaterials.moltencore);
            }

            // Add more items with different probabilities as needed
        }
    }

    public Location getLocation() {
        return location;
    }
    // public boolean isEntityAlive(LivingEntity entity) {
    //     for (Entity entity : world.getEntities()) {
    //         if (entity.isDead() == true) {
    //             return entity.isDead();
    //         }
    //     }
    // }


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
