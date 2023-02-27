package Main;

import java.util.Scanner;

public class CreateCourse {
    public String name;
    public int ID;

    public CreateCourse(String name) {

        System.out.println("Add name of Course\n");
        Scanner scanner = new Scanner(System.in);
        String nameCourse = scanner.next();
       // Courses newNameCourse = new Courses(nameCourse);
        this.ID = Course.ID;
        System.out.println("New Course " + nameCourse + ". Total of Courses are  " + ID);


    }


}












