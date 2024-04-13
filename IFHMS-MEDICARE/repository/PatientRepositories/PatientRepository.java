package repository.PatientRepositories;

 
import java.util.HashMap;
import java.util.Map;
import models.patient.Patient;



public class PatientRepository {
    private static PatientRepository repoSingleton = null;
    public Map<String, Patient> patientsMap;

    private PatientRepository() {
        patientsMap = new HashMap<>();
    }

    public static PatientRepository getInstance() {
        if (repoSingleton == null) {
            repoSingleton = new PatientRepository();
        }
        return repoSingleton;
    }


    public int getMapSize() {
        return patientsMap.size(); 
    }
}
