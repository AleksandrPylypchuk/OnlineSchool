package Main;


import Service.CoursesService;

import static Service.CoursesService.Counting;

public class Courses {
    public static String name;
    public int id;
    public static Integer ID = 0;
    private int identifier;
    private Lectors lectors;
    private Students students;
    private AdditionalMaterial material;
    private HomeWork homeWork;

    public CreateCourse createCourse(String name) {
        return new CreateCourse(name);

    }



    public Courses(String name) {
        Courses.name = name;
        Counting();
        id = Courses.ID;


    }


}












