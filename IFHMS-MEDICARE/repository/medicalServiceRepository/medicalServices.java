package repository.medicalServiceRepository;

import models.medicalService.MedicalService;

import java.util.HashMap;
import java.util.Map;

public class MedicalServices {

    public Map<String, MedicalService> memdicalServicesMap;

    public MedicalServices(){
        memdicalServicesMap = new HashMap<>();
        addService("Medical Checkup", 10000.0);
        addService("Vaccination", 50000.0);
        addService("Dental Checkup", 20000.0);
    }

    private void addService(String serviceName, double servicePrice) {
        String serviceId = "S" + (memdicalServicesMap.size() + 1);
        memdicalServicesMap.put(serviceId, new MedicalService(serviceName, servicePrice, serviceId));
    }
}
