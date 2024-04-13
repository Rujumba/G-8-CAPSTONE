package repository.medicalServiceRepository;

import models.medicalService.MedicalService;

import java.util.ArrayList;
import java.util.List;

public class medicalServices {

    List<MedicalService> medicalServices = new ArrayList<>();

    public List<MedicalService> getMedicalServices(){
        MedicalService medicalService = new MedicalService("Treatment", 5000);
        medicalServices.add(medicalService);
        MedicalService medicalService1 = new MedicalService("CheckUp", 10000);
        medicalServices.add(medicalService1);

        return medicalServices;
    }
}
