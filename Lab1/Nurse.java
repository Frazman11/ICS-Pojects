/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

/**
 * Nurse class inherits from Employee, and declares final constants for salary based on shiftA-C, and a private int shift.
 * @author C0530980
 */
public final class Nurse extends Employee {
    public final static int SHIFT_A = 1;
    public final static int SHIFT_B = 2;
    public final static int SHIFT_C = 3;
    private int shift;
    /**
     * Three argument constructor for Nurse, that takes String unit, String givenName and String surname as parameters. 
     * Calls the super constructor and passes all three values, then assigns this shift to shiftA by default.
     * @param unit
     * @param givenName
     * @param surname 
     */
    public Nurse(String unit, String givenName, String surname){
        super(unit, givenName, surname);
        this.setShift(SHIFT_A);
    }
    /**
    * Sets the shift of the employee and updates the annual salary based on the shift.
    * Valid shift values are 1, 2, and 3.
    *
    * @param shift the shift value to set
    */
    public void setShift(int shift){
        this.shift = shift;
        switch(shift){
            case 1 -> this.annualSalary = 80000;
            case 2 -> this.annualSalary = 85000;
            case 3 -> this.annualSalary = 90000;
        }
        
    }
    /**
     * Gets the nurse's shift
     * @return shift
     */
    public int getShift(){
        return shift;
    }
    /**
     * Override for the toString method to match the format: "Martha McGee (ID# 1234) (Radiology unit, shift 5). 
     * Calls the superclass toString method, and appends Nurse's unit and shift details.
     * @return String output with all of Nurse's details.
     */
    @Override
    public String toString(){
        return super.toString() + "(" + unit + " unit, shift " + shift + ")";
    }
    
    public static void main(String[] args){
        //create a Nurse and assign shift A
        Nurse ethan = new Nurse("terminal","Ethan", "Smith");
        ethan.setShift(SHIFT_A);
        //Print salary and toString to verify details
        System.out.println(ethan.annualSalary);
        System.out.println(ethan);
        //create another nurse and assign different shift, then print details to verify
        Nurse nurse2 = new Nurse("Emergency", "Brad", "Williams");
        nurse2.setShift(SHIFT_B);
        System.out.println(nurse2.getShift());
        System.out.println(nurse2);
        System.out.println(nurse2.annualSalary);
    }
    
}
