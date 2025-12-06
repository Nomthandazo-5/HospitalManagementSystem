package com.example;

import java.util.ArrayList;

/**
 * Represents a doctor in the Hospital Management System.
 * Manages doctor information and their assigned patients.
 */
public class Doctor {
    private static int idCounter = 1;
    private final int id;
    private final String name;
    private final String specialization;
    private final ArrayList<Patient> assignedPatients;
    private String licenseNumber;
    private String contactNumber;
    private int yearsOfExperience;

    /**
     * Constructs a Doctor with validation.
     * @param name Doctor's name (non-empty)
     * @param specialization Doctor's specialization (defaults to "General" if null)
     * @throws IllegalArgumentException if name is empty
     */
    public Doctor(String name, String specialization) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be null or empty");
        }
        if (specialization == null || specialization.trim().isEmpty()) {
            specialization = "General";
        }

        this.id = idCounter++;
        this.name = name.trim();
        this.specialization = specialization.trim();
        this.assignedPatients = new ArrayList<>();
        this.licenseNumber = "";
        this.contactNumber = "";
        this.yearsOfExperience = 0;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public ArrayList<Patient> getAssignedPatients() { return assignedPatients; }
    public String getLicenseNumber() { return licenseNumber; }
    public String getContactNumber() { return contactNumber; }
    public int getYearsOfExperience() { return yearsOfExperience; }

    /**
     * Assigns a patient to this doctor.
     * @param patient the patient to assign
     * @throws IllegalArgumentException if patient is null
     */
    public void assignPatient(Patient patient) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        if (!assignedPatients.contains(patient)) {
            assignedPatients.add(patient);
            patient.setAssignedDoctor(this.name);
        }
    }

    /**
     * Removes a patient from this doctor's list.
     * @param patient the patient to remove
     * @return true if removed, false if not found
     */
    public boolean removePatient(Patient patient) {
        if (patient == null) return false;
        return assignedPatients.remove(patient);
    }

    public void setLicenseNumber(String licenseNumber) {
        if (licenseNumber == null || licenseNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("License number cannot be null or empty");
        }
        this.licenseNumber = licenseNumber.trim();
    }

    public void setContactNumber(String contactNumber) {
        if (contactNumber == null || !contactNumber.matches("^[\\d\\s\\-\\+\\(\\)]{10,}$")) {
            throw new IllegalArgumentException("Invalid contact number format");
        }
        this.contactNumber = contactNumber.trim();
    }

    public void setYearsOfExperience(int years) {
        if (years < 0 || years > 70) {
            throw new IllegalArgumentException("Years of experience must be between 0 and 70");
        }
        this.yearsOfExperience = years;
    }

    @Override
    public String toString() {
        return String.format("Doctor ID: %d | Name: %s | Specialization: %s | Experience: %d years | Patients: %d",
                id, name, specialization, yearsOfExperience, assignedPatients.size());
    }
}