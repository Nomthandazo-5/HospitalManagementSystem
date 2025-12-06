# Hospital Management System

A comprehensive Java console application for managing hospital operations including patients, doctors, and medical appointments with robust error handling and data validation.

##  Project Overview

This system provides a complete solution for managing hospital operations:
- **Patient Management**: Add, view, search, and manage patients
- **Doctor Management**: Register and manage doctors with specializations
- **Appointment Scheduling**: Schedule, track, and manage medical appointments
- **Assignment Management**: Assign patients to doctors with tracking
- **Diagnosis Tracking**: Update and manage patient diagnoses
- **Data Validation**: Comprehensive input validation on all fields
- **Error Handling**: Robust error management without crashes

##  Core Features

### 1. Patient Management
- Add new patients with validation (age 0-150)
- View all registered patients with complete details
- Search patients by name (partial match supported)
- Update patient diagnoses
- Track patient contact information
- Manage medical history

### 2. Doctor Management
- Register doctors with name and specialization
- View all doctors with patient counts
- View detailed doctor information
- Track doctors' assigned patients
- Manage professional credentials
- Monitor years of experience

### 3. Appointment System
- Schedule appointments between patients and doctors
- View all scheduled appointments
- Update appointment status (Scheduled, Completed, Cancelled)
- Reschedule appointments as needed
- Add notes to appointments
- Track appointment history

### 4. Assignment & Diagnosis
- Assign patients to specific doctors
- Prevent duplicate patient assignments
- Update patient diagnoses with validation
- Automatic bidirectional updates
- View complete patient-doctor relationships

### 5. Data Validation
- **Patient name**: Non-empty string validation
- **Patient age**: Range validation (0-150 years)
- **Doctor name**: Non-empty string validation
- **Contact number**: Format validation (10+ digits)
- **Appointment date**: Future date validation
- **Appointment status**: Enum-like value validation
- **Experience**: Range validation (0-70 years)

### 6. Error Handling
- Try-catch blocks for all operations
- Custom HospitalException class
- Null pointer prevention
- NumberFormatException handling
- User-friendly error messages
- Graceful failure recovery

##  Project Structure

\\\
JavaApp/
 src/com/example/
    HospitalManagementSystem.java   (Main app - 360+ lines)
    Patient.java                    (Patient model - 90+ lines)
    Doctor.java                     (Doctor model - 140+ lines)
    Appointment.java                (Appointment model - 110+ lines)
    InputValidator.java             (Validation utility - 100+ lines)
    HospitalException.java          (Custom exception)
 bin/com/example/
    HospitalManagementSystem.class  ( Compiled)
    Patient.class                   ( Compiled)
    Doctor.class                    ( Compiled)
    Appointment.class               ( Compiled)
    InputValidator.class            ( Compiled)
    HospitalException.class         ( Compiled)
 README.md                           (This file)
 DOCUMENTATION.md                    (API reference)
 QUICK_REFERENCE.md                  (Quick guide)
 compile_and_run.bat                 (Build script)
\\\

##  Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Windows Command Prompt, PowerShell, or terminal

### Setup Instructions

1. **Extract the project** to your desired location

2. **Compile the application**:
   \\\ash
   javac -d bin src/com/example/*.java
   \\\

3. **Run the application**:
   \\\ash
   java -cp bin com.example.HospitalManagementSystem
   \\\

4. **Or use the batch file** (Windows):
   \\\ash
   compile_and_run.bat
   \\\

##  Menu System (12 Options)

| # | Option | Description |
|----|--------|-------------|
| 1 | Add Patient | Register a new patient with name and age |
| 2 | Add Doctor | Register a new doctor with specialization |
| 3 | View Patients | Display all registered patients |
| 4 | View Doctors | Display all registered doctors |
| 5 | Assign Patient to Doctor | Link a patient to a doctor |
| 6 | Update Patient Diagnosis | Update patient's medical diagnosis |
| 7 | Search Patient | Find patients by name (partial match) |
| 8 | View Doctor Details | View doctor and their assigned patients |
| 9 | Schedule Appointment | Create new appointment |
| 10 | View Appointments | Display all scheduled appointments |
| 11 | Update Appointment Status | Change appointment status |
| 12 | Exit | Close the application |

##  Class Architecture

### HospitalManagementSystem (Main Application)
- **Purpose**: Main entry point with menu system
- **Responsibilities**: User interaction, menu handling, data coordination
- **Methods**: 12 menu handlers, 3 finder methods, main method

### Patient (Data Model)
- **Fields**: ID, Name, Age, Diagnosis, AssignedDoctor, ContactNumber, MedicalHistory
- **Validation**: Name non-empty, Age 0-150
- **Methods**: Getters, setters with validation, toString()

### Doctor (Data Model)
- **Fields**: ID, Name, Specialization, AssignedPatients, LicenseNumber, ContactNumber, YearsOfExperience
- **Methods**: Assign/remove patients, getters, setters with validation, toString()

### Appointment (Data Model)
- **Fields**: ID, Patient, Doctor, AppointmentTime, Purpose, Status, Notes
- **Status Options**: Scheduled, Completed, Cancelled
- **Methods**: Reschedule, update status, add notes, getters, setters with validation

### InputValidator (Utility Class)
**Static Methods for Input Validation**:
- \parseInteger(String)\ - Safe integer parsing, returns -1 if invalid
- \parseIntegerInRange(String, int, int)\ - Integer parsing with range checking
- \isValidString(String)\ - Validates non-empty strings
- \isValidContactNumber(String)\ - Validates contact format (10+ digits)
- \isValidAge(int)\ - Validates age range (0-150)
- \getValidString(Scanner, String)\ - Interactive string input with retry
- \getValidInteger(Scanner, String)\ - Interactive integer input with retry
- \getValidIntegerInRange(Scanner, String, int, int)\ - Interactive range input with retry

**Benefits**:
- Centralized validation logic
- Reusable across all operations
- Consistent error handling
- Interactive user prompts
- Returns -1 for invalid values (can be checked in calling code)

### HospitalException (Custom Exception)
- Extends Exception class
- Used for domain-specific error handling
- Supports message and cause parameters

##  Data Validation Rules

| Field | Rules | Example |
|-------|-------|---------|
| Patient Name | Non-empty, trimmed | "John Smith" |
| Patient Age | 0-150 inclusive | 45 |
| Doctor Name | Non-empty, trimmed | "Dr. Sarah Johnson" |
| Specialization | Defaults to "General" if empty | "Cardiology" |
| Contact Number | 10+ digits, +, -, (), spaces | "+1-555-123-4567" |
| Appointment Date | Must be in future | Future date/time |
| Appointment Status | Scheduled/Completed/Cancelled | "Completed" |
| Experience | 0-70 years | 15 |

##  Code Quality

- **Total Classes**: 6
- **Total Methods**: 50+
- **Lines of Code**: 800+
- **Validation Rules**: 15+
- **Error Handlers**: 20+
- **Documentation**: JavaDoc comments on all classes and methods

##  Documentation Files

- **README.md** - This file (project overview)
- **DOCUMENTATION.md** - Complete API reference
- **QUICK_REFERENCE.md** - Quick lookup guide
- **PROJECT_SUMMARY.md** - Feature breakdown

---

**Hospital Management System v2.0** | **Status**: Production Ready  | **Version**: 2.0 - Enhanced Edition | **Released**: December 2025
