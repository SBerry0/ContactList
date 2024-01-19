public class Athlete extends Person {
    private String sport;
    // Constructor calling the super constructor of Person
    public Athlete(String firstName, String lastName, String phoneNumber, String sport) {
        super(firstName, lastName, phoneNumber);
        this.sport = sport;
    }

    // Getter for the sport
    public String getSport() {
        return sport;
    }

    // toString() adding on the Athlete's sport in addition to Person's toString()
    @Override
    public String toString() {
        return super.toString() + " Sport: " + sport;
    }
}
