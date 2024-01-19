import java.util.ArrayList;
import java.util.Scanner;

public class ContactList {
    ArrayList<Person> contacts;
    // Constructor
    public ContactList() {
        contacts = new ArrayList<Person>();
    }

    // Getter for the contactList
    public ArrayList<Person> getContacts() {
        return contacts;
    }

    // Request data about a contact from the user depending on which type they choose, then add it to the contactList
    public void createContact(int personType) {
        Scanner s = new Scanner(System.in);
        System.out.println("Please fill in the following information.");
        System.out.println("First Name:");
        String firstName = s.nextLine();
        System.out.println("Last Name:");
        String lastName = s.nextLine();
        System.out.println("Phone Number:");
        String number = s.nextLine();
        if (personType == 1) {
            // Just a regular Person contact
            contacts.add(new Person(firstName, lastName, number));
        } else if (personType == 2) {
            // A Student contact
            int grade = 0;
            do {
                System.out.println("Grade");
                grade = s.nextInt();
                s.nextLine();
            } while (grade < 1 || grade > 12);
            contacts.add(new Student(firstName, lastName, number, grade));
        }  else if (personType == 3) {
            // An Athlete contact
            System.out.println("Sport:");
            String sport = s.nextLine();
            contacts.add(new Athlete(firstName, lastName, number, sport));
        }
    }

    // Bubble sort depending on which piece of data were sorting on
    public void sort(int sortBy) {
        for (int i = 0; i < contacts.size(); i++) {
            for (int j = 0; j < contacts.size()- i - 1; j++) {
                String item1 = "";
                String item2 = "";
                if (sortBy == 0) {
                    // Sort by first name
                    item1 = contacts.get(j).getFirstName();
                    item2 = contacts.get(j + 1).getFirstName();
                } else if (sortBy == 1) {
                    // Sort by last name
                    item1 = contacts.get(j).getLastName();
                    item2 = contacts.get(j + 1).getLastName();
                } else if (sortBy == 2) {
                    // Sort by phone number
                    item1 = contacts.get(j).getPhoneNumber();
                    item2 = contacts.get(j + 1).getPhoneNumber();
                }
                int result = item1.compareTo(item2);
                if (result > 0) {
                    // num2 is first
                    swap(j);
                }
                // Otherwise they're equal numbers, or they're in the right order and all good
            }
        }
    }
    // Private method to swap two consecutive positions in the arrayList
    private void swap(int location) {
        Person p = contacts.get(location);
        contacts.set(location, contacts.get(location + 1));
        contacts.set(location + 1, p);
    }

    // Prints out people, and will only print students if the boolean argument is true by using insanceof
    public void printPeople(boolean onlyStudents) {
        for (Person person : contacts) {
            if (onlyStudents) {
                if (person instanceof Student) {
                    System.out.println(person);
                }
            }
            else {
                System.out.println(person);
            }
        }
    }

    // Program to search the contacts for the first instance of the inputted name, returning a Person object and null
    // if no matches
    public Person searchByFirstName(String firstName) {
        for (Person p : contacts) {
            if (p.getFirstName().equals(firstName)) {
                return p;
            }
        }
        return null;
    }
    // Program to search the contacts for the first instance of the inputted last name, returning a Person object and null
    // if no matches
    public Person searchByLastName(String lastName) {
        for (Person p : contacts) {
            if (p.getLastName().equals(lastName)) {
                return p;
            }
        }
        return null;
    }
    // Program to search the contacts for the first instance of the inputted phone number, returning a Person object and null
    // if no matches
    public Person searchByPhoneNumber(String phoneNumber) {
        for (Person p : contacts) {
            if (p.getPhoneNumber().equals(phoneNumber)) {
                return p;
            }
        }
        return null;
    }

    // Prints the options a user could pick after a separator
    public void printMenu() {
        System.out.println("---------------------------------------");
        System.out.println("Menu:");
        System.out.println("1. Add Contact");
        System.out.println("2. List All Contacts By First Name");
        System.out.println("3. List All Contacts By Last Name");
        System.out.println("4. List All Contacts By Phone Number");
        System.out.println("5. List All Students");
        System.out.println("6. Search By First Name");
        System.out.println("7. Search By Last Name");
        System.out.println("8. Search By Phone Number");
        System.out.println("0. Exit");
        System.out.println("Select an option:");
    }

    // Method to ask for user input until killed with '0'
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 0) {
                // 0. Exit
                System.out.println("buh bye");
                return;
            } else if (choice == 1) {
                // 1. Add Contact
                int type = 1;
                do {
                    System.out.println("Select a type of contact to add");
                    System.out.println("1. Person");
                    System.out.println("2. Student");
                    System.out.println("3. Athlete");
                    type = scanner.nextInt();
                    scanner.nextLine();
                } while (type < 1 || type > 3);
                createContact(type);
            } else if (choice == 2) {
                // 2. List All Contacts By First Name
                sort(0);
                // Print everyone
                printPeople(false);
            } else if (choice == 3) {
                // 3. List All Contacts By Last Name
                sort(1);
                printPeople(false);
            } else if (choice == 4) {
                // 4. List All Contacts By Phone Number
                sort(2);
                printPeople(false);
            } else if (choice == 5) {
                // 5. List All Students
                printPeople(true);
            } else if (choice == 6) {
                // 6. Search By First Name
                System.out.println("Enter a name:");
                String name = scanner.nextLine();
                Person person = searchByFirstName(name);
                // If there is a match, print the Person
                if (person != null) {
                    System.out.println(person);
                }
                else {
                    // Otherwise alert the user
                    System.out.println(name + " is not in your contacts");
                }
            } else if (choice == 7) {
                // 7. Search By Last Name
                System.out.println("Enter a last name:");
                String lastName = scanner.nextLine();
                Person person = searchByLastName(lastName);
                if (person != null) {
                    System.out.println(person);
                }
                else {
                    System.out.println("Nobody in your contacts has the last name " + lastName);
                }
            } else if (choice == 8) {
                // 8. Search By Phone Number
                System.out.println("Enter a number:");
                String number = scanner.nextLine();
                Person person = searchByPhoneNumber(number);
                if (person != null) {
                    System.out.println(person);
                }
                else {
                    System.out.println("Nobody in your contacts has the number " + number);
                }
            }
        }
    }

    public static void main(String[] args) {
        ContactList contact = new ContactList();
        contact.run();
    }
}
