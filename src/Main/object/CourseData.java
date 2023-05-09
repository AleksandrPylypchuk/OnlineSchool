package Main.object;

import java.io.*;
import java.util.List;

public class CourseData implements Serializable {
    private List<Course> courses;
    private List<HomeWork> homeworks;
    private List<Person> persons;

    public CourseData(List<Course> courses, List<HomeWork> homeworks, List<Person> persons) {
        this.courses = courses;
        this.homeworks = homeworks;
        this.persons = persons;

    }
    public static CourseData restore(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (CourseData) ois.readObject();
        }
    }
    public List<Course> getCourses() {
        return courses;
    }

    public List<HomeWork> getHomeworks() {
        return homeworks;
    }

    public List<Person> getPersons() {
        return persons;
    }



    public void backup(String fileName) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
        }
    }

}
