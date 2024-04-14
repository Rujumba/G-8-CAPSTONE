package ehr;

import views.logger.services.DebugLogger;

public class PatientHealthAdapter extends PatientHealthAdaptee implements PatientHealthTarget{
    
    // The PatientHealthAdapter extends PatientHealthAdaptee to leverage its existing functionality
    // and implements PatientHealthTarget to conform to the expected interface for interacting
    // with patient health information.

    DebugLogger logger = DebugLogger.getLogger();


    // Retrieve all patients
    @Override
    public void retrieveAllPatients() {
        // Log info
        logger.printInfo("Retrieving all patients...");
        // Call adaptee method
        retrieveAllPatients();
        // Log success message
        logger.logSuccess("All patients retrieved successfully.");
    }

    // Retrieve patient diagnoses
    @Override
    public void retrievePatientDiagnoses() {
        // Log info
        logger.printInfo("Retrieving patient diagnoses...");
        // Call adaptee method
        retrieveDiagnosisRecords();
        // Log success message
        logger.logSuccess("Patient diagnoses retrieved successfully.");
    }

    // Retrieve insurance information
    @Override
    public void retrieveInsuranceInformation() {
        // Log info
        logger.printInfo("Retrieving insurance information...");
        // Call adaptee method
        retrieveInsuranceRecords();
        // Log success message
        logger.logSuccess("Insurance information retrieved successfully.");
    }

    // Retrieve medical records
    @Override
    public void retrieveMedicalRecords() {
        // Log info
        logger.printInfo("Retrieving medical records...");
        // Call adaptee method
        retrieveAllMedicalRecords();
        // Log success message
        logger.logSuccess("Medical records retrieved successfully.");
    }
}
