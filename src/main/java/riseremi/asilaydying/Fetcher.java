package riseremi.asilaydying;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 *
 * @author riseremi
 */
public class Fetcher {

    private final static String TARGET_URL = "http://annimon.com/";

    public static AniState fetch() throws IOException {
        Document doc;
        doc = Jsoup.connect(TARGET_URL).get();

        Element onlineElement = doc.select(".footer").first();

        String[] online = onlineElement.text().split("\\(")[1].split("\\/");
        int users = Integer.parseInt(online[0], 10);

        String guestsStr = online[1];
        guestsStr = guestsStr.substring(0, guestsStr.length() - 1);
        int guests = Integer.parseInt(guestsStr, 10);

        return new AniState(users, guests);
    }

}
