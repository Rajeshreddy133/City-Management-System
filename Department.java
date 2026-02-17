import java.util.ArrayList;

public class Department {

    private int deptId;
    private String deptName;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Department(int deptId, String deptName) {
        this.deptId = deptId;
        this.deptName = deptName;
    }

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void displayDepartment() {
        System.out.println("Department ID: " + deptId);
        System.out.println("Department Name: " + deptName);
        System.out.println("Employees:");
        for (Employee emp : employees) {
            emp.display();
        }
    }
}