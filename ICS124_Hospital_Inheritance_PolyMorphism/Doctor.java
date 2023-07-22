/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

/**
 * The Doctor class inherits from Employee and declares a public String variable
 * specialty
 *
 * @author C0530980
 */
public class Doctor extends Employee {

    public String specialty;

    /**
     * Four argument constructor for Doctor. Calls the super constructor and
     * passes unit, givenName and surname. Sets this instance's specialty to
     * that supplied, and sets annual salary to 250000 by default.
     *
     * @param unit
     * @param specialty
     * @param givenName
     * @param surname
     */
    public Doctor(String unit, String specialty, String givenName, String surname) {
        super(unit, givenName, surname);
        this.specialty = specialty;
        this.annualSalary = 250000;
    }

    /**
     * Override for toString to match the format: "Dr. Brenda Freeman (ID# 0023)
     * (Podiatry)". Returns "Dr." then appends output of superclass toString,
     * and appends their specialty.
     *
     * @return String output with Doctor's details.
     */
    @Override
    public String toString() {
        return "Dr. " + super.toString() + " (" + specialty + ")";
    }

    public static void main(String[] args) {
        // Create a Doctor instance for testing
        Doctor doctor = new Doctor("Emergency", "Brain Surgery", "Alex", "Diaz");
        System.out.println(doctor.toString());
        System.out.println(doctor.getAnnualSalary());
        
    }

}
