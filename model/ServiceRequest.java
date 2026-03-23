package model;

public class ServiceRequest {
    private int requestId;
    private Citizen citizen;
    private CityService service;
    private String status;
    private String priority;
    private String date;

    public ServiceRequest(int requestId, Citizen citizen, CityService service, String priority, String date) {
        this.requestId = requestId;
        this.citizen = citizen;
        this.service = service;
        this.priority = priority;
        this.date = date;
        this.status = "Pending";
    }

    public int getRequestId() { return requestId; }
    public String getStatus() { return status; }
    
    public void updateStatus() {
        if (status.equals("Pending")) {
            status = "In Progress";
        } else if (status.equals("In Progress")) {
            status = "Completed";
        } else {
            System.out.println("Already Completed!");
        }
    }

    public void display() {
        System.out.println("Request ID: " + requestId);
        System.out.println("Citizen: " + citizen.getName());
        System.out.println("Service ID: " + service.getServiceId());
        System.out.println("Status: " + status);
        System.out.println("Priority: " + priority);
        System.out.println("Date: " + date);
        System.out.println("----------------------");
    }
    public Citizen getCitizen() {
        return citizen;
    }
}