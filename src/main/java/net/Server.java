package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * The Server class povides the ServerSocket for clients to
 * connect to this application / service.
 * For every client a new thread handling the connection to said client
 * is started.
 */
public class Server implements Runnable {
    private static boolean isRunning = false;

    /** Don't let anyone from the outside instantiate this class */
    private Server() { }

    public void run() {
        try {
            ServerSocket server = new ServerSocket(1337);
            Socket connection;
            while (isRunning) {
                connection = server.accept();
                System.out.println("New connection made");
                new Thread(new NetWorker(connection)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Starts the server's thread.
     * Makes sure that only one thread may run at a time
     */
    public static void startThread() {
        if (!isRunning) {
            System.out.println("Starting networking thread...");
            isRunning = true;
            new Thread(new Server()).start();
        }
    }

    public static void stopServer() {
        isRunning = false;
    }
}
