package Main;


public class Course {
  //  public static String name;
    public String name;
    public int id;
    public static Integer ID = 0;
    private int identifier;
    private Lector lectors;

    private AdditionalMaterial material;
    private HomeWork homeWork;

    public CreateCourse createCourse(String name) {
        return new CreateCourse(name);

    }

  public Course(String name) {
    this.name = name;
      }

  @Override
  public String toString() {
    return "Courses{" +
            "name='" + name + '\'' +
            '}';
  }



    }















