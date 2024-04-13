package views.patient;


import models.patient.Patient;
import repository.PatientRepositories.PatientRepository;
import views.patient.services.PatientFactory;

import java.util.List;
import java.util.Scanner;

public class PatientView {
    private static Scanner scanner = new Scanner(System.in);
    PatientRepository patientRepository = new PatientRepository();

    private static PatientService patientService;

    public void choosePatientOption(){

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Register Patient");
            System.out.println("2. View Patients");
            System.out.println("3. Delete Patient");
            System.out.println("4. Assign Service");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
            } catch (Exception e) {
                System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                scanner.nextLine(); // Consume newline character
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("Select the facility type");
                    System.out.println("1. Hospital");
                    System.out.println("2. Clinic");
                    System.out.println("3. Pharmacy");

                    int selectedFacility;

                    try {
                        selectedFacility = scanner.nextInt();


                        switch (selectedFacility){
                            case 1:
                                patientService = PatientFactory.createService("hospital");
                                patientService.savePatient(new Patient());

                                break;
                            case 2:
                                patientService = PatientFactory.createService("clinic");
                                patientService.savePatient(new Patient());
                            case 3:
                                patientService = PatientFactory.createService("clinic");
                                patientService.savePatient(new Patient());
                            default:
                                System.out.println("Wrong option selected");
                        }
                    }catch (Exception e){
                        System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                        scanner.nextLine(); // Consume newline character
                        continue;
                    }

                    break;
                case 2:
                    List<Patient> patientsList = patientService.getAllPatients();
                    System.out.println("-------------------------Patients----------------------");
                    //create a table showing each patient details

                    System.out.println("List size "+patientsList.size());
                    System.out.println("Patient Name\tFacility Type\tDoctor Name");
                    for (Patient patient1: patientsList){
                        System.out.println(patient1.getName()+"\t"+patient1.getFacilityType()+"\t"+patient1.getDoctorName());
                    }

                    break;
                case 3:
                    System.out.println("You selected Delete Patient");
                    deletePatient();
                    break;
                case 4:
                    System.out.println("You selected Assign Service");
                    // Call method to handle assigning a service
                    break;
                case 5:
                    System.out.println("\nExiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("\nInvalid choice. Please choose a number between 1 and 5.");
            }
        }
    }



            private static void deletePatient() {
                while (true) {
                    // Retrieve the list of patients
                    List<Patient> patientsList = patientService.getAllPatients();
                    
                    // Display the list of patients with their IDs
                    System.out.println("List of Patients:");
                    for (int i = 0; i < patientsList.size(); i++) {
                        System.out.println((i + 1) + ". " + patientsList.get(i).getName());
                    }
                    
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
                    if (patientIdToDelete >= 1 && patientIdToDelete <= patientsList.size()) {
                        // Confirm deletion
                        System.out.print("Are you sure you want to delete this patient? (yes/no): ");
                        String confirmation = scanner.nextLine().trim().toLowerCase();
                        
                        if (confirmation.equals("yes")) {
                            // Call the deletePatient method from PatientService
                            patientService.deletePatient(patientsList.get(patientIdToDelete - 1).getId());
                            System.out.println("Patient deleted successfully.");
                            return;
                        } else if (confirmation.equals("no")) {
                            System.out.println("Deletion cancelled.");
                            return;
                        } else {
                            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
                        }
                    } else {
                        System.out.println("Invalid patient ID. Please try again.");
                    }
                }
            }
            
            
}
