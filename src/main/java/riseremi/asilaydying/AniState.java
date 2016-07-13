package riseremi.asilaydying;

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

    @Override
    public String toString() {
        return "Users: " + this.users + "\r\n"
                + "Guests: " + this.guests + "\r\n";
    }

}
