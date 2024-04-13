package views.patient.services;


import views.patient.PatientService;

public class PatientFactory {

     

    public static PatientService createService(String facilityType) {
        if (facilityType.equalsIgnoreCase("hospital")) {
            return new HospitalPatientService();
        } else if (facilityType.equalsIgnoreCase("clinic")) {
            return new ClinicPatientService();
        } else if (facilityType.equalsIgnoreCase("pharmacy")) {
            return new PharmacyPatientService();
        } else {
            throw new IllegalArgumentException("Invalid facility type");
        }
    }
}
