🏙️ City Management System (Java OOP Project)

📌 Project Description

The City Management System is a Java-based application developed using Object-Oriented Programming (OOP) principles. It manages citizens, departments, employees, services, and service requests efficiently. The project demonstrates real-world use of OOP concepts such as encapsulation, abstraction, inheritance, and polymorphism.

🎯 Objectives

Implement Object-Oriented Programming concepts in Java
Manage citizens, departments, employees, and services
Handle service requests with status workflow (Pending → In Progress → Completed)
Provide a modular and maintainable system for city management
Demonstrate practical Java OOP application

🧠 OOP Concepts Used

Encapsulation – Protecting data using private variables and public methods

Abstraction – Exposing only essential information

Inheritance – Citizen and Employee inherit from Person

Polymorphism – Flexible method implementations for future enhancements

🏗️ Project Structure

CityManagementSystem/
├── model/
│   ├── Person.java
│   ├── Citizen.java
│   ├── Employee.java
│   ├── Department.java
│   ├── City.java
│   ├── CityService.java
│   ├── Service.java
│   └── ServiceRequest.java
├── main/
│   └── Main.java
└── citizens.txt

👤 Citizen Class

Stores citizen information: ID, Name, Age, Contact, Address

Functions: Add, Display, Update, Delete, Search


🏢 Department Class

Stores department information: Department ID, Department Name, Employees

Functions: Add Employee, Display Department


⚙️ Features

Citizens: Add, View, Update, Delete, Search by ID/Name

Departments: Add, View, Manage Employees

Employees: Add to departments, View details

Services: Add, View, Delete

Service Requests: Add request, View requests, Update status (Pending → In Progress → Completed)

Reports: View basic summaries of citizens, services, and requests

Fully modular, easy to extend for future enhancements


💻 Technologies Used

Java (OOP)

VS Code / IntelliJ IDEA


Git & GitHub

▶️ How to Run the Project

1.Clone the repository:

   git clone https://github.com/Rajeshreddy133/City-Management-System.git

2.Open in VS Code or IntelliJ

3.Compile the project:

   javac -d out model/*.java main/*.java

4.Run the project:

   java -cp out main.Main


📷 Sample Output
===== CITY MANAGEMENT SYSTEM =====
Choose option: 1
Enter ID: 101
Enter Name: Alice
Enter Contact: 1234567890
Enter Address: 12 Maple St
Enter Age: 28
Citizen Added Successfully!

Choose option: 6
Enter Service ID: 301
Enter Service Name: Vaccination
Enter Description: Free vaccination
Service Added Successfully!

Choose option: 13
Enter Request ID: 401
Enter Citizen ID: 101
Enter Service ID: 301
Service Request Added Successfully!

Choose option: 14
---- Service Requests List ----
Request ID: 401
Citizen: Alice
Service ID: 301
Status: Pending
----------------------

Choose option: 15
Enter Request ID: 401
Status Updated! → Status now In Progress

Choose option: 15
Enter Request ID: 401
Status Updated! → Status now Completed

Choose option: 14
---- Service Requests List ----
Request ID: 401
Citizen: Alice
Service ID: 301
Status: Completed
----------------------
🚀 Future Enhancements

Add database connectivity (MySQL or SQLite)

Implement GUI using Java Swing or JavaFX

Assign employees to service requests automatically

Generate advanced reports and analytics

Add authentication and user roles

Include search, filters, and sorting for citizens, services, and requests


👨‍💻 Author

Rajesh Reddy – B.Tech Student | Java Developer


📄 License

This project is for educational purposes.