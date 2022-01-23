package me.hcodekeeper.mcembeddedlight;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandGetLight implements CommandExecutor {
    private LightListener listener;

    public CommandGetLight(LightListener listener){
        this.listener = listener;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(listener.getLightLevel());
        return true;
    }
}
