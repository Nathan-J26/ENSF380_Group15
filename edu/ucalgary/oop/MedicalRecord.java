package edu.ucalgary.oop;

public class MedicalRecord {
    private Location location;
    private String treatmentDetails;
    private String dateOfTreatment;

    public MedicalRecord(Location location, String treatmentDetails, String dateOfTreatment) {
        if(isValidDateFormat(dateOfTreatment)) {
            this.location = location;
            this.treatmentDetails = treatmentDetails;
            this.dateOfTreatment = dateOfTreatment;
        }
        else {
            throw new IllegalArgumentException("Invalid date format: " + dateOfTreatment);
        }
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getTreatmentDetails() {
        return this.treatmentDetails;

        ////////////////// Says it should return an exception?????????
    }

    public void setTreatmentDetails(String treatmentDetails) {
        this.treatmentDetails = treatmentDetails;
    }

    public String getDateOfTreatment() {
        return this.dateOfTreatment;
    }

    public void setDateOfTreatment(String dateOfTreatment) {
        if(isValidDateFormat(dateOfTreatment)) {
            this.dateOfTreatment = dateOfTreatment;
        }
        else {
            throw new IllegalArgumentException("Invalid date format: " + dateOfTreatment);
        }
    }

    private boolean isValidDateFormat(String date) {
        String datePattern = "\\d{4}-\\d{2}-\\d{2}"; //matches a string in the form YYYY-MM-DD
        return date.matches(datePattern);
    }

}
