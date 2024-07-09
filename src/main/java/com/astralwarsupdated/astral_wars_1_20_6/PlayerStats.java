package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.text.html.parser.Entity;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;

public class PlayerStats implements Listener {
    
    private Double playerGravity;
    private Double playerCurrentHealth;
    private Double playerMaxHealth;
    private Double playerMaxAbsorption;
    private Double playerAttackDamage;
    private Double playerArmor;
    private Double playerSafeFallDistance;
    private Double playerAttackSpeed;
    private Double playerMovementSpeed;
    private Double playerMagicFind;
    private Double playerScale;
    private Double playerCritDamage;
    private Double playerCritChance;
    private Double playerStrength;

    private ItemStack stats;

    

    //public PlayerStats(ItemStack equipedWeapon) {
    public PlayerStats() {//Double playerGravity, Double playerMaxHealth, Double playerAbsorptionHealth, Double playerAttackDamage, Double playerArmor, Double playerSafeFallDistance, Double playerAttackSpeed, Double playerMovementSpeed) {

        //this.plugin = plugin;
        //Default Parameters that are immediately changed
        this.playerArmor = 0.0; 
        this.playerAttackDamage = 0.0;
        // gravity = playerGravity;
        // maxhealth = playerMaxHealth;
        // maxabsorption = playerAbsorptionHealth;
        // attackdamage = playerAttackDamage;
        // armor = playerArmor;
        // safefalldistance = playerSafeFallDistance;
        // attackspeed = playerAttackSpeed;
        // movementspeed = playerMovementSpeed;
    }

    public void updatePlayerStats(Player player) {

        //weapon.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(30);

          ItemStack itemInHand = player.getInventory().getItemInMainHand();

          playerStrength = (double) Weapons.getCustomStrength(itemInHand) + 10.0; //10 Base Strength
          playerCritChance = (double) Weapons.getCustomCritChance(itemInHand) + 10.0; //10% Base Crit Chance
          playerCritDamage = (double) Weapons.getCustomCritDamage(itemInHand) + 50.0; //50% Base Crit Damage
          

          playerCurrentHealth = player.getHealth();
          playerGravity = player.getAttribute(Attribute.GENERIC_GRAVITY).getValue();
          playerMaxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
          playerMaxAbsorption = player.getAttribute(Attribute.GENERIC_MAX_ABSORPTION).getValue();
          playerAttackDamage = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue();
          playerArmor = player.getAttribute(Attribute.GENERIC_ARMOR).getValue();  //Unique the armor the player is using
          playerSafeFallDistance = player.getAttribute(Attribute.GENERIC_SAFE_FALL_DISTANCE).getValue();
          playerAttackSpeed = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getValue(); //Unique to the weapon
          playerMovementSpeed = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue();
          playerMagicFind = player.getAttribute(Attribute.GENERIC_LUCK).getValue();
          playerScale = player.getAttribute(Attribute.GENERIC_SCALE).getValue();
          //playerStrength = player.getAttribute(Attribute.)
    }

         @EventHandler
     public void onPlayerJoin(PlayerJoinEvent event) {
         event.setJoinMessage("Bitch");

         Player player = event.getPlayer();
         
         
         player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.02); //sets the gravity of that given player
         playerGravity = player.getAttribute(Attribute.GENERIC_GRAVITY).getValue();
        
