package DysonFrazer_lab7;

/**
 * Class declaration for AcademicRecord. Declarations for student of type person, major of type String, year as a short, and grades as a double array. 
 */
public class AcademicRecord {

    public Person student;
    public String major;
    public short year;
    public double[] grades;
    /**
     * Constructor for AcademicRecord that takes one argument, a person object with name. Sets this academic record's attributes 
     * to defaults (undeclared, year 1, grades array 10 assignment initialized to zero) and sets the name to that provided. 
     * @param name
     */
    public AcademicRecord(Person name){
        this.student = name;
        this.major = "undeclared";
        this.year = 1;
        this.grades = new double[10];
    }
    /**
     * method to calculate the average of grades in the academic record. Returns the average as a long
     * @return average 
     */
    public long calculateAverage(){
        long sum = 0;
        for(int i = 0; i < 10; i++){
            sum+= this.grades[i];
        }
        long average = Math.round(sum/10);
        return average;
    }
    /**
     * method to calculate the letter grade. Calls the calculateAverage method and then compares to grading scheme. Returns letter grade as a string.
     * @return letterGrade
     */
    public String calculateLetterGrade(){
        double average = this.calculateAverage();
        String letterGrade;
        if (average >= 90 && average <= 100) {
            letterGrade = ("A+");
        } else if (average >= 85 && average <= 89){
            letterGrade = ("A");
        } else if (average >= 80 && average <= 84){
            letterGrade = ("A-");
        } else if (average >= 77 && average <= 79){
            letterGrade = ("B+");
        } else if (average >= 73 && average <= 76){
            letterGrade = ("B");
        } else if (average >= 70 && average <= 72){
            letterGrade = ("B-");
        } else if (average >= 65 && average <= 69){
            letterGrade = ("C+");
        } else if (average >= 60 && average <= 64){
            letterGrade = ("C");
        } else if (average >= 50 && average <= 59){
            letterGrade = ("D");
        } else if (average >= 0 && average <= 49){
            letterGrade = ("F");
        } else {
            letterGrade = ("Invalid average value");}
        return letterGrade;
           
    }

     /**
     * Manual Override of default Object toString Method, to output a specific format of "Academic Record: ID Major LetterGrade".
     * @return "Person: firstName lastName ID".
     */
    @Override
    public String toString(){
        return "Academic Record: " + student.ID + " " + this.major + " " + this.calculateLetterGrade(); 
    }
}
