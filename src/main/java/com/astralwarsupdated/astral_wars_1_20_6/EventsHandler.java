package com.astralwarsupdated.astral_wars_1_20_6;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.swing.text.html.parser.Entity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.util.Vector;

import java.util.logging.Logger;



public class EventsHandler implements Listener {
    
    
    private static final long COOLDOWN_TIME2 = 1; // 1 seconds
    private static final long COOLDOWN_TIME = 10; // 10 seconds
    private final Map<UUID, Long> lastUseTimes = new HashMap<>();
    private final Map<UUID, Long> holdTasks = new HashMap<>();
    private final JavaPlugin plugin;
    
    //double angle = 0;
    
    //public static JavaPlugin plugin = new 
    //private org.bukkit.entity.Entity armorStand1;
    //private org.bukkit.entity.Entity armorStand2;
    //private org.bukkit.entity.Entity armorStand3;




    public EventsHandler(JavaPlugin plugin) {
        this.plugin = plugin;
    }

   

    @EventHandler
    public void onPlayerArmorStandManipulate(PlayerArmorStandManipulateEvent event) {
        //if (event.getRightClicked().getCustomName() != null && event.getRightClicked().getCustomName().equals("RemoveMe")) {
            // Prevent players from picking up items from this specific armor stand
            event.setCancelled(true);
        //}
    }

    @EventHandler
    public void onLeaveBed(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        
        
        player.sendMessage("§aDeath is a terrible thing");
        player.setAbsorptionAmount(1); //ONLY WORKS IF YOU ALREADY HAVE ABSORPTION
    }

    // public void solar() {
    //     Player player = event.getPlayer();
    //     Location currentLocation = player.getLocation();
    //     Location c1 = currentLocation.clone();
    //     double circleRadius = 5.0;

    //     for (double x = 0 ; x <= 2*Math.PI ; x+= Math.PI / 24) { //Angular Speed - Math.PI / 24
    //         double var1 = (Math.sin(x)*circleRadius);
    //         double var2 = (Math.cos(x)*circleRadius);
                        
    //         Vector position1 = new Vector(var1, var2, 0);

                        

    //         c1.getWorld().spawnParticle(Particle.CRIT_MAGIC, c1.add(position1), 5);

    //         if (x >= 2*Math.PI) {
    //             x = 0;

    //         }

    //     player.sendMessage("" + x);
    //     }
    // }
    
     @EventHandler
     public void onPlayerJoin(PlayerJoinEvent event) {
         event.setJoinMessage("Welcome, " + event.getPlayer().getName() + "!");

         Player player = event.getPlayer();
         //player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.01); //sets the gravity of that given player

         
         //AttributeInstance attributeInstance2 = player.getAttribute(Attribute.GENERIC_GRAVITY); //standard damage
         //AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(), "customPlayerGravityModifier", -.1, AttributeModifier.Operation.ADD_NUMBER);
         //attributeInstance2.addModifier(modifier2);

     }

    //  @EventHandler
    //  public void PlayerMoveEvent(Player player) {

    //     for (org.bukkit.entity.Entity entity : player.getLocation().getWorld().getEntities()) {
            
    //         if (entity instanceof LivingEntity) {
    //             LivingEntity livingEntity = (LivingEntity) entity;
    //             if ("RemoveMe".equals(livingEntity.getCustomName())) {
                        
                    

    //             }
    //         }
    //     }

    //  }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        // Check if the player right-clicked
        
        Player player = event.getPlayer();
        
        ItemStack itemInHand = player.getInventory().getItemInMainHand();
        ItemMeta meta = itemInHand.getItemMeta();
        
        player.sendMessage("You are doing something cool!");
        

