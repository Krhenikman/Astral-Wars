package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.swing.text.html.parser.Entity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;

public class GravityField implements Listener{
    


    
    private final JavaPlugin plugin;
    
    float yaw = 0;
    float height = 0;
    boolean maxHeight = false;
    private boolean playerGravityHalfed = false;
    private boolean playerOutsidething = false;
    private Map<UUID, Boolean> gravityfield = new HashMap<>();
    private ArmorStand armorStand;

    private ArmorStand armorStand1;



    
    //private ArmorStand[] armorObjects = new ArmorStand[3];

    // Object[] stuff;

    // private Location[] locValues = new Location[3];
    // private double x;
    // private double z;
    
    // private double x2;
    // private double z2;

    // private double x3;
    // private double z3;
    //private ArmorStand armorStand0;

    
    //public static JavaPlugin plugin = new 
    //private org.bukkit.entity.Entity armorStand1;
    //private org.bukkit.entity.Entity armorStand2;
    //private org.bukkit.entity.Entity armorStand3;




    public GravityField(JavaPlugin plugin) {
        this.plugin = plugin;
        
    }

    @SuppressWarnings("deprecation")
    private ArmorStand armorStandHandler(Player player) {
        //double circleRadius = 5.0;
        Location c1 = player.getLocation();

        //Location rotatingAmethyst = new Location(c1.getWorld(), c1.getX(), c1.getY() + , c1.getZ());

        // double x = c1.getX() + (circleRadius * Math.cos(0));
        // double z = c1.getZ() + (circleRadius * Math.sin(0));
        
        // double x2 = c1.getX() + (circleRadius * Math.cos((Math.PI/1.5)));
        // double z2 = c1.getZ() + (circleRadius * Math.sin((Math.PI/1.5)));

        // double x3 = c1.getX() + (circleRadius * Math.cos((Math.PI/.75)));
        // double z3 = c1.getZ() + (circleRadius * Math.sin((Math.PI/.75)));

        // Location particleLocation = new Location(c1.getWorld(), x, c1.getY(), z);

        // Location particleLocation2 = new Location(c1.getWorld(), x2, c1.getY(), z2);

        // Location particleLocation3 = new Location(c1.getWorld(), x3, c1.getY(), z3);

        armorStand = (ArmorStand) c1.getWorld().spawnEntity(c1, EntityType.ARMOR_STAND);
        armorStand.setCustomName("RemoveMe");
        armorStand.setCustomNameVisible(false);
        armorStand.setVisible(false);
        armorStand.setBasePlate(false);
        armorStand.setArms(true);
        armorStand.setGravity(false);
        //armorStand.setItemInHand(new ItemStack(Material.OCHRE_FROGLIGHT));
        //armorStand.setHeadPose((new EulerAngle(90, 90, 90)));
        armorStand.setHelmet(new ItemStack(Material.AMETHYST_BLOCK));

        return armorStand;
    }
    
