package discord.bot.spigot.communication;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import discord.bot.spigot.communication.commands.SendServer;
import discord.bot.spigot.communication.commands.TryConnect;

public final class wise_mystical_tree extends JavaPlugin {

    @Override
    public void onEnable() {
        this.getCommand("connect").setExecutor(new TryConnect());
        this.getCommand("send").setExecutor(new SendServer());

        Bukkit.getServer().getPluginManager().registerEvents(new Listeners(), this);

        if (wise_server.try_start()) {
            // sender.sendMessage("successfully started to wise_server");
            System.out.println("successfully started to wise_client");
        } else {
            // sender.sendMessage("couldn't start to wise_server");
            System.out.println("couldn't start to wise_client");
        }
    }

    @Override
    public void onDisable() {
        if (wise_client.try_close()) {
            System.out.println("successfully closed wise_client");
        } else {
            System.out.println("couldn't close wise_client");
        }
        if (wise_server.try_stop()) {
            System.out.println("successfully stopped wise_server");
        } else {
            System.out.println("couldn't stop wise_server");
        }
    }
}
