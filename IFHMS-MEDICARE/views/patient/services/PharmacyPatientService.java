package views.patient.services;


import models.patient.Patient;
import repository.PatientRepositories.PatientRepository;
import views.patient.PatientService;

import java.util.List;
import java.util.Scanner;

public class PharmacyPatientService extends PatientService {

    PatientRepository patientRepository = new PatientRepository();

    public void savePatient(Patient patient) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient name");
        patient.setName(scanner.nextLine());

        System.out.println("Enter Prescription");
        patient.setPrescription(scanner.nextLine());

        patient.setFacilityType("PHARMACY");

        patientRepository.addPatient(patient);

    }

    public List<Patient> getMedicationDispensedPatients() {
        throw new UnsupportedOperationException("Unimplemented method 'getMedicationDispensedPatients'");
    }

    
}
