package discord.bot.spigot.communication;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Listeners implements Listener {
    public static Server plugin;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        StringBuilder builder = new StringBuilder();
        builder.append("\\");
        builder.append(Bukkit.getOnlinePlayers().size());
        String cmd = builder.toString();
        wise_client.try_send(cmd);

        builder = new StringBuilder();
        builder.append(Bukkit.getOnlinePlayers().size());
        String str = builder.toString();
        Bukkit.getServer().broadcastMessage(ChatColor.GREEN + str);

    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        StringBuilder builder = new StringBuilder();
        builder.append("\\");
        builder.append(Bukkit.getOnlinePlayers().size() - 1);
        String cmd = builder.toString();
        wise_client.try_send(cmd);

        builder = new StringBuilder();
        builder.append(Bukkit.getOnlinePlayers().size() - 1);
        String str = builder.toString();
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + str);

    }
}
