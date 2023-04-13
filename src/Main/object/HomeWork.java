package Main.object;

public class HomeWork {
    private String name;
    private String task;
    private long id;
    private long lectureID;
    private static int idCounter = 0;


    public HomeWork(long lectureID, String task) {
        this.task = task;
        this.lectureID = lectureID;
        this.id = ++idCounter;
    }

    public String getName() {
        return name;
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

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setLectureid(long lectureID) {
        this.lectureID = lectureID;
    }

    public String toString() {
        return "HomeWork " +
                "id=" + id +
                ", lectureID=" + lectureID +
                ", task='" + task;
    }
}
