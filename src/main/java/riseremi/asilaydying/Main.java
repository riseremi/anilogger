package riseremi.asilaydying;

/**
 *
 * @author riseremi
 */
public class Main {

    private static Poller poller;

    public static void main(String[] args) {
        String arg = args[0];
        boolean debug = "--debug".equals(arg);

        poller = new Poller(debug);
        poller.start();
    }
}
