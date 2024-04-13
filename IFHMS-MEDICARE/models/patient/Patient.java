package models.patient;

import java.util.UUID;

public class Patient {

    private String id;

    private String name;

    private String facilityType;

    private String medication;

    private String doctorName;

    private String prescription;

public Patient() {
    this.id = UUID.randomUUID().toString();
}

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String service;


public String getId() {
    return id;
}



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }
}
