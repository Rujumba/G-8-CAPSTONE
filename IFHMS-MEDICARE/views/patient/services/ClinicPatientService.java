package views.patient.services;

import java.util.List;
import java.util.Scanner;
import models.patient.Patient;
import repository.PatientRepositories.PatientRepository;
import views.patient.PatientService;

public class ClinicPatientService extends PatientService {
    PatientRepository patientRepository = PatientRepository.getInstance();
   


    @Override
    public void savePatient(Patient patient) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient name");
        patient.setName(scanner.nextLine());

        System.out.println("Enter Doctors Name");
        patient.setDoctorName(scanner.nextLine());
        String patientId = patient.getId();


addPatient(patientId, patient);
        String message = patient.toString();

        System.out.print(message);
        System.out.print("dahvjebhjlbawuebwfa");


        // scanner.close();

    }

    public void scheduleAppointment(long patientId, String doctorName) {
        throw new UnsupportedOperationException("Unimplemented method 'scheduleAppointment'");
    }


    public List<Patient> getAppointmentsByDoctor(String doctorName) {
        throw new UnsupportedOperationException("Unimplemented method 'getAppointmentsByDoctor'");
    }

    
}
