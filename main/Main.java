package main;
import java.util.*;
import model.*;
public class Main {

    public static void main(String[] args) {

        
        Scanner sc = new Scanner(System.in);
        City city = new City("Smart City");
        city.loadCitizensFromFile();
        int id = city.getCitizens().size() + 1;
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("admin", "1234", "admin"));
        users.add(new User("rajesh", "1111", "citizen"));

        System.out.println("===== LOGIN =====");
        System.out.print("Username: ");
        String uname = sc.next();
        System.out.print("Password: ");
        String pass = sc.next();

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
           citizenMenu(city, sc);
        }
    }
    public static void adminMenu(City city, Scanner sc){
        while(true){
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. View Citizens");
            System.out.println("2. View Services");
            System.out.println("3. View Requests");
            System.out.println("4. Exit");

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                   city.displayCitizens();
                   break;
                case 2:
                   city.displayServices();
                   break;
                case 3:
                   city.viewRequests();
                   break;
                case 4:
                    return;
            }
        }
    }
    public static void citizenMenu(City city, Scanner sc){
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
                    System.out.print("Enter Request ID: ");
                    int rid = sc.nextInt();

                    System.out.print("Enter Citizen ID: ");
                    int cid = sc.nextInt();

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