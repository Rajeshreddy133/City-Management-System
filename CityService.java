public class CityService implements Service {

    private int serviceId;
    private String serviceName;
    private String description;

    public CityService(int serviceId, String serviceName, String description) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.description = description;
    }

    public void provideService() {
        System.out.println("Service ID: " + serviceId);
        System.out.println("Service Name: " + serviceName);
        System.out.println("Description: " + description);
        System.out.println("----------------------------");
    }
}