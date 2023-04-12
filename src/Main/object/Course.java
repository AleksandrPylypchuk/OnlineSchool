package Main.object;


import Main.CreateCourse;

public class Course{
    private String name;
    private int lectureID;
    private static Integer ID = 0;
    private int identifier;
    private Lector lectors;
    private AdditionalMaterial material;
    private HomeWork homeWork;

    public CreateCourse createCourse(String name) {
        return new CreateCourse(name);
    }

    public Course(int lectureID, String name) {
        this.name = name;
        this.lectureID=lectureID;
    }
    public Course(int lectureID, String name, HomeWork homeWork) {
        this.name = name;
        this.homeWork = homeWork;
        this.lectureID=lectureID;
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

    public void setHomeWorkID(int id){
        homeWork.setId(id);
    }

    public void setHomeWorkLectureID(int lectureID) {
        homeWork.setLectureid(lectureID);
    }
    public void setHomeWorkTask(String task) {
        homeWork.setTask(task);
    }
}















