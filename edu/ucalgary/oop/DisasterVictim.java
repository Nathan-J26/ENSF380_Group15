package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.Arrays;

public class DisasterVictim {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private final int ASSIGNED_SOCIAL_ID;
    private ArrayList<FamilyRelation> familyConnections;
    private ArrayList<MedicalRecord> medicalRecords;
    private ArrayList<Supply> personalBelongings;
    private final String ENTRY_DATE;
    private String gender;
    private String comments;
    private static int counter = 0;
    
    public DisasterVictim(String firstName, String ENTRY_DATE) {
        if(!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format: " + ENTRY_DATE);
        }
        else {
            this.firstName = firstName;
            this.ENTRY_DATE = ENTRY_DATE;
            this.familyConnections = new ArrayList<FamilyRelation>();
            this.medicalRecords = new ArrayList<MedicalRecord>();
            this.personalBelongings = new ArrayList<Supply>();
            this.ASSIGNED_SOCIAL_ID = generateSocialID();
            counter++;
        }
    }

    public DisasterVictim(String firstName, String ENTRY_DATE, String dateOfBirth) {
        if(!isValidDateFormat(ENTRY_DATE)) {
            throw new IllegalArgumentException("Invalid date format: " + ENTRY_DATE);
        }
        else {
            this.firstName = firstName;
            this.ENTRY_DATE = ENTRY_DATE;
            this.setDateOfBirth(dateOfBirth);
            this.familyConnections = new ArrayList<FamilyRelation>();
            this.medicalRecords = new ArrayList<MedicalRecord>();
            this.personalBelongings = new ArrayList<Supply>();
            this.ASSIGNED_SOCIAL_ID = generateSocialID();
            counter++;
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        if(isValidDateFormat(dateOfBirth)) { // if the birthday format is valid
            if(convertDateStringToInt(dateOfBirth) < convertDateStringToInt(this.ENTRY_DATE)) {
                // only set dateOfBirth if the date inputted is before the entry date
                this.dateOfBirth = dateOfBirth;
            }
            else {
                // if dateOfBirth is after ENTRY_DATE throw IllegalArgumentException
                throw new IllegalArgumentException("Invalid birthdate: " + dateOfBirth + " - birthday cannot be after entry date");
            }
        }
        else {
            // if date format is not valid, throw IllegalArgumentException
            throw new IllegalArgumentException("Invalid date format: " + dateOfBirth);
        }
    }

    public int getAssignedSocialID() {
        return this.ASSIGNED_SOCIAL_ID;
    }
    
    public FamilyRelation[] getFamilyConnections() {
        // converts to an array before returning
        return this.familyConnections.toArray(new FamilyRelation[0]);
    }

    public MedicalRecord[] getMedicalRecords() {
        // converts to an array before returning
        return this.medicalRecords.toArray(new MedicalRecord[0]);
    }

    public Supply[] getPersonalBelongings() {
        // converts to an array before returning
        return this.personalBelongings.toArray(new Supply[0]);
    }

    public void setFamilyConnections(FamilyRelation[] connections) {
        // converts the input argument "connections" into an ArrayList so that it functions with the class
        ArrayList<FamilyRelation> convertedConnections = new ArrayList<FamilyRelation>(Arrays.asList(connections));
        this.familyConnections = convertedConnections;
    }

    public void setMedicalRecords(MedicalRecord[] records) {
        // converts the input argument "records" into an ArrayList so that it functions with the class
        ArrayList<MedicalRecord> convertedRecords = new ArrayList<MedicalRecord>(Arrays.asList(records));
        this.medicalRecords = convertedRecords;
    }

    public void setPersonalBelongings(Supply[] belongings) {
        // converts the input argument "belongings" into an ArrayList so that it functions with the class
        ArrayList<Supply> convertedBelongings = new ArrayList<Supply>(Arrays.asList(belongings));
        this.personalBelongings = convertedBelongings;
    }
    
    public void addPersonalBelonging(Supply supply) {
        this.personalBelongings.add(supply);
    }

    public void removePersonalBelonging(Supply unwantedSupply) {
        this.personalBelongings.remove(unwantedSupply);
    }

    public void removeFamilyConnection(FamilyRelation exRelation) {
        this.familyConnections.remove(exRelation);
    }

    public void addFamilyConnection(FamilyRelation record) {
        this.familyConnections.add(record);
    }

    private static int generateSocialID() {
        return counter;
    }

    public void addMedicalRecord(MedicalRecord record) {
        this.medicalRecords.add(record);
    }

    public String getEntryDate() {
        return this.ENTRY_DATE;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        String[] validGenderInput = {"male", "female", "other", "prefer not to say"}; // list of genders that will be allowed by the class
        for(int i = 0; i < 4; i++) { // iterate through the list
            if(validGenderInput[i].equalsIgnoreCase(gender)) { // check if the inputted gender matches any of the valid genders
                this.gender = gender; // set the gender and exit
                return;
            }
        }
        throw new IllegalArgumentException("Invalid gender: " + gender); 
        // if the gender is not in the list of valid genders, throw IllegalArgumentException
    }

    private static boolean isValidDateFormat(String date) {
        String datePattern = "\\d{4}-\\d{2}-\\d{2}"; //matches a string in the form YYYY-MM-DD
        return date.matches(datePattern);
    }

    private static int convertDateStringToInt(String dateStr) {
        // will take the date format of YYYY-MM-DD and return a number with the value YYYYMMDD
        return Integer.parseInt(dateStr.replace("-", "")); 
    }

}
