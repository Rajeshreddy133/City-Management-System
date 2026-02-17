import java.util.ArrayList;

public class City {

    private String cityName;
    private ArrayList<Citizen> citizens = new ArrayList<>();
    private ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<CityService> services = new ArrayList<>();
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
}