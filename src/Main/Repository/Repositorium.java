package Main.Repository;


import Main.Object.Course;

import static Service.CoursesService.Counting;

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

//    public void add(Object a) {
//        for (int i = 0; i < a.length; i++) {
//            if (a.[i] == null) {
//                a[i] = a;
//                int b = Counting();
//                Course.setID(b);
//                break;
//            }else if (i == a.length - 1) break;
//
//        }
//    }
}

