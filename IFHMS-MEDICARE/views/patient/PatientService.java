package views.patient;

import models.patient.Patient;
// import repository.PatientRepositories.patientList;


public abstract class PatientService {
    // List <Patient> patienList = patientList.getPatientRepo();


    public void savePatient(Patient patient) {

    }

    // public void updatePatient(Patient patient) {
    //     // Find the patient in the list and update its details
    //     for (int i = 0; i < patienList.size(); i++) {
    //         if (patientList.get(i).getId().equals(patient.getId())) {
    //             patientList.set(i, patient);
    //             break;
    //         }
    //     }
    // }

    // public void deletePatient(long patientId) {
    //     // Find the patient in the list and remove it
    //     patientList.getPatientsList().removeIf(patient -> patient.getId().equals(patientId));
    // }

    // public Patient findPatientById(String patientId) {
    //     // Find and return the patient with the specified ID
    //     for (Patient patient : patientList.getPatientsList()) {
    //         if (patient.getId().equals(patientId)) {
    //             return patient;
    //         }
    //     }
    //     return null; // Patient not found
    // }

    // public List<Patient> getAllPatients() {
    //     return patientList.getPatientsList();
    // }

    // public boolean isPatientExists(long patientId) {
    //     // Check if patient exists by iterating over the list
    //     return patientList.getPatientsList().stream().anyMatch(patient -> patient.getId().equals(patientId));
    // }

    // public int getTotalPatientCount() {
    //     return patientList.getPatientsList().size();
    // }
}

