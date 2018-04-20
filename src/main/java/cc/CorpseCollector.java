package cc;

public class CorpseCollector implements Runnable {
    private static boolean isRunning = false;

    public void run() {
    }

    public static void startThread() {
        if (!isRunning) {
            System.out.println("Starting Corpse Collector thread...");
            new Thread(new CorpseCollector()).start();
            isRunning = true;
        }
    }
}