    @SuppressWarnings({ "deprecation", "unlikely-arg-type" })
    public void circleGravityBuff(Player player, ArmorStand a1, Location c1, PlayerStats pStats) {




        for (Player defaultPlayer : Bukkit.getOnlinePlayers()) {
            //UUID modifierUUID = UUID.randomUUID(); // Unique UUID for the modifier        
            UUID playerId = defaultPlayer.getUniqueId();
            //gravityfield.put(playerId, false); //Needs to reset to false to check again if still in the gravity field 
            gravityfield.getOrDefault(playerId, false);
            //player.sendMessage("first");

        }
        for (Player players : Bukkit.getOnlinePlayers()) {
        //for (org.bukkit.entity.Entity entity : c1.getWorld().getNearbyEntities(c1, 4, 25, 4)) {
            //Location particleLocation = new Location(c1.getWorld(), c1.getX(), c1.getY() -1, c1.getZ());

            c1.setYaw(yaw);
            armorStand.teleport(c1);
            //if (entity == player) { //meaning player is in the gravity field

                
                for (org.bukkit.entity.Entity entity : c1.getWorld().getNearbyEntities(c1, 4, 25, 4)) {
                    //boolean playerFound = false;
                    if (entity.getUniqueId() == players.getUniqueId() && gravityfield.getOrDefault(players.getUniqueId(), false) == false) { //if any entity is one of the players set there value to true
                        players.sendMessage("adding attribute");
                        gravityfield.put(players.getUniqueId(), true); //player is in the circle
                        AttributeInstance attribute = players.getAttribute(Attribute.GENERIC_GRAVITY);
                        UUID playersUuid = players.getUniqueId();
                        AttributeModifier modifier = new AttributeModifier(playersUuid, "Gravity_Field_Modifier", -0.50, AttributeModifier.Operation.ADD_SCALAR);
                        
                        attribute.addModifier(modifier);
                        //break;
                        
                    }    
                        
                }
                

                        
                    //     ////players.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.01);
                    //     players.sendMessage("In gravity field");
                    //     player.sendMessage("inside yes");
                    // }
                    // player.sendMessage("inside no");
                
            //}
        }

        
        for (Player players : Bukkit.getOnlinePlayers()) {
            //double distance = players.getLocation().distance(c1);
            double distanceX = Math.abs(players.getLocation().getX() - (c1.getX()));
            double distanceZ = Math.abs(players.getLocation().getZ() - (c1.getZ()));
            //double distance = Math.pow(Math.sqrt(distanceX) + Math.sqrt(distanceZ), 2);
            if (distanceX > 4 || distanceZ > 4) {
                //remove attributes
                gravityfield.put(players.getUniqueId(), false);
            

            // if (gravityfield.getOrDefault(players.getUniqueId(), false) == true) {
            //     player.sendMessage("mhmmm");
            // }
                ////players.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.02);
                UUID playersUuid = players.getUniqueId();
                AttributeInstance attribute = players.getAttribute(Attribute.GENERIC_GRAVITY);
                if (attribute != null) {
                    Collection <AttributeModifier> modifier = attribute.getModifiers();
                    for (AttributeModifier mod : modifier) {
                        //players.sendMessage(mod.toString());
                        if (mod.getName().equals("Gravity_Field_Modifier")) {
                            if (mod != null) {
                                //AttributeModifier removeableModifier = mod;
                                attribute.removeModifier(mod);
                                players.sendMessage("Not in gravity field mod removed");
                                break;
                            }
                        }
                    }
                    
                

                }
                // }   
            }
        }
    }
        
        // if (playerGravityHalfed == true) {
        //     playerGravityHalfed = false;
        //     //pStats.setGravity(player, 1.0);
        //     player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.02);
        //     player.sendMessage("Not in gravity field");
        // }
    


    // public void entityChecker(ArmorStand armorStand) {
        
    //     for (org.bukkit.entity.Entity entity : armorStand.getNearbyEntities(0.5, 0.5, 0.5)) {
    //         if (entity != armorStand) {
    //             // Handle collision logic here
    //             ((Damageable) entity).damage(20, entity); // Apply damage
    //         }
    //     }
    // }


    //@EventHandler
    public void gravityfieldRunnable(Player player) {

        final Player players = player;
        final Location c1 = player.getLocation();
        
        
        final PlayerStats playerStats = new PlayerStats();
        final double originalGravity = playerStats.getGravity(); 
        //ArmorStand[] armorStand = armorStands(players);
        

        armorStand1 = armorStandHandler(players);



        for (int i= 0; i <= 150; i++) {
            new BukkitRunnable() {
                @Override
                public void run() {

                    //playerUsingOrbitalPlanetStrike = true;
                    //players.sendMessage(originalGravity + "");
                    
                    Location location = new Location(c1.getWorld(), c1.getX(), c1.getY() -1 + (height), c1.getZ());
                    circleGravityBuff(players, armorStand1, location, playerStats);
                    
                    //entityChecker(armorStand1);
                    if (yaw >= 360) {
                        yaw = 0;
                    }
                    if (height == 0) {
                        maxHeight = false;
                    }
                    if (height >= 3 && maxHeight == false) {
                        maxHeight = true;
                    }
                    if (height >= 0 && maxHeight == false) {
                        height += 0.04;
                    }
                    if (height > 0 && maxHeight == true) {
                        height -= 0.04;
                        //maxHeight = false;
                    }
                    yaw += 7.20;
                    //stuff = circleNums;
                    //Bukkit.getLogger().info("This message is printed after a delay.");
                }
            }.runTaskLater(plugin, i*2); // 100L is the delay in ticks (100 ticks = 5 seconds)
        }

            new BukkitRunnable() {
                @Override
                public void run() {

                    armorStand1.remove();
                    //playerStats.setGravity(players, 1.0);
                    //players.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.02);

                    for (Player players : Bukkit.getOnlinePlayers()) {

                            UUID playersUuid = players.getUniqueId();
                            AttributeInstance attribute = players.getAttribute(Attribute.GENERIC_GRAVITY);
                            if (attribute != null) {
                                Collection <AttributeModifier> modifier = attribute.getModifiers();
                                for (AttributeModifier mod : modifier) {
                                    //players.sendMessage(mod.toString());
                                    if (mod.getName().equals("Gravity_Field_Modifier")) {
                                        if (mod != null) {
                                            //AttributeModifier removeableModifier = mod;
                                            attribute.removeModifier(mod);
                                            players.sendMessage("Gravity field over!");
                                            break;
                                        }
                                    }
                                }
                                
                            
            
                            }
  
                        }
                    }

                
            }.runTaskLater(plugin, (300) + 1); // 100L is the delay in ticks (100 ticks = 5 seconds)
        
        //Deletes Armor Stand entities from previous runnable
        //entityChecker(players);

    }

    // @EventHandler
    // public void PlayerMoveEvent(PlayerMoveEvent event) {
    //     Player player = event.getPlayer();
    //     //player.sendMessage(playerUsingOrbitalPlanetStrike + "");
    //     if (armorStand1 != null) {
    //         //player.sendMessage("working");
    //         circleEffect(player, armorStand1, armorStand2, armorStand3);
    //     }
    // }

    //     Player player = event.getPlayer();

    //     player.sendMessage("not working");
    //     //ArmorStand[] armorStand = armorStands(player);
    //     Location loc1 = (Location) stuff[0];
    //     Location loc2 = (Location) stuff[1];
    //     Location loc3 = (Location) stuff[2];
    //     ArmorStand armor1 = (ArmorStand) stuff[3];
    //     ArmorStand armor2 = (ArmorStand) stuff[4];
    //     ArmorStand armor3 = (ArmorStand) stuff[5];

    //     if (armor1 != null) {
    //         player.sendMessage("working");
        
    //         armor1.teleport(loc1);
    //         armor2.teleport(loc2);
    //         armor3.teleport(loc3);
    //     }
    // }
        // Method to add a modifier for testing purposes
        // public void addAttributeModifier(Player player) {
        //     AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        //     if (attribute != null) {
        //         UUID modifierUUID = UUID.randomUUID(); // Unique UUID for the modifier
        //         AttributeModifier modifier = new AttributeModifier(modifierUUID, "generic.attackDamage", 0.20, AttributeModifier.Operation.ADD_SCALAR);
        //         attribute.addModifier(modifier);
        //     }
        // }
    
        // // Method to remove a modifier
        // public void removeAttributeModifier(Player player, UUID modifierUUID) {
        //     AttributeInstance attribute = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        //     if (attribute != null) {
        //         AttributeModifier modifier = attribute.getModifier(modifierUUID);
        //         if (modifier != null) {
        //             attribute.removeModifier(modifier);
        //         }
        //     }
        // }
}


