package views.patient;

import java.util.Map;
import models.patient.Patient;
import repository.PatientRepositories.PatientRepository;

// import repository.PatientRepositories.patientList;


public abstract class PatientService {
    PatientRepository patientRepository = PatientRepository.getInstance();


    Map<String, Patient> patientsMap = patientRepository.patientsMap;

    public void savePatient(Patient patient) {

    }

    public Map<String, Patient> getPatientsMap() {
        return  patientsMap;
    }

    public void addPatient(String patientId, Patient patient) {
        patientsMap.put(patientId, patient);
    }
    public void updatePatient(Patient patient) {
        // Find the patient in the map and update its details
        if (patientsMap.containsKey(patient.getId())) {
            patientsMap.put(patient.getId(), patient);
        }
    }

    public void deletePatient(String patientId) {
        patientsMap.remove(patientId);
    }

    public Patient findPatientById(String patientId) {
        // Find and return the patient with the specified ID
        return patientsMap.get(patientId);
    }

    public boolean isPatientExists(String patientId) {
        // Check if patient exists in the patientsMap
        return patientsMap.containsKey(patientId);
    }


    public int getTotalPatientCount() {
        return patientsMap.size();
    }
 
}

