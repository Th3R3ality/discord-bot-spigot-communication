package discord.bot.spigot.communication.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import discord.bot.spigot.communication.wise_client;

public class TryConnect implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (wise_client.sock == null && wise_client.try_connect()) {
            sender.sendMessage("successfully connected to wise_client");
            System.out.println("successfully connected to wise_client");
        } else {
            sender.sendMessage("couldn't connect to wise_client");
            System.out.println("couldn't connect to wise_client");
        }

        return true;
    }
}
