package Main.repository;


public abstract class Repositorium {


    public String getAll(Object[] a) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        return b.append("").toString();
    }

    public Object getByID(Object[] a, int ID) {
        ID--;
        return a[ID];
    }

    public Object deleteByID(Object[] a, int ID) {
        ID--;
        return a[ID] = null;
    }

}

