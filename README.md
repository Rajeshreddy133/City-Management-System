🏙️ City Management System (Java OOP Project)
📌 Project Description

The City Management System is a console-based Java application developed using Object-Oriented Programming (OOP) principles. It simulates real-world city operations by managing citizens, services, and service requests with role-based access and persistent data storage.

The system includes authentication, admin & citizen roles, priority-based request handling, and file-based persistence, making it a scalable and real-world inspired project.

🎯 Objectives
Implement Object-Oriented Programming concepts in Java
Manage citizens, services, and service requests
Provide role-based access (Admin & Citizen)
Track service requests with status workflow
Persist data using file handling
Build a modular and maintainable system
🔐 Key Features
👤 Authentication & Roles
Login system with username and password
Role-based access:
Admin – Full system control
Citizen – Limited access (service usage)
👨‍💼 Admin Functionalities
Add new citizens
View all citizens
Add and manage city services
View all service requests
Update request status
Sort requests by priority (High → Medium → Low)
Search request by ID
Delete service requests
View system reports
Identify most used service
👤 Citizen Functionalities
View available services
Raise service requests (without manually entering ID)
View personal requests
📩 Service Request System
Create requests with:
Request ID
Citizen (auto-detected from login)
Service
Priority (High / Medium / Low)
Date
Track request status:
Pending → In Progress → Completed
📂 Data Persistence (🔥 Newly Added)
File handling implemented for:
Citizens → citizens.txt
Services → services.txt
Requests → requests.txt
Data is automatically:
Saved after operations
Loaded when program starts

👉 Ensures no data loss after restart

📊 Reports & Analytics
Total citizens
Total services
Total requests
Pending vs Completed requests
Most frequently used service
🧠 OOP Concepts Used
Encapsulation – Data hiding using private variables & getters/setters
Abstraction – Simplified interaction via methods
Inheritance – Citizen and Employee inherit from Person
Polymorphism – Flexible method usage and overrides
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
│   ├── ServiceRequest.java
│   ├── User.java
├── main/
│   └── Main.java
├── citizens.txt
├── services.txt
├── requests.txt
💻 Technologies Used
Java (OOP Concepts)
File Handling (BufferedReader, FileWriter)
VS Code / IntelliJ IDEA
Git & GitHub
▶️ How to Run the Project
Clone the repository:
git clone https://github.com/Rajeshreddy133/City-Management-System.git
Navigate to project folder:
cd City-Management-System
Compile the project:
javac model/*.java main/*.java
Run the application:
java main.Main
📷 Sample Flow
🔐 Login
===== LOGIN =====
Username: admin
Password: 1234
👨‍💼 Admin Menu
===== ADMIN MENU =====
1. Add Citizen
2. View Citizens
3. Add Service
4. View Services
5. View Requests
6. Update Request Status
7. View Report
8. Sort Requests by Priority
9. Search Request by ID
10. Delete Request
11. Most Used Service
12. Exit
👤 Citizen Menu
===== CITIZEN MENU =====
1. View Services
2. Raise Request
3. View My Requests
4. Exit
🚀 Future Enhancements
Convert to Web Application (Spring Boot)
Add Database Integration (MySQL)
Implement GUI (JavaFX / Swing)
Add advanced filtering & sorting
Assign employees to requests automatically
Add notifications system
👨‍💻 Author

Rajesh Reddy
B.Tech Student | Java Developer

📄 License

This project is developed for educational purposes.