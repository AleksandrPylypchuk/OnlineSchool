package Main.object;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
public class  HomeWork implements Serializable {
    private String name;
    private String task;
    private Integer id;
    private long lectureID;
    private static int idCounter = 0;
    private Date deadline;

    public HomeWork(long lectureID, String task) {
        this.task = task;
        this.lectureID = lectureID;
        this.id = ++idCounter;
        this.deadline = calculateDeadline();
    }
    private Date calculateDeadline() {
        Date courseDate = getCourseDate();
        Date deadline = new Date(courseDate.getTime() + 24 * 60 * 60 * 1000);
        deadline.setHours(12);
        deadline.setMinutes(0);
        deadline.setSeconds(0);
        return deadline;
    }
    private Date getCourseDate() {
       return new Date();
    }
    public String getName() {
        return name;
    }
    public void printDeadline() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, HH:mm");
        System.out.println(dateFormat.format(deadline));
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public long getLectureID() {
        return lectureID;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLectureID(Integer lectureID) {
        this.lectureID = lectureID;
    }

    public String toString() {
        return "HomeWork " +
                "id=" + id +
                ", lectureID=" + lectureID +
                ", task='" + task;
    }
}
