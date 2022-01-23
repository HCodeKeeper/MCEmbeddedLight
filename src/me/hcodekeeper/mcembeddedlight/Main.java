package me.hcodekeeper.mcembeddedlight;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{
    private LightListener lightListener;

    @Override
    public void onEnable(){
        lightListener = new LightListener("user"); //change to listen to other player
        getServer().getPluginManager().registerEvents(lightListener, this);
        this.getCommand("getlight").setExecutor(new CommandGetLight(lightListener));
        Bukkit.getLogger().info(ChatColor.GREEN + "Enabled" + this.getName());
    }

    @Override
    public void onDisable(){
        lightListener.setToDefault();
        Bukkit.getLogger().info(ChatColor.RED + "Disabled" + this.getName());
    }
}
