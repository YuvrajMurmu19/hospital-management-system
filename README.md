# Hospital Management System

A desktop-based Hospital Management System developed using **Java Swing**, **JDBC**, and **MySQL**. The application provides a graphical interface for managing patients, rooms, employees, departments, ambulances, and other hospital-related information.

## 📌 Overview

The Hospital Management System is designed to simplify common hospital administrative operations through a Java-based desktop application.

The application uses **Java Swing** for the graphical user interface, **JDBC** for database connectivity, and **MySQL** for persistent data storage.

### Main Features

- 🔐 Login Authentication
- 👨‍⚕️ Patient Management
- 🛏️ Room Management
- 🔍 Room Search
- 👨‍💼 Employee Information
- 🏥 Department Information
- 🚑 Ambulance Information
- 📝 Patient Details Update
- 🚪 Patient Discharge
- 📊 Display of database records using JTable

---

## 🛠️ Technologies Used

- **Java**
- **Java Swing**
- **JDBC (Java Database Connectivity)**
- **MySQL**
- **SQL**
- **DbUtils**

### Libraries Used

- `javax.swing` - GUI components
- `java.awt` - GUI and event handling
- `java.sql` - Database connectivity
- `net.proteanit.sql.DbUtils` - Converting ResultSet into TableModel

---

## 🏗️ Application Architecture

The basic architecture of the application is:

```text
              User
                |
                ↓
          Java Swing GUI
                |
                ↓
        Event Handling
        ActionListener
                |
                ↓
         Java Application
                |
                ↓
              JDBC
                |
                ↓
             MySQL
