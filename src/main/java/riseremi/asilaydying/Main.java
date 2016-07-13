package riseremi.asilaydying;

/**
 *
 * @author riseremi
 */
public class Main {

    private static Poller poller;
    private static boolean debug = false;

    public static void main(String[] args) {
        if (args.length > 0) {
            String arg = args[0];
            debug = "--debug".equals(arg);
        }

        poller = new Poller(debug);
        poller.start();
    }
}
