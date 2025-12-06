# Quick Reference Guide - Hospital Management System

## 🚀 Quick Start

### Windows Users
```bash
compile_and_run.bat
```

### All Users
```bash
javac -d bin src/com/example/*.java
java -cp bin com.example.HospitalManagementSystem
```

---

## 📋 Menu Quick Reference

| # | Action | How to Use |
|----|--------|-----------|
| 1 | Add Patient | Enter name + age (0-150) |
| 2 | Add Doctor | Enter name + specialization |
| 3 | View Patients | Lists all patients with details |
| 4 | View Doctors | Lists all doctors with specialty |
| 5 | Assign Patient | Select patient ID and doctor ID |
| 6 | Update Diagnosis | Select patient ID + enter diagnosis |
| 7 | Search Patient | Enter patient name (partial match OK) |
| 8 | Doctor Details | View doctor + their assigned patients |
| 9 | Schedule Appointment | Select patient + doctor + purpose |
| 10 | View Appointments | Lists all scheduled appointments |
| 11 | Update Appointment | Change appointment status |
| 12 | Exit | Closes application |

---

## ✅ Validation Rules

### Ages
- Valid: 0-150
- Invalid: Negative, over 150

### Contact Numbers
- Format: 10+ digits with +, -, (), or spaces
- Example: +1-555-123-4567, (555) 123-4567

### Appointment Status
- Scheduled (initial)
- Completed (when done)
- Cancelled (if needed)

### Names
- Cannot be empty
- Whitespace trimmed automatically

---

## 🔍 Search Tips

### Patient Search
- Partial names work: "John" finds "John Smith"
- Case-insensitive: "john" finds "John"
- Enter first name or last name

### Doctor Lookup
- Use the displayed ID numbers
- View doctors first to get IDs
- IDs auto-increment (1, 2, 3...)

---

## 📁 File Locations

| File | Purpose |
|------|---------|
| README.md | Getting started guide |
| DOCUMENTATION.md | Complete API reference |
| PROJECT_SUMMARY.md | Features and metrics |
| PROJECT_OVERVIEW.md | Full implementation report |
| compile_and_run.bat | Windows build script |

---

## 💡 Common Operations

### Add a Patient
```
Menu: 1 → Enter name: John Doe → Enter age: 45 → Done!
```

### Assign Patient to Doctor
```
Menu: 5 → Select from displayed lists → Enter IDs → Done!
```

### Update Diagnosis
```
Menu: 6 → Select patient ID → Enter new diagnosis → Done!
```

### Schedule Appointment
```
Menu: 9 → Enter patient ID → Enter doctor ID → Enter purpose → Done!
```

---

## ⚠️ Important Notes

- **Data is in-memory** (lost when you exit)
- **IDs auto-increment** (cannot be changed)
- **Duplicate assignments prevented** (one doctor per patient)
- **Appointment dates must be future** (no past dates allowed)
- **All inputs validated** (empty fields rejected)

---

## 🔧 Troubleshooting

### "javac: command not found"
→ Install Java JDK 11+
→ Add Java to PATH environment variable

### Compilation errors
→ Ensure all .java files in `src/com/example/`
→ Check for typos in filenames
→ Verify Java version: `java -version`

### Application won't run
→ Make sure `bin` directory exists
→ Verify .class files in `bin/com/example/`
→ Check command syntax: `java -cp bin com.example.HospitalManagementSystem`

### Invalid input errors
→ Check age range (0-150)
→ Ensure names aren't empty
→ Use valid contact format (10+ digits)
→ Select from displayed ID options

---

## 📊 Data Examples

### Valid Patient Entry
- Name: Sarah Johnson
- Age: 35
- Diagnosis: Migraine
- Contact: +1-555-123-4567

### Valid Doctor Entry
- Name: Dr. Michael Chen
- Specialization: Neurology
- Experience: 15 years
- License: MED-2010-001

### Valid Appointment Entry
- Patient: Sarah Johnson (ID: 1)
- Doctor: Dr. Michael Chen (ID: 1)
- Purpose: Migraine Treatment
- Status: Scheduled

---

## 🎯 Key Features

✅ **Patient Management** - Add, view, search patients
✅ **Doctor Management** - Register doctors, track experience
✅ **Appointments** - Schedule, update status, reschedule
✅ **Validation** - Comprehensive input checking
✅ **Error Handling** - Graceful error management
✅ **Search** - Case-insensitive partial name search
✅ **User-Friendly** - Clear menus and error messages

---

## 📞 Getting Help

1. **Review error message** - Often indicates the issue
2. **Check README.md** - General guidance
3. **Review DOCUMENTATION.md** - Detailed API info
4. **Check inline comments** - Code documentation

---

**Hospital Management System v2.0**
Quick Reference Guide - December 2025
