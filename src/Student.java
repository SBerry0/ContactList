public class Student extends Person {
    private int grade;

    // Constructor that calls its super constructor of Person
    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }
    // Getter for private instance variable
    public int getGrade() {
        return grade;
    }
    // toString() adding the grade to Person's toString()
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
