package repository.PatientRepositories;

 
import java.util.HashMap;
import java.util.Map;
import models.patient.Patient;



public class PatientRepository {
    private static PatientRepository repoSingleton = null;
    private Map<String, Patient> patientsMap;

    private PatientRepository() {
        patientsMap = new HashMap<>();
    }

    public static PatientRepository getInstance() {
        if (repoSingleton == null) {
            repoSingleton = new PatientRepository();
        }
        return repoSingleton;
    }

    public Map<String, Patient> getPatientsMap() {
        return patientsMap;
    }

    public void addPatient(String patientId, Patient patient) {
        patientsMap.put(patientId, patient);
    }


    public int getMapSize() {
        return patientsMap.size();
    }
}
