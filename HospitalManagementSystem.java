package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class HospitalManagementSystem {
    // Lists to store data
    private static final ArrayList<Patient> patients = new ArrayList<>();
    private static final ArrayList<Doctor> doctors = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("🏥 Welcome to Hospital Management System");

        try (Scanner sc = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("\n--- Menu ---");
                System.out.println("1. Add Patient");
                System.out.println("2. Add Doctor");
                System.out.println("3. View Patients");
                System.out.println("4. View Doctors");
                System.out.println("5. Assign Patient to Doctor");
                System.out.println("6. Update Patient Diagnosis");
                System.out.println("7. Search Patient");
                System.out.println("8. View Doctor Details");
                System.out.println("9. Exit");
                System.out.print("Enter choice: ");

                String line = sc.nextLine();
                try {
                    choice = Integer.parseInt(line.trim());
                } catch (NumberFormatException e) {
                    choice = -1;
                }

                switch (choice) {
                    case 1 -> addPatient(sc);
                    case 2 -> addDoctor(sc);
                    case 3 -> viewPatients();
                    case 4 -> viewDoctors();
                    case 5 -> assignPatientToDoctor(sc);
                    case 6 -> updatePatientDiagnosis(sc);
                    case 7 -> searchPatient(sc);
                    case 8 -> viewDoctorDetails(sc);
                    case 9 -> System.out.println("Exiting... 👋");
                    default -> System.out.println("Invalid choice! Try again.");
                }
            } while (choice != 8);
        }
    }

    private static void addPatient(Scanner sc) {
        System.out.print("Enter patient name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Invalid name. Aborting.");
            return;
        }

        System.out.print("Enter age: ");
        String ageLine = sc.nextLine();
        int age;
        try {
            age = Integer.parseInt(ageLine.trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age. Aborting.");
            return;
        }

        patients.add(new Patient(name, age));
        System.out.println("✅ Patient added successfully!");
    }

    private static void addDoctor(Scanner sc) {
        System.out.print("Enter doctor name: ");
        String name = sc.nextLine().trim();
        if (name.isEmpty()) {
            System.out.println("Invalid name. Aborting.");
            return;
        }

        System.out.print("Enter specialization: ");
        String spec = sc.nextLine().trim();
        if (spec.isEmpty()) spec = "General";

        doctors.add(new Doctor(name, spec));
        System.out.println("✅ Doctor added successfully!");
    }

    private static void viewPatients() {
        System.out.println("\n--- Patient List ---");
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet!");
            return;
        }
        for (Patient p : patients) {
            System.out.println(p);
        }
    }

    private static void viewDoctors() {
        System.out.println("\n--- Doctor List ---");
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered yet!");
            return;
        }
        for (Doctor d : doctors) {
            System.out.println(d);
        }
    }

    private static void viewDoctorDetails(Scanner sc) {
        if (doctors.isEmpty()) {
            System.out.println("No doctors registered yet!");
            return;
        }

        viewDoctors();
        System.out.print("Enter doctor ID to view details: ");
        String didLine = sc.nextLine();
        int doctorId;
        try {
            doctorId = Integer.parseInt(didLine.trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("Doctor not found!");
            return;
        }

        System.out.println("\n--- Doctor Details ---");
        System.out.println(doctor);
        System.out.println("Assigned Patients:");
        if (doctor.getAssignedPatients().isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (Patient p : doctor.getAssignedPatients()) {
                System.out.println("  " + p);
            }
        }
    }

    private static void assignPatientToDoctor(Scanner sc) {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("Need both patients and doctors to make an assignment!");
            return;
        }

        viewPatients();
        System.out.print("Enter patient ID: ");
        String pidLine = sc.nextLine();
        int patientId;
        try {
            patientId = Integer.parseInt(pidLine.trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid patient ID.");
            return;
        }

        viewDoctors();
        System.out.print("Enter doctor ID: ");
        String didLine = sc.nextLine();
        int doctorId;
        try {
            doctorId = Integer.parseInt(didLine.trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid doctor ID.");
            return;
        }

        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);

        if (patient != null && doctor != null) {
            doctor.assignPatient(patient);
            System.out.println("✅ Patient assigned successfully!");
        } else {
            System.out.println("❌ Invalid patient or doctor ID!");
        }
    }

    private static void updatePatientDiagnosis(Scanner sc) {
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet!");
            return;
        }

        viewPatients();
        System.out.print("Enter patient ID: ");
        String pidLine = sc.nextLine();
        int patientId;
        try {
            patientId = Integer.parseInt(pidLine.trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid patient ID.");
            return;
        }

        Patient patient = findPatientById(patientId);
        if (patient != null) {
            System.out.print("Enter new diagnosis: ");
            String diagnosis = sc.nextLine();
            patient.setDiagnosis(diagnosis);
            System.out.println("✅ Diagnosis updated successfully!");
        } else {
            System.out.println("❌ Patient not found!");
        }
    }

    private static void searchPatient(Scanner sc) {
        if (patients.isEmpty()) {
            System.out.println("No patients registered yet!");
            return;
        }

        System.out.print("Enter patient name to search: ");
        String searchName = sc.nextLine().toLowerCase();

        boolean found = false;
        System.out.println("\n--- Search Results ---");
        for (Patient p : patients) {
            if (p.getName().toLowerCase().contains(searchName)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No patients found with that name!");
        }
    }

    private static Patient findPatientById(int id) {
        return patients.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    private static Doctor findDoctorById(int id) {
        return doctors.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }
}