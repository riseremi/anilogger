package riseremi.asilaydying;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author riseremi
 */
public class Poller extends Thread {

    private final static long INTERVAL_DEFAULT = 15 * 60 * 1000; // 15 minutes
    private final static long INTERVAL_DEBUG = 5 * 1000; // 5 seconds
    private static long interval;

    Poller(boolean debug) {
        Poller.interval = debug ? INTERVAL_DEBUG : INTERVAL_DEFAULT;
    }

    @Override
    public void run() {
        while (true) {
            try {
                final AniState newState = Fetcher.fetch();
                System.out.println(newState.toString());
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException ex) {
                    System.out.println("I cannot sleep at night. They're watching me.");
                }
            } catch (IOException ex) {
                System.out.println("Error while polling.");
            }
        }
    }
}