         player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40); //sets the health of that given player
         playerMaxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
         
         player.getAttribute(Attribute.GENERIC_MAX_ABSORPTION).setBaseValue(20); //sets the health of that given player
         playerMaxAbsorption = player.getAttribute(Attribute.GENERIC_MAX_ABSORPTION).getValue();

         player.getAttribute(Attribute.GENERIC_SCALE).setBaseValue(1); //Changes the entities size
         playerScale = player.getAttribute(Attribute.GENERIC_SCALE).getValue();
         
         player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(1); //sets the fist damage of that given player
         playerAttackDamage = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getValue();
         //playerAttackDamage = 20.0;
         
         player.getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(0); //sets the armor of that given player
         playerArmor = player.getAttribute(Attribute.GENERIC_ARMOR).getValue(); //Unique the armor the player is using

         player.getAttribute(Attribute.GENERIC_LUCK).setBaseValue(1); //sets the fist damage of that given player
         playerMagicFind = player.getAttribute(Attribute.GENERIC_LUCK).getValue();
         
         player.getAttribute(Attribute.GENERIC_SAFE_FALL_DISTANCE).setBaseValue(1000); //sets the gravity of that given player
         playerSafeFallDistance = player.getAttribute(Attribute.GENERIC_SAFE_FALL_DISTANCE).getValue();

         
         player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(4); //sets the gravity of that given player
         playerAttackSpeed = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).getValue(); //Unique to the weapon

         
         player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(0.1); //sets the gravity of that given player
         playerMovementSpeed = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).getValue();



         //playerCritChance = 60.0;

         //playerCritDamage = 1.5;

         //player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.01); //sets the gravity of that given player
         //player.getAttribute(Attribute.GENERIC_GRAVITY).getBaseValue();
         
         //AttributeInstance attributeInstance2 = player.getAttribute(Attribute.GENERIC_GRAVITY); //standard damage
         //AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "customPlayerGravityModifier", -.1, AttributeModifier.Operation.ADD_NUMBER);
         //attributeInstance2.addModifier(modifier2);

     }

     public void customPlayerStatsGUI(Player event) {

        Inventory inv = Bukkit.createInventory(null, 45, "Astral Wars");  //5x9

        stats = new ItemStack(Material.GRASS_BLOCK);
        ItemMeta metas = stats.getItemMeta();
        metas.setDisplayName("Stats");
        List<String> lore = new ArrayList<>();
        lore.add("§c❤ Health: " + playerMaxHealth +"\n");
        lore.add("§c❁ Damage: " + playerAttackDamage +"\n");
        lore.add("§c❁ Strength: " + playerStrength +"\n");
        lore.add("§9☣ Crit Chance: " + playerCritChance + "%" +"\n");
        lore.add("§9☠ Crit Damage: " + playerCritDamage + "%" +"\n");
        lore.add("§a❈ Armor: " + playerArmor +"\n");
        lore.add("§e⚔ Attack Speed: " + playerAttackSpeed +"\n");
        lore.add("§f✦ Movement Speed: " + (playerMovementSpeed * 1000) + "%" +"\n");
        lore.add("§b✯ Magic Find: " + playerMagicFind +"\n");
        lore.add("§5⸎ Gravity: " + (playerGravity * 5000) + "%" +"\n");
        //lore.add(playerSafeFallDistance + "");
        metas.setLore(lore);
        //metas.addEnchant(Enchantment.EFFICIENCY, 1, true);
        metas.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        metas.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        
        stats.setItemMeta(metas);

        inv.setItem(22, Weapons.blackholesword);
        inv.setItem(13, stats);

        Player player = event.getPlayer();

        player.openInventory(inv);

        player.sendMessage("GUI YAHHH");


     }

     @EventHandler
     public void onClick(InventoryClickEvent event) {

        InventoryView view = event.getView();
        if (view.getTitle().equals("Astral Wars")) {

            event.setCancelled(true);

        }
     }

     @EventHandler
     public void onPlayerInteract(PlayerInteractEvent event) {

        Player player = event.getPlayer();
        

        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();

        if ((itemInHand != null) && (itemInHand.hasItemMeta())) {
           


            if ((event.getAction().toString().contains("RIGHT_CLICK")) && (meta.getDisplayName().equals("Menu"))) { 
                
                updatePlayerStats(player);




                customPlayerStatsGUI(player);

            }
        }
     }


    @SuppressWarnings("deprecation")
    @EventHandler
    public void EntityDamageByEntityEvent(EntityDamageByEntityEvent event) {


        
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();

            updatePlayerStats(player); //Updates stats to make sure damage is accurate

            //LivingEntity entity = (LivingEntity) event.getEntity();
            //ItemStack weapon = player.getInventory().getItemInMainHand();

            player.sendMessage("Fall Distance: " + player.getFallDistance());
            // Get player's crit chance and crit damage
            //double critChance = player.getCritChance(player);
            //double critDamage = getCritDamage(player);

            // if (entity != player) {
            //     entity.setCustomName("Kevin " + entity.getHealth() + " / " + entity.getMaxHealth());
            // }
            //TEMP SHIT 

            // Determine if it's a critical hit
            Random random = new Random();
            if (random.nextDouble() * 100 < playerCritChance) {

                // Apply critical damage
                //double originalDamage = event.getDamage();
                double originalDamage = playerAttackDamage;
                double newDamage = originalDamage * ((1 + (playerCritDamage/100))) * Math.sqrt(player.getAttackCooldown()) * playerStrength; //ADD BASE STR HERE
                event.setDamage(newDamage);
                
                player.sendMessage("Critical Hit! Damage increased to " + newDamage);

            }

            else {

                // Apply critical damage
                
                double originalDamage = playerAttackDamage;
                
                double newDamage = originalDamage * Math.sqrt(player.getAttackCooldown()) * playerStrength;
                event.setDamage(newDamage);
                
                player.sendMessage("Not Critical Hit! Damage increased to " + newDamage);

            }
        }
        
        
    }   

    //add getter methods to grab stats in a different class
    public double getDefense() {
        return playerArmor;
    }

    public double getDamage() {
        return playerAttackDamage;
    }

    public double getStrength() {
        return playerStrength;
    }



























/*



             
            // Check if the player is falling (velocity in Y is negative)
            if (player.getFallDistance() <= 0.0 && player.isOnGround() || player.isInsideVehicle()) { //&& !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {

                // Determine if it's a critical hit
                Random random = new Random();
                if (random.nextDouble() * 100 < playerCritChance) {

                    // Apply critical damage
                    //double originalDamage = event.getDamage();
                    double originalDamage = playerAttackDamage;
                    double newDamage = originalDamage * playerCritDamage * Math.sqrt(player.getAttackCooldown());
                    event.setDamage(newDamage);
                    
                    player.sendMessage("Critical Hit, Not Jumping! Damage increased to " + newDamage);

                }

                else {

                    // Apply critical damage
                    
                    double originalDamage = playerAttackDamage;
                    
                    event.setDamage(originalDamage);
                    
                    player.sendMessage("Not Critical Hit, Not Jumping! Damage increased to " + originalDamage);

                }
            }

            // If the player is falling remove Minecrafts 1.5x crit damage jump crit
            else {
                //player.getItemInUse().getItemMeta().
                // Determine if it's a critical hit
                Random random = new Random();
                if (random.nextDouble() * 100 < playerCritChance) {

                    
                    //double damage = event.getDamage(EntityDamageEvent.DamageModifier.BASE); //Base Weapon Damage
                    double damage = playerAttackDamage; //Base Weapon Damage
                    //Double castedVar = event.getDamage(EntityDamageEvent.DamageModifier.BASE, damage * playerCritDamage);
                    Double newDamage2 = damage * playerCritDamage;
                    // Apply critical damage
                    //event.setDamage(EntityDamageEvent.DamageModifier.BASE,  playerCritDamage); // Reset to base damage, canceling critical hit, and multiplying by custom crit
                    event.setDamage(newDamage2);

                    // Apply critical damage

                        
                    player.sendMessage("Critical Hit, Jumping! Damage increased to " + newDamage2);

                    player.sendMessage("Jump critical hits are disabled!");
                }

                else {
                    //double damage = event.getDamage(EntityDamageEvent.DamageModifier.BASE); //Base Weapon Damage
                    double damage = playerAttackDamage; //Base Weapon Damage
                    //Double castedVar = event.getDamage(EntityDamageEvent.DamageModifier.BASE, damage * playerCritDamage);

                    // Apply critical damage
                    //event.setDamage(EntityDamageEvent.DamageModifier.BASE,  playerCritDamage); // Reset to base damage, canceling critical hit
                    event.setDamage(damage);
                        
                    player.sendMessage("Not Critical Hit, Jumping! Damage is " + damage);

                    player.sendMessage("Jump critical hits are disabled!");
                }
            }
        }

    }
*/    
}
