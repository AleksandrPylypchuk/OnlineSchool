package Service;

public class Service {
    public static Integer ID = 0;
    int CAPASITY = 10;
 /*   private Service[] services = new Service[CAPASITY];

    public void ServicePrint(Service service) {
        for (int i = 0; i < services.length; i++) {
            ID = i + 1;
            System.out.println(services[i] + " ID" + ID);

        }

    }

    public void setServices(Service[] services) {
        this.services = services;
    }
}*/

    public static String ServicePrinting(Object[] a) {
        int tmp=0;
        int iMax = a.length - 1;
        StringBuilder b = new StringBuilder();
        b.append(' ');
        for (int i = 0; ; i++) {
            tmp = i+1;
            System.out.println((String.valueOf(a[i]) + " ID= "+ tmp));
            if (i == iMax)
               return b.append("End").toString();

        }
    }
}
