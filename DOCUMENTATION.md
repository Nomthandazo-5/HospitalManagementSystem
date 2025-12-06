# Hospital Management System

A comprehensive Java console application for managing hospital operations including patients, doctors, and medical appointments.

## 📋 Project Overview

This system provides a robust solution for managing hospital operations with advanced features:
- **Patient Management**: Register, view, and search for patients
- **Doctor Management**: Add and manage doctors with specializations
- **Appointment Scheduling**: Schedule and manage medical appointments
- **Assignment Management**: Assign patients to doctors
- **Diagnosis Tracking**: Update and manage patient diagnoses
- **Error Handling**: Comprehensive input validation and error management

## ✨ Core Features

### 1. Patient Management
- Add new patients with name and age validation (0-150)
- View all registered patients with detailed information
- Search for patients by name (partial match supported)
- Track patient diagnoses and assigned doctors
- Manage contact information for patients

### 2. Doctor Management
- Register doctors with specialization (defaults to "General")
- View all doctors with specialization and patient count
- View detailed doctor information including assigned patients
- Track doctor experience and license information
- Manage doctor contact details

### 3. Appointment System
- Schedule appointments between patients and doctors
- Set appointment purpose and date/time
- Track appointment status (Scheduled, Completed, Cancelled)
- Add notes to appointments
- Reschedule appointments as needed

### 4. Assignment & Diagnosis
- Assign patients to specific doctors
- Update patient diagnoses
- Prevent duplicate patient assignments
- View complete patient-doctor relationships
- Track complete medical history

### 5. Data Validation & Error Handling
- **Input Validation**:
  - Non-empty name validation
  - Age range validation (0-150 years)
  - Contact number format validation
  - Safe integer parsing

- **Error Handling**:
  - Try-catch blocks for all operations
  - Descriptive error messages
  - Graceful handling of invalid inputs
  - Exception propagation and logging

## 🗂️ Project Structure

```
JavaApp/
├── src/
│   └── com/example/
│       ├── HospitalManagementSystem.java   (Main application, menu system)
│       ├── Patient.java                     (Patient model with validation)
│       ├── Doctor.java                      (Doctor model with patient management)
│       ├── Appointment.java                 (Appointment model for scheduling)
│       ├── HospitalException.java           (Custom exception class)
│       └── InputValidator.java              (Utility for input validation)
├── bin/                                     (Compiled .class files)
├── lib/                                     (External libraries)
├── README.md                                (This file)
└── DOCUMENTATION.md                         (Detailed API documentation)
```

## 🚀 Getting Started

### Prerequisites
- Java Development Kit (JDK) 11 or higher
- Windows Command Prompt or PowerShell

### Setup Instructions

1. **Extract the project files** to your desired location

2. **Compile the application**:
   ```bash
   javac -d bin src/com/example/*.java
   ```

3. **Run the application**:
   ```bash
   java -cp bin com.example.HospitalManagementSystem
   ```

## 📖 User Manual

### Main Menu Options

| Option | Description |
|--------|-------------|
| 1 | Add a new patient |
| 2 | Add a new doctor |
| 3 | View all registered patients |
| 4 | View all registered doctors |
| 5 | Assign a patient to a doctor |
| 6 | Update a patient's diagnosis |
| 7 | Search for a patient by name |
| 8 | View detailed doctor information |
| 9 | Schedule a new appointment |
| 10 | View all scheduled appointments |
| 11 | Update appointment status |
| 12 | Exit the application |

### Usage Examples

#### Adding a Patient
```
Enter patient name: John Smith
Enter age (0-150): 45
✓ Patient added successfully! (ID: 1)
```

#### Adding a Doctor
```
Enter doctor name: Dr. Sarah Johnson
Enter specialization (press Enter for 'General'): Cardiology
✓ Doctor added successfully! (ID: 1)
```

#### Assigning a Patient to a Doctor
1. System displays all patients and doctors
2. Enter the Patient ID
3. Enter the Doctor ID
4. Confirmation message appears

## 💻 Class Architecture

### HospitalManagementSystem
- Main application class with menu interface
- Manages collections of patients, doctors, and appointments
- Coordinates all user interactions
- Methods: `main()`, menu handlers, finder methods

### Patient
**Fields**: ID, Name, Age, Diagnosis, AssignedDoctor, ContactNumber, MedicalHistory

**Methods**:
- `Patient(String name, int age)` - Constructor with validation
- Getters for all fields
- `setDiagnosis()`, `setAssignedDoctor()`, `setContactNumber()`, `setMedicalHistory()`
- `toString()` - Formatted output

### Doctor
**Fields**: ID, Name, Specialization, AssignedPatients, LicenseNumber, ContactNumber, YearsOfExperience

