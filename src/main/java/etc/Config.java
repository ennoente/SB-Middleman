package etc;

import java.util.Properties;

/**
 *
 * Helper class for a centralized and easy access to the server's
 * configuration.
 *
 * @author Enno Thoma, 10.04.2018
 *
 */
public class Config {

    /** The interval between website fetches from the content slurper, in seconds */
    public static final String TIME_INTERVAL_FETCHES = "interval_fetches";

    /** The interval between cc collection cycles, in seconds */
    public static final String TIME_INTERVAL_CORPSE_COLLECTION_CYCLES = "interval_cc_cycles";

    /** The port inhabited by the server which clients connect to */
    public static final String NET_PORT = "net_port";

    private static Properties conf = new Properties();

    /**
     * Returns the time interval between website fetches from the content slurper.
     *
     * @return The time interval between website fetches from the content slurper.
     */
    public static int getTimeIntervalFetch() {
        return Integer.parseInt((String) conf.get(TIME_INTERVAL_FETCHES));
    }


    /**
     * Returns the time interval between cc collection cycles.
     *
     * @return The time interval between cc collection cycles.
     */
    public static int getTimeIntervalCorpseCollection() {
        return Integer.parseInt((String) conf.get(TIME_INTERVAL_CORPSE_COLLECTION_CYCLES));
    }


    /**
     * Returns the port used by the server, more specifically, the ServerSocket responsible
     * for client communication, located in the net package.
     *
     * @return The port used by the server.
     */
    public static int getNetPort() {
        return Integer.parseInt((String) conf.get(NET_PORT));
    }


    /**
     * Sets the properties of the class Config to the passed properties object.
     *
     * @param properties The properties of the project
     */
    public static void setConfiguration(Properties properties) {
        conf = properties;
    }


}
