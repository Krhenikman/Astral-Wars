package com.astralwarsupdated.astral_wars_1_20_6;


import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class OreMining implements Listener{
    
    private final JavaPlugin plugin;

    public OreMining(JavaPlugin plugin) {
        this.plugin = plugin;
        
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();
        if (block.getType() == Material.MAGMA_BLOCK) {

            event.setCancelled(true);
            player.getInventory().addItem(ItemMaterials.meteoriteOre); //Meteorite Ore
            blockBedrockRunnable(block);
            

        }
    }

    public void blockBedrockRunnable(Block blocks) {
        final Block block = blocks;
        final Material material = block.getType();

        block.setType(Material.BEDROCK);
            

        new BukkitRunnable() {
            @Override
            public void run() {
                block.setType(material);
            }
        }.runTaskLater(plugin, 100); // 100L is the delay in ticks (100 ticks = 5 seconds)
    }

    @EventHandler
    public void onEntityDamage(EntityDamageEvent event) {
        // Check if the damage cause is HOT_FLOOR
        if (event.getCause() == EntityDamageEvent.DamageCause.HOT_FLOOR) {
            Entity entity = event.getEntity();
            
            // Check if the entity is a player
            if (entity instanceof Player) {
                Player player = (Player) entity;
                Block blockBelow = player.getLocation().subtract(0, 1, 0).getBlock();

                // Check if the block below the player is a magma block
                if (blockBelow.getType() == Material.MAGMA_BLOCK) {
                    // Set custom damage amount
                    event.setDamage(10.0); // Example: set damage to 2.0
                }
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        // Get the player who died
        String playerName = event.getEntity().getName();
        EntityDamageEvent.DamageCause cause = event.getEntity().getLastDamageCause().getCause();
        //EntityDamageEvent.DamageCause.HOT_FLOOR
        if (cause.toString().equals("HOT_FLOOR")) {
            event.setDeathMessage(playerName + " stood to close to the meteorite!");
        }
    }
}
