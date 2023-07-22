package Lab1;
import java.util.Random;
/**
 * Main class from which to run Lab1
 * @author C0530980
 */
public class Main {
    // source: https://nameberry.com/unisex-names
    static String[] givenNames = {
        "Avery", "Riley", "Jordan", "Angel", "Peyton",
        "Quinn", "Hayden", "Taylor", "Alexis", "Rowan",
        "Charlie", "Emerson", "Finley", "River", "Emery",
        "Morgan", "Elliot", "London", "Eden", "Elliott",
        "Karter", "Dakota", "Reese", "Remington", "Payton",
        "Amari", "Phoenix", "Kendall", "Harley", "Rylan",
        "Marley", "Dallas", "Skyler", "Spencer", "Sage",
        "Kyrie", "Ellis", "Rory", "Remi", "Justice",
        "Ali", "Haven", "Tatum", "Arden", "Linden",
        "Devon", "Rebel", "Rio", "Ripley", "Frankie"
    };
// source: http://www.locatemyname.com/topsurnames.php?country=canada
    static String[] surnames = {
        "Smith", "Brown", "Tremblay", "Martin", "Roy",
        "Wilson", "Macdonald", "Gagnon", "Johnson", "Taylor",
        "Cote", "Campbell", "Anderson", "Leblanc", "Lee",
        "Jones", "White", "Williams", "Miller", "Thompson",
        "Gauthier", "Young", "Van", "Morin", "Bouchard",
        "Scott", "Stewart", "Belanger", "Reid", "Pelletier",
        "Moore", "Lavoie", "King", "Robinson", "Levesque",
        "Murphy", "Fortin", "Gagne", "Wong", "Clark",
        "Johnston", "Clarke", "Ross", "Walker", "Thomas",
        "Boucher", "Landry", "Kelly", "Bergeron", "Davis"};
    
//Dr specialties
    static String[] specialties = {
        "NeuroSurgery", "Dermatology", "Urology", "Cardiology", 
        "Rheumatology", "Psychiatry", "Endocrinology", "Pediatrics", 
        "Oncology", "Opthalmology"
    };
    
