package com.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private static int idCounter = 1;
    private final int id;
    private final Patient patient;
    private final Doctor doctor;
    private LocalDateTime appointmentTime;
    private String purpose;
    private String status; // "Scheduled", "Completed", "Cancelled"
    private String notes;

    public Appointment(Patient patient, Doctor doctor, LocalDateTime appointmentTime, String purpose) {
        if (patient == null) {
            throw new IllegalArgumentException("Patient cannot be null");
        }
        if (doctor == null) {
            throw new IllegalArgumentException("Doctor cannot be null");
        }
        if (appointmentTime == null || appointmentTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment time must be in the future");
        }
        if (purpose == null || purpose.trim().isEmpty()) {
            throw new IllegalArgumentException("Appointment purpose cannot be empty");
        }

        this.id = idCounter++;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentTime = appointmentTime;
        this.purpose = purpose.trim();
        this.status = "Scheduled";
        this.notes = "";
    }

    // Getters
    public int getId() { return id; }
    public Patient getPatient() { return patient; }
    public Doctor getDoctor() { return doctor; }
    public LocalDateTime getAppointmentTime() { return appointmentTime; }
    public String getPurpose() { return purpose; }
    public String getStatus() { return status; }
    public String getNotes() { return notes; }

    // Setters with validation
    public void setStatus(String status) {
        if (status == null || (!status.equals("Scheduled") && !status.equals("Completed") && !status.equals("Cancelled"))) {
            throw new IllegalArgumentException("Invalid status. Must be 'Scheduled', 'Completed', or 'Cancelled'");
        }
        this.status = status;
    }

    public void setNotes(String notes) {
        if (notes == null) {
            this.notes = "";
        } else {
            this.notes = notes.trim();
        }
    }

    public void reschedule(LocalDateTime newTime) {
        if (newTime == null || newTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("New appointment time must be in the future");
        }
        if (status.equals("Completed") || status.equals("Cancelled")) {
            throw new IllegalStateException("Cannot reschedule a " + status.toLowerCase() + " appointment");
        }
        this.appointmentTime = newTime;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return String.format("Appointment ID: %d | Patient: %s | Doctor: %s | Time: %s | Purpose: %s | Status: %s",
                id, patient.getName(), doctor.getName(), appointmentTime.format(formatter), purpose, status);
    }
}
