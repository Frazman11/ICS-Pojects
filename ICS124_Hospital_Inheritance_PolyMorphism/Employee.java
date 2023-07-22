/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

/**
 * Class Employee which inherits from Person. Declares a public String unit and a protected int for annualSalary
 * @author C0530980
 */
public class Employee extends Person {
    public String unit;
    public int annualSalary;
    /**
     * Three argument constructor for Employee.Calls super constructor and passes
 givenName and surname as arguments.Assigns supplied unit to this instance's unit.
     * @param unit
     * @param givenName
     * @param surname 
     */
    public Employee(String unit, String givenName, String surname){
        super(givenName, surname);
        this.unit = unit;
        
    }
    /**
     * getter method to return annualSalary
     * @return this.annualSalary
     */
    public int getAnnualSalary(){
        return this.annualSalary;
    }
public static void main(String[] args) {
    // Create an Employee instance for testing
    Employee employee = new Employee("Emergency", "Nathan", "Nunez");
    System.out.println(employee.toString());
//    employee.annualSalary = 65000;
    System.out.println(employee.getAnnualSalary());

}

}
