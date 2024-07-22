package com.astralwarsupdated.astral_wars_1_20_6;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;


/*
 * astral_wars_1_20_6 java plugin
 */
public class Plugin extends JavaPlugin
{
  //private static final Logger LOGGER=Logger.getLogger("astral_wars_1_20_6");
  private static Plugin instance;
  //private static JavaPlugin javaInstance;
  public static Logger LOGGER=Logger.getLogger("astral_wars_1_20_6");
  private CommandHandler commandHandler;
  private CustomScoreboard healthbar;
  private PlayerStats playerRegen;
  //private Weapons exAttributes;

  public void onEnable()
  {
    LOGGER.info("astral_wars_1_20_6 enabled");
    
    instance = this;
    //exAttributes = new Weapons(this);
    //javaInstance = this;

    //Runnables
    playerRegen = new PlayerStats();
    playerRegen.startRegenTask(); 
    healthbar = new CustomScoreboard(this);
    healthbar.startHealthActionBarTask();




    //Events
    getServer().getPluginManager().registerEvents(new EventsHandler(instance), this);
    getServer().getPluginManager().registerEvents(new OrbitalPlanetStrike(instance), this);
    getServer().getPluginManager().registerEvents(new OreMining(instance), this);
    getServer().getPluginManager().registerEvents(new PlayerStats(), this);
    getServer().getPluginManager().registerEvents(new CustomMob(), this);
    //getServer().getPluginManager().registerEvents(new CustomScoreboard(), this);

    //Commands
    
    commandHandler = new CommandHandler();
    
    Weapons.init();
    Pickaxes.init();
    ItemMaterials.init();

    //Utility

    getCommand("getleapwand").setExecutor(commandHandler);

    getCommand("mingravity").setExecutor(commandHandler);

    //Weapons

    getCommand("test").setExecutor(commandHandler);

    getCommand("planet").setExecutor(commandHandler);

    getCommand("blackhole").setExecutor(commandHandler);

    
    //getServer().getPluginManager().registerEvents(new Weapons(), this);

    getCommand("register").setExecutor(commandHandler);

    //pickaxes
    
    getCommand("rustycopper").setExecutor(commandHandler);


    getCommand("copper").setExecutor(commandHandler);

    getCommand("steel").setExecutor(commandHandler);

    getCommand("colbalt").setExecutor(commandHandler);
    
    getCommand("celestial").setExecutor(commandHandler);
    
    getCommand("customzombie").setExecutor(commandHandler);

    getCommand("customskeleton").setExecutor(commandHandler);



    
    //player.getAttribute(Attribute.GENERIC_GRAVITY).setBaseValue(100.0);
    
    
    //Items

    getCommand("gui").setExecutor(commandHandler);

    //Heath Bars
    //runnable();

    //new MyBukkitTasks().runTaskTimer(this, 0L, 5L);
  }

  public void onDisable()
  {
    LOGGER.info("astral_wars_1_20_6 disabled");
  }



  public static Plugin getInstance() {
    //return plugin;
    return instance;
  }

  // public static JavaPlugin getjavaInstance() {
  //   //return java plugin;
  //   return javaInstance;
  // }



  // public void runnable() {
	// 	 new BukkitRunnable() {

	// 		@SuppressWarnings("deprecation")
	// 		@Override
	// 		public void run() {
        
	// 			for (LivingEntity e : getServer().getWorld("world").getLivingEntities()) {
  //         if (e != null) {
  //           e.setCustomName(e.getType() + "§c[" + e.getHealth()
  //                + e.getMaxHealth() + "§c]");
  //           e.setCustomNameVisible(true);
  //           LOGGER.info("Health Working!");
  //         }
	// 			}

	// 		}

	// 	}.runTaskTimerAsynchronously(this, 0, 10);
		
	//}

}