        if ((itemInHand != null) && (itemInHand.hasItemMeta())) {
           


            if ((event.getAction().toString().contains("RIGHT_CLICK")) && (meta.getDisplayName().equals("Rocket Thruster"))) { 
                //key = uuid of the player
                //long =    the epoch time of when they ran the command
                //private final HashMap<UUID, Long> cooldown = new HashMap<>();
                //this.cooldown = new HashMap<>();
                //if (!this.cooldown.containsKey(player.getUniqueId())) {
                //   this.cooldown.put(player.getUniqueId(), System.currentTimeMillis());
             


                UUID playerId = player.getUniqueId();
       
                long now = System.currentTimeMillis();


                //returns the value of the hashmap that this player id is mapped to
                long lastUse = lastUseTimes.getOrDefault(playerId, 0L);
       
                if (now - lastUse < TimeUnit.SECONDS.toMillis(COOLDOWN_TIME)) {
                    // Cooldown hasn't elapsed
                    long timeLeft = COOLDOWN_TIME - TimeUnit.MILLISECONDS.toSeconds(now - lastUse);
                    player.sendMessage("You must wait " + timeLeft + " seconds before interacting again.");
                    event.setCancelled(true); // Cancel the event to prevent interaction
                    return;
                }
               
                    // Cooldown has elapsed, update the last use time
                    lastUseTimes.put(playerId, now);
           
                    player.sendMessage("You are holding a Feather!");
                    Vector velocity = player.getLocation().getDirection().multiply(2); // Increase the multiplier for faster velocity
                    player.setVelocity(velocity);
            }


            if ((event.getAction().toString().contains("RIGHT_CLICK")) && (meta.getDisplayName().equals("Pulsar Cannon"))) { 
                //Location playerLocation = player.getLocation();
               
                Location origin = player.getEyeLocation();
                Location currentLocation = origin.clone();




                for (int travelDistance = 1; travelDistance < 10; travelDistance++) {    //roughly 13 blocks




                    double damageRadius = 2.0;
                    double damageAmount = 5.0; // Amount of damage to apply
                    //Vector direction;


                    currentLocation.add(currentLocation.getDirection().multiply(1));


                    currentLocation.getWorld().spawnParticle(Particle.SOUL_FIRE_FLAME, currentLocation, 5); // 10 flame particles
                   
                   




                    for (org.bukkit.entity.Entity entity : currentLocation.getWorld().getNearbyEntities(currentLocation, damageRadius, damageRadius, damageRadius)) {
                        if (player != entity) { // Don't hurt the user of the weapon
                            //entity.setLastDamageCause(null); // Reset any other damage causes
                            ((Damageable) entity).damage(damageAmount, entity); // Apply damage
                       
                   


                           
                        }
                    }    //runTaskTimer(this, 0L, 1L); // 1-tick interval for smooth particle effect
                }
            }

            if ((event.getAction().toString().contains("RIGHT_CLICK")) && (meta.getDisplayName().equals("§5Black Hole Sword"))) { 

                Location origin = player.getEyeLocation();
                Location currentLocation = origin.clone();

                for (org.bukkit.entity.Entity entity : currentLocation.getWorld().getNearbyEntities(currentLocation, 30, 30, 30)) {
                    if ((player != entity) && (!entity.isDead()) && (entity instanceof LivingEntity)) { // Don't TP to self && Don't TP to unalive entities

                        // Teleport the player
                        player.teleport(entity.getLocation());
                        
                        if (entity instanceof Player) {

                        String victim = entity.getName(); 
                        Player victimID = Bukkit.getPlayer(victim);
                        
                        PotionEffect blindnessEffect = new PotionEffect(PotionEffectType.DARKNESS, 80, 0);
                        victimID.addPotionEffect(blindnessEffect);

                        }

                        PotionEffect absorptionEffect = new PotionEffect(PotionEffectType.ABSORPTION, 150, 1);


                        player.addPotionEffect(absorptionEffect);

                    }
                }
            }

            
                


            

            if ((event.getAction().toString().contains("RIGHT_CLICK")) && (meta.getDisplayName().equals("Minor Gravity Field"))) {

                GravityField gravityField = new GravityField(plugin);
                //planetRunnable(player);
                gravityField.gravityfieldRunnable(player);
            }

            //     Location field = player.getLocation();
            //     for (org.bukkit.entity.Entity entity : field.getWorld().getNearbyEntities(field, 3, 3, 3)) {


                    

            //     //player.setGravity(false);
            //     if (!player.isFlying() && !player.isOnGround()) {
            //         // Get the player's current velocity
            //         Vector velocity = player.getVelocity();
                    
            //         // Modify the y-component to simulate custom gravity
            //         velocity.setY(velocity.getY() + gravityModifier);
                    
            //         // Set the player's new velocity
            //         player.setVelocity(velocity);
            //     }



            //     PotionEffect slowfallEffect = new PotionEffect(PotionEffectType.SLOW_FALLING, 150, 1); //vectors

            // }







            
            // if ((event.getAction().toString().contains("RIGHT")) && (meta.getDisplayName().equals("Orbital Planet Strike"))) {
               
               
                
            //         Vector playerFacing = player.getLocation().getDirection();
            //         Location currentLocation = player.getLocation();
            //         Location c1 = currentLocation.clone();
            //         double circleRadius = 10.0;


            //         for (double angle = 0 ; angle <= 2*Math.PI ; angle+= Math.PI / 24) { //Angular Speed - Math.PI / 24
            //             //double var1 = (Math.cos(x)*5);
            //             //double var2 = (Math.sin(x)*5);

            //             double x = c1.getX() + (circleRadius * Math.cos(angle));
            //             double z = c1.getZ() + (circleRadius * Math.sin(angle));
                        
                       
            //             if (angle >= 2*Math.PI) {
            //                 angle = 0;


            //             }


            //             player.sendMessage("hey" + angle);


            //             //Vector position1 = new Vector(x, 0, z);
            //             Location particleLocation = new Location(c1.getWorld(), x, c1.getY(), z);

            //            //rotateAroundAxis()

            //             c1.getWorld().spawnParticle(Particle.HEART, particleLocation, 1);








            //             //straight attack
            //             // double var3 = (Math.tan(x)) *5;
            //             // c1.getWorld().spawnParticle(Particle.HEART, c1.add(c1.getDirection().multiply(var3)), 5);


            //             // if (x >= 2*Math.PI) {
            //             //     x = 0;


            //             // }


            //             // player.sendMessage("" + x);

            //         }

                    if ((event.getAction().toString().contains("RIGHT")) && (meta.getDisplayName().equals("Orbital Planet Strike"))) {
               
                        OrbitalPlanetStrike orbit = new OrbitalPlanetStrike(plugin);
                        //planetRunnable(player);
                        orbit.planetRunnable(player);

    
    
    
    
    
    
    
    
                            //straight attack
                            // double var3 = (Math.tan(x)) *5;
                            // c1.getWorld().spawnParticle(Particle.HEART, c1.add(c1.getDirection().multiply(var3)), 5);
    
    
                            // if (x >= 2*Math.PI) {
                            //     x = 0;
    
    
                            // }
    
    
                            // player.sendMessage("" + x);
    
                    

            }






                   
                    //MyBukkitTasks task = new MyBukkitTasks(player);
                    //task.runTaskTimerAsynchronously(plugin, 0, 20);














                        // final Player player2 = event.getPlayer();


                        // new BukkitRunnable() {
                        //     //PlayerInteractEvent event2 = event;
                        //     //final PlayerInteractEvent event = event.clone();
                        //     @Override
                        //     public void run() {
                        //         solar(player);


                        //     }
                        // }.runTaskTimer(plugin, 0, 20);
                   


                       
                       




                   




                        // player.sendMessage("Hey you");


                   
               


            //}


        }
    }



    // public void planetsMove() {
    //     new BukkitRunnable() {
    //         @Override
    //         public void run() {
    //             for (Player player : Bukkit.getOnlinePlayers()) {
    //                 //sendActionBar(player, getStatsMessage(player));
    //             }
    //         }
    //     }.runTaskTimer(Plugin, 0, 20); // Update every second (20 ticks)
    // }

    // @SuppressWarnings("deprecation") //!player.isOnGround()
    // public void PlayerMoveEvent(Player event) {
        
    //     Player player = event.getPlayer();
    //     if (!player.isFlying() && !player.isOnGround()) {

    //         AttributeInstance attributeInstance3 = player.getAttribute(Attribute.GENERIC_GRAVITY); //standard damage
    //         AttributeModifier modifier3 = new AttributeModifier(UUID.randomUUID(), "customGravityModifier", 100, AttributeModifier.Operation.ADD_NUMBER);
    //         attributeInstance3.addModifier(modifier3);
    //         attributeInstance3.getDefaultValue()
    //     }

    //     else {

    //         player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(1);

    //     }
    // }

    
}
