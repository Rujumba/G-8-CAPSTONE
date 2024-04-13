package views.patient.services;

import models.patient.Patient;
import repository.PatientRepositories.PatientRepository;
import views.patient.PatientService;


import java.util.List;
import java.util.Scanner;

public class ClinicPatientService extends PatientService {
    PatientRepository patientRepository = new PatientRepository();

    public void savePatient(Patient patient) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient name");
        patient.setName(scanner.nextLine());

        System.out.println("Enter Doctors Name");
        patient.setDoctorName(scanner.nextLine());

        patient.setFacilityType("CLINIC");

        patientRepository.addPatient(patient);

    }

    public void scheduleAppointment(long patientId, String doctorName) {
        throw new UnsupportedOperationException("Unimplemented method 'scheduleAppointment'");
    }


    public List<Patient> getAppointmentsByDoctor(String doctorName) {
        throw new UnsupportedOperationException("Unimplemented method 'getAppointmentsByDoctor'");
    }

    
}
