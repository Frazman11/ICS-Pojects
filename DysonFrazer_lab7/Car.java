package DysonFrazer_lab7;

/**
 * class declaration for Car, declares Strings make and model, int year of manufacture, owner of type person, and odometer number of type long.
 */
public class Car {

    public String make, model;
    public int year;
    public Person owner;
    public long odometer;

    /**
     * Three argument constructor definition for car, takes strings make and model, and in year as parameters, and sets this car's attributes to those values. 
     * @param make
     * @param model
     * @param year
     */
    public Car(String make, String model, int year){
        this.make = make;
        this.model = model;
        this.year = year;
        this.odometer = 0;
        
    }

    /**
     * Method that defines the drive behaviour for Car. Takes a distance as a long as parameter. Updates the odometer with the distance provided. Odomoter will accumulate if multiple drives are called on same car. 
     * @param distance
     * @return
     */
    public long drive(long distance){
        System.out.println("Vroooom!");
        this.odometer += distance;
        return odometer;
    }

    /**
     * Ovveride for toString() to format output to Car: Year Make Model.
     */
    @Override
    public String toString(){
        return "Car: " + year + " " + make + " " + model;
    }
}
