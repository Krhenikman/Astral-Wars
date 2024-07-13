package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.swing.text.html.parser.Entity;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
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
    
    @SuppressWarnings("deprecation")
    public void circleGravityBuff(Player player, ArmorStand a1, Location c1, PlayerStats pStats) {


        //Location c1 = player.getLocation();
        //if (org.bukkit.entity.Entity entity : c1.getWorld().getNearbyEntities(c1, 3, 3, 3)
        //for (Player players : Bukkit.getOnlinePlayers()) {

        for (Player defaultPlayer : Bukkit.getOnlinePlayers()) {
                    
            UUID playerId = defaultPlayer.getUniqueId();
            gravityfield.put(playerId, false);
            gravityfield.getOrDefault(playerId, false);
            

        }

        for (org.bukkit.entity.Entity entity : c1.getWorld().getNearbyEntities(c1, 3, 3, 3)) {
            //Location particleLocation = new Location(c1.getWorld(), c1.getX(), c1.getY() -1, c1.getZ());

            c1.setYaw(yaw);
            armorStand.teleport(c1);
            if (entity == player) { //meaning player is in the gravity field

                
                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (entity.getUniqueId() == players.getUniqueId()) { //if any entity is one of the players set there value to true
                        gravityfield.put(players.getUniqueId(), true); //player is in the circle
                        players.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.01);
                        players.sendMessage("In gravity field");
                    }
                }
            }
        }

        for (Player players : Bukkit.getOnlinePlayers()) {
            if (gravityfield.getOrDefault(players.getUniqueId(), false) == false) {

                players.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.02);
                players.sendMessage("Not in gravity field");
            }
        }
        
        // if (playerGravityHalfed == true) {
        //     playerGravityHalfed = false;
        //     //pStats.setGravity(player, 1.0);
        //     player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.02);
        //     player.sendMessage("Not in gravity field");
        // }
    }


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
        final Location location = new Location(c1.getWorld(), c1.getX(), c1.getY() -1, c1.getZ());
        final PlayerStats playerStats = new PlayerStats();
        final double originalGravity = playerStats.getGravity(); 
        //ArmorStand[] armorStand = armorStands(players);
        

        armorStand1 = armorStandHandler(players);



        for (int i= 0; i <= 30; i++) {
            new BukkitRunnable() {
                @Override
                public void run() {

                    //playerUsingOrbitalPlanetStrike = true;
                    //players.sendMessage(originalGravity + "");
                    circleGravityBuff(players, armorStand1, location, playerStats);
                    
                    //entityChecker(armorStand1);
                    if (yaw >= 360) {
                        yaw = 0;
                    }

                    yaw += 18;
                    //stuff = circleNums;
                    //Bukkit.getLogger().info("This message is printed after a delay.");
                }
            }.runTaskLater(plugin, i*10); // 100L is the delay in ticks (100 ticks = 5 seconds)
        }

            new BukkitRunnable() {
                @Override
                public void run() {

                    armorStand1.remove();
                    //playerStats.setGravity(players, 1.0);
                    players.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(0.02);
                    //armorStand2.remove();
                    //armorStand3.remove();
                    //playerUsingOrbitalPlanetStrike = false;
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
}


