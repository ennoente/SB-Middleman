package bootstrap;

import java.io.File;

/**
 * Main startup/boot class.
 *
 * The main goal is to setup the environment and all connections, which involves:
 *      1. Setting up the Logger (TODO 10.04.2018)
 *      2. Setting up all directories
 *      3. Reading from config.properties (creating a default one, if it not already exists)
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
        System.out.println("Created /srv/SB Middleman/: " + SERVER_ROOT_DIR.mkdirs() + ", directory exists: " + SERVER_ROOT_DIR.exists());
    }
}
