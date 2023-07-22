
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab1;

/**
 * Base class of Person, which declares an int variable ID, String variables givenName and surname, and a static count variable
 * @author C0530980
 */
public class Person {

    public final int ID;
    public String givenName;
    public String surname;
    public static int count = 1;

    /**
     * Two argument constructor for Person. Sets the new instance's surname and
     * givenName to those passed as arguments. Set this instance's ID to the
     * current count value, and iterates count by 1.
     *
     * @param givenName
     * @param surname
     */
    public Person(String givenName, String surname) {
        this.givenName = givenName;
        this.surname = surname;
        this.ID = count;
        count++;
    }
    /**
     * toString method override to match the format: "John Jones (ID# 00003)"
     * if surname or givenName is null, they are not included
     * in the output.
     * @return 
     */
    @Override
    public String toString() {
        if (givenName == null) {
            return surname + " (ID# " + ID + ")";
        } else if (surname == null) {
            return givenName + " (ID# " + ID + ")";
        } else if ((surname == null) && (givenName == null)) {
            return "ID# " + ID + ")";
        } else {
            return givenName + " " + surname + " (ID# " + ID + ")";
        }
    }
    public static void main(String[] args){
        //Create Person with first and last names
        Person derek = new Person("Derek", "Zoolander");
        //manually print each instance variable
        System.out.println(derek.givenName);
        System.out.println(derek.surname);
        System.out.println(derek.ID);
        System.out.println(count);
        //try to string output
        System.out.println(derek.toString());
        //create People with null as first or last names to test toString output for null cases
        Person noName = new Person(null, "lastName");
        System.out.println(noName.toString());
        Person noName2 = new Person("firstName", null);
        System.out.println(noName2);

    }
}
