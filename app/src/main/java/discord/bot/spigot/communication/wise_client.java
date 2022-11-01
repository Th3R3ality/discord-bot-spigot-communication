package discord.bot.spigot.communication;

import java.net.*;
import java.io.*;

public class wise_client {
    public static Socket sock = null;
    static PrintWriter out = null;

    public static boolean try_connect() {
        try {
            if (out != null)
                out.close();
            out = null;

            if (sock != null)
                sock.close();
            sock = null;

            sock = new Socket("localhost", 6969);
            out = new PrintWriter(sock.getOutputStream());
            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean try_send(String msg) {
        if (sock != null && out != null) {
            out.println(msg);
            out.flush();
            return true;
        } else {
            return false;
        }

    }

    public static boolean try_close() {
        try {
            out.close();
            sock.close();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}