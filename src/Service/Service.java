package Service;

public class Service {
    public static Integer ID = 0;

    private Service[] services = new Service[100];
    private void ServicePrint(Service service) {
        for (int i = 0; i <services.length; i++) {
            ID++;
            System.out.println(services[i] + " ID" + ID);

        }

    }
}
