package main;
import java.util.*;
import model.*;
public class Main {

    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);
        City city = new City("Smart City");

        city.loadCitizensFromFile();     
        city.loadServicesFromFile();    
        city.loadRequestsFromFile();
        int id = city.getCitizens().size() + 1;
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("admin", "1234", "admin"));
        users.add(new User("rajesh", "1111", "citizen"));

        System.out.println("===== LOGIN =====");
        System.out.print("Username: ");
        String uname = sc.nextLine();
        System.out.print("Password: ");
        String pass = sc.next();

        Citizen loggedInCitizen = null;

        for (Citizen c : city.getCitizens()) {
            if (c.getName().equalsIgnoreCase(uname)) {
                loggedInCitizen = c;
                break;
            }
        }

        User loggedUser = null;

        for(User u : users){
            if(u.getUsername().equals(uname) && u.getPassword().equals(pass)){
               loggedUser = u;
               break;
            }
        }

        if(loggedUser == null){
            System.out.println("Invalid Login!");
            return;
        }
        if(loggedUser.getRole().equals("admin")){
           adminMenu(city, sc);
        } else {
           citizenMenu(city, sc, loggedInCitizen);
        }
    }
    public static void adminMenu(City city, Scanner sc){
        while(true){
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add Citizen");
            System.out.println("2. View Citizens");
            System.out.println("3. Add Service");
            System.out.println("4. View Services");
            System.out.println("5. View Requests");
            System.out.println("6. Update Request Status");
            System.out.println("7. View Report");
            System.out.println("8. Sort Requests by Priority");
            System.out.println("9. Search Request by ID");
            System.out.println("10. Delete Request");
            System.out.println("11. Most Used Service");
            System.out.println("12. Exit");

            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    sc.nextLine();
                    int id = city.getCitizens().size() + 1;

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Contact: ");
                    String contact = sc.nextLine();

                    System.out.print("Enter Address: ");
                    String address = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    Citizen c = new Citizen(id, name, contact, address, age);
                    city.addCitizen(c);

                    System.out.println("Citizen Added Successfully!");
                    break;

                case 2:
                    city.displayCitizens();
                    break;

                case 3:
                    sc.nextLine();
                    int sid = city.getServices().size() + 1;

                    System.out.print("Enter Service Name: ");
                    String sname = sc.nextLine();

                    System.out.print("Enter Description: ");
                    String desc = sc.nextLine();

                    CityService service = new CityService(sid, sname, desc);
                    city.addService(service);
                    city.saveServicesToFile();   
                    System.out.println("Service Added Successfully!");
                    break;

                case 4:
                    city.displayServices();
                    break;

                case 5:
                    city.viewRequests();
                    break;

                case 6:
                    city.viewRequests();
                    System.out.print("Enter Request ID: ");
                    int rid = sc.nextInt();
                    city.updateRequestStatus(rid);
                    break;

                case 7:
                    city.showReport();
                    break;

                case 8:
                    city.sortRequestsByPriority();
                    city.viewRequests();
                    break;

                case 9:
                    System.out.print("Enter Request ID: ");
                    int sid2 = sc.nextInt();
                    city.searchRequestById(sid2);
                    break;

                case 10:
                    System.out.print("Enter Request ID: ");
                    int did = sc.nextInt();
                    city.deleteRequest(did);
                    break;

                case 11:
                    city.mostUsedService();
                    break;

                case 12:
                    city.saveCitizensToFile();
                    city.saveServicesToFile();   
                    city.saveRequestsToFile();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
    public static void citizenMenu(City city, Scanner sc,Citizen citizen){
        while(true){
            System.out.println("\n===== CITIZEN MENU =====");
            System.out.println("1. View Services");
            System.out.println("2. Raise Request");
            System.out.println("3. View My Requests");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    city.displayServices();
                    break;

                case 2:
                    System.out.println("\nAvailable Services:");
                    city.displayServices();  
                    System.out.print("Enter Request ID: ");
                    int rid = sc.nextInt();

                    int cid = citizen.getId();

                    System.out.print("Enter Service ID: ");
                    int sid = sc.nextInt();

                    sc.nextLine();
                    System.out.print("Enter Priority (Low/Medium/High): ");
                    String priority = sc.nextLine();

                    System.out.print("Enter Date: ");
                    String date = sc.nextLine();

                    Citizen foundCitizen = null;
                    CityService foundService = null;

                    for (Citizen c : city.getCitizens()) {
                        if (c.getId() == cid) {
                            foundCitizen = c;
                        }
                    }

                    for (CityService s : city.getServices()) {
                        if (s.getServiceId() == sid) {
                            foundService = s;
                        }
                    }

                    if (foundCitizen != null && foundService != null) {
                        ServiceRequest req = new ServiceRequest(rid, foundCitizen, foundService, priority, date);
                        city.addServiceRequest(req);
                        System.out.println("DEBUG: Saving request...");
                        city.saveRequestsToFile(); 
                    } else {
                        System.out.println("Invalid Citizen or Service!");
                    }
                    break;

                case 3:
                    System.out.print("Enter Your Citizen ID: ");
                    int id = sc.nextInt();
                    city.viewRequestsByCitizen(id);
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}