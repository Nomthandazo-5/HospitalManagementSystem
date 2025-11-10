package com.example;

import java.util.ArrayList;

public class Doctor {
    private static int idCounter = 1;

    private final int id;
    private final String name;
    private final String specialization;
    private final ArrayList<Patient> assignedPatients;

    public Doctor(String name, String specialization) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Doctor name cannot be null or empty");
        }
        if (specialization == null) {
            specialization = "General";
        }

        this.id = idCounter++;
        this.name = name.trim();
        this.specialization = specialization.trim();
        this.assignedPatients = new ArrayList<>();
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getSpecialization() { return specialization; }
    public ArrayList<Patient> getAssignedPatients() { return assignedPatients; }

    public void assignPatient(Patient patient) {
        if (patient == null) return;
        if (!assignedPatients.contains(patient)) {
            assignedPatients.add(patient);
            patient.setAssignedDoctor(this.name);
        }
    }

    @Override
    public String toString() {
        return String.format("Doctor ID: %d | Name: %s | Specialization: %s | Patients: %d",
                id, name, specialization, assignedPatients.size());
    }
}