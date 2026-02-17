public class Citizen extends Person {

    private String address;
    private int age;

    public Citizen(int id, String name, String contact, String address, int age) {
        super(id, name, contact);
        this.address = address;
        this.age = age;
    }

    public void display() {
        super.display();
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
        System.out.println("----------------------------");
    }
}