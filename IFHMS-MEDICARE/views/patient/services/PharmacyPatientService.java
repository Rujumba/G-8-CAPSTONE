package views.patient.services;


import java.util.List;
import java.util.Scanner;
import models.patient.Patient;
import views.patient.PatientService;


public class PharmacyPatientService extends PatientService {





    @Override
    public void savePatient(Patient patient) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient name");
        patient.setName(scanner.nextLine());

        System.out.println("Enter Prescription");
        patient.setPrescription(scanner.nextLine());

        patient.setFacilityType("PHARMACY");
         String patientId = patient.getId();


addPatient(patientId, patient);


    }

    public List<Patient> getMedicationDispensedPatients() {
        throw new UnsupportedOperationException("Unimplemented method 'getMedicationDispensedPatients'");
    }

    
}
