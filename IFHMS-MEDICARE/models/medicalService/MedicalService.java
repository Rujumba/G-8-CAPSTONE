package models.medicalService;

public class MedicalService {
    private String serviceName;
    private double servicePrice;
    private String serviceId;

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceId() {
        return serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(double servicePrice) {
        this.servicePrice = servicePrice;
    }


    public MedicalService(String serviceName, double servicePrice, String serviceId) {
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.serviceId = serviceId;
    }
}
