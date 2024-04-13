package views.patient.services;


import models.patient.Patient;
import repository.PatientRepositories.PatientRepository;
import views.patient.PatientService;

import java.util.List;
import java.util.Scanner;

public class HospitalPatientService extends PatientService {
    PatientRepository patientRepository = new PatientRepository();

    public void savePatient(Patient patient) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient name");
        patient.setName(scanner.nextLine());

        System.out.println("Enter Doctors Name");
        patient.setDoctorName(scanner.nextLine());

        patient.setFacilityType("HOSPITAL");

        patientRepository.addPatient(patient);

    }

    public void admitPatient(long patientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'admitPatient'");
    }

    public void dischargePatient(long patientId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dischargePatient'");
    }

    public List<Patient> getAdmittedPatients() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAdmittedPatients'");
    }

    public List<Patient> getDischargedPatients() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDischargedPatients'");
    }
    
}
