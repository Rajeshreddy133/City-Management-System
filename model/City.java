package model;
import java.util.ArrayList;
import java.io.*;
public class City {

    private String cityName;
    private ArrayList<Citizen> citizens = new ArrayList<>();
    private ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<CityService> services = new ArrayList<>();
    private ArrayList<ServiceRequest> requests = new ArrayList<>();
    public City(String cityName) {
        this.cityName = cityName;
    }

    public void addCitizen(Citizen citizen) {
        citizens.add(citizen);
    }

    public void addDepartment(Department dept) {
        departments.add(dept);
    }

    public void addService(CityService service){
        services.add(service);
    }
    public ArrayList<Citizen> getCitizens() {
        return citizens;
    }

    public ArrayList<CityService> getServices() {
        return services;
    }
    public void displayCitizens() {
        System.out.println("---- Citizens List ----");
        for (Citizen c : citizens) {
            c.display();
        }
    }

    public void displayDepartments() {
        System.out.println("---- Departments List ----");
        for (Department d : departments) {
            d.displayDepartment();
        }
    }
    public void displayServices(){
        System.out.println("------Services List------");
        for(CityService s : services){
            s.provideService();
        }
    }
    public void addEmployeeToDepartment(int index, Employee emp) {
        if (index >= 0 && index < departments.size()) {
            departments.get(index).addEmployee(emp);
        } 
        else{
             System.out.println("Invalid Department Index!");
         }
    }
    public void deleteCitizen(int id) {
        boolean found = false;
           for (Citizen c : citizens) {
               if (c.getId() == id) {
                   citizens.remove(c);
                   System.out.println("Citizen Deleted Successfully!");
                   found = true;
                   break;
                }
            }
            if (!found) {
               System.out.println("Citizen Not Found!");
            }
        }

    public void deleteDepartment(int deptId) {
        boolean found = false;
           for (Department d : departments) {
               if (d.getDeptId() == deptId) {
                   departments.remove(d);
                   System.out.println("Department Deleted Successfully!");
                   found = true;
                   break;
                }
            }
            if (!found) {
                System.out.println("Department Not Found!");
            }
        }
    public void deleteService(int serviceId) {
        boolean found = false;
        for (CityService s : services) {
            if (s.getServiceId() == serviceId) {
                services.remove(s);
                System.out.println("Service Deleted Successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Service Not Found!");
        }
    }
    public void updateCitizen(int id, String newName, String newContact) {
        boolean found = false;
        for (Citizen c : citizens) {
            if (c.getId() == id) {
                c.name = newName;
                c.contact = newContact;
                System.out.println("Citizen Updated Successfully!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Citizen Not Found!");
        }
    }

    public void updateService(int serviceId, String newName, String newDesc) {
        boolean found = false;
        for (CityService s : services) {
            if (s.getServiceId() == serviceId) {
               s.setServiceName(newName);
               s.setDescription(newDesc);
               System.out.println("Service Updated Successfully!");
               found = true;
               break;
            }
        }
        if (!found) {
           System.out.println("Service Not Found!");
        }
    }
    public void saveCitizensToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("citizens.txt"));

            for (Citizen c : citizens) {
                writer.write(c.getId() + "," +
                         c.getName() + "," +
                         c.getContact() + "," +
                         c.getAddress() + "," +
                         c.getAge());
                writer.newLine();
            }

            writer.close();
            System.out.println("Citizens saved to file successfully!");
        } catch (IOException e) {
            System.out.println("Error saving file.");
        }
    }
    public void loadCitizensFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("citizens.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String contact = data[2];
                String address = data[3];
                int age = Integer.parseInt(data[4]);

                Citizen citizen = new Citizen(id, name, contact, address, age);
                citizens.add(citizen);
            }

            reader.close();
            System.out.println("Citizens loaded from file!");
        } catch (IOException e) {
            System.out.println("No previous citizen data found.");
        }
    }
    public void searchCitizenById(int id) {
        for (Citizen c : citizens) {
            if (c.getId() == id) {
                c.display();
                return;
            }
        }
        System.out.println("Citizen Not Found!");
    }

    public void searchCitizenByName(String name) {
        boolean found = false;
        for (Citizen c : citizens) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.display();
                found = true;
            }
        }
        if (!found) {
           System.out.println("No citizen found with this name!");
        }
    }
    public boolean isCitizenExists(int id) {
        for (Citizen c : citizens) {
            if (c.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public void addServiceRequest(ServiceRequest req) {
        requests.add(req);
        System.out.println("Service Request Added!");
    }

    public void viewRequests() {
        for (ServiceRequest r : requests) {
           r.display();
        }
    }

    public void updateRequestStatus(int id) {
        for (ServiceRequest r : requests) {
            if (r.getRequestId() == id) {
                System.out.println("Before Update: " + r.getStatus());
                r.updateStatus();
                System.out.println("After Update: " + r.getStatus());
                return;
            }
        }
        System.out.println("Request Not Found!"); 
    }

    public void showReport() {
        System.out.println("Total Citizens: " + citizens.size());
        System.out.println("Total Departments: " + departments.size());
        System.out.println("Total Services: " + services.size());

        int totalAge = 0;
        for (Citizen c : citizens) {
           totalAge += c.getAge();
        }

        if (citizens.size() > 0) {
           System.out.println("Average Age: " + (totalAge / citizens.size()));
        }
    }
}