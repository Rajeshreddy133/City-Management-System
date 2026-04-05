# 🏙️ City Management System (Java OOP Project)

------------------------------------------------------------------------

## 📌 Project Description

The **City Management System** is a console-based Java application
developed using Object-Oriented Programming (OOP) principles.

It simulates real-world city operations by managing citizens, services,
and service requests with **role-based access and persistent data
storage**.

------------------------------------------------------------------------

## 🎯 Objectives

-   Implement Object-Oriented Programming concepts in Java\
-   Manage citizens, services, and service requests\
-   Provide role-based access (Admin & Citizen)\
-   Track service requests with status workflow\
-   Persist data using file handling\
-   Build a modular and maintainable system

------------------------------------------------------------------------

## 🔐 Key Features

### 👤 Authentication & Roles

-   Login system with username and password\
-   Role-based access:
    -   **Admin** -- Full system control\
    -   **Citizen** -- Limited access

------------------------------------------------------------------------

### 👨‍💼 Admin Functionalities

-   Add new citizens\
-   View all citizens\
-   Add and manage city services\
-   View all service requests\
-   Update request status\
-   Sort requests by priority (High → Medium → Low)\
-   Search request by ID\
-   Delete service requests\
-   View system reports\
-   Identify most used service

------------------------------------------------------------------------

### 👤 Citizen Functionalities

-   View available services\
-   Raise service requests\
-   View personal requests

------------------------------------------------------------------------

### 📩 Service Request System

-   Create requests with:
    -   Request ID\
    -   Citizen\
    -   Service\
    -   Priority (High / Medium / Low)\
    -   Date
-   Track request status:
    -   Pending → In Progress → Completed

------------------------------------------------------------------------

### 📂 Data Persistence

-   File handling used for:
    -   citizens.txt\
    -   services.txt\
    -   requests.txt
-   Data is:
    -   Saved automatically\
    -   Loaded on restart

------------------------------------------------------------------------

### 📊 Reports

-   Total citizens\
-   Total services\
-   Total requests\
-   Pending vs Completed requests\
-   Most used service

------------------------------------------------------------------------

## 🧠 OOP Concepts Used

-   **Encapsulation**
-   **Abstraction**
-   **Inheritance**
-   **Polymorphism**

------------------------------------------------------------------------

## 🏗️ Project Structure

CityManagementSystem/ ├── model/ │ ├── Person.java │ ├── Citizen.java │
├── Employee.java │ ├── Department.java │ ├── City.java │ ├──
CityService.java │ ├── Service.java │ ├── ServiceRequest.java │ ├──
User.java ├── main/ │ └── Main.java ├── citizens.txt ├── services.txt
├── requests.txt

------------------------------------------------------------------------

## 💻 Technologies Used

-   Java\
-   File Handling\
-   VS Code / IntelliJ\
-   Git & GitHub

------------------------------------------------------------------------

## ▶️ How to Run

git clone https://github.com/Rajeshreddy133/City-Management-System.git\
cd City-Management-System\
javac model/*.java main/*.java\
java main.Main

------------------------------------------------------------------------

## 📷 Sample Flow

### 🔐 Login

===== LOGIN =====\
Username: admin\
Password: 1234

------------------------------------------------------------------------

### 👨‍💼 Admin Menu

===== ADMIN MENU =====\
1. Add Citizen\
2. View Citizens\
3. Add Service\
4. View Services\
5. View Requests\
6. Update Request Status\
7. View Report\
8. Sort Requests by Priority\
9. Search Request by ID\
10. Delete Request\
11. Most Used Service\
12. Exit

------------------------------------------------------------------------

### 👤 Citizen Menu

===== CITIZEN MENU =====\
1. View Services\
2. Raise Request\
3. View My Requests\
4. Exit

------------------------------------------------------------------------

## 🚀 Future Enhancements

-   Convert to Web App (Spring Boot)\
-   Add Database (MySQL)\
-   Build GUI (JavaFX)\
-   Add filters & search\
-   Notifications system

------------------------------------------------------------------------

## 👨‍💻 Author

**Rajesh Reddy**\
B.Tech Student \| Java Developer

------------------------------------------------------------------------

## 📄 License

This project is for educational purposes.
