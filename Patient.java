package com.example;

/**
 * Represents a patient in the Hospital Management System.
 * Provides validation for patient data and manages patient information.
 */
public class Patient {
    private static int idCounter = 1;
    private final int id;
    private final String name;
    private final int age;
    private String diagnosis;
    private String assignedDoctor;
    private String contactNumber;
    private String medicalHistory;

    /**
     * Constructs a Patient with validation.
     * @param name Patient's name (non-empty)
     * @param age Patient's age (0-150)
     * @throws IllegalArgumentException if name is empty or age is invalid
     */
    public Patient(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty");
        }
        if (age < 0 || age > 150) {
            throw new IllegalArgumentException("Patient age must be between 0 and 150");
        }

        this.id = idCounter++;
        this.name = name.trim();
        this.age = age;
        this.diagnosis = "Pending";
        this.assignedDoctor = "Unassigned";
        this.contactNumber = "";
        this.medicalHistory = "";
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }
    public String getAssignedDoctor() { return assignedDoctor; }
    public String getContactNumber() { return contactNumber; }
    public String getMedicalHistory() { return medicalHistory; }

    public void setDiagnosis(String diagnosis) {
        if (diagnosis == null || diagnosis.trim().isEmpty()) {
            throw new IllegalArgumentException("Diagnosis cannot be null or empty");
        }
        this.diagnosis = diagnosis.trim();
    }

    public void setAssignedDoctor(String doctor) {
        if (doctor == null || doctor.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be null or empty");
        }
        this.assignedDoctor = doctor.trim();
    }

    public void setContactNumber(String contactNumber) {
        if (contactNumber == null || !contactNumber.matches("^[\\d\\s\\-\\+\\(\\)]{10,}$")) {
            throw new IllegalArgumentException("Invalid contact number format");
        }
        this.contactNumber = contactNumber.trim();
    }

    public void setMedicalHistory(String history) {
        if (history == null || history.trim().isEmpty()) {
            throw new IllegalArgumentException("Medical history cannot be null or empty");
        }
        this.medicalHistory = history.trim();
    }

    @Override
    public String toString() {
        return String.format("Patient ID: %d | Name: %s | Age: %d | Diagnosis: %s | Doctor: %s | Contact: %s",
                id, name, age, diagnosis, assignedDoctor, contactNumber.isEmpty() ? "N/A" : contactNumber);
    }
}