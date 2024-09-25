/**
 * The HiringTable class creates a table of Applicants that has different functions that is done of the array of Applicants in candidates.
 *
 * @author Freddy Zhou
 *      Email: freddy.zhou@stonybrook.edu
 *      Stony Brook ID: 116580337
 *      HW #1 - Hiring System
 *      CSE 214
 *      Recitation Number: R04 | TA Names: Veronica Oreshko, Anuj Sureshbhai, Alex Zuzow
 */
public class HiringTable{
    // Creation of instance variables for the HiringTable class and setting final values for constants throughout the code.
    private Applicant[] candidates; // The array of Applicants that holds all the Applicants added to the table.
    private static final int MAX_SKILLS = 3; // Constant that shows the maximum number of skills.
    private static final int MAX_COMPANIES = 3; // Constant that shows the maximum number of companies.
    private static final int MAX_APPLICANTS = 50; // Constant that shows the maximum number of applicants.
    private int candidatesCounter; // Counter that counts the number of Applicants added to the candidates array.

    /**
     * Creates an instance of the HiringTable and sets default values as no parameters are passed.
     */
    public HiringTable(){
        candidates = new Applicant[MAX_APPLICANTS];
        candidatesCounter = 0;
    }

    /**
     * Sets the array of candidates.
     * @param candidates
     *  Array of Applicants that make up the candidates attribute in HiringTable.
     * @custom.precondition
     *  candidates should not have more than 50 elements and should be Applicants values.
     * @custom.postcondition
     *  candidates will have a new array of Applicants values.
     */
    public void setCandidates(Applicant[] candidates){
        this.candidates = candidates;
    }

    /**
     * Sets the candidatesCounter value.
     * @param candidatesCounter
     *  The number of candidates in the candidates array.
     * @custom.precondition
     *  candidatesCounter should have values that are positive and not greater than 50
     * @custom.postcondition
     *  candidatesCounter will have a new int value.
     */
    public void setCandidatesCounter(int candidatesCounter){
        this.candidatesCounter = candidatesCounter;
    }

    /**
     * The candidates array is returned.
     * @return
     *  Returns the candidates array.
     * @custom.precondition
     *  candidates will not have elements greater than 50.
     * @custom.postcondition
     *  candidates will remain unchanged.
     */
    public Applicant[] getCandidates(){
        return candidates;
    }

    /**
     * The candidatesCounter will be returned.
     * @return
     *  Returns the candidatesCounter as an int.
     * @custom.precondition
     *  candidatesCounter will not be greater than 50.
     * @custom.postcondition
     *  candidatesCounter will remain unchanged.
     */
    public int getCandidatesCounter(){
        return candidatesCounter;
    }

    /**
     * The size of the HiringTable will be returned.
     * @return
     *  Returns the size of the HiringTable by using candidatesCounter.
     * @custom.precondition
     *  candidatesCounter should be positive and not greater than 50.
     * @custom.postcondition
     *  candidatesCounter will remain unchanged.
     */
    public int size(){
        return candidatesCounter;
    }

    /**
     * The specified Applicant will be added to the candidates array.
     * @param newApplicant
     *  Applicant that is to be added to the candidates array in the HiringTable.
     * @throws FullTableException
     *  Indicates that the table is full and can't support more values.
     * @custom.precondition
     *  candidatesCounter has to not be greater than 50.
     * @custom.postcondition
     *  candidatesCounter will not be greater than 50.
     *  A new Applicant will be added to the candidates array in the HiringTable.
     */
    public void addApplicant(Applicant newApplicant) throws FullTableException{
        if (this.size() > MAX_APPLICANTS){
            throw new FullTableException();
        } else{
            candidates[candidatesCounter] = newApplicant;
            candidatesCounter++;
        }
    }

    /**
     * The specified Applicant will be removed from candidates and candidatesCounter will be decremented.
     * @param name
     *  The Applicant that will be removed from candidates.
     * @throws ApplicantNotFoundException
     *  Indicates that the Applicant was not found in candidates to remove.
     * @custom.precondition
     *  name should be present in the applicantName of the Applicant array.
     * @custom.postcondition
     *  The name parameter should be found in the pool of applicantName in the Applicant array, candidates,
     *  and removed and the candidates array should be properly decremented.
     */
    public void removeApplicant(String name) throws ApplicantNotFoundException{
        boolean found = false;
        int counterIndex = 0;

        while (!found){
            if (counterIndex > candidatesCounter-1){
                throw new ApplicantNotFoundException();
            }
            if ((candidates[counterIndex].getApplicantName()).equals(name)){
                for (int i = counterIndex; i < candidates.length-1; i++){
                    candidates[i] = candidates[i+1];
                }
                candidatesCounter--;
                found = true;
            }
            counterIndex++;
        }
    }

    /**
     * The Applicant with the name parameter will be returned.
     * @param name
     *  The name of the Applicant that will be found and returned.
     * @return
     *  Returns the Applicant in candidates that has the same applicantName.
     * @throws ApplicantNotFoundException
     *  Indicates that the name parameter was not found in the candidates array of Applicants.
     * @custom.precondition
     *  name should be in the candidates array.
     * @custom.postcondition
     *  The name parameter should be found in the candidates array and returned.
     */
    public Applicant getApplicant(String name) throws ApplicantNotFoundException{
        for (int i = 0; i < candidatesCounter; i++){
            if (candidates[i].getApplicantName().equals(name))
                return candidates[i];
        }
        throw new ApplicantNotFoundException();
    }

    /**
     * Searches through each Applicant in the HiringTable in the candidates array and makes sure it satisfies the parameters.
     * @param table
     *  The HiringTable object that is specified to be searched.
     * @param company
     *  The company that should be present in the Applicants that are searched for.
     * @param skill
     *  The skill that should be present in the Applicants that are searched for.
     * @param college
     *  The college that should be present in the Applicants that are searched for.
     * @param GPA
     *  The minimum GPA that should be present in the Applicants that are searched for.
     * @custom.precondition
     *  All of the parameters meet their own requirements and are present somewhere in one of the Applicants.
     * @custom.postcondition
     *  All of the Applicants that satisfy the requirements given in the parameters are displayed to the console.
     */
    public static void refineSearch(HiringTable table, String company, String skill, String college, double GPA){
        Applicant[] refinedCandidates = new Applicant[table.candidatesCounter];
        int refinedCandidatesCounter = 0;

        for (int i = 0; i < table.candidatesCounter; i++){
            boolean hasCompany = false, hasSkill = false, hasCollege = false, hasMinGPA = false;
            if (company.isEmpty())
                hasCompany = true;
            if (skill.isEmpty())
                hasSkill = true;
            if (college.isEmpty())
                hasCollege = true;

            String[] companyCheck = table.candidates[i].getCompanyName();
            for (int j = 0; j < 3; j++) {
                if (companyCheck[j] != null) {
                    if (companyCheck[j].equals(company))
                        hasCompany = true;
                }
            }
            String[] skillCheck = table.candidates[i].getSkills();
            for (int j = 0; j < 3; j++) {
                if (skillCheck[j] != null) {
                    if (skillCheck[j].equals(skill))
                        hasSkill = true;
                }
            }
            if (table.candidates[i].getCollege().equals(college))
                hasCollege = true;
            if (table.candidates[i].getGpa() >= GPA)
                hasMinGPA = true;

            if (hasCompany && hasSkill && hasCollege && hasMinGPA) {
                refinedCandidates[refinedCandidatesCounter] = table.candidates[i];
                refinedCandidatesCounter++;
            }
        }

        System.out.printf("%-33s%-16s%-11s%-17s%-21s", "Company Name", "Applicant", "GPA", "College", "Skills");
        System.out.println();
        for (int i = 0; i < 98; i++){
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < refinedCandidatesCounter; i++){
            String companiesStr = "";
            for (int j = 0; j < elementsInArrStatic(refinedCandidates[i].getCompanyName()); j++){
                if (j < elementsInArrStatic(refinedCandidates[i].getCompanyName())-1)
                    companiesStr += refinedCandidates[i].getCompanyName()[j] + ", ";
                else
                    companiesStr += refinedCandidates[i].getCompanyName()[j];
            }
            String skillsStr = "";
            for (int j = 0; j < elementsInArrStatic(refinedCandidates[i].getSkills()); j++){
                if (j < elementsInArrStatic(refinedCandidates[i].getSkills())-1)
                    skillsStr += refinedCandidates[i].getSkills()[j] + ", ";
                else
                    skillsStr += refinedCandidates[i].getSkills()[j];
            }
            System.out.printf("%-33s%-16s%-11.2f%-17s%-21s", companiesStr, refinedCandidates[i].getApplicantName(), refinedCandidates[i].getGpa(),
                    refinedCandidates[i].getCollege(), skillsStr);
            System.out.println();
        }
    }

    /*
    Checks if two arrays are equal to one another
    Precondition:
        Elements in the arrays are in the order
    */
    /**
     * Checks if two arrays are equal to one another.
     * @param arr1
     *  The first array that is being compared.
     * @param arr2
     *  The second array that is being compared.
     * @return
     *  Returns whether the two arrays provided are equal.
     * @exception NullPointerException
     *  Indicates whether a null is being compared.
     * @custom.precondition
     *  arr1 and arr2 do not need to be the same lengths as nulls are accounted for.
     *  arr1 and arr2 can't have more than 50 candidates each.
     * @custom.postcondition
     *  The result of whether arr1 and arr2 are equal is returned without changing the arrays.
     */
    public boolean equalArrays(Applicant[] arr1, Applicant[] arr2){
        boolean result = true;
        for (int i = 0; i < arr1.length; i++){
            // The comparisons to null check for instances of when elements in the arrays are null to prevent NullPointerException
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

    // Checks if two of the HiringTables are the same in content
    /**
     * Checks if two of the HiringTables are the same in content.
     * @param obj
     *  The object/HiringTable that is being compared to the current HiringTable/obj.
     * @return
     *  Returns whether the two HiringTables are the same in content.
     * @custom.precondition
     *  candidates should not have more than 50 elements.
     * @custom.postcondition
     *  The result of whether the two HiringTables are equal in content will be returned.
     *  candidates remains unchanged.
     */
    public boolean equals(Object obj){
        if (obj instanceof HiringTable){
            HiringTable tester = (HiringTable) obj;
            if (equalArrays(tester.getCandidates(), candidates) && (tester.getCandidatesCounter() == candidatesCounter)){
                return true;
            }
        }
        return false;
    }

    /**
     * The current HiringTable is cloned/copied.
     * @return
     *  Returns the new instance of HiringTable that is a clone of the current HiringTable.
     * @custom.precondition
     *  candidates can't be greater than 50.
     * @custom.postcondition
     *  candidates remains unchanged.
     */
    public Object clone(){
        HiringTable hiringTableClone = new HiringTable();
        for (int i = 0; i < candidatesCounter; i++){
            hiringTableClone.candidates[i] = (Applicant)candidates[i].clone();
        }
        hiringTableClone.candidatesCounter = candidatesCounter;

        return hiringTableClone;
    }

    /**
     * Finds how many elements are in the array specified.
     * @param arr
     *  The array that is being measured on how many elements make it up.
     * @return
     *  Returns how many elements make up the specified array.
     * @custom.precondition
     *  Have no elements be null.
     * @custom.postcondition
     *  The array in the parameter will remain unchanged.
     */
    public int elementsInArr(String[] arr){
        int elementCounter = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null)
                elementCounter++;
        }
        return elementCounter;
    }

    /**
     * The static version of the elementsInArr method. Finds how many elements are in the array specified.
     * @param arr
     *  The array that is being measured on how many elements make it up.
     * @return
     *  Returns how many elements make up the specified array.
     * @custom.precondition
     *  Have no elements be null.
     * @custom.postcondition
     *  The array in the parameter will remain unchanged.
     */
    public static int elementsInArrStatic(String[] arr){
        int elementCounter = 0;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] != null)
                elementCounter++;
        }
        return elementCounter;
    }

    /**
     * Prints out the HiringTable in a formatted way to the console.
     * @custom.precondition
     *  candidates can't be greater than 50.
     *  candidatesCounter can't be greater than 50.
     * @custom.postcondition
     *  candidates remains unchanged.
     */
    public void printApplicantTable(){
        System.out.printf("%-33s%-16s%-11s%-17s%-21s", "Company Name", "Applicant", "GPA", "College", "Skills");
        System.out.println();
        for (int i = 0; i < 98; i++){
            System.out.print("-");
        }
        System.out.println();

        for (int i = 0; i < candidatesCounter; i++){
            String companiesStr = "";
            for (int j = 0; j < elementsInArr(candidates[i].getCompanyName()); j++){
                if (j < elementsInArr(candidates[i].getCompanyName())-1)
                    companiesStr += candidates[i].getCompanyName()[j] + ", ";
                else
                    companiesStr += candidates[i].getCompanyName()[j];
            }
            String skillsStr = "";
            for (int j = 0; j < elementsInArr(candidates[i].getSkills()); j++){
                if (j < elementsInArr(candidates[i].getSkills())-1)
                    skillsStr += candidates[i].getSkills()[j] + ", ";
                else
                    skillsStr += candidates[i].getSkills()[j];
            }

            System.out.printf("%-33s%-16s%-11.2f%-17s%-21s", companiesStr, candidates[i].getApplicantName(), candidates[i].getGpa(), candidates[i].getCollege(), skillsStr);
            System.out.println();
        }
    }
    // test for the methods created in class
    public static void main(String[] args) throws FullTableException {
        String[] companies = {"Apple", "Google", "Amazon"};
        String[] companies2 = {"Facebook", "Netflix", "Spotify"};
        String[] skills = {"Java", "C++", "Python"};
        String[] skills2 = {"Management", "C#", "HTML"};
        Applicant appTest = new Applicant(companies, "Freddy Zhou", 3.89, "Stony Brook", skills);
        Applicant appTest2 = new Applicant(companies, "Freddy Zhou", 3.89, "Stony Brook", skills2);
        HiringTable htTest = new HiringTable();

        System.out.println(appTest.equals(appTest2));

        //htTest.addApplicant(appTest);
        //refineSearch(htTest, "Google", "Java", "Stony Brook", 3.5);
        //htTest.printApplicantTable();
    }
}