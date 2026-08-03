# 🏠 APNA PG.COM – PG Rental Management System

A Java-based console application that simulates a Paying Guest (PG) Rental Management System. The project demonstrates Object-Oriented Programming (OOP) concepts by managing PG accommodations, tenants, room bookings, payments, and customer feedback through an interactive command-line interface.

---

## 📖 Overview

Managing a Paying Guest accommodation manually can be time-consuming and error-prone. This project provides a simple console-based solution that allows administrators to create PGs, manage tenants, allocate rooms, process bookings, record payments, and collect tenant feedback.

The application is completely developed in **Core Java** without using any database or graphical user interface, making it an excellent demonstration of Java fundamentals and OOP principles.

---

## ✨ Features

### PG Management
- Add new PG accommodations
- Store PG name and address
- Manage owner information
- Add multiple rooms to each PG

### Room Management
- Add rooms with rent details
- Single and Sharing room support
- Track room occupancy
- Display available rooms for booking

### Tenant Management
- Register new tenants
- Store contact information
- Search tenants by name
- Assign and vacate rooms

### Booking Management
- Create room bookings
- Generate unique booking IDs
- Record booking date
- Calculate remaining rent after advance payment

### Payment Management
- Record tenant payments
- Store payment history
- Display payment receipts

### Feedback System
- Collect ratings (1–5)
- Store tenant feedback
- Display all submitted feedback

---

## 🛠️ Tech Stack

- Java
- Object-Oriented Programming (OOP)
- Java Collections Framework
- Command Line Interface (CLI)

---

## 📂 Project Structure

```
PGRentSystem/
│
├── PGRentSystem.java
├── PG.java
├── Owner.java
├── Room.java
├── Tenant.java
├── Booking.java
├── Payment.java
├── Feedback.java
└── README.md
```

---

## 🧩 Object-Oriented Design

The project is designed using separate classes for different entities:

| Class | Responsibility |
|--------|----------------|
| PG | Manages PG information and rooms |
| Owner | Stores owner details |
| Room | Stores room details and occupancy status |
| Tenant | Stores tenant information and room assignment |
| Booking | Handles room booking operations |
| Payment | Records tenant payments |
| Feedback | Stores tenant ratings and comments |
| PGRentSystem | Main application and menu system |

---

## 📋 Main Menu

```
******* Welcome To APNA PG.COM ********

1. Add PG
2. Add Tenant
3. Book Room
4. Make Payment
5. Vacate Room
6. Display All Bookings
7. Search Tenant by Name
8. View Feedback
9. Exit
```

---

## 🚀 How It Works

1. Add a PG along with owner information.
2. Add rooms for the PG.
3. Register tenants.
4. Book available rooms.
5. Collect advance payments.
6. Make additional payments.
7. Vacate rooms when tenants leave.
8. Record tenant ratings and feedback.

---

## 💻 How to Run

### Clone Repository

```bash
git clone https://github.com/yourusername/PGRentSystem.git
```

### Compile

```bash
javac *.java
```

### Run

```bash
java PGRentSystem
```

---

## 📚 Concepts Demonstrated

- Object-Oriented Programming
- Classes & Objects
- Encapsulation
- Constructors
- Collections (ArrayList)
- Object Relationships
- Exception-safe User Input
- Menu-driven Programming
- Modular Design

---

## 🔮 Future Improvements

- MySQL Database Integration
- Java Swing / JavaFX GUI
- Login & Authentication
- File-Based Data Storage
- Report Generation
- Search & Filter Enhancements
- Monthly Rent Tracking
- Admin Dashboard

---

## 👨‍💻 Author

**Shubham**

B.Tech Computer Science Student

---

## 📄 License

This project is intended for educational purposes and to demonstrate Java programming and Object-Oriented Design principles.
