package me.hcodekeeper.mcembeddedlight;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import java.io.FileWriter;
import java.io.IOException;

public class LightListener implements Listener {
    private LightLogger lightLogger = new LightLogger("D:\\MCLightC\\Light.txt");
    private String playerToListen;
    //in such way it's only possible to track a single player's light level at a time
    private String lightLevel = "-1";

    public LightListener(String playerToListen){
        this.playerToListen = playerToListen;
    }

    @EventHandler
    public void onPlayerLightChange(PlayerMoveEvent plMoveE){
        if(!(playerToListen.equals(plMoveE.getPlayer().getName()))){
            try(FileWriter fw = new FileWriter("D:\\Github\\MCEmbeddedLight\\LOG.txt")){
                fw.write("ARR");
            }
            catch (IOException e){

            }
            return;
        }
        Location playerDestination = plMoveE.getTo();
        World world = playerDestination.getWorld();
        if (world != null){
            Block block = world.getBlockAt(playerDestination.getBlockX(), playerDestination.getBlockY() + 1,
                    playerDestination.getBlockZ());
            this.lightLevel = Integer.toString(Byte.toUnsignedInt(block.getLightLevel()));
        }
    }

    public void setToDefault(){
        lightLogger.update("0");
    }

    public String getLightLevel(){
        return this.lightLevel;
    }
}
