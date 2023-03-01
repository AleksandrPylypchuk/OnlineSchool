package Service;

public class Service {
    public static Integer ID = 0;
    int CAPASITY = 10;

    public static String ServicePrinting(Object[] a) {
        int tmp=0;
        int iMax = a.length - 1;
        StringBuilder b = new StringBuilder();
        b.append(' ');
        for (int i = 0; ; i++) {
            tmp = i+1;
            System.out.println((String.valueOf(a[i]) + " ID= "+ tmp));
            if (i == iMax)
               return b.append("").toString();

        }
    }
}
