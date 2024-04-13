package views.patient.services;


import java.util.List;
import java.util.Scanner;
import models.patient.Patient;
import repository.PatientRepositories.PatientRepository;
import views.patient.PatientService;


public class PharmacyPatientService extends PatientService {

    PatientRepository patientRepository = PatientRepository.getInstance();



    @Override
    public void savePatient(Patient patient) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient name");
        patient.setName(scanner.nextLine());

        System.out.println("Enter Prescription");
        patient.setPrescription(scanner.nextLine());

        patient.setFacilityType("PHARMACY");
         String patientId = patient.getId();


patientRepository.addPatient(patientId, patient);


    }

    public List<Patient> getMedicationDispensedPatients() {
        throw new UnsupportedOperationException("Unimplemented method 'getMedicationDispensedPatients'");
    }

    
}
