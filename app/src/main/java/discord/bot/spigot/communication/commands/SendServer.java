package discord.bot.spigot.communication.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import discord.bot.spigot.communication.wise_client;

public class SendServer implements CommandExecutor {
    Player player;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player)
            player = (Player) sender;

        if (args.length > 0) {
            StringBuilder builder = new StringBuilder();
            for (String s : args) {
                builder.append(s);
                builder.append(" ");
            }

            builder.deleteCharAt(builder.toString().length() - 1);
            String str = builder.toString();
            if (sender instanceof Player)
                player.sendMessage("sent \"" + str + "\" to the server");

            builder = new StringBuilder();
            if (sender instanceof Player)
                builder.append(player.getName());
            else
                builder.append("console");
            builder.append(": ");
            builder.append(str);
            String cmd = builder.toString();
            wise_client.try_send(cmd);

        } else {
            if (sender instanceof Player)
                player.sendMessage("ERROR! message too short");
        }
        return true;
    }
}