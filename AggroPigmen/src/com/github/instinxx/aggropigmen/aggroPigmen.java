package com.github.instinxx.aggropigmen;

import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;


public class aggroPigmen extends JavaPlugin implements Listener {
	public void onEnable() {
		getLogger().info("AggroPigmen is loaded!");
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
				return;
			}
			
			World world = null;
			if (extracted(world).getEnvironment().equals(Environment.NETHER)){
				return;
			}
			
			else if (ent instanceof PigZombie){
				PigZombie pz = (PigZombie)event.getEntity();
				pz.setAngry(true);
						
				if (pz.getTarget() != target){
					pz.setTarget(target);
				}
			}
			
		}

	private World extracted(World world) {
		return world;
	}
		
	@Override
	public void onDisable() {
		// TODO Insert what happens on plugin Disable
		getLogger().info("AggroPigmen are disabled!");
	}
}

