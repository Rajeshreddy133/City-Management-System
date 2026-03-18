package main;
import java.util.*;
import model.*;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        City city = new City("Smart City");
        city.loadCitizensFromFile();

        while (true) {
            System.out.println("\n===== CITY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Citizen");
            System.out.println("2. View Citizens");
            System.out.println("3. Add Department");
            System.out.println("4. View Departments");
            System.out.println("5.Add Employee");
            System.out.println("6. Add Service ");;
            System.out.println("7. View Services ");
            System.out.println("8. Delete Citizen");
            System.out.println("9. Update Citizen");
            System.out.println("10. Deletion Service");
            System.out.println("11. Search Citizen by ID");
            System.out.println("12. Search Citizen by Name");
            System.out.println("13. Add Service Request");
            System.out.println("14. View Requests");
            System.out.println("15. Complete Request");
            System.out.println("16. View Report");
            System.out.println("17 Exit.");
            System.out.print("Choose option: ");

            int choice=0;
            try{
                choice=sc.nextInt();
            }
            catch(Exception e){
                System.out.println("Invalid Input!");
                sc.nextLine();
            }

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

                    if (age <= 0) {
                        System.out.println("Invalid Age!");
                         break;
                    }

                    if (city.isCitizenExists(id)) {
                        System.out.println("Citizen ID already exists!");
                        break;
                    }

                    Citizen citizen = new Citizen(id, name, contact, address, age);
                    city.addCitizen(citizen);
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
                    System.out.print("Enter Citizen ID to Delete: ");
                    int delId = sc.nextInt();
                    city.deleteCitizen(delId);
                    break;

                case 9:
                    System.out.print("Enter Citizen ID to Update: ");
                    int upId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();
                    System.out.print("Enter New Contact: ");
                    String newContact = sc.nextLine();
                    city.updateCitizen(upId, newName, newContact);
                    break;

                case 10:
                    System.out.print("Enter Service ID to Delete: ");
                    int delServiceId = sc.nextInt();
                    city.deleteService(delServiceId);
                    break;

                case 11:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();
                    city.searchCitizenById(sid);
                    break;

                case 12:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String sname = sc.nextLine();
                    city.searchCitizenByName(sname);
                    break;
                case 13:
                    System.out.print("Enter Request ID: ");
                    int rid = sc.nextInt();

                    System.out.print("Enter Citizen ID: ");
                    int cid = sc.nextInt();

                    System.out.print("Enter Service ID: ");
                    int serId = sc.nextInt();

                    Citizen foundCitizen = null;
                    CityService foundService = null;

                    for (Citizen c : city.getCitizens()) {
                       if (c.getId() == cid) {
                           foundCitizen = c;
                        }
                    }

                    for (CityService s : city.getServices()) {
                        if (s.getServiceId() == serId) {
                           foundService = s;
                        }
                    }

                    if (foundCitizen != null && foundService != null) {
                        ServiceRequest req = new ServiceRequest(rid, foundCitizen, foundService);
                        city.addServiceRequest(req);
                    } else {
                        System.out.println("Invalid Citizen or Service!");
                    }
                    break;

                case 14:
                    city.viewRequests();
                     break;

                case 15:
                    System.out.print("Enter Request ID: ");
                    int crid = sc.nextInt();
                    city.completeRequest(crid);
                    break;
                case 16:
                    city.showReport();
                    break;
                case 17:
                    city.saveCitizensToFile();
                    System.out.println("Exiting System...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}