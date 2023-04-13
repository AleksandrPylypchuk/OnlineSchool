package service;

public class Service {
    public static Integer ID = 0;
    int CAPACITY = 10;

    public static String ServicePrinting(Object[] a) {

        int iMax = a.length - 1;
        StringBuilder b = new StringBuilder();
        b.append(' ');
        for (int i = 0; ; i++) {


            System.out.println((String.valueOf(a[i])));
            if (i == iMax)
               return b.append("").toString();

        }
    }
}
