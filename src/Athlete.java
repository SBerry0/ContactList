public class Athlete extends Person {
    private String sport;
    public Athlete(String firstName, String lastName, String phoneNumber, String sport) {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }
    @Override
    public String toString() {
        return super.toString() + " Sport: " + sport;
    }
}
