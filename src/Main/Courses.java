package Main;


import static Service.CoursesService.Counting;

public class Courses {
    public static String name;
    public static Integer ID=0;
    private long identifier;
    private Lectors lectors;
    private Students students;
    private AdditionalMaterial material;
    private HomeWork homeWork;
    public Courses(String name) {
        Courses.name = name;
        System.out.println(name);
        Counting();
    }}











