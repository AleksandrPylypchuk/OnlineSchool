package Main.object;


import Main.CreateCourse;

public class Course {
    private String name;
    private Integer lectureID;
    private static Integer ID = 1;
    private int identifier;
    private Lector lectors;
    private AdditionalMaterial material;
    private HomeWork homeWork;
    private static int idCounter = 1;

    public CreateCourse createCourse(String name) {
        return new CreateCourse(name);
    }

    public void setLectureID(Integer lectureID) {
        this.lectureID = lectureID;
    }

    public Course(int lectureID, String name) {
        this.name = name;
        this.lectureID = idCounter++;;

    }

    public Course(String name, HomeWork homeWork) {
        this.name = name;
        this.homeWork = homeWork;
        this.lectureID = idCounter++;

    }

    public int getLectureID() {
        return lectureID;
    }

    @Override
    public String toString() {
        return "Courses ID=" + lectureID + "{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public static int getIdCounter() {
        return idCounter;
    }

    public static void setIdCounter(int idCounter) {
        Course.idCounter = idCounter;
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

    public void setHomeWorkID(int id) {
        homeWork.setId(id);
    }

    public void setHomeWorkLectureID(Integer lectureID) {
        homeWork.setLectureID(lectureID);
    }

    public String getName() {
        return name;
    }

    public void setHomeWorkTask(String task) {
        homeWork.setTask(task);
    }
}

