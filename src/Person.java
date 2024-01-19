public class Person {
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // Constructor for regular Person
    public Person(String firstName, String lastName, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    // Getters
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // toString to print a person
    public String toString() {
        return firstName + " " + lastName + " - #" + phoneNumber;
    }
}