    private static int nurseCount;
    private static int drCount;
    private static int patientCount;
    static Nurse[] nurses;
    static Doctor[] doctors;
    /**
     * Method which returns a random number from 0-49, using the Random class.
     * @return int randomNum
     */
    public static int randomNames() {
        //make new instance of Random
        Random rand = new Random();
        // create int to store random number and assign it random number from 0-49, which will fall within the index range for givenNames and surnames.
        int randomNum = rand.nextInt(50);
        return randomNum;
    }
    /**
     * Method which returns a random index number from Doctor[] doctors, using
     * the Random class.
     * @return int randomNum
     */
    public static int randomDr() {
        Random rand = new Random();
        int randomNum = rand.nextInt(doctors.length);
        return randomNum;
    }
    /**
     * Returns a random specialty from the specialties array.
     * @return String - a random specialty
     */
    public static String getSpecialty(){
        Random rand = new Random();
        int randomNum = rand.nextInt(specialties.length);
        return specialties[randomNum];
    }
    /**
     * Method to get givenName at index of parameter num from list of givenNames
     * @param num
     * @return String givenName
     */
    public static String getGivenName(int num) {
        return givenNames[num];
    }
    /**
     * Method to get surname at index of parameter num from list of surnames
     * @param num
     * @return String surname
     */
    public static String getSurNames(int num) {
        return surnames[num];
    }
    /**
     * Creates multiple  instances of the Nurse class. Assigns "Emergency"
     * as unit, and a random givenName and surname. Keeps track of number of
     * nurses created with nurseCount.
     * @param num - number of nurses to make
     * @return Nurse[] nurses - array containing all nurses created
     */
    public static Nurse[] nurseMaker(int num) {
        Nurse[] nurses = new Nurse[num];
        for (int i = 0; i < num; i++) {
            nurses[i] = new Nurse("Emergency", getGivenName(randomNames()), getSurNames(randomNames()));
            nurseCount++;
        }
        return nurses;
    }
    /**
     * Creates multiple instances of the Doctor class. Assigns "Emergency"
     * as unit, "Brain Surgery" as specialty, and a random givenName and surname
     * @param num - number of Doctors to make
     * @return Doctor[] doctors - array containing all doctors created
     */
    public static Doctor[] drMaker(int num) {
        Doctor[] doctors = new Doctor[num];
        for (int i = 0; i < num; i++) {
            doctors[i] = new Doctor("Emergency", getSpecialty(), getGivenName(randomNames()), getSurNames(randomNames()));
            drCount++;
        }
        return doctors;
    }
    /**
     * Creates multiple instances of the Patient class. Assigns random
     * givenName and surname Assigns a random physician from the Doctor[]
     * doctors.
     * @param num - number of patients to make
     * @return Patient[] patients - array containing all patients created
     */
    public static Patient[] patientMaker(int num) {
        Patient[] patientsRest = new Patient[num];
        for (int i = 0; i < num; i++) {
            patientsRest[i] = new Patient(getGivenName(randomNames()), getSurNames(randomNames()), doctors[randomDr()]);
            patientCount++;
        }
        return patientsRest;
    }
    /**
     * Calculates the total payroll of Doctors and Nurses
     * @return long payroll - total payroll of all nurses and doctors
     */
    public static long Payroll() {
        long payroll = 0;
        for (int i = 0; i < drCount; i++) {
            payroll += doctors[i].annualSalary;
        }
        for (int i = 0; i < nurseCount; i++) {
            payroll += nurses[i].annualSalary;
        }
        return payroll;
    }
    /**
     * Automatically assigns nurses SHIFT_A, SHIFT_B, or SHIFT_C. Rolls over
     * from 1-3 (shiftCounter) repeatedly.
     * @param nurses - array containing nurses who need shift (re)assignment
     */
    public static void autoShiftAssign(Nurse[] nurses) {
        int shiftCounter = 1;
        for (Nurse nurse : nurses) {
            switch (shiftCounter) {
                case 1 ->
                    nurse.setShift(Nurse.SHIFT_A);
                case 2 ->
                    nurse.setShift(Nurse.SHIFT_B);
                case 3 ->
                    nurse.setShift(Nurse.SHIFT_C);
            }
            shiftCounter = (shiftCounter == 3) ? 1 : ++shiftCounter;
        }
    }
    /**
     * Counts how many patients each doctor has.
     * @param doctors - array containing doctors
     * @param patients - array containing patients
     * @return
     */
    public static void patientCounter(Doctor[] doctors, Patient[] patients) {
        for (Doctor doctor : doctors) {
            int drPatientCount = 0;
            int drID2Count = doctor.ID;
            for (Patient patient : patients) {
                if (patient.physician.ID == drID2Count) {
                    drPatientCount++;
                }
            }
            System.out.println("Dr. " + doctor.surname + " (ID# " + doctor.ID + ") has " + drPatientCount + " patients.");
        }
    }
    /**
     * Prints givenName, surname, ID, unit and shift for Nurses and givenName,
     * surname, ID and Specialty for Doctors.
     * @param doctors - array containing all Doctors
     * @param nurses - array containing all Nurses
     */
    private static void employeePrinter(Doctor[] doctors, Nurse[] nurses) {
        System.out.println("Nurses: ");
        for (int i = 0; i < nurseCount; i++) {
            System.out.println(nurses[i].toString());
        }
        System.out.println("\nDoctors: ");
        for (int i = 0; i < drCount; i++) {
            System.out.println(doctors[i].toString());
        }
    }
    /**
     * Prints givenName, surname, ID and Dr ID for manually entered patients,
     * followed by randomly generated patients
     * @param patientsAll - array containing all patients
     */
    private static void patientPrinter(Patient[] patientsAll) {
        System.out.println("\nManual Patients:");
        for (int i = 0; i < 3; i++) {
            System.out.println(patientsAll[i].toString() + " Dr ID#: " + patientsAll[i].physician.ID);
        }
        System.out.println("\nRandom Patients:");
        for (int i = 3; i < patientsAll.length; i++) {
            System.out.println(patientsAll[i].toString() + " Dr ID#: " + patientsAll[i].physician.ID);
        }
    }
    public static void main(String[] args) {
        // 1. Creates three or more Nurse instances assigned to different shifts.
        nurses = nurseMaker(8);
        autoShiftAssign(nurses);
        // 2. Creates three or more Doctor instances.
        doctors = drMaker(5);
        // 3. Creates three or more Patient instances with pre-determined names and manually 
        //    assigned physicians chosen from the pool of Doctor instances previously created.
        Patient[] patientsAll = new Patient[23];
        patientsAll[0] = new Patient("Toby", "Handford", doctors[0]);
        patientCount++;
        patientsAll[1] = new Patient("Kieran", "Avlonitis", doctors[1]);
        patientCount++;
        patientsAll[2] = new Patient("Ethan", "Smith", doctors[2]);
        patientCount++;
        // 4. Generates another 20 Patient instances using randomly generated names and randomly 
        //    assigns them physicians chosen from the pool of Doctor instances previously created.
        //create another 20 patients, then uses arraycopy to copy each patient into the original patientsAll array
        Patient[] patientsRest = patientMaker(20);
        System.arraycopy(patientsRest, 0, patientsAll, 3, patientsRest.length);
        // 5. Prints the toString() values for all employees.
        employeePrinter(doctors, nurses);
        // 6. Prints the toString() value and physician ID for each patient.
        patientPrinter(patientsAll);
        // 7. Calculates and prints the total annual cost to employ all of the created doctors and nurses.
        System.out.println("\nHospital Payroll: $" + Payroll() +"\n");
        // 8. Calculates and prints the number of patients assigned to each Doctor.
        patientCounter(doctors, patientsAll);
    }
}