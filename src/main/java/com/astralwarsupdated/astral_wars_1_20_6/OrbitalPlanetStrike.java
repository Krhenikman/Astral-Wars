package com.astralwarsupdated.astral_wars_1_20_6;

import javax.swing.text.html.parser.Entity;

import org.bukkit.Location;
import org.bukkit.Material;
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

public class OrbitalPlanetStrike implements Listener {
    
    private final JavaPlugin plugin;
    
    double angle = 0;
    boolean playerUsingOrbitalPlanetStrike = true;
    
    
    private ArmorStand armorStand;

    private ArmorStand armorStand1;
    private ArmorStand armorStand2;
    private ArmorStand armorStand3;




    
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




    public OrbitalPlanetStrike(JavaPlugin plugin) {
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
        //armorStand.setItemInHand(new ItemStack(Material.OCHRE_FROGLIGHT));
        armorStand.setHeadPose((new EulerAngle(90, 90, 90)));
        armorStand.setHelmet(new ItemStack(Material.OCHRE_FROGLIGHT));

        return armorStand;
    }
    
    @SuppressWarnings("deprecation")
    public void circleEffect(Player player, ArmorStand a1, ArmorStand a2, ArmorStand a3) {


       
        //Player player = event.getPlayer();
        Vector playerFacing = player.getLocation().getDirection();
        Location currentLocation = player.getLocation();
        Location c1 = currentLocation.clone();
        double circleRadius = 5.0;


            double x = c1.getX() + (circleRadius * Math.cos(angle));
            double z = c1.getZ() + (circleRadius * Math.sin(angle));
            
            double x2 = c1.getX() + (circleRadius * Math.cos((Math.PI/1.5) + angle));
            double z2 = c1.getZ() + (circleRadius * Math.sin((Math.PI/1.5) + angle));

            double x3 = c1.getX() + (circleRadius * Math.cos((Math.PI/.75) + angle));
            double z3 = c1.getZ() + (circleRadius * Math.sin((Math.PI/.75) + angle));
           



            player.sendMessage("Angle: " + angle);


            //Vector position1 = new Vector(x, 0, z);
            Location particleLocation = new Location(c1.getWorld(), x, c1.getY() -1, z);

            Location particleLocation2 = new Location(c1.getWorld(), x2, c1.getY() -1, z2);

            Location particleLocation3 = new Location(c1.getWorld(), x3, c1.getY() -1, z3);


            a1.teleport(particleLocation);
            a2.teleport(particleLocation2);
            a3.teleport(particleLocation3);

            // for (org.bukkit.entity.Entity entity : particleLocation.getWorld().getNearbyEntities(particleLocation, 1, 1, 1)) {
            //     if (player != entity) { // Don't hurt the user of the weapon
            //         //entity.setLastDamageCause(null); // Reset any other damage causes
            //         ((Damageable) entity).damage(10, entity); // Apply damage
                       
                   


                           
            //     }
            // } 


            if (angle >= 2*Math.PI) {
                angle = 0;


            }
            
            
        //}
        // values[0] = particleLocation;
        // values[1] = particleLocation2;
        // values[2] = particleLocation3;
        // values[3] = a1;
        // values[4] = a2;
        // values[5] = a3;
        // return values;
    }

    public void entityChecker(ArmorStand armorStand) {
        
        for (org.bukkit.entity.Entity entity : armorStand.getNearbyEntities(0.5, 0.5, 0.5)) {
            if (!(entity instanceof ArmorStand) && (entity instanceof LivingEntity)) {
                // Handle collision logic here
                ((Damageable) entity).damage(20, entity); // Apply damage
            }
        }
    }

    // public ArmorStand[] armorStands(Player player) {
    //     ArmorStand[] armorStand = new ArmorStand[3];
    //     armorStand[0] = armorStandHandler(player); //private
    //     armorStand[1] = armorStandHandler(player); //private
    //     armorStand[2] = armorStandHandler(player); //private
    //     return armorStand;
    // }

    //@EventHandler
    public void planetRunnable(Player player) {

        final Player players = player;
        //ArmorStand[] armorStand = armorStands(players);
        
        // final ArmorStand armorStand1 = armorStandHandler(players); //private
        // final ArmorStand armorStand2 = armorStandHandler(players); //private
        // final ArmorStand armorStand3 = armorStandHandler(players); //private
        armorStand1 = armorStandHandler(players);
        armorStand2 = armorStandHandler(players);
        armorStand3 = armorStandHandler(players);
        // this.armorStand1 = armorStand1;
        // this.armorStand2 = armorStand2;
        // this.armorStand3 = armorStand3;
        
        // final ArmorStand armorStand1 = armorStand[0]; //private
        // final ArmorStand armorStand2 = armorStand[1]; //private
        // final ArmorStand armorStand3 = armorStand[2]; //private
        //armorStands(players);
        for (int i= 0; i <= 384; i++) {
            new BukkitRunnable() {
                @Override
                public void run() {

                    playerUsingOrbitalPlanetStrike = true;
                    //entityChecker(players);
                    // Code to be executed after the delay
                    //Object[] circleNums = 
                    circleEffect(players, armorStand1, armorStand2, armorStand3);
                    entityChecker(armorStand1);
                    entityChecker(armorStand2);
                    entityChecker(armorStand3);
                    angle += Math.PI /(96);
                    //stuff = circleNums;
                    //Bukkit.getLogger().info("This message is printed after a delay.");
                }
            }.runTaskLater(plugin, i/2); // 100L is the delay in ticks (100 ticks = 5 seconds)
        }

            new BukkitRunnable() {
                @Override
                public void run() {

                    armorStand1.remove();
                    armorStand2.remove();
                    armorStand3.remove();
                    //playerUsingOrbitalPlanetStrike = false;
                }
            }.runTaskLater(plugin, (192) + 1); // 100L is the delay in ticks (100 ticks = 5 seconds)
        
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
