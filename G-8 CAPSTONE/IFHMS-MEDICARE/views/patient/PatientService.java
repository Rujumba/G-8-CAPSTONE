package views.patient;

import models.patient.Patient;
import repository.PatientRepositories.PatientRepository;

import java.util.List;

public abstract class PatientService {
    private final PatientRepository patientRepository = new PatientRepository();


    public void savePatient(Patient patient) {

    }

    public void updatePatient(Patient patient) {
        // Find the patient in the list and update its details
        for (int i = 0; i < patientRepository.getPatientsList().size(); i++) {
            if (patientRepository.getPatientsList().get(i).getId().equals(patient.getId())) {
                patientRepository.getPatientsList().set(i, patient);
                break;
            }
        }
    }

    public void deletePatient(long patientId) {
        // Find the patient in the list and remove it
        patientRepository.getPatientsList().removeIf(patient -> patient.getId().equals(patientId));
    }

    public Patient findPatientById(String patientId) {
        // Find and return the patient with the specified ID
        for (Patient patient : patientRepository.getPatientsList()) {
            if (patient.getId().equals(patientId)) {
                return patient;
            }
        }
        return null; // Patient not found
    }

    public List<Patient> getAllPatients() {
        return patientRepository.getPatientsList();
    }

    public boolean isPatientExists(long patientId) {
        // Check if patient exists by iterating over the list
        return patientRepository.getPatientsList().stream().anyMatch(patient -> patient.getId().equals(patientId));
    }

    public int getTotalPatientCount() {
        return patientRepository.getPatientsList().size();
    }
}

