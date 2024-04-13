package repository.PatientRepositories;

import models.patient.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository {
    private List<Patient> patientsList = new ArrayList<>();

    public List<Patient> getPatientsList() {
        return patientsList;
    }

    public void setPatientsList(List<Patient> patientsList) {
        this.patientsList = patientsList;
    }

    public void addPatient(Patient patient){
        patientsList.add(patient);
    }
    
}
