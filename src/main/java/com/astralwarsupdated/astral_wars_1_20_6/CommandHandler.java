package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandHandler implements CommandExecutor{
    
    private final Map<UUID, Long> lastZombieSpecial = new HashMap<>();
    private static final long ZOMBIE_COOLDOWN_TIME = 10; // 10 seconds
    UUID zombieId;
    JavaPlugin plugin;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("Only players can use that command!");
            return true;
        }
        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("register")) {
            
            String password = args[0];
            player.sendMessage("§aCRY ABOUT IT...");
            Plugin.LOGGER.info("registering player " + player.getName() + " with password " + password);
            //player.setGameMode();

            
        }

        if (command.getName().equalsIgnoreCase("getleapwand")) {
            
            player.getInventory().addItem(Weapons.wand);
            
        }

        if (command.getName().equalsIgnoreCase("mingravity")) {
            
            player.getInventory().addItem(Weapons.minorgravityfield);
            
        }

        if (command.getName().equalsIgnoreCase("test")) {
            
            player.getInventory().addItem(Weapons.pulsarcannon);
            
        }

        if (command.getName().equalsIgnoreCase("planet")) {
            
            player.getInventory().addItem(Weapons.solarsystem);
            
        }

        if (command.getName().equalsIgnoreCase("blackhole")) {
            
            player.getInventory().addItem(Weapons.blackholesword);
            
        }

        if (command.getName().equalsIgnoreCase("rustycopper")) {
            
            player.getInventory().addItem(Pickaxes.rustycopperdrill);
            
        }

        if (command.getName().equalsIgnoreCase("copper")) {
            
            player.getInventory().addItem(Pickaxes.copperdrill);
            
        }

        if (command.getName().equalsIgnoreCase("steel")) {
            
            player.getInventory().addItem(Pickaxes.steeldrill);
            
        }

        if (command.getName().equalsIgnoreCase("colbalt")) {
            
            player.getInventory().addItem(Pickaxes.colbaltdrill);
            
        }

        if (command.getName().equalsIgnoreCase("celestial")) {
            
            player.getInventory().addItem(Pickaxes.celestialdrill);
            
        }

        if (command.getName().equalsIgnoreCase("customzombie")) {
            


            CustomMob mob = new CustomMob(player, player.getLocation(), EntityType.ZOMBIE, "Kevin", Weapons.zomhelmet, Weapons.zomchestplate, Weapons.zomleggings, Weapons.zomboots, 1000.0, 25.0, 2, 0.2, 2.0);

            mob.createCustomMob();




            //zombie.setLootTable
            //Set the armor

            // zombie.getEquipment().setHelmet(Weapons.zomhelmet);
            // zombie.getEquipment().setChestplate(Weapons.zomchestplate);
            // zombie.getEquipment().setLeggings(Weapons.zomleggings);
            // zombie.getEquipment().setBoots(Weapons.zomboots);
            
            //zombieId = ((Entity) mob).getUniqueId();
        }

        if (command.getName().equalsIgnoreCase("customskeleton")) {
            


            CustomMob mob = new CustomMob(player, player.getLocation(), EntityType.SKELETON, "Kyle", Weapons.zomhelmet, Weapons.zomchestplate, Weapons.zomleggings, Weapons.zomboots, 1000.0, 15.0, 2, 0.3, 10.0);

            mob.createCustomMob();




            //zombie.setLootTable
            //Set the armor

            // zombie.getEquipment().setHelmet(Weapons.zomhelmet);
            // zombie.getEquipment().setChestplate(Weapons.zomchestplate);
            // zombie.getEquipment().setLeggings(Weapons.zomleggings);
            // zombie.getEquipment().setBoots(Weapons.zomboots);
            
            //zombieId = ((Entity) mob).getUniqueId();
        }

        if (command.getName().equalsIgnoreCase("customMeteorHead")) {
            


            CustomMob mob = new CustomMob(player, player.getLocation(), EntityType.ZOMBIE, "Meteor Head", Weapons.magmahelmet, Weapons.magmachestplate,Weapons.magmaleggings, Weapons.magmaboots, 1000.0, 15.0, 1.5, 0.5, 10.0);

            mob.createCustomMob();

            // CustomHead head = new CustomHead();
            // ItemStack item = head.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzExNDdkODlkMjQ5OGY5ZTIxZjM2YWQzZTUzNTZiMjMyN2M4Zjg1NTE4M2QzZTY5ZjRkNjYwZTViYzIxMGFiYiJ9fX0=");
            // ItemStack items = head.getCustomTextureSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzExNDdkODlkMjQ5OGY5ZTIxZjM2YWQzZTUzNTZiMjMyN2M4Zjg1NTE4M2QzZTY5ZjRkNjYwZTViYzIxMGFiYiJ9fX0=");
            // //player.getInventory().addItem(item);
            // player.getInventory().addItem(items);




            //zombie.setLootTable
            //Set the armor

            // zombie.getEquipment().setHelmet(Weapons.zomhelmet);
            // zombie.getEquipment().setChestplate(Weapons.zomchestplate);
            // zombie.getEquipment().setLeggings(Weapons.zomleggings);
            // zombie.getEquipment().setBoots(Weapons.zomboots);
            
            //zombieId = ((Entity) mob).getUniqueId();
        }

        if (command.getName().equalsIgnoreCase("gui")) {
            
            player.getInventory().addItem(Weapons.statgui);
            
        }

        if (command.getName().equalsIgnoreCase("starboard")) {
            
            player.getInventory().addItem(Weapons.StarboardGuitar);
            
        }





        return true; //must return true
    }
    


           

    // // Schedule a repeating task to run every 10 seconds (200 ticks)
        // Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
        //     @Override
        //     public void run() {
        //         // Code to be executed every 10 seconds
        //         performScheduledTask();
        //     }
        // }, 0L, 200L); // Initial delay is 0 ticks, repeat every 200 ticks
        
        // private void performScheduledTask() {
        //     //player.sendMessage("heyyyyyyyy!!!");
        //     Bukkit.getLogger().info("10 seconds have passed! Performing scheduled task.");
        // }


        // if(command.getName().equalsIgnoreCase("creative") && sender instanceof Player) {
        //     public static final GameMode CREATIVE;
        //     Player player = (Player) sender;
        //     //GameMode mode = new GameMode(creative);
        //     player.setGameMode(GameMode);
        // }    
            //Plugin.LOGGER.info("Command not found");
    
        
    
}