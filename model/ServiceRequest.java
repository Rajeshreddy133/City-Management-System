package model;

public class ServiceRequest {
    private int requestId;
    private Citizen citizen;
    private CityService service;
    private String status;

    public ServiceRequest(int requestId, Citizen citizen, CityService service) {
        this.requestId = requestId;
        this.citizen = citizen;
        this.service = service;
        this.status = "Pending";
    }

    public int getRequestId() {
        return requestId;
    }

    public void completeRequest() {
        status = "Completed";
    }

    public void display() {
        System.out.println("Request ID: " + requestId);
        System.out.println("Citizen: " + citizen.getName());
        System.out.println("Service: " + service.getServiceId());
        System.out.println("Status: " + status);
        System.out.println("----------------------");
    }
}