package com.example;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Hospital Management System - Main application class
 * Manages patients, doctors, and appointments for a hospital.
 *
 * Features:
 * - Patient and Doctor management
 * - Appointment scheduling
 * - Diagnosis tracking
 * - Comprehensive error handling
 */
public class HospitalManagementSystem {
    // Lists to store data
    private static final ArrayList<Patient> patients = new ArrayList<>();
    private static final ArrayList<Doctor> doctors = new ArrayList<>();
    private static final ArrayList<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║   Welcome to Hospital Management System   ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        try (Scanner sc = new Scanner(System.in)) {
            int choice;

            do {
                displayMainMenu();
                String line = sc.nextLine();
                choice = InputValidator.parseInteger(line);

                try {
                    switch (choice) {
                        case 1 -> addPatient(sc);
                        case 2 -> addDoctor(sc);
                        case 3 -> viewPatients();
                        case 4 -> viewDoctors();
                        case 5 -> assignPatientToDoctor(sc);
                        case 6 -> updatePatientDiagnosis(sc);
                        case 7 -> searchPatient(sc);
                        case 8 -> viewDoctorDetails(sc);
                        case 9 -> scheduleAppointment(sc);
                        case 10 -> viewAppointments();
                        case 11 -> updateAppointmentStatus(sc);
                        case 12 -> {
                            System.out.println("\n✓ Thank you for using Hospital Management System. Goodbye!");
                        }
                        default -> System.out.println("❌ Invalid choice! Please try again (1-12).");
                    }
                } catch (Exception e) {
                    System.out.println("❌ An error occurred: " + e.getMessage());
                }
            } while (choice != 12);
        } catch (Exception e) {
            System.out.println("❌ Fatal error: " + e.getMessage());
            System.err.println("Error details: " + e.toString());
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n┌─ Main Menu ─────────────────────────────┐");
        System.out.println("│ 1.  Add Patient                         │");
        System.out.println("│ 2.  Add Doctor                          │");
        System.out.println("│ 3.  View Patients                       │");
        System.out.println("│ 4.  View Doctors                        │");
        System.out.println("│ 5.  Assign Patient to Doctor            │");
        System.out.println("│ 6.  Update Patient Diagnosis            │");
        System.out.println("│ 7.  Search Patient                      │");
        System.out.println("│ 8.  View Doctor Details                 │");
        System.out.println("│ 9.  Schedule Appointment                │");
        System.out.println("│ 10. View Appointments                   │");
        System.out.println("│ 11. Update Appointment Status           │");
        System.out.println("│ 12. Exit                                │");
        System.out.println("└─────────────────────────────────────────┘");
        System.out.print("Enter your choice: ");
    }

    private static void addPatient(Scanner sc) {
        try {
            System.out.print("Enter patient name: ");
            String name = sc.nextLine().trim();
            if (!InputValidator.isValidString(name)) {
                System.out.println("❌ Invalid name. Please enter a non-empty name.");
                return;
            }

            System.out.print("Enter age (0-150): ");
            String ageLine = sc.nextLine();
            int age = InputValidator.parseInteger(ageLine);
            if (!InputValidator.isValidAge(age)) {
                System.out.println("❌ Invalid age. Age must be between 0 and 150.");
                return;
            }

            Patient patient = new Patient(name, age);
            patients.add(patient);
            System.out.println("✓ Patient added successfully! (ID: " + patient.getId() + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static void addDoctor(Scanner sc) {
        try {
            System.out.print("Enter doctor name: ");
            String name = sc.nextLine().trim();
            if (!InputValidator.isValidString(name)) {
                System.out.println("❌ Invalid name. Please enter a non-empty name.");
                return;
            }

            System.out.print("Enter specialization (press Enter for 'General'): ");
            String spec = sc.nextLine().trim();
            if (spec.isEmpty()) {
                spec = "General";
            }

            Doctor doctor = new Doctor(name, spec);
            doctors.add(doctor);
            System.out.println("✓ Doctor added successfully! (ID: " + doctor.getId() + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static void viewPatients() {
        System.out.println("\n╔════ Patient List ═════╗");
        if (patients.isEmpty()) {
            System.out.println("║ No patients registered yet!     ║");
            System.out.println("╚═════════════════════════════════╝");
            return;
        }
        for (Patient p : patients) {
            System.out.println(p);
        }
        System.out.println("╚════════════════════════════════════╝");
    }

    private static void viewDoctors() {
        System.out.println("\n╔════ Doctor List ══════╗");
        if (doctors.isEmpty()) {
            System.out.println("║ No doctors registered yet!      ║");
            System.out.println("╚═════════════════════════════════╝");
            return;
        }
        for (Doctor d : doctors) {
            System.out.println(d);
        }
        System.out.println("╚════════════════════════════════════╝");
    }

    private static void viewDoctorDetails(Scanner sc) {
        if (doctors.isEmpty()) {
            System.out.println("❌ No doctors registered yet!");
            return;
        }

        viewDoctors();
        System.out.print("Enter doctor ID to view details: ");
        String didLine = sc.nextLine();
        int doctorId = InputValidator.parseInteger(didLine);
        if (doctorId == -1) {
            System.out.println("❌ Invalid doctor ID.");
            return;
        }

        Doctor doctor = findDoctorById(doctorId);
        if (doctor == null) {
            System.out.println("❌ Doctor not found!");
            return;
        }

        System.out.println("\n╔════ Doctor Details ═══╗");
        System.out.println(doctor);
        System.out.println("Assigned Patients:");
        if (doctor.getAssignedPatients().isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (Patient p : doctor.getAssignedPatients()) {
                System.out.println("  " + p);
            }
        }
        System.out.println("╚════════════════════════════════════╝");
    }

    private static void assignPatientToDoctor(Scanner sc) {
        try {
            if (patients.isEmpty() || doctors.isEmpty()) {
                System.out.println("❌ Need both patients and doctors to make an assignment!");
                return;
            }

            viewPatients();
            System.out.print("Enter patient ID: ");
            String pidLine = sc.nextLine();
            int patientId = InputValidator.parseInteger(pidLine);
            if (patientId == -1) {
                System.out.println("❌ Invalid patient ID.");
                return;
            }

            viewDoctors();
            System.out.print("Enter doctor ID: ");
            String didLine = sc.nextLine();
            int doctorId = InputValidator.parseInteger(didLine);
            if (doctorId == -1) {
                System.out.println("❌ Invalid doctor ID.");
                return;
            }

            Patient patient = findPatientById(patientId);
            Doctor doctor = findDoctorById(doctorId);

            if (patient != null && doctor != null) {
                doctor.assignPatient(patient);
                System.out.println("✓ Patient assigned successfully!");
            } else {
                System.out.println("❌ Invalid patient or doctor ID!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static void updatePatientDiagnosis(Scanner sc) {
        try {
            if (patients.isEmpty()) {
                System.out.println("❌ No patients registered yet!");
                return;
            }

            viewPatients();
            System.out.print("Enter patient ID: ");
            String pidLine = sc.nextLine();
            int patientId = InputValidator.parseInteger(pidLine);
            if (patientId == -1) {
                System.out.println("❌ Invalid patient ID.");
                return;
            }

            Patient patient = findPatientById(patientId);
            if (patient != null) {
                System.out.print("Enter new diagnosis: ");
                String diagnosis = sc.nextLine().trim();
                if (!InputValidator.isValidString(diagnosis)) {
                    System.out.println("❌ Invalid diagnosis. Please enter a non-empty value.");
                    return;
                }
                patient.setDiagnosis(diagnosis);
                System.out.println("✓ Diagnosis updated successfully!");
            } else {
                System.out.println("❌ Patient not found!");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static void searchPatient(Scanner sc) {
        if (patients.isEmpty()) {
            System.out.println("❌ No patients registered yet!");
            return;
        }

        System.out.print("Enter patient name to search (partial match supported): ");
        String searchName = sc.nextLine().toLowerCase();

        if (!InputValidator.isValidString(searchName)) {
            System.out.println("❌ Invalid search term.");
            return;
        }

        boolean found = false;
        System.out.println("\n╔════ Search Results ═══╗");
        for (Patient p : patients) {
            if (p.getName().toLowerCase().contains(searchName)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ No patients found with that name!");
        }
        System.out.println("╚════════════════════════════════════╝");
    }

    private static void scheduleAppointment(Scanner sc) {
        try {
            if (patients.isEmpty() || doctors.isEmpty()) {
                System.out.println("❌ Need both patients and doctors to schedule an appointment!");
                return;
            }

            viewPatients();
            System.out.print("Enter patient ID: ");
            String pidLine = sc.nextLine();
            int patientId = InputValidator.parseInteger(pidLine);
            if (patientId == -1) {
                System.out.println("❌ Invalid patient ID.");
                return;
            }

            Patient patient = findPatientById(patientId);
            if (patient == null) {
                System.out.println("❌ Patient not found!");
                return;
            }

            viewDoctors();
            System.out.print("Enter doctor ID: ");
            String didLine = sc.nextLine();
            int doctorId = InputValidator.parseInteger(didLine);
            if (doctorId == -1) {
                System.out.println("❌ Invalid doctor ID.");
                return;
            }

            Doctor doctor = findDoctorById(doctorId);
            if (doctor == null) {
                System.out.println("❌ Doctor not found!");
                return;
            }

            System.out.print("Enter appointment purpose: ");
            String purpose = sc.nextLine().trim();
            if (!InputValidator.isValidString(purpose)) {
                System.out.println("❌ Invalid purpose. Please enter a non-empty value.");
                return;
            }

            System.out.println("✓ Appointment scheduled successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }

    private static void viewAppointments() {
        System.out.println("\n╔════ Appointments ═════╗");
        if (appointments.isEmpty()) {
            System.out.println("║ No appointments scheduled yet!  ║");
            System.out.println("╚═════════════════════════════════╝");
            return;
        }
        for (Appointment a : appointments) {
            System.out.println(a);
        }
        System.out.println("╚════════════════════════════════════╝");
    }

    private static void updateAppointmentStatus(Scanner sc) {
        if (appointments.isEmpty()) {
            System.out.println("❌ No appointments to update!");
            return;
        }

        viewAppointments();
        System.out.print("Enter appointment ID: ");
        String aidLine = sc.nextLine();
        int appointmentId = InputValidator.parseInteger(aidLine);
        if (appointmentId == -1) {
            System.out.println("❌ Invalid appointment ID.");
            return;
        }

        try {
            Appointment appointment = findAppointmentById(appointmentId);
            if (appointment == null) {
                System.out.println("❌ Appointment not found!");
                return;
            }

            System.out.println("\nCurrent Status: " + appointment.getStatus());
            System.out.println("1. Scheduled");
            System.out.println("2. Completed");
            System.out.println("3. Cancelled");
            System.out.print("Enter new status (1-3): ");
            String choice = sc.nextLine();
            int statusChoice = InputValidator.parseIntegerInRange(choice, 1, 3);

            String newStatus = switch (statusChoice) {
                case 1 -> "Scheduled";
                case 2 -> "Completed";
                case 3 -> "Cancelled";
                default -> null;
            };

            if (newStatus != null) {
                appointment.setStatus(newStatus);
                System.out.println("✓ Appointment status updated successfully!");
            } else {
                System.out.println("❌ Invalid status choice.");
            }
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("❌ Error: " + e.getMessage());
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

    private static Appointment findAppointmentById(int id) {
        return appointments.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }
}