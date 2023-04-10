package DysonFrazer_lab7;

/**
 * Class declaration for Person. Declares String variables of ID, firstName and lastName.
 */
public class Person {

    public String ID;
    public String firstName;
    public String lastName;
    /**
     * Constructor for Person when given A First and Last Name as parameters. For creating an instance of person, assigning names and creating an ID by concatenating given names.
     *
     * @param firstName
     * @param lastName
     */
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = firstName + lastName;

    }
    /**
     * Constructor for Person when given A First and Last Name and an ID as parameters. For creating an instance of person, assigning names and creating an ID 
     * @param firstName
     * @param lastName
     * @param ID
     *
     */
    public Person(String firstName, String lastName, String ID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;

    }
    /**
     * Prints a greeting message to "Name" given as parameter, massage is from the Person from which the method is called
     * @param Name
     */
    public void sayHelloTo(String Name) {
        System.out.println("Hi " + Name + ", my name is " + this.firstName);
    }
    /**
     * Prints a greeting to Person given as parameter, message is from the Person in which the method was called.
     * @param Person
     * @param Person2
     */
    public void sayHelloTo(Person Person2) {
        sayHelloTo(Person2.firstName);
    }

    /**
     * Manual Override of default Object toString Method, to output a specific format of "Person: John Smith (C9999999), age 12".
     * @return "Person: firstName lastName ID".
     */
    @Override
    public String toString() {
        return "Person: " + firstName + " " + lastName + " " + ID;
    }

}