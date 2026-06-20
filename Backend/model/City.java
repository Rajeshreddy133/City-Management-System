package model;
import java.util.ArrayList;
import java.util.HashMap;
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
        log("Citizen added: " + citizen.getName());
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
        System.out.println("\n===== CITY REPORT =====");

        System.out.println("Total Citizens: " + citizens.size());
        System.out.println("Total Departments: " + departments.size());
        System.out.println("Total Services: " + services.size());
        System.out.println("Total Requests: " + requests.size());

        int totalAge = 0;
        for (Citizen c : citizens) {
            totalAge += c.getAge();
        }

        if (citizens.size() > 0) {
            System.out.println("Average Age: " + (totalAge / citizens.size()));
        }

        int pending = 0, completed = 0;

        for (ServiceRequest r : requests) {
            if (r.getStatus().equals("Pending")) {
                pending++;
            } else if (r.getStatus().equals("Completed")) {
                completed++;
            }
        }

        System.out.println("Pending Requests: " + pending);
        System.out.println("Completed Requests: " + completed);

        System.out.println("==============================");
    }

    public void log(String msg){
        try{
            FileWriter fw = new FileWriter("log.txt", true);
            fw.write(msg + "\n");
            fw.close();
        }catch(Exception e){}
    }

    public void viewRequestsByCitizen(int citizenId){
        for(ServiceRequest r : requests){
            if(r.getCitizen().getId() == citizenId){
                r.display();
            }
        }
    }

    public void sortRequestsByPriority(){
        requests.sort((a, b) -> b.getPriority().compareTo(a.getPriority()));
        System.out.println("Requests sorted by priority!");
    }

    public void searchRequestById(int id){
        for(ServiceRequest r : requests){
            if(r.getRequestId() == id){
                r.display();
                return;
            }
        }
        System.out.println("Request Not Found!");
    }

    public void deleteRequest(int id){
        for(ServiceRequest r : requests){
            if(r.getRequestId() == id){
                requests.remove(r);
                System.out.println("Request Deleted!");
                return;
            }
        }
         System.out.println("Request Not Found!");
    }

    public void mostUsedService(){
        HashMap<Integer, Integer> count = new HashMap<>();

        for(ServiceRequest r : requests){
            int sid = r.getService().getServiceId();
            count.put(sid, count.getOrDefault(sid, 0) + 1);
        }

        int max = 0, serviceId = -1;

        for(int key : count.keySet()){
            if(count.get(key) > max){
                max = count.get(key);
                serviceId = key;
            }
        }

        System.out.println("Most Used Service ID: " + serviceId);
    }
    public void saveRequestsToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("requests.txt"));

            for (ServiceRequest r : requests) {
                writer.write(
                    r.getRequestId() + "," +
                    r.getCitizen().getId() + "," +
                    r.getService().getServiceId() + "," +
                    r.getStatus()
                );
                writer.newLine();
            }

            writer.close();
            System.out.println("Requests saved!");
        } catch (Exception e) {
            e.printStackTrace(); 
            System.out.println("Error saving requests!");
        }
    }
    public void saveServicesToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("services.txt"));

            for (CityService s : services) {
                writer.write(
                    s.getServiceId() + "," +
                    s.getServiceName() + "," +
                    s.getDescription()
                );
                writer.newLine();
            }

            writer.close();
            System.out.println("Services saved!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadRequestsFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("requests.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int rid = Integer.parseInt(data[0]);
                int cid = Integer.parseInt(data[1]);
                int sid = Integer.parseInt(data[2]);
                String status = data[3];

                Citizen foundCitizen = null;
                CityService foundService = null;

                for (Citizen c : citizens) {
                    if (c.getId() == cid) foundCitizen = c;
                }

                for (CityService s : services) {
                    if (s.getServiceId() == sid) foundService = s;
                }

                if (foundCitizen != null && foundService != null) {
                    ServiceRequest req = new ServiceRequest(rid, foundCitizen, foundService, "Medium", "Loaded");
                    requests.add(req);
                }
            }

            reader.close();
            System.out.println("Requests loaded!");
        } catch (Exception e) {
            System.out.println("No previous requests found.");
        }
    }
        public void loadServicesFromFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("services.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String desc = data[2];

                services.add(new CityService(id, name, desc));
            }

            reader.close();
            System.out.println("Services loaded!");
        } catch (IOException e) {
            System.out.println("No previous services found.");
        }
    }
}