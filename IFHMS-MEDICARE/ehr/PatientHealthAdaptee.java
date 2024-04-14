package ehr;
// Utility class for integrating patient health information

public class PatientHealthAdaptee {
        // Retrieve list of patients
    public void retrieveAllPatients() {
        System.out.println("Adaptee: Retrieving list of patients...");
    }

    // Retrieve health records
    public void retrieveAllMedicalRecords() {
        System.out.println("Adaptee: Retrieving health records...");
    }

    // Retrieve diagnosis records
    public void retrieveDiagnosisRecords() {
        System.out.println("Adaptee: Retrieving diagnosis records...");
    }

    // Retrieve insurance records
    public void retrieveInsuranceRecords() {
        System.out.println("Adaptee: Retrieving insurance records...");
    }
    
}
