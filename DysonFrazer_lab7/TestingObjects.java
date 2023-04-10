package DysonFrazer_lab7;

/**
 *
 * @author C0530980
 */
public class TestingObjects {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        pointTest();
        pointTestCoord();
        distanceFromCoordTest();
        distanceFromPointTest();
        testToString();
        testPerson1();
        testPerson2();
        testsayHelloTo1();
        testsayHelloTo2();
        testPersontoString();
        testCar();
        testdrive();
        testCartoString();
        testAcademicRecord();
        testAcademicRecordArray();
        testArrayInit();
    }
    /**
     * 
     * @param actual
     * @param expected
     * Method to test an objects actual value vs expected, to shorten unit tests
     */
    public static void assertEquals(Number actual, Number expected) {
        if (actual.equals(expected)) {
            System.out.println("passed with " + actual + "\n");
        } else {
            System.out.println("FAILED: expected " + expected +
                " got " + actual);
        }
    }
    /**
     * 
     * @param actual
     * @param expected
     * Method to test an objects actual boolean vs expected, to shorten unit tests
     */
    public static void assertEquals(Boolean actual, Boolean expected) {
        if (actual.equals(expected)) {
            System.out.println("passed\n");
        } else {
            System.out.println("FAILED: expected " + expected +
                " got " + actual);
        }
    }

    /**
     * Method to test the no arg constructor, and test whether X and Y were set to 0.0
     */
    public static void pointTest() {
        Point Point1 = new Point();
        System.out.println("X Coordinate initialized to Zero: ");
        assertEquals(Point1.X, 0.0);

        System.out.println("Y Coordinate initialized to Zero: ");
        assertEquals(Point1.Y, 0.0);

    }

    /**
     * Method to test the 2 Argument Constructor for Point
     */
    public static void pointTestCoord() {
        Point PointC = new Point(1.0, 2.5);
        System.out.println("X Coordinate set to 1.0: ");
        assertEquals(PointC.X, 1.0);
        System.out.println("Y Coordinate set to 2.5: ");
        assertEquals(PointC.Y, 2.5);
    }

    /**
     * Method to test the distanceFrom given X,Y coordinates as parameters
     */
    public static void distanceFromCoordTest() {
        Point P1 = new Point(0.0, 0.0);
        Point P2 = new Point(3.0, 4.0);
        double distanceExpected = 5.0;
        double distanceActual = P1.distanceFrom(P2.X, P2.Y);
        System.out.println("Distance from 0,0 to 3.0,4.0, expected 5.0: ");
        assertEquals(distanceActual, distanceExpected);

    }

    /**
     * Method to test the distanceFrom given a point as parameter. 
     */
    public static void distanceFromPointTest() {
        Point P1 = new Point(0.0, 0.0);
        Point P2 = new Point(3.0, 4.0);
        double distanceExpected = 5.0;
        double distanceActual = P2.distanceFrom(P1);
        System.out.println("Distance from 0,0 to 3.0,4.0 (Given as Point), expected 5.0: ");

        assertEquals(distanceActual, distanceExpected);

    }
    /**
     * Method to test Overriden toString method. If expected string is not equal to actual string, test fails.
     */
    public static void testToString() {
        Point P1 = new Point(7.0, 9.0);
        String expectedString = "Point: [7.0, 9.0]";
        String actualString = P1.toString();
        System.out.println("Testing toString Override, output format as expected?: ");
        assertEquals((expectedString.equals(actualString)), true);

    }
    /**
     * Test method for Person constructor taking two inputs. If first name and last name are not equal to expected (passed as parameters), test fails.
     */
    public static void testPerson1() {
        Person Person1 = new Person("Frazer", "Dyson");
        System.out.println("First name correctly assigned: ");
        assertEquals((Person1.firstName.equals("Frazer")), true);
        System.out.println("Last name correctly assigned: ");
        assertEquals((Person1.lastName.equals("Dyson")), true);

    }
    /**
     * test for Person constructor taking three arguments. Check whether firstName, lastName and ID are correctly assigned.
     */
    public static void testPerson2() {
        Person Person1 = new Person("Frazer", "Dyson", "666");
        System.out.println("First name correctly assigned: ");

        assertEquals((Person1.firstName.equals("Frazer")), true);
        System.out.println("Last name correctly assigned: ");

        assertEquals((Person1.lastName.equals("Dyson")), true);
        System.out.println("ID correctly assigned: ");

        assertEquals((Person1.ID.equals("666")), true);
    }
    /**
     * test method for sayHelloTo() when passed two strings as arguments. Prints result for manual comparison
     */
    public static void testsayHelloTo1() {
        Person Person1 = new Person("Frazer", "Dyson");
        System.out.println("Is Output correct format: 'Hi Kris, my name is Frazer?'\n ");
        Person1.sayHelloTo("Kris");
    }
    /** 
     * test method for sayHelloTo() when passed a Person as argument. Prints result for manual comparison
     */
    public static void testsayHelloTo2() {
        Person Person1 = new Person("Frazer", "Dyson");
        Person Person2 = new Person("Jack", "Dorsey");
        System.out.println("\nIs Output correct format: Hi Jack, my name is Frazer?:");
        Person1.sayHelloTo(Person2);
    }
    /**
     * tests toString() ovveride for Person. prints results for manual comparison.
     */
    public static void testPersontoString() {
        Person Person1 = new Person("Frazer", "Dyson", "C0530980");
        System.out.println("\nCompare toString Output to expected format: Person: Frazer Dyson C0530980");
        System.out.println(Person1.toString());
    }
    /**
     * Tests Car constructor when passed two strings and an int. Checks to see if make, model and year are assigned correctly and default odometer is zero.
     */
    public static void testCar() {
        Car ronda = new Car("Honda", "Civic", 2004);
        System.out.println("\nMake is Honda: ");
        assertEquals(ronda.make.equals("Honda"), true);
        System.out.println("Model is Civic: ");

        assertEquals(ronda.model.equals("Civic"), true);
        System.out.println("Year is 2004: ");

        assertEquals(ronda.year, 2004);

        System.out.println("Is the Odometer Set to Zero?");
        assertEquals(ronda.odometer, (long) 0);

    }
    /**
     * test that the Car drive() method by checking whether odometer is correctly updated with given parameter.
     */
    public static void testdrive() {
        Car ronda = new Car("Honda", "Civic", 2004);
        ronda.drive(3400);
        System.out.println("Is Odometer updated to 3400? ");

        assertEquals(ronda.odometer, (long) 3400);
    }
    /**
     * test the Car toString Override, prints result for comparison to expected output
     */
    public static void testCartoString() {
        Car ronda = new Car("Honda", "Civic", 2004);
        System.out.println("toString Override is expected to output: 'Car: 2004 Honda Civic' ");
        System.out.println(ronda.toString());
    }
    /**
     * Creates a new Person and new Academic Record for that person. Tests whether major is initialized as 
     * "undeclared", year is initialized as 1, checks whether grades array was initialized with zeros
     * then fills grades with all 90's and tests whether calculate Average gives back 90, and calculateLetterGrade
     * returns an A+. Finally, this method tests the toString() override for AcademicRecord by printing for manual comparison.
     * 
     */
    public static void testAcademicRecord() {
        Person person1 = new Person("Frazer", "Dyson");
        AcademicRecord rec1 = new AcademicRecord(person1);
        System.out.println("\nis Major undeclared?");
        assertEquals(rec1.major.equals("undeclared"), true);
        System.out.println("Is year set to 1?");
        assertEquals(rec1.year, (short) 1);
    }

    public static void testAcademicRecordArray() {
        Person person1 = new Person("Frazer", "Dyson");
        AcademicRecord rec1 = new AcademicRecord(person1);
        for (int i = 0; i < rec1.grades.length; i++) {
            rec1.grades[i] = 90;
        }
        System.out.println("\nIs Average 90? ");
        assertEquals(rec1.calculateAverage(), (long) 90);
        System.out.println("Is Letter Grade A+?");
        assertEquals(rec1.calculateLetterGrade().equals("A+"), true);
        System.out.println("toString Override expected format: 'Academic Record: FrazerDyson undeclared A+:' ");
        System.out.println(rec1.toString());
    }

    public static void testArrayInit() {
        Person person1 = new Person("Frazer", "Dyson");
        AcademicRecord rec1 = new AcademicRecord(person1);
        boolean indexIsInitWithZero = true;
        for (int i = 0; i < rec1.grades.length; i++) {
            if (rec1.grades[i] != 0) {
                indexIsInitWithZero = false;
                break;
            }
        }
        if (indexIsInitWithZero = true) {
            System.out.println("\nArray is initialized with all Zeros");
        } else {
            System.out.println("Array is not properly initialized with all Zeros.");
        }
    }
}