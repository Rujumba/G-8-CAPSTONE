package ehr;
// Interface for interacting with patient health information
public interface PatientHealthTarget {
      // Retrieve patient's insurance information
    public void retrieveInsuranceInformation();

    // Retrieve all patient records
    public void retrieveAllPatients();

    // Retrieve patient's medical records
    public void retrieveMedicalRecords();

    // Retrieve patient's diagnosis information
    public void retrievePatientDiagnoses();
}
