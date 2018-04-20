package content;

/**
 * Retrieves the SB website and filters out the relevant content
 */
public class ContentSlurper implements Runnable {
    private static boolean isRunning = false;

    public void run() {

    }

    public static void startThread() {
        if (!isRunning) {
            System.out.println("Starting Content Slurper thread...");
            new Thread(new ContentSlurper()).start();
            isRunning = true;
        }
    }
}
