import java.util.Scanner;

/**
 * The HiringSystem combines the functions of both Applicant and HiringTable and creates a system out of both classes.
 *
 * @author Freddy Zhou
 */
public class HiringSystem{
    /**
     * The main method that runs the HiringSystem by displaying the menu and being able to access its functions.
     * @throws FullTableException
     *  Indicates that the HiringTale is full of values.
     * @throws ApplicantNotFoundException
     *  Indicates that the Applicant could not be found.
     * @param args - not used
     */
    public static void main(String[] args) throws FullTableException, ApplicantNotFoundException{
        Scanner cin = new Scanner(System.in); // Scanner creation for input values from console.
        HiringTable testHiringTable = new HiringTable();
        HiringTable backupHiringTable = new HiringTable();
        boolean quit = false; // used to check whether the user has requested to quit the application.

        // while loop to keep the program running until the user requests to quit.
        while (!quit) {
            System.out.print("(A) Add Applicant\n(R) Remove Applicant\n(G) Get Applicant\n(P) Print List\n(RS) Refine Search\n(S) Size\n(B) Backup\n(CB) Compare Backup\n" +
                    "(RB) Revert Backup\n(Q) Quit\n\n");
            System.out.print("Please enter a command: ");
            String menuInput = cin.nextLine();

            // Quitting the System Menu Option
            if (menuInput.equals("Q"))
                quit = true;
            // Adding Applicant Menu Option
            if (menuInput.equals("A")) {
                String appName = "", appCollege = "";
                double appGpa = 0.0;
                String[] appCompanies = new String[3];
                String[] appSkills = new String[3];
                System.out.print("Enter Applicant Name: ");
                appName = cin.nextLine();
                System.out.print("Enter Applicant GPA: ");
                appGpa = cin.nextDouble();
                cin.nextLine(); // consumes the newline character because nextDouble() in the Scanner class looks for tokens.
                System.out.print("Enter Applicant College: ");
                appCollege = cin.nextLine();

                int companiesInputCounter = 3; // used for print out.
                int companiesIndexCounter = 0; // used for array of companies.
                boolean isEmpty = false; // checks if input is empty to end the while loop to move onto skills
                while (!isEmpty && companiesInputCounter > 0) {
                    System.out.print("Enter up to " + companiesInputCounter + " Companies: ");
                    String currentInput = cin.nextLine();
                    if (!currentInput.isEmpty()) {
                        appCompanies[companiesIndexCounter] = currentInput;
                        companiesIndexCounter++; // increment
                        companiesInputCounter--; // decrement
                    } else {
                        isEmpty = true;
                    }
                }
                int skillsInputCounter = 3; // used for pint out
                int skillsIndexCounter = 0; // used for array of skills
                isEmpty = false; // checks if input is empty to end the while loop to move onto skills
                while (!isEmpty && skillsInputCounter > 0){
                    System.out.print("Enter up to " + skillsInputCounter + " Skills: ");
                    String currentInput = cin.nextLine();
                    if (!currentInput.isEmpty()) {
                        appSkills[skillsIndexCounter] = currentInput;
                        skillsInputCounter--; // decrement
                        skillsIndexCounter++; // increment
                    } else {
                        isEmpty = true;
                    }
                }
                Applicant testApplicant = new Applicant(appCompanies, appName, appGpa, appCollege, appSkills); // creates new instance with the given applicant details.
                testHiringTable.addApplicant(testApplicant);
                System.out.println("Applicant " + appName + " has been successfully added to the hiring system.\n");
            }
            // Removing Applicant Menu Option
            if (menuInput.equals("R")) {
                String appRemove = "";
                System.out.print("Enter applicant name: ");
                appRemove = cin.nextLine();
                testHiringTable.removeApplicant(appRemove); // call to HiringTable method to carry out the removing action.
                System.out.println("Applicant " + appRemove + " has been successfully removed from the hiring system.\n");
            }
            // Getting Applicant Menu Option
            if (menuInput.equals("G")) {
                System.out.print("Enter Applicant Name: ");
                String appGet = cin.nextLine();

                Applicant gotApplicant = testHiringTable.getApplicant(appGet); // setting gotApplicant equal to the applicant the user wants.
                System.out.println("\n" + gotApplicant.toString() + "\n");
            }
            // Print Hiring Table of added Applicants Menu Option
            if (menuInput.equals("P")){
                System.out.println();
                testHiringTable.printApplicantTable(); // calling the printout option created in the HiringTable class.
                System.out.println();
            }
            // Refined Search for Applicants Menu Option
            if (menuInput.equals("RS")){
                System.out.print("Enter a company to filter for: ");
                String companyFilter = cin.nextLine();
                System.out.print("Enter a skill to filter for: ");
                String skillFilter = cin.nextLine();
                System.out.print("Enter a college to filter for: ");
                String collegeFilter = cin.nextLine();
                System.out.print("Enter the minimum GPA to filter for: ");
                String inputTest = cin.nextLine();
                double minGPAFilter = 0;
                if (!inputTest.isEmpty()){ // If else statement is used to allow for the double value of gpa to not be added to requirements.
                    minGPAFilter = Double.valueOf(inputTest); // turns the String double into primitive double.
                } else{
                    minGPAFilter = 0; // value that minGPA will be if there is no requirement for the minimum GPA as 0 is the lowest GPA can go.
                }

                System.out.println();
                HiringTable.refineSearch(testHiringTable, companyFilter, skillFilter, collegeFilter, minGPAFilter); // Calling the method in HiringTable.
                System.out.println();
            }
            // Get the number of Applicants Menu Option
            if (menuInput.equals("S")){
                int size = testHiringTable.size(); // Calling method from HiringTable.
                System.out.println("There are " + size + " applicants in the hiring system.\n");
            }
            // Get a backup of the Hiring Table Menu Option
            if (menuInput.equals("B")){
                backupHiringTable = (HiringTable)testHiringTable.clone(); // Calling clone from HiringTable and casting it.
                System.out.println("Successfully created backup.\n");
            }
            // Check if current list and backup lists are the same Menu Option
            if (menuInput.equals("CB")){
                if (testHiringTable.equals(backupHiringTable)){ // Checking if the backup is the same as the current by using equals in HiringTable.
                    System.out.println("Current list is the same as the backup copy.\n");
                } else{
                    System.out.println("Current list is not the same as the backup copy.\n");
                }
            }
            // Reverts the current list to the backed up list Menu Option
            if (menuInput.equals("RB")){
                testHiringTable = new HiringTable(); // Creating new instance of HiringTable to give to current to revert back.
                testHiringTable.setCandidates(backupHiringTable.getCandidates()); // Setting values of backup into the new instance.
                testHiringTable.setCandidatesCounter(backupHiringTable.getCandidatesCounter()); // Setting values of backup into the new instance.
                System.out.println("Successfully reverted to the backup copy.\n");
            }
        }
    }
}
