package com.astralwarsupdated.astral_wars_1_20_6;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class CustomScoreboard {
    
    private final JavaPlugin plugin;

    public CustomScoreboard(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    void startHealthActionBarTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    sendActionBar(player, getStatsMessage(player));
                }
            }
        }.runTaskTimer(plugin, 20, 20); // Update every second (20 ticks)
    }

    @SuppressWarnings("deprecation")
    private void sendActionBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    private String getStatsMessage(Player player) {

        //double health = player.getHealth();
        @SuppressWarnings("deprecation")
        //double maxHealth = player.getMaxHealth();
        EntityHealth healthSys = new EntityHealth();
        PlayerStats stats = new PlayerStats();
        stats.updatePlayerStats(player);
        double health = healthSys.getHealth(player);
        //double maxHealth = healthSys.getMaxHealth(player);
        //double maxHealth = stats.getHealth();
        double defense = healthSys.getDamageResistance(player);
        double actualMax = healthSys.getMaxHealth(player); 
        player.sendMessage(actualMax + "");
        //int defense = (int) stats.getDefense();
        //int damage = (int) stats.getDamage();
        return ChatColor.RED + "❤ " + (int) health + "/" + (int) actualMax + ChatColor.GREEN + "   ❈ " + defense + ChatColor.DARK_RED + "   ❁ " + stats.getStrength();
    }


    //   public void entityHealthBar() {
	// 	 new BukkitRunnable() {

	// 		@SuppressWarnings("deprecation")
	// 		@Override
	// 		public void run() {
    //             Bukkit.spigot().
	// 			for (LivingEntity e : getServer().getWorld().getLivingEntities()) {
    //       if (e != null) {
    //         e.setCustomName(e.getType() + "§c[" + e.getHealth()
    //              + e.getMaxHealth() + "§c]");
    //         e.setCustomNameVisible(true);
    //         LOGGER.info("Health Working!");
    //       }
	// 			}

	// 		}

	// 	}.runTaskTimer(plugin, 0, 0);




    // @EventHandler
    
    // public void onPlayerJoin(PlayerJoinEvent event) {
            
    //     Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
    //     Player player = event.getPlayer();

    //     //Criteria customHealth = new Criteria();

    //     Objective objective = scoreboard.registerNewObjective("health", Criteria.HEALTH, ChatColor.RED + "❤");

    //     objective.setDisplaySlot(DisplaySlot.BELOW_NAME);

    //     //scoreboard.setDisplayName(ChatColor.RED + "❤");

    //     player.setScoreboard(scoreboard);

    //     updateScoreboard(player, scoreboard);

    //     player.setScoreboard(scoreboard);
    // }


    // public void updateScoreboard(Player player, Scoreboard scoreboard) {
    //     Objective objective = scoreboard.getObjective("health");
    //     if (objective != null) {
    //         objective.getScore(ChatColor.GREEN + "Health:").setScore((int) player.getHealth());
    //     }
    // }

    // @EventHandler
    // public void onPlayerDamage(EntityDamageEvent event) {
    //     if (event.getEntity() instanceof Player) {
    //         Player player = (Player) event.getEntity();
    //         updateScoreboard(player, player.getScoreboard());
    //     }
    // }

    // @EventHandler
    // public void onPlayerRegainHealth(EntityRegainHealthEvent event) {
    //     if (event.getEntity() instanceof Player) {
    //         Player player = (Player) event.getEntity();
    //         updateScoreboard(player, player.getScoreboard());
    //     }
    // }
}


