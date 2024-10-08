package com.astralwarsupdated.astral_wars_1_20_6;


import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Creature;
import org.bukkit.entity.DragonFireball;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.ShulkerBullet;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class OreMining implements Listener{
    
    private final JavaPlugin plugin;
    //private boolean meteorShot = false;

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
            //molten cores boss drop???
            blockBedrockRunnable(block);

            
            Random random = new Random();
            if (random.nextDouble() * 100 <= 20) {
                CustomMob mob = new CustomMob(player, new Location(block.getWorld(), block.getX(), block.getY()+2.0, block.getZ()), EntityType.ZOMBIE, "Meteor Head", Weapons.magmahelmet, Weapons.magmachestplate,Weapons.magmaleggings, Weapons.magmaboots, 1000.0, 15.0, 1, 0.5, 10.0, 0);

                mob.createCustomMob();
            }
            if (random.nextDouble() * 100 <= 20) {
                CustomHead head = new CustomHead();
                ItemStack meteorBossHead = head.getCustomTextureSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjNlNTkyNTBjOTY4ZTUwODUzOWJmMmU4NDkyZjU2YTJmNjY0ZWZiMzA5ZjQ5NWEwN2RjM2E1NGM4YjZhMjQ5ZSJ9fX0=");
                CustomMob mob = new CustomMob(player, new Location(block.getWorld(), 12,-20,252), EntityType.ZOMBIE, "Molten Fiend", meteorBossHead, Weapons.magmachestplate,Weapons.magmaleggings, Weapons.magmaboots, 40000.0, 30.0, 2, 0.5, 10.0, 0);
                //meteorShot = true;
                mob.createCustomMob();
                moltenFiendAtk(player.getWorld(), mob);
                moltenFiendAtk2(player.getWorld(), mob);
                moltenFiendAtk3(player.getWorld(), mob);
            }

        }
        if (block.getType() == Material.CRYING_OBSIDIAN) {

            event.setCancelled(true);
            player.getInventory().addItem(ItemMaterials.darkmatter); //Meteorite Ore
            //molten cores boss drop???
            blockBedrockRunnable(block);

            
            Random random = new Random();
            if (random.nextDouble() * 100 <= 20) {
                CustomMob mob = new CustomMob(player, new Location(block.getWorld(), block.getX(), block.getY()+2.0, block.getZ()), EntityType.ENDERMAN, "Void Knight", Weapons.magmahelmet, Weapons.magmachestplate,Weapons.magmaleggings, Weapons.magmaboots, 1000.0, 15.0, 1, 0.5, 10.0, 100);

                mob.createCustomMob();
            }
            if (random.nextDouble() * 100 <= 20) {
                CustomHead head = new CustomHead();
                ItemStack meteorBossHead = head.getCustomTextureSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNjNlNTkyNTBjOTY4ZTUwODUzOWJmMmU4NDkyZjU2YTJmNjY0ZWZiMzA5ZjQ5NWEwN2RjM2E1NGM4YjZhMjQ5ZSJ9fX0=");
                CustomMob mob = new CustomMob(player, new Location(block.getWorld(), -125,6,124), EntityType.ENDERMAN, "§5Anthony's Worst Nightmare", meteorBossHead, Weapons.magmachestplate,Weapons.magmaleggings, Weapons.magmaboots, 100000.0, 30.0, 1.5, 1.5, 20.0, 100);
                //meteorShot = true;
                mob.createCustomMob();
                VoidKnightAtk(player.getWorld(), mob);
                VoidKnightAtk2(player.getWorld(), mob);
                VoidKnightAtk3(player.getWorld(), mob);
            }

        }

        else if (player.isOp() == false){
            event.setCancelled(true);
            player.sendMessage("§cYou can't mine that!");
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
                    //event.setDamage(10.0); // Example: set damage to 2.0
                    EntityHealth playerStats = new EntityHealth();
                    entity.setMetadata("GENERIC_ENTITY_HEALTH", new FixedMetadataValue(plugin, (playerStats.getHealth(player) - 10)));
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

    public void moltenFiendAtk(World world, CustomMob customMob) {
        final CustomMob customMobs = customMob;
        final World worlds = world;
        new BukkitRunnable() {
                    //@Override
            public void run() {
                for (Entity entity : worlds.getEntities()) {
                    if (customMobs.getName(entity).equals("Molten Fiend") && (entity.isDead() == false)) {
                        final LivingEntity entitys = (LivingEntity) entity;
                        Vector direction = entity.getLocation().getDirection();
                        Fireball fireball = entitys.launchProjectile(Fireball.class);
                        
                        fireball.setVelocity(direction.multiply(3)); // Adjust the speed as needed
                        fireball.setYield(3); // Set the explosion power
                    }
                }        
            }
        }.runTaskTimer(plugin, 40, 40); // 100L is the delay in ticks (100 ticks = 5 seconds)
    }
    public void moltenFiendAtk2(World world, CustomMob customMob) {
        final CustomMob customMobs = customMob;
        final World worlds = world;
        new BukkitRunnable() {
                        //@Override
            public void run() {
                for (Entity entity : worlds.getEntities()) {
                    if (customMobs.getName(entity).equals("Molten Fiend") && (entity.isDead() == false)) {
                        for (Entity player : worlds.getNearbyEntities(entity.getLocation(), 15, 15, 15)) {
                            if (player instanceof Player) {
                                final LivingEntity entitys = (LivingEntity) player;
                                Location direction = entitys.getLocation().add(0, 8, 0);
                                Arrow arrow = worlds.spawn(direction, Arrow.class);
                                arrow.setVelocity(new Vector(0, -1, 0));
                                arrow.setDamage(10);
                            }
                        }
                    }
                }
            }
                            
        }.runTaskTimer(plugin, 40, 20); // 100L is the delay in ticks (100 ticks = 5 seconds)
    }
        public void moltenFiendAtk3(World world, CustomMob customMob) {
            final CustomMob customMobs = customMob;
            final World worlds = world;
            new BukkitRunnable() {
                            //@Override
                public void run() {
                    for (Entity entity : worlds.getEntities()) {
                        if (customMobs.getName(entity).equals("Molten Fiend") && (entity.isDead() == false)) {
                            for (Entity player : worlds.getNearbyEntities(entity.getLocation(), 15, 15, 15)) {
                                if (player instanceof Player) {
                                    final LivingEntity entitys = (LivingEntity) player;
                                    Location direction = entity.getLocation().add(0, 4, 0);
                                    ShulkerBullet bullet = entitys.launchProjectile(ShulkerBullet.class);
                                    //ShulkerBullet bullet = worlds.spawn(direction, ShulkerBullet.class);
                                    //arrow.setVelocity(new Vector(0, -1, 0));
                                    bullet.setTarget(player);
                                    //arrow.setDamage(10);
                                }
                            }
                        }
                    }
                }
                                
            }.runTaskTimer(plugin, 40, 20); // 100L is the delay in ticks (100 ticks = 5 seconds)
            
        
    }

    public void VoidKnightAtk(World world, CustomMob customMob) {
        final CustomMob customMobs = customMob;
        final World worlds = world;
        new BukkitRunnable() {
                    //@Override
            public void run() {
                for (Entity entity : worlds.getEntities()) {
                    if (customMobs.getName(entity).equals("§5Anthony's Worst Nightmare") && (entity.isDead() == false)) {
                        final LivingEntity entitys = (LivingEntity) entity;
                        Vector direction = entity.getLocation().getDirection();
                        DragonFireball dragonfireball = entitys.launchProjectile(DragonFireball.class);
                        
                        dragonfireball.setVelocity(direction.multiply(3)); // Adjust the speed as needed
                        dragonfireball.setYield(3); // Set the explosion power

                    }
                }        
            }
        }.runTaskTimer(plugin, 40, 40); // 100L is the delay in ticks (100 ticks = 5 seconds)
    }

    public void VoidKnightAtk2(World world, CustomMob customMob) {
        final CustomMob customMobs = customMob;
        final World worlds = world;
        new BukkitRunnable() {
                    //@Override
            public void run() {
                for (Entity entity : worlds.getEntities()) {
                    if (customMobs.getName(entity).equals("§5Anthony's Worst Nightmare") && (entity.isDead() == false)) {
                        
                        for (org.bukkit.entity.Entity entitys : entity.getWorld().getNearbyEntities(entity.getLocation(), 5, 10, 5)) {
                            if (entitys instanceof  Player) {
                                Player player = (Player) entitys;
                                PotionEffect blindnessEffect = new PotionEffect(PotionEffectType.DARKNESS, 60, 0);
                                    
                                player.addPotionEffect(blindnessEffect);
                            }
                        }
                        
                    }
                }        
            }
        }.runTaskTimer(plugin, 40, 20); // 100L is the delay in ticks (100 ticks = 5 seconds)
    }

    public void VoidKnightAtk3(World world, CustomMob customMob) {
        final CustomMob customMobs = customMob;
        final World worlds = world;
        new BukkitRunnable() {
                    //@Override
            public void run() {
                for (Entity entity : worlds.getEntities()) {
                    if (customMobs.getName(entity).equals("§5Anthony's Worst Nightmare") && (entity.isDead() == false)) {
                        Creature creature = (Creature) entity;
                        LivingEntity target = creature.getTarget();

                        entity.teleport(target);
                        
                    }
                }        
            }
        }.runTaskTimer(plugin, 40, 100); // 100L is the delay in ticks (100 ticks = 5 seconds)
    }
}
