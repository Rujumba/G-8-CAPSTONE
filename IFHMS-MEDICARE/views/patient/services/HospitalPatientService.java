package views.patient.services;


import java.util.List;
import java.util.Scanner;
import models.patient.Patient;
import views.patient.PatientService;


public class HospitalPatientService extends PatientService {

    @Override
    public void savePatient(Patient patient) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Patient name");
        patient.setName(scanner.nextLine());

        System.out.println("Enter Doctors Name");
        patient.setDoctorName(scanner.nextLine());

        patient.setFacilityType("HOSPITAL");
        String patientId = patient.getId();

        addPatient(patientId, patient);

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
