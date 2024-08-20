package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class StarboardGuitar {

    private final JavaPlugin plugin;

    private String originalStrand = ChatColor.RED + "----" + ChatColor.GREEN + "--" + ChatColor.RED + "----";
    private String strand1 = ChatColor.RED + "X---" + ChatColor.GREEN + "--" + ChatColor.RED + "----";
    private String strand2 = ChatColor.RED + "-X--" + ChatColor.GREEN + "--" + ChatColor.RED + "----";
    private String strand3 = ChatColor.RED + "--X-" + ChatColor.GREEN + "--" + ChatColor.RED + "----";
    private String strand4 = ChatColor.RED + "---X" + ChatColor.GREEN + "--" + ChatColor.RED + "----";
    private String strand5 = ChatColor.RED + "----" + ChatColor.GREEN + "X-" + ChatColor.RED + "----";
    private String strand6 = ChatColor.RED + "----" + ChatColor.GREEN + "-X" + ChatColor.RED + "----";
    private String strand7 = ChatColor.RED + "----" + ChatColor.GREEN + "--" + ChatColor.RED + "X---";
    private String strand8 = ChatColor.RED + "----" + ChatColor.GREEN + "--" + ChatColor.RED + "-X--";
    private String strand9 = ChatColor.RED + "----" + ChatColor.GREEN + "--" + ChatColor.RED + "--X-";
    private String strand10 = ChatColor.RED + "----" + ChatColor.GREEN + "--" + ChatColor.RED + "---X";

    private String originalComboStrand = ChatColor.RED + "---" + ChatColor.GREEN + "--" + ChatColor.RED + "---";
    private String strandCombo1 = ChatColor.RED + "X--" + ChatColor.GREEN + "--" + ChatColor.RED + "---";
    private String strandCombo2 = ChatColor.RED + "-X-" + ChatColor.GREEN + "--" + ChatColor.RED + "---";
    private String strandCombo3 = ChatColor.RED + "--X" + ChatColor.GREEN + "--" + ChatColor.RED + "---";
    private String strandCombo4 = ChatColor.RED + "---" + ChatColor.GREEN + "X-" + ChatColor.RED + "---";
    private String strandCombo5 = ChatColor.RED + "---" + ChatColor.GREEN + "-X" + ChatColor.RED + "---";
    private String strandCombo6 = ChatColor.RED + "---" + ChatColor.GREEN + "--" + ChatColor.RED + "X--";
    private String strandCombo7 = ChatColor.RED + "---" + ChatColor.GREEN + "--" + ChatColor.RED + "-X-";
    private String strandCombo8 = ChatColor.RED + "---" + ChatColor.GREEN + "--" + ChatColor.RED + "--X";





    private int strandNum;
    private int starCount;

    //private int taskId = -1;
    private final Map<UUID, Integer> playerTasks = new HashMap<>();

    public StarboardGuitar(JavaPlugin plugin, int stringNumber, int starNum) {
        this.plugin = plugin;
        strandNum = stringNumber;
        starCount = starNum;
        
    }

    @SuppressWarnings("deprecation")
    private void sendGuitarBar(Player player, String message) {
        player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));
    }

    private String getGuitarStrand(Player player) {
        //EventsHandler starCount = new EventsHandler(plugin);
        player.sendMessage(starCount + "");
        if (starCount <= 3) {
            if (strandNum == 0) {
                strandNum++;
                return originalStrand;
            }
            if (strandNum == 1) {
                strandNum++;
                return strand1;
            }
            if (strandNum == 2) {
                strandNum++;
                return strand2;
            }
            if (strandNum == 3) {
                strandNum++;
                return strand3;
            }
            if (strandNum == 4) {
                strandNum++;
                return strand4;
            }
            if (strandNum == 5) {
                strandNum++;
                return strand5;
            }
            if (strandNum == 6) {
                strandNum++;
                return strand6;
            }
            if (strandNum == 7) {
                strandNum++;
                return strand7;
            }
            if (strandNum == 8) {
                strandNum++;
                return strand8;
            }
            if (strandNum == 9) {
                strandNum++;
                return strand9;
            }
            else {
                strandNum = 0;
                return strand10;
            }
        }
        else {
            if (strandNum == 0) {
                strandNum++;
                return originalComboStrand;
            }
            if (strandNum == 1) {
                strandNum++;
                return strandCombo1;
            }
            if (strandNum == 2) {
                strandNum++;
                return strandCombo2;
            }
            if (strandNum == 3) {
                strandNum++;
                return strandCombo3;
            }
            if (strandNum == 4) {
                strandNum++;
                return strandCombo4;
            }
            if (strandNum == 5) {
                strandNum++;
                return strandCombo5;
            }
            if (strandNum == 6) {
                strandNum++;
                return strandCombo6;
            }
            if (strandNum == 7) {
                strandNum++;
                return strandCombo7;
            }

            else {
                strandNum = 0;
                return strandCombo8;
            }
        }

    }
    private void stopRepeatingTask(UUID playerId) {
        if (playerTasks.containsKey(playerId)) {
            int taskId = playerTasks.get(playerId);
            Bukkit.getScheduler().cancelTask(taskId);
            playerTasks.remove(playerId);
        }
    }

    @SuppressWarnings("deprecation")
    public void musicalDamage(Player players, PlayerItemHeldEvent event) { //area of effect with particles pushing away 6 block 




        
        final UUID playerIds = players.getUniqueId();

        if (playerTasks.containsKey(playerIds)) {
            stopRepeatingTask(playerIds);
        }
       
                
                //ItemStack itemInHand = event.getPlayer().getInventory().getItem(event.getNewSlot());
                
                final Player player = players;
                final EventsHandler starCount = new EventsHandler(plugin);
                int taskId = new BukkitRunnable() {
                    @Override
                    public void run() {
                        ItemStack itemInHand = player.getInventory().getItemInMainHand();
                        if (itemInHand != null && itemInHand.hasItemMeta()) {
                            ItemMeta meta = itemInHand.getItemMeta();
                            if (meta.hasDisplayName() && "§b♫ Starboard Guitar ♫".equals(meta.getDisplayName())) {
                                sendGuitarBar(player, getGuitarStrand(player));

                                // new BukkitRunnable() {
                                //     public void run() {
                                        
                                //     }
                                // }.runTaskTimer(plugin,0,1);

                        // Location c1 = player.getLocation();
                        // for (org.bukkit.entity.Entity entity : c1.getWorld().getNearbyEntities(c1, 6, 6, 6)) {
                            
                            }
                            else {
                                player.sendMessage("You stopped holding the required item. Task cancelled.");
                                stopRepeatingTask(playerIds);
                            }
                        }
                        else {
                            stopRepeatingTask(playerIds);
                            player.sendMessage("You stopped holding the required item. Task cancelled.");
                        }

                    }
                    
                }.runTaskTimer(plugin, 5, 4).getTaskId(); // Update every second (20 ticks)
            

                playerTasks.put(playerIds, taskId);
                player.sendMessage(taskId + "");
            //}
    }

    public int getstrandNumb() {
        return strandNum;
    }
    public void setstrandNumb(int string) {
        strandNum = string;
    }
    public int starCount() {
        return starCount;
    }
    public void setStarCount(int star) {
        starCount = star;
    }

}
