package riseremi.asilaydying;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author riseremi
 */
public class Poller extends Thread {

    private final static long INTERVAL_DEFAULT = 5 * 60 * 1000; // 5 minutes
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

                String currentDate = getCurrentDate();

                File log = new File(getFileName(currentDate));
                if (!log.exists()) {
                    log.createNewFile();
                }
                Files.write(Paths.get(getFileName(currentDate)),
                        (newState.toLogString() + "\r\n").getBytes(), StandardOpenOption.APPEND);

                try {
                    Thread.sleep(interval);
                } catch (InterruptedException ex) {
                    System.out.println("I cannot sleep at night. They're watching me.");
                }
            } catch (IOException ex) {
                System.out.println("Error while polling: " + ex);
            }
        }
    }

    private String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        return dateFormat.format(date);
    }

    private String getFileName(String body) {
        return "logs/" + body + ".anilog";
    }
}