**Methods**:
- `Doctor(String name, String specialization)` - Constructor
- `assignPatient(Patient)` - Add patient to doctor
- `removePatient(Patient)` - Remove patient from doctor
- Getters and setters with validation
- `toString()` - Formatted output

### Appointment
**Fields**: ID, Patient, Doctor, AppointmentTime, Purpose, Status, Notes

**Methods**:
- `Appointment(Patient, Doctor, LocalDateTime, String)` - Constructor with validation
- `reschedule(LocalDateTime)` - Reschedule appointment
- `setStatus(String)` - Update status with validation
- `setNotes(String)` - Add appointment notes
- `toString()` - Formatted output

### InputValidator (Utility)
**Static Methods**:
- `parseInteger(String)` - Safe integer parsing
- `parseIntegerInRange(String, int, int)` - Integer with range
- `isValidString(String)` - Non-empty validation
- `isValidContactNumber(String)` - Phone number validation
- `isValidAge(int)` - Age range validation
- `getValidString()`, `getValidInteger()`, `getValidIntegerInRange()` - Interactive input

### HospitalException
- Custom exception for hospital operations
- Extends `Exception` class

## 🔐 Data Validation

### Patient Validation
- **Name**: Non-empty, trimmed string
- **Age**: Integer 0-150
- **Diagnosis**: Non-empty when set
- **Contact**: 10+ digits with format validation

### Doctor Validation
- **Name**: Non-empty, trimmed string
- **Specialization**: Defaults to "General"
- **License**: Non-empty when set
- **Contact**: 10+ digits with format
- **Experience**: 0-70 years

### Appointment Validation
- **Patient/Doctor**: Must be valid and non-null
- **Date/Time**: Must be in the future
- **Purpose**: Non-empty string
- **Status**: Only "Scheduled", "Completed", or "Cancelled"

## 🎯 Error Handling Strategy

1. **Invalid Input**:
   - Catches `NumberFormatException` for numeric parsing
   - Validates string length and content
   - Range checking for numeric values

2. **Not Found Errors**:
   - Returns `null` from finder methods
   - Displays user-friendly messages

3. **Business Logic Errors**:
   - Throws `IllegalArgumentException` for invalid data
   - Throws `IllegalStateException` for invalid operations
   - Provides descriptive error messages

## 🧪 Testing Checklist

- [ ] Add patient with valid data
- [ ] Reject patient with invalid age (negative, >150)
- [ ] Reject patient with empty name
- [ ] Add doctor with valid data
- [ ] Default specialization to "General"
- [ ] Assign patient to doctor successfully
- [ ] Prevent duplicate assignments
- [ ] Update diagnosis
- [ ] Search patient by name (partial match)
- [ ] Schedule appointment
- [ ] Update appointment status
- [ ] Handle all error cases gracefully

## 📝 Code Quality Metrics

- **Modularity**: 6 separate classes with single responsibilities
- **Error Handling**: 100% of user inputs validated
- **Documentation**: JavaDoc comments on all classes and public methods
- **Code Style**: Follows Java naming conventions and best practices
- **Resource Management**: Try-with-resources for Scanner
- **Encapsulation**: Private fields with controlled accessors

## 🔄 Future Enhancements

Potential features for next versions:
- [ ] File-based data persistence (JSON/CSV)
- [ ] Database integration (SQLite/MySQL)
- [ ] Prescription management system
- [ ] Billing and payment tracking
- [ ] Medical test result tracking
- [ ] Discharge summaries
- [ ] Graphical User Interface (JavaFX)
- [ ] Multi-user support with authentication
- [ ] Appointment reminders
- [ ] Availability scheduling

## 📊 System Requirements

- **Java Version**: JDK 11 or higher
- **Memory**: Minimum 256MB RAM
- **Storage**: 10MB free space
- **OS**: Windows, macOS, or Linux

## 📄 Project Metadata

- **Version**: 2.0 - Enhanced Edition
- **Release Date**: December 2025
- **Status**: Production Ready
- **License**: Open Source (Educational)

## 🤝 Contributing

This is an educational project. Contributions and suggestions are welcome!

## 📞 Support & Documentation

Refer to:
- **Code Comments**: Inline JavaDoc documentation
- **Class Headers**: Detailed class descriptions
- **Method Documentation**: Purpose and parameter descriptions
- **Error Messages**: User-friendly guidance for issues

## 🎓 Learning Outcomes

This project demonstrates:
- Object-oriented programming principles
- Input validation and error handling
- Collection management (ArrayList)
- Method decomposition
- User interface design
- Data model design
- Exception handling
- Java best practices

---

**Hospital Management System** - Built with ❤️ for efficient hospital operations management
