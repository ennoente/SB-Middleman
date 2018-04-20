package bootstrap;

import cc.CorpseCollector;
import content.ContentSlurper;
import etc.Config;
import net.Server;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Main startup/boot class.
 *
 * The main goal is to setup the environment and all connections, which involves:
 *      1. Setting up the Logger (TODO 10.04.2018)
 *      2. Setting up all directories
 *      3. Reading from config.properties (creating a default one, if it not already exists)
 *      4. Open/Setup JDBC connection
 *      5. Starting the cc collector Thread
 *      6. Starting the content slurper Thread
 *      7. Starting the networking Thread
 */
public class Startup {
    private static final File SERVER_ROOT_DIR = new File("/srv/SB Middleman/");
    private static final File CONF_FILE = new File(SERVER_ROOT_DIR, "config.properties");
    private static final File DATABASE_FILE = new File(SERVER_ROOT_DIR, "blackboard.db");

    public static void main(String[] args) {
        setupServerDirectories();
        readAndSetupConfiguration();
        setupDatabaseConnection();

        CorpseCollector.startThread();
        ContentSlurper.startThread();
        Server.startThread();
    }

    /**
     * Creates all directories for the server and logs if successful.
     */
    private static void setupServerDirectories() {
        System.out.println("Created /srv/SB Middleman/: " + SERVER_ROOT_DIR.mkdirs() + ", directory exists: " + SERVER_ROOT_DIR.exists());
    }


    private static void readAndSetupConfiguration() {
        Properties props = new Properties();

        // Put in default values
        props.put(Config.TIME_INTERVAL_FETCHES, "30");
        props.put(Config.TIME_INTERVAL_CORPSE_COLLECTION_CYCLES, "20");
        props.put(Config.NET_PORT, "1337");

        try {
            System.out.println("Created Configuration file at " + CONF_FILE.getAbsolutePath() + ": " + CONF_FILE.createNewFile());

            props.load(new FileInputStream(CONF_FILE));
            props.store(new FileOutputStream(CONF_FILE), null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Config.setConfiguration(props);
    }


    /**
     * Initializes the connectino to the JDBC driver (SQLite) and passes
     * the connection object to the sql classes responsible for dealing with
     * all database operations
     */
    private static void setupDatabaseConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:" + DATABASE_FILE.getAbsolutePath());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
