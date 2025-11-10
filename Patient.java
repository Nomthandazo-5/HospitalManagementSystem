package com.example;

public class Patient {
    private static int idCounter = 1;
    private final int id;
    private final String name;
    private final int age;
    private String diagnosis;
    private String assignedDoctor;

    public Patient(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Patient name cannot be null or empty");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Patient age cannot be negative");
        }

        this.id = idCounter++;
        this.name = name.trim();
        this.age = age;
        this.diagnosis = "Pending";
        this.assignedDoctor = "Unassigned";
    }

    // Getters and setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDiagnosis() { return diagnosis; }
    public String getAssignedDoctor() { return assignedDoctor; }

    public void setDiagnosis(String diagnosis) { this.diagnosis = diagnosis; }
    public void setAssignedDoctor(String doctor) { this.assignedDoctor = doctor; }

    @Override
    public String toString() {
        return String.format("Patient ID: %d | Name: %s | Age: %d | Diagnosis: %s | Doctor: %s",
                id, name, age, diagnosis, assignedDoctor);
    }
}