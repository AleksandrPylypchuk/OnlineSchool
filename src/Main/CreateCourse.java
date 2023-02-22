package Main;

import java.util.Scanner;

import static Service.CoursesService.Counting;

public class CreateCourse {
    public String name;
    public int ID;

    public CreateCourse(String name) {

        System.out.println("Add name of Course\n");
        Scanner scanner = new Scanner(System.in);
        String nameCourse = scanner.next();
        Courses newNameCourse = new Courses(nameCourse);
        this.ID = Courses.ID;
        System.out.println("New Course " + nameCourse + ". Total of Courses are  " + ID);


    }


}












