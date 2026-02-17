public class Employee extends Person {

    private String position;
    private double salary;

    public Employee(int id, String name, String contact, String position, double salary) {
        super(id, name, contact);
        this.position = position;
        this.salary = salary;
    }

    public void display() {
        super.display();
        System.out.println("Position: " + position);
        System.out.println("Salary: " + salary);
        System.out.println("----------------------------");
    }
}