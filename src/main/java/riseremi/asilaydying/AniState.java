package riseremi.asilaydying;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/**
 *
 * @author riseremi
 */
public class AniState {

    private int users;
    private int guests;

    AniState(int users, int guests) {
        this.users = users;
        this.guests = guests;
    }

    public int getUsers() {
        return users;
    }

    public void setUsers(int users) {
        this.users = users;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    private String getCurrentDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd, HH:mm:ss");
        Date date = new Date();

        return dateFormat.format(date);
    }

    @Override
    public String toString() {
        return getCurrentDateTime() + "\r\nUsers: " + this.users + ", "
                + "Guests: " + this.guests + "\r\n";
    }

    public String toLogString() {
        JSONObject state = new JSONObject();
        state.put("users", this.users);
        state.put("guests", this.guests);
        state.put("timestamp", System.currentTimeMillis());

        return state.toString();
    }

}
