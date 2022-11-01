package discord.bot.spigot.communication;

import java.io.*;
import java.net.*;

import org.bukkit.Bukkit;

public class wise_server implements Runnable {
    public static ServerSocket server_sock = null;
    static Socket client_sock = null;
    static BufferedReader in = null;
    static boolean should_listen = true;
    static Thread listen_thread = null;

    public static boolean try_start() {
        try {
            server_sock = new ServerSocket(1337);
            wise_server server = new wise_server();
            listen_thread = new Thread(server);
            listen_thread.start();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public void run() {
        try {
            client_sock = server_sock.accept();
            System.out.println("wise_server connected");
            in = new BufferedReader(new InputStreamReader(client_sock.getInputStream()));
        } catch (IOException e1) {
            e1.printStackTrace();
            return;
        }
        String input;
        try {
            while ((input = in.readLine()) != null) {
                System.out.println(input);
                Bukkit.getServer().broadcastMessage(input);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public static boolean try_stop() {
        try {
            in.close();
            client_sock.close();
            server_sock.close();
            should_listen = false;
            listen_thread.join();
            return true;
        } catch (IOException | InterruptedException e) {
            return false;
        }
    }
}