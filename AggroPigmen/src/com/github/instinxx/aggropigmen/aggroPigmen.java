package com.github.instinxx.aggropigmen;

import java.util.logging.Logger;

import org.bukkit.Server;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

@SuppressWarnings("unused")
public class aggroPigmen extends JavaPlugin implements Listener {
	public static aggroPigmen plugin;
	public static final Logger log = Logger.getLogger("Minecraft");
	
	
	@Override
	public void onEnable() {
		plugin = this;
		getLogger().info("AggroPigmen is Enabled!");
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	private Player target;
	
	
	@EventHandler
	public void onCreatureSpawn(CreatureSpawnEvent event){

		if(event.isCancelled()){
			return;
		}

		Entity ent = event.getEntity();
		if (ent == null){
			return;
		}

		if (!(ent instanceof PigZombie)){
			getLogger().info("AggroPigmen spawned!");
			return;
		}

		else if (ent instanceof PigZombie){
			PigZombie pz = (PigZombie)event.getEntity();
			pz.setAngry(true);}
		}
			
	
	@Override
	public void onDisable() {
		getLogger().info("AggroPigmen are disabled - Be nice to them!");
	}}
