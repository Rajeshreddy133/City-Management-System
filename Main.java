import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        City city = new City("Smart City");

        while (true) {
            System.out.println("\n===== CITY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Citizen");
            System.out.println("2. View Citizens");
            System.out.println("3. Add Department");
            System.out.println("4. View Departments");
            System.out.println("5.Add Employee");
            System.out.println("6. Add Service ");;
            System.out.println("7. View Services ");
            System.out.println("8. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    Citizen citizen = new Citizen(id, name, contact, address, age);
                    city.addCitizen(citizen);
                    System.out.println("Citizen Added Successfully!");
                    break;

                case 2:
                    city.displayCitizens();
                    break;

                case 3:
                    System.out.print("Enter Department ID: ");
                    int deptId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Department Name: ");
                    String deptName = sc.nextLine();

                    Department dept = new Department(deptId, deptName);
                    city.addDepartment(dept);
                    System.out.println("Department Added Successfully!");
                    break;

                case 4:
                    city.displayDepartments();
                    break;

                case 5:
                    System.out.print("Enter Employee ID: ");
                    int empId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String empName = sc.nextLine();

                    System.out.print("Enter Contact: ");
                    String empContact = sc.nextLine();

                    System.out.print("Enter Position: ");
                    String position = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee emp = new Employee(empId, empName, empContact, position, salary);

                    System.out.print("Enter Department Index (0,1,2...): ");
                    int index = sc.nextInt();

                    city.addEmployeeToDepartment(index, emp);

                    System.out.println("Employee Added Successfully!");
                    break;   

                case 6:
                    System.out.print("Enter Service ID: ");
                    int serviceId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Service Name: ");
                    String serviceName = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    CityService service = new CityService(serviceId, serviceName, desc);
                    city.addService(service);

                    System.out.println("Service Added Successfully!");
                    break; 

                case 7:
                    city.displayServices();
                    break;

                case 8:
                    System.out.println("Exiting System...");
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}