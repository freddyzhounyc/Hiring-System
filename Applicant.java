/**
 * The Applicant class creates profiles for each applicant including the companies they have worked for, name, gpa, college, and skills.
 *
 * @author Freddy Zhou
 *      Email: freddy.zhou@stonybrook.edu
 *      Stony Brook ID: 116580337
 *      HW #1 - Hiring System
 *      CSE 214
 *      Recitation Number: R04 | TA Names: Veronica Oreshko, Anuj Sureshbhai, Alex Zuzow
 */
public class Applicant implements Cloneable{
    // Initializing the variables for the Applicant class.
    private String[] companyName; // Array that holds all the companies of the Applicant
    private String applicantName; // Name of the Applicant
    private double gpa; // GPA of the Applicant
    private String college; // College the Applicant attended
    private String[] skills; // Array of the skills the Applicant has

    // No Argument Constructor for the Applicant class.
    /**
     * Returns the default instance of Applicant when no parameters are passed.
     */
    public Applicant(){
    }

    // Argument Constructor for the Applicant class.
    /**
     * Returns an instance of Applicant when specific parameters, described below, are passed.
     * @param companyName
     *  All the companies of the Applicant
     * @param applicantName
     *  Name of the Applicant
     * @param gpa
     *  GPA of the Applicant
     * @param college
     *  College the Applicant attended
     * @param skills
     *  Set of skills the Applicant has
     *
     * @custom.precondition
     *  companyName's length must be less than or equal to 3
     *  gpa must be a positive double
     *  skills' length must be less than or equal to 3
     * @custom.postcondition
     *  The new Applicant object should have all the attributes of the parameters.
     *
     * @exception IllegalArgumentException
     *  GPA can't be less than 0.
     */
    public Applicant(String[] companyName, String applicantName, double gpa, String college, String[] skills){
        this.companyName = companyName;
        this.applicantName = applicantName;
        this.gpa = gpa;
        this.college = college;
        this.skills = skills;
    }

    // Creating the getter methods for the Applicant class.
    /**
     * Returns the whole array that contains what companies the Applicant has worked at.
     * @return
     *  Returns the array with the companies that Applicant has worked for.
     * @custom.precondition
     *  companyName is an array of Strings not greater than 3.
     * @custom.postcondition
     *  companyName will return the array without changing.
     */
    public String[] getCompanyName() {
        return companyName;
    }

    /**
     * The Applicant's name will be returned.
     * @return
     *  Returns the name of the Applicant.
     * @custom.precondition
     *  The applicantName is a String.
     * @custom.postcondition
     *  The applicantName will remain unchanged in Applicant.
     */
    public String getApplicantName(){
        return applicantName;
    }

    /**
     * The GPA of the Applicant will be returned.
     * @return
     *  Returns the GPA of the Applicant.
     * @custom.precondition
     *  GPA is a double that is greater than 0.
     * @custom.postcondition
     *  GPA remains unchanged in Applicant
     */
    public double getGpa(){
        return gpa;
    }

    /**
     * The college of the Applicant is returned.
     * @return
     *  Returns the college the Applicant attended.
     * @custom.precondition
     *  College is a String.
     * @custom.postcondition
     *  College remains unchanged in Applicant.
     */
    public String getCollege(){
        return college;
    }

    /**
     * The skills that the Applicant has is returned.
     * @return
     *  Returns the skills that the Applicant has.
     * @custom.precondition
     *  skills is an array of Strings that is not greater than 3.
     * @custom.postcondition
     *  skills remains unchanged in Applicant.
     */
    public String[] getSkills(){
        return skills;
    }

    // Creating the setter methods for the Applicant class.
    /**
     * Sets the companyName array of the Applicant to show the companies the Applicant has worked for.
     * @param companyName
     *  Array of all the companies the Applicant has worked for.
     * @exception OutOfMemoryError
     *  The length of the companyName can't be greater than 3.
     * @custom.precondition
     *   companyName will be an array of Strings not greater than 3.
     * @custom.postcondition
     *  companyName will be a new array of Strings not greater than 3.
     */
    public void setCompanyName(String[] companyName){
        this.companyName = companyName;
    }

    /**
     * Sets the name of the Applicant.
     * @param applicantName
     *  Name of the Applicant.
     * @custom.precondition
     *  applicantName will be a String
     * @custom.postcondition
     *  applicantName will have a new String value.
     */
    public void setApplicantName(String applicantName){
        this.applicantName = applicantName;
    }

    /**
     * Sets the GPA of the Applicant.
     * @param gpa
     *  GPA that the Applicant has.
     * @throws IllegalArgumentException
     *  The value of GPA can't be less than 0.
     * @custom.precondition
     *  gpa will be a double that is greater than 0.
     * @custom.postcondition
     *  gpa will have a new double value.
     */
    public void setGpa(double gpa){
        if (gpa < 0){
            throw new IllegalArgumentException("GPA can't be negative!");
        }
        this.gpa = gpa;
    }

    /**
     * Sets the college that the Applicant attended.
     * @param college
     *  The college the Applicant attended.
     * @custom.precondition
     *  college will be a String.
     * @custom.postcondition
     *  college will have a new String value.
     */
    public void setCollege(String college){
        this.college = college;
    }

