# JavaApp
Java console Hospital Management System.

# Hospital Management System
A simple Java console application to manage patients, doctors, and assignments in a hospital setting.

## Project Overview
This application provides a straightforward system to manage hospital operations including:
- **Patient Management**: Add, view, and search for patients
- **Doctor Management**: Add and view doctors with their specializations
- **Assignment Management**: Assign patients to doctors and track relationships
- **Diagnosis Tracking**: Update and manage patient diagnoses
- **Detailed Records**: View comprehensive information about doctors and their assigned patients

## Features

### Core Functionality
1. **Add Patient** - Register new patients with name and age
2. **Add Doctor** - Register new doctors with name and specialization
3. **View Patients** - Display all registered patients with their details (ID, name, age, diagnosis, assigned doctor)
4. **View Doctors** - List all registered doctors with patient counts
5. **Assign Patient to Doctor** - Link a patient to a doctor for treatment
6. **Update Patient Diagnosis** - Record and update medical diagnosis for patients
7. **Search Patient** - Find patients by name (partial match supported)
8. **View Doctor Details** - Display a specific doctor and their complete list of assigned patients

### Data Validation
- Prevents null or empty patient/doctor names
- Validates age as non-negative
- Prevents duplicate patient assignments to the same doctor
- Safe numeric input parsing with error handling

### User Experience
- Interactive menu system with clear options
- Input validation with helpful error messages
- Empty state messaging when no records exist
- Try-with-resources for safe resource management

## Folder Structure

```
JavaApp/
├── src/
│   └── com/example/
│       ├── HospitalManagementSystem.java   (Main application)
│       ├── Patient.java                     (Patient model)
│       └── Doctor.java                      (Doctor model)
├── bin/                                     (Compiled .class files)
├── lib/                                     (External libraries)
├── README.md                                (This file)
└── .gitignore                               (Git ignore rules)
```

## Build Instructions

### Compile
```powershell
javac -d bin src/com/example/*.java
```

### Run
```powershell
java -cp bin com.example.HospitalManagementSystem
```

## Usage Example

```
🏥 Welcome to Hospital Management System

--- Menu ---
1. Add Patient
2. Add Doctor
3. View Patients
4. View Doctors
5. Assign Patient to Doctor
6. Update Patient Diagnosis
7. Search Patient
8. View Doctor Details
9. Exit
Enter choice: 1

Enter patient name: John Doe
Enter age: 45
✅ Patient added successfully!
```

## Technical Details

**Classes**:
- `HospitalManagementSystem.java` - Main entry point and menu handler
- `Patient.java` - Patient model with ID, name, age, diagnosis, assigned doctor
- `Doctor.java` - Doctor model with ID, name, specialization, assigned patients

**Key Features**:
- Try-with-resources for safe Scanner management
- Input validation with error handling
- Auto-incrementing IDs for patients and doctors
- Immutable field declarations where appropriate
- In-memory data storage using ArrayLists

## Requirements

- Java JDK 11 or higher
- Windows, macOS, or Linux
- Terminal/Console

## Data Storage

**Current**: In-memory only (data lost on exit)

**Future Enhancements**:
- [ ] CSV/JSON persistence
- [ ] Database integration (SQLite/MySQL)
- [ ] Appointment scheduling
- [ ] GUI (JavaFX/Swing)
- [ ] Unit tests (JUnit)
- [ ] Patient medical history

## Getting Started

1. Clone or download this repository
2. Navigate to project: `cd JavaApp`
3. Compile: `javac -d bin src/com/example/*.java`
4. Run: `java -cp bin com.example.HospitalManagementSystem`
5. Follow on-screen menu

## Troubleshooting

- **"javac: command not found"**: Install JDK from https://www.oracle.com/java/technologies/downloads/
- **Compilation errors**: Ensure all .java files are in src/com/example/
- **Runtime issues**: Verify bin/ directory exists and contains .class files

## Version

v1.0 - November 10, 2025
