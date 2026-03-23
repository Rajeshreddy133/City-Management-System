# 🏙️ City Management System (Java OOP Project)

---

## 📌 Project Description

The **City Management System** is a console-based Java application developed using Object-Oriented Programming (OOP) principles. It simulates real-world city operations by managing citizens, services, and service requests with role-based access.

The system includes **user authentication**, **admin and citizen roles**, and **file-based data persistence**, making it a practical and scalable project.

---

## 🎯 Objectives

* Implement Object-Oriented Programming concepts in Java
* Manage citizens, services, and service requests
* Provide role-based access (Admin & Citizen)
* Track service requests with status workflow
* Build a modular and maintainable system
* Simulate a real-world city service platform

---

## 🔐 Key Features

### 👤 Authentication & Roles

* Login system with username and password
* Role-based access:

  * **Admin** – Full control
  * **Citizen** – Limited access

---

### 👨‍💼 Admin Functionalities

* Add new citizens
* View all citizens
* Add and manage city services
* View all service requests
* Update request status (Pending → In Progress → Completed)
* View system reports

---

### 👤 Citizen Functionalities

* View available services
* Raise service requests
* View personal requests

---

### 📩 Service Request System

* Create requests with:

  * Request ID
  * Citizen
  * Service
  * Priority
  * Date
* Track request status:

  * Pending
  * In Progress
  * Completed

---

### 📂 Data Persistence

* File handling used for:

  * Saving citizens
  * Saving service requests
* Data is retained even after program restarts

---

### 📊 Reports

* Total citizens
* Total services
* Total requests
* Pending vs Completed requests

---

## 🧠 OOP Concepts Used

* **Encapsulation** – Data hiding using private variables and getters/setters
* **Abstraction** – Simplified interfaces for complex operations
* **Inheritance** – `Citizen` and `Employee` inherit from `Person`
* **Polymorphism** – Flexible and extendable method design

---

## 🏗️ Project Structure

```
CityManagementSystem/
├── model/
│   ├── Person.java
│   ├── Citizen.java
│   ├── Employee.java
│   ├── Department.java
│   ├── City.java
│   ├── CityService.java
│   ├── Service.java
│   ├── ServiceRequest.java
│   ├── User.java
├── main/
│   └── Main.java
├── citizens.txt
├── requests.txt
```

---

## 💻 Technologies Used

* Java (OOP Concepts)
* File Handling (BufferedReader, FileWriter)
* VS Code / IntelliJ IDEA
* Git & GitHub

---

## ▶️ How to Run the Project

1. Clone the repository:

```
git clone https://github.com/Rajeshreddy133/City-Management-System.git
```

2. Navigate to project folder:

```
cd City-Management-System
```

3. Compile the project:

```
javac model/*.java main/*.java
```

4. Run the application:

```
java main.Main
```

---

## 📷 Sample Flow

### 🔐 Login

```
===== LOGIN =====
Username: admin
Password: 1234
```

---

### 👨‍💼 Admin Menu

```
===== ADMIN MENU =====
1. Add Citizen
2. View Citizens
3. Add Service
4. View Services
5. View Requests
6. Update Request Status
7. Exit
```

---

### 👤 Citizen Menu

```
===== CITIZEN MENU =====
1. View Services
2. Raise Request
3. View My Requests
4. Exit
```

---

## 🚀 Future Enhancements

* Convert to Web Application (Spring Boot)
* Add Database Integration (MySQL)
* Implement GUI (JavaFX / Swing)
* Add advanced filtering & sorting
* Assign employees to requests automatically
* Add notifications system

---

## 👨‍💻 Author

**Rajesh Reddy**
B.Tech Student | Aspiring Java Developer

---

## 📄 License

This project is developed for educational and learning purposes.
