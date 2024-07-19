package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;



import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
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
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerStats implements Listener {
    
    private Double playerGravity;
    //private Double playerCurrentHealth;
    private Double playerMaxHealth;
    private Double playerHealth;
    private Double playerHealthRegen;
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

    public static Plugin plugin = Plugin.getInstance();

   


    //public PlayerStats(ItemStack equipedWeapon) {
    public PlayerStats() {//Double playerGravity, Double playerMaxHealth, Double playerAbsorptionHealth, Double playerAttackDamage, Double playerArmor, Double playerSafeFallDistance, Double playerAttackSpeed, Double playerMovementSpeed) {

        //this.plugin = plugin;
        //Default Parameters that are immediately changed
        this.playerArmor = 0.0; 
        this.playerAttackDamage = 0.0;
        this.playerGravity = 0.0;
        this.playerHealth = 100.0;
        this.playerMaxHealth = 100.0;
        this.playerHealthRegen = 2.0;

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
          
          //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, 100));
          //player.setMetadata("GENERIC_ENTITY_MAX_HEALTH", new FixedMetadataValue(plugin, 100));
          //player.setMetadata("GENERIC_ENTITY_HEALTH_REGEN", new FixedMetadataValue(plugin, 2));
          
          //playerCurrentHealth = player.getHealth();
          //playerMaxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();

          playerGravity = player.getAttribute(Attribute.GENERIC_GRAVITY).getValue();
          
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
         event.setJoinMessage("Coolio");

         Player player = event.getPlayer();
         
         playerHealth = setHealth(player);
         playerMaxHealth = setMaxHealth(player);
         playerHealthRegen = setHealthRegen(player);
         
         player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.02); //sets the gravity of that given player
         playerGravity = player.getAttribute(Attribute.GENERIC_GRAVITY).getValue();
        
        //  player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(40); //sets the health of that given player
        //  playerMaxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue();
         
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
    public double setHealth(Player player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_HEALTH")) {

                player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, 100.0)); //no value found means that this is the players first join 
            
            return 100.0;

    }
    public double getHealth(Player player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_HEALTH")) {

                //player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, setMaxHealth(player))); //no value found means that this is the players first join 
            //player.sendMessage("null1");
            return 100.0;

    }
    public double setMaxHealth(Player player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_MAX_HEALTH")) {

                //player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            player.setMetadata("GENERIC_ENTITY_MAX_HEALTH", new FixedMetadataValue(plugin, 100.0)); //no value found means that this is the players first join 
            
            return 100.0;

    }

    public double getMaxHealth(Player player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_MAX_HEALTH")) {

                //player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, 100)); //no value found means that this is the players first join 
            //player.sendMessage("null2");
            return playerMaxHealth;

    }

    public double setHealthRegen(Player player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_HEALTH_REGEN")) {

                //player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            player.setMetadata("GENERIC_ENTITY_HEALTH_REGEN", new FixedMetadataValue(plugin, 2)); //no value found means that this is the players first join 
            
            return 2;

    }

    public double getHeathRegen(Player player) {
        //if (entity != null) {
            for (MetadataValue value : player.getMetadata("GENERIC_ENTITY_HEALTH_REGEN")) {

                player.sendMessage(value.asString() + "");
                return value.asDouble(); // or a default value

            }
            //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, 100)); //no value found means that this is the players first join 
            //player.sendMessage("null3");
            return 0;

    }

    public void startRegenTask() {
        new BukkitRunnable() {
            @SuppressWarnings("deprecation")
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (!(player.isDead())) {
                        if ((getHealth(player)/getMaxHealth(player) <= 0)) { //player dead
                            player.sendMessage("Muerte");
                            player.setHealth(0);
                        }

                        else if(getHealth(player) + getHeathRegen(player) >= getMaxHealth(player)) { //player no longer needs regen
                            player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getMaxHealth(player))));
                            player.setHealth((getHealth(player)/getMaxHealth(player)) * player.getMaxHealth());
                        }

                        else {//(getHealth(player) < getMaxHealth(player)) {
                            if ((getHealth(player) + getHeathRegen(player)) <= getMaxHealth(player)) {
                                player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getHealth(player) + getHeathRegen(player))));
                            }
                            // else {
                            //     player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getMaxHealth(player)  + getHeathRegen(player))));
                            // }
                            player.setHealth((getHealth(player)/getMaxHealth(player)) * player.getMaxHealth());
                            player.sendMessage(getHealth(player) + " / " + getMaxHealth(player) + " * " + player.getMaxHealth());
                        }
                    }

                    //if none is true then players health equals max health

                    // final Player players = player;
                    // new BukkitRunnable() {
                    //     @Override
                    //     public void run() {
                    //         players.sendMessage("Runnable prob");
                            
    
                        //}
                    //}.runTaskLater(plugin, 1); // 100L is the delay in ticks (100 ticks = 5 seconds)
                }
            }
        }.runTaskTimer(plugin, 20, 40); // Update every second (20 ticks)
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


        if (event.getDamager() instanceof Player) { //player attacker
            
                Player player = (Player) event.getDamager();
                //Player entity = (Player) event.getEntity();
                updatePlayerStats(player); //Updates stats to make sure damage is accurate

                Random random = new Random();
                if (random.nextDouble() * 100 <= playerCritChance) {

                    // Apply critical damage
                    
                    double originalDamage = playerAttackDamage;
                    double newDamage = originalDamage * ((1 + (playerCritDamage/100))) * Math.sqrt(player.getAttackCooldown()) * playerStrength; //ADD BASE STR HERE
                    
                    if (event.getEntity() instanceof Player) { //player defender

                        event.setDamage(0);
                        Player entity = (Player) event.getEntity();
                        playerHpRunnable(entity);
                        entity.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getHealth(entity) - newDamage)));
                        
                    }
                    else { //Entity defender
                        event.setDamage(newDamage);
                    }
                    //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getHealth(player) - newDamage)));
                    
                    player.sendMessage("Critical Hit! Damage increased to " + newDamage);

                    // final Player players = player;
                    // new BukkitRunnable() {
                    //     @Override
                    //     public void run() {

                    //         players.setHealth(playerHealth/playerMaxHealth);

                    //     }
                    // }.runTaskLater(plugin, 1); // 100L is the delay in ticks (100 ticks = 5 seconds)
                    
                }

                else {

                    // Do not apply critical damage
                    
                    double originalDamage = playerAttackDamage;
                    double newDamage = originalDamage * Math.sqrt(player.getAttackCooldown()) * playerStrength; //ADD BASE STR HERE
                    
                    if (event.getEntity() instanceof Player) { //player defender
                        event.setDamage(0);
                        Player entity = (Player) event.getEntity();
                        player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getHealth(player) - newDamage)));
                        playerHpRunnable(entity);
                    }
                    else { //Entity defender
                        event.setDamage(newDamage);
                    }
                    //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getHealth(player) - newDamage)));
                    
                    player.sendMessage("Not Critical Hit! Damage increased to " + newDamage);
                    //if (event.getEntity() instanceof Player) { //player defender
                    

                    

                    // //player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getHealth(player) - newDamage)));
                    // player.sendMessage("Not Critical Hit! Damage increased to " + newDamage);

                    // final Player players = player;
                    // new BukkitRunnable() {
                    //     @Override
                    //     public void run() {

                    //         players.setHealth(playerHealth/playerMaxHealth);

                    //     }
                    // }.runTaskLater(plugin, 1); // 100L is the delay in ticks (100 ticks = 5 seconds)
                }
        }
    
        else { //Entity Attacker on player
            double newDamage = event.getDamage();
            
            if (event.getEntity() instanceof Player) { //player defender
                event.setDamage(0);
                Player entity = (Player) event.getEntity();
                playerHpRunnable(entity);
                entity.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getHealth(entity) - newDamage)));
                
            }
            else {
                event.setDamage(newDamage); //entity defender
            }
              
            // Player entity = (Player) event.getEntity();
            // entity.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (getHealth(entity) - event.getDamage())));
            
            // playerHpRunnable(entity);

            
        }


            if (event.getEntity() instanceof LivingEntity) {
                //Player player = (Player) event.getDamager();
                final LivingEntity entity = (LivingEntity) event.getEntity();
                final Player players = (Player) event.getDamager();
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            
                            //ItemStack weapon = player.getInventory().getItemInMainHand();
                
                            CustomMob mob = new CustomMob();
                
                            //if (entity != player && getName(entity).toString() != null) {
                                entity.setCustomName("§3" + mob.getName(entity, players) + " §c❤ " + String.format("%.2f", entity.getHealth()) + " / " + String.format("%.2f", entity.getMaxHealth()));
                        }
                    }.runTaskLater(plugin, 5); // Update every second (20 ticks)
                }
            }
        
    

                //}
            //}
    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {
        Player player = event.getPlayer();
        player.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, getMaxHealth(player)));
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

    public double getGravity() {
        return playerGravity;
    }

    public void setGravity(Player player, Double multiplier) {
        player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.02 * multiplier); //sets the gravity of that given player
    }

    public void playerHpRunnable(Player player) {
        final Player players = player;
        new BukkitRunnable() {
            @SuppressWarnings("deprecation")
            @Override
            public void run() {
                if ((getHealth(players)/getMaxHealth(players) <= 0)) {
                    //players.sendMessage("your ded dmubass");
                    players.setHealth(0);
                }
                else {
                    players.setHealth((getHealth(players)/getMaxHealth(players)) * players.getMaxHealth());
                }
            }
        }.runTaskLater(plugin, 10); // 100L is the delay in ticks (100 ticks = 5 seconds)
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
