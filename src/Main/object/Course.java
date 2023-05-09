package Main.object;


import Main.CreateCourse;

import java.io.Serializable;
import Main.object.AdditionalMaterial;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Course implements Serializable {
    private String name;
    private Integer lectureID;
    private static Integer ID = 1;
    private int identifier;
    private Lector lector;
    private AdditionalMaterial material;
    private HomeWork homeWork;
    private static int idCounter = 1;
    private Date creationDate;
    private Date courseDate;
    private List<AdditionalMaterial> additionalMaterials;
    private Person lecturer;

    public void printCourseDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, EEEE HH:mm:ss");
        System.out.println(dateFormat.format(courseDate));
    }

    public Person getLecturer() {
        return lecturer;
    }

    public void setLecturer(Person lecturer) {
        this.lecturer = lecturer;
    }

    public Course(int lectureID, String name) {
        this.name = name;
        this.lectureID = idCounter++;
        this.creationDate = new Date();
        this.additionalMaterials = new ArrayList<>();
        this.lecturer = lecturer;
    }



    public Course(String name, HomeWork homeWork) {
        this.name = name;
        this.homeWork = homeWork;
        this.lectureID = idCounter++;
        this.creationDate = new Date();
        this.additionalMaterials = new ArrayList<>();
    }
    public Lector getLector() {
        return lector;
    }
    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCourseDate() {
        return courseDate;
    }

    public void setCourseDate(Date courseDate) {
        this.courseDate = courseDate;
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
    public int getNumAdditionalMaterials() {
        return additionalMaterials.size();
    }


}