    /**
     * Sets the skills that the Applicant has.
     * @param skills
     *  The skills that the Applicant has.
     * @exception OutOfMemoryError
     *  The length of the skills array can't be greater than 3.
     * @custom.precondition
     *  skills will be an array of Strings that is not greater than 3.
     * @custom.postcondition
     *  skills will be a new array of Strings not greater than 3.
     */
    public void setSkills(String[] skills){
        this.skills = skills;
    }

    // Clone method for Applicant class.
    /**
     * Clone will create a copy of the current Applicant by creating a new instance of Applicant and creating new values.
     * @return
     *  Returns the clone/copy of the current Applicant.
     * @exception CloneNotSupportedException
     *  When the object is called to be cloned, but Cloneable is not implemented.
     * @custom.precondition
     *  The companyName array is not greater than 3.
     *  The skills array is not greater than 3.
     *  GPA is a positive double.
     * @custom.postcondition
     *  The different attributes of Applicant will be copied/cloned to a new instance of Applicant.
     */
    public Object clone(){
        Applicant applicantClone = new Applicant();
        applicantClone.companyName = companyName.clone();
        applicantClone.skills = skills.clone();
        applicantClone.applicantName = applicantName; // Strings are immutable, so .clone() is not necessary
        applicantClone.gpa = gpa;
        applicantClone.college = college; // Strings are immutable, so .clone() is not necessary

        return applicantClone;
    }

    /*
    Checks if two arrays are equal to one another
    Precondition:
        Both arrays have equal lengths
        Elements in the arrays are in the order
    */
    /**
     * Checks if two arrays are equal to one another
     * @param arr1
     *  The first array to be compared.
     * @param arr2
     *  The second array to be compared.
     * @return
     *  Returns a boolean value depicting whether the two parameter arrays are equivalent.
     * @custom.precondition
     *  Both arrays have equal lengths
     *  The elements in the arrays are in the same order if they have the same contents.
     * @custom.postcondition
     *  The arrays will be compared and the result will be returned.
     * @exception NullPointerException
     *  If elements in the array are null and they are directly compared.
     */
    public boolean equalArrays(String[] arr1, String[] arr2){
        boolean result = true;
        for (int i = 0; i < arr1.length; i++){
            if (arr1[i] == null && arr2[i] == null)
                return true;
            if (arr1[i] == null && arr2[i] != null)
                return false;
            if (arr1[i] != null && arr2[i] == null)
                return false;
            if ((arr1[i] != null && arr2[i] != null)){
                if (!arr1[i].equals(arr2[i]))
                    result = false;
            }
        }
        return result;
    }

    // Equals method to compare applicants.
    /**
     * Compares the current Applicant to an Applicant passed in as a parameter.
     * @param obj
     *  Applicant that will be compared to the current Applicant.
     * @return
     *  Returns whether the two Applicants are the same in content.
     * @custom.precondition
     *  The obj Object should have values that satisfy the requirements of its attributes.
     * @custom.postcondition
     *  The Applicants are unchanged and the result of whether the Applicants are equal or not is returned.
     */
    public boolean equals(Object obj){
        if (obj instanceof Applicant){
            Applicant tester = (Applicant) obj;
            if (equalArrays(tester.getCompanyName(), companyName) && tester.getApplicantName().equals(applicantName) &&
            tester.getGpa() == gpa && tester.getCollege().equals(college) && equalArrays(tester.getSkills(), skills)){
                return true;
            }
        }
        return false;
    }

    // Finds how many elements are in an array
    /**
     * Finds how many elements are in an array
     * @param arr
     *  The array that is measured on how many elements make up the array.
     * @return
     *  Returns the number of elements in the array passed in by the parameter.
     * @custom.precondition
     *  arr should have elements that populate it.
     * @custom.postcondition
     *  The arr is unchanged and the amount of elements is returned.
     */
    public int elementsInArr(String[] arr){
        int elementCounter = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null)
                elementCounter++;
        }
        return elementCounter;
    }

    // toString method to print out the different variables in the Applicant class.
    /**
     * Prints out all the different attributes/variables that make up the Applicant to the console.
     * @return
     *  Returns a String that properly formats the attributes that make up the Applicant.
     * @custom.precondition
     *  The arrays of companyName and skills should have elements populating them.
     * @custom.postcondition
     *  The arrays will be unchanged and the String that will be returned is created and returned with proper formatting.
     */
    public String toString(){
        String companiesStr = "";
        for (int i = 0; i < elementsInArr(companyName); i++){
            if (i < elementsInArr(companyName)-1)
                companiesStr += companyName[i] + ", ";
            else
                companiesStr += companyName[i];
        }
        String skillsStr = "";
        for (int i = 0; i < elementsInArr(skills); i++){
            if (i < elementsInArr(skills)-1)
                skillsStr += skills[i] + ", ";
            else
                skillsStr += skills[i];
        }
        return "Applicant Name: " + applicantName + "\n" + "Applicant Applying From: " + companiesStr +
                "\n" + "Applicant GPA: " + gpa + "\n" + "Applicant College: " +
                college + "\n" + "Applicant Skills: " + skillsStr;
    }
}