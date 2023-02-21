package Main;


import Service.CoursesService;

import static Service.CoursesService.Counting;

public class Courses {
    public static String name;
    public int id;
    public static  Integer ID = 0;
    private int identifier;
    private Lectors lectors;
    private Students students;
    private AdditionalMaterial material;
    private HomeWork homeWork;

    public Courses(String name) {
        Courses.name = name;
        System.out.println(name);
        Counting();
        id  = Courses.ID;

    }




        



}












