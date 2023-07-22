/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

/**
 * Patient class inherits from Person and declares a physician of type Doctor.
 * @author C0530980
 */
public class Patient extends Person{
    public Doctor physician;
    /**
     * Three argument constructor for Patient which takes givenName, surname and physician. Calls superclass constructor and
     * supplies givenName and surname as parameters, then assigns this patient's physician with the Doctor provided. 
     * @param givenName
     * @param surname
     * @param physician 
     */
    public Patient(String givenName, String surname, Doctor physician){
        super(givenName, surname);
        this.physician = physician;
    }
    public int getID(){
        return this.ID;
    }
public static void main(String[] args) {
    // Create a Doctor instance for testing
    Doctor doctor = new Doctor("Emergency", "Brain Surgery", "Alex", "Baldwin");

    // Create Patient instances
    Patient patient1 = new Patient("Toby", "Handford", doctor);
    Patient patient2 = new Patient("Kieran", "Avlonitis", doctor);
    Patient patient3 = new Patient("Ethan", "Smith", doctor);

    // Print the details of the patients
    System.out.println(patient1.toString());
    System.out.println(patient2.toString());
    System.out.println(patient3.toString());
    System.out.println(patient1.physician);
}

}

