package Main.object;


import Main.CreateCourse;

public class Course extends SuperObject{

    private String name;
    private int id;
    private static Integer ID = 0;
    private int identifier;
    private Lector lectors;

    private AdditionalMaterial material;
    private HomeWork homeWork;

    public CreateCourse createCourse(String name) {
        return new CreateCourse(name);

    }

  public Course(String name) {
    super(name);
    this.name = name;
      }

  @Override
  public String toString() {
    return "Courses{" +
            "name='" + name + '\'' +
            '}';
  }


  public static class AdditionalMaterial {
      private AdditionalMaterial name;
      private long identifier;
  }

  public static void setID(Integer ID) {
    Course.ID = ID;
  }

  public static Integer getID() {
    return ID;
  }
}















