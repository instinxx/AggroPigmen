package com.github.instinxx.aggropigmen;

import org.bukkit.World;
import org.bukkit.World.Environment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;






public class aggroPigmen extends JavaPlugin implements Listener{
	public static aggroPigmen plugin;
	public static final Logger log = Logger.getLogger("Minecraft");
	
	
	
	@Override
	public void onEnable() {
		// TODO Insert what happens on plugin enable
		getLogger().info("AggroPigmen is loaded!");
	}		
	
	private Player target;		
				
	
	@SuppressWarnings("null")
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
			if (!world.getEnvironment().equals(Environment.NETHER)){
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
		
	@Override
	public void onDisable() {
		// TODO Insert what happens on plugin Disable
		getLogger().info("AggroPigmen are disabled!");
	}
}

