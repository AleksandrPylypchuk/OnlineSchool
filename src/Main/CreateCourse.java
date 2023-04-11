package Main;

import Main.object.Course;

import java.util.Scanner;

public class CreateCourse {
    public String name;
    private int ID;

    public CreateCourse(String name) {

        System.out.println("Add name of Course\n");
        Scanner scanner = new Scanner(System.in);
        String nameCourse = scanner.next();
        this.ID = Course.getID();
        System.out.println("New Course " + nameCourse + ". Total of Courses are  " + ID);
    }

}












