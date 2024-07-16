package com.astralwarsupdated.astral_wars_1_20_6;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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
            player.getInventory().addItem(new ItemStack(Material.MAGMA_BLOCK));
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

    
}
