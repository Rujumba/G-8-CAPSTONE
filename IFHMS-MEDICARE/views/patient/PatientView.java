package views.patient;


import java.util.Map;
import java.util.Scanner;

import models.account.AccountReceivable;
import models.medicalService.MedicalService;
import models.patient.Patient;
import repository.PatientRepositories.PatientRepository;
import repository.medicalServiceRepository.MedicalServices;
import views.accountReconcilation.services.AccountReceivableService;
import views.patient.services.PatientFactory;


public class PatientView {
    private static Scanner scanner = new Scanner(System.in);
    private static PatientRepository patientRepository = PatientRepository.getInstance();
    Map<String, Patient> patientMap = patientRepository.patientsMap;
    private static MedicalServices medicalServices = new MedicalServices();

    private static PatientService patientService;

    public void choosePatientOption(){

        while (true) {
          System.out.println("\033[0;34m╔══════════════════════╗");
            System.out.println("║        Menu          ║");
            System.out.println("╠══════════════════════╣");
            System.out.println("║ 1. Register Patient  ║");
            System.out.println("║ 2. View Patients     ║");
            System.out.println("║ 3. Delete Patient    ║");
            System.out.println("║ 4. Assign Service    ║");
            System.out.println("║ 5. Exit              ║");
            System.out.println("╚══════════════════════╝");
            System.out.print("\033[0mEnter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                scanner.nextLine(); // Consume newline character
                continue;
            }
            // ...

            switch (choice) {
                case 1:
                    System.out.println("Select the facility type");
                    System.out.println("1. Hospital");
                    System.out.println("2. Clinic");
                    System.out.println("3. Pharmacy");

                    int selectedFacility;

                    try {
                        selectedFacility = scanner.nextInt();


                       switch (selectedFacility) {
                            case 1:
                                patientService = PatientFactory.createService("hospital");
                                patientService.savePatient(new Patient());
                                break;
                            case 2:
                                patientService = PatientFactory.createService("clinic");
                                patientService.savePatient(new Patient());
                                break;
                            case 3:
                                patientService = PatientFactory.createService("pharmacy");
                                patientService.savePatient(new Patient());
                                break;
                            default:
                                System.out.println("Wrong option selected");
                                break;
                        }
                    }catch (Exception e){
                        System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                        scanner.nextLine(); // Consume newline character
                        continue;
                    }

                    break;
                case 2:
                    System.out.println("-------------------------Patients----------------------");
                    //create a table showing each patient details

                    System.out.println("Patient ID\tPatient Name\tFacility Type");
                    for(Patient patient: patientMap.values()){
                        System.out.println(patient.getId()+"\t"+patient.getName()+"\t"+patient.getFacilityType());
                    }

                    break;
                case 3:
                    System.out.println("You selected Delete Patient");
                    deletePatient();
                    break;
                case 4:
                    //i want to first display a list of the patients
                    //then prompt the user to select a patient
                    //then display a list of services and ask the user to select a service
                    //then save the service to the patient
                    System.out.println("-------------------------Assign Service----------------------");
                    System.out.println("List of Patients:");
                    for(Patient patient: patientMap.values()){
                        System.out.println(patient.getId()+"\t"+patient.getName()+"\t"+patient.getFacilityType());
                    }
                    System.out.print("Enter the ID of the patient to assign service to: ");
                    String patientId = scanner.nextLine();
                    Patient patient = patientService.findPatientById(patientId);
                    if(patient == null){
                        System.out.println("Patient not found");
                        break;
                    }
                    System.out.println("Select the service to assign to the patient");
                    System.out.println("Service ID\tService Name\tService Price");
                    for (MedicalService medicalService: medicalServices.memdicalServicesMap.values()){
                        System.out.println(medicalService.getServiceId()+"\t"+medicalService.getServiceName()+"\t"+medicalService.getServicePrice());
                    }

                    System.out.print("Enter the ID of the service to assign to the patient: ");
                    String serviceId = scanner.nextLine();
                    MedicalService medicalService = medicalServices.memdicalServicesMap.get(serviceId);
                    if(medicalService == null){
                        System.out.println("Service not found");
                        break;
                    }
                    patient.setService(medicalService.getServiceName());
                    patientService.updatePatient(patient);

                    AccountReceivable accountReceivable = new AccountReceivable();
                    accountReceivable.setAmount(medicalService.getServicePrice());
                    accountReceivable.setDescription(medicalService.getServiceName()+" to "+patient.getName());

                    AccountReceivableService accountReceivableService = new AccountReceivableService();
                    accountReceivableService.saveToAccountsReceivable(accountReceivable);

                    break;
                case 5:
                    System.out.println("\nExiting...");
                    // scanner.close();
                    return;
                default:
                    System.out.println("\nInvalid choice. Please choose a number between 1 and 5.");
            }
        }
    }



            private static void deletePatient() {
                while (true) {
                    // Retrieve the list of patients
                    // List<Patient> patientsList = patientService.getAllPatients();
                    
                    // Display the list of patients with their IDs
                    System.out.println("List of Patients:");
                    // for (int i = 0; i < patientList.size(); i++) {
                    //     System.out.println((i + 1) + ". " + patientList.get(i).getName());
                    // }
                    
                    // Prompt the user to enter the ID of the patient to delete
                    System.out.print("Enter the ID of the patient to delete (or 0 to cancel): ");
                    int patientIdToDelete = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    
                    // Check if the user wants to cancel
                    if (patientIdToDelete == 0) {
                        System.out.println("Operation cancelled.");
                        return;
                    }
                    
                    // Check if the entered ID is valid
                    // if (patientIdToDelete >= 1 && patientIdToDelete <= patientList.size()) {
                    //     // Confirm deletion
                    //     System.out.print("Are you sure you want to delete this patient? (yes/no): ");
                    //     String confirmation = scanner.nextLine().trim().toLowerCase();
                        
                    //     if (confirmation.equals("yes")) {
                    //         // Call the deletePatient method from PatientService
                    //         // patientService.deletePatient(patientList.get(patientIdToDelete - 1).getId());
                    //         System.out.println("Patient deleted successfully.");
                    //         return;
                    //     } else if (confirmation.equals("no")) {
                    //         System.out.println("Deletion cancelled.");
                    //         return;
                    //     } else {
                    //         System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                    //     }
                    // } else {
                    //     System.out.println("Invalid patient ID. Please try again.");
                    // }
                }
            }
            
            
}



 