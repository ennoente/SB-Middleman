package bootstrap;

import java.io.File;

/**
 * Main startup/boot class.
 * Main goal is to setup the environment and all connections:
 *      1. Setting up the Logger
 *      2. Setting up all directories
 *      3. Reading from config.properties
 *      4. JDBC connection
 *      5. Starting the networking Thread
 *      6. Starting the corpse collector Thread
 *      7. Starting the content slurper Thread
 */
public class Startup {

    public static void main(String[] args) {

        setupServerDirectories();
    }

    /**
     * Creates all directories for the server and logs if successful.
     */
    private static void setupServerDirectories() {
        final File SERVER_ROOT_DIR = new File("/srv/SB Middleman/");
        final File LOGGING_DIR = new File("/var/log/SB Middleman");

        

    }
}
