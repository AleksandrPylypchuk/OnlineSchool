package Main;

import Service.CoursesService;

import java.net.IDN;

public class Main {
    public static void main(String[] args) {
        CoursesService CourseOne = new CoursesService("Lesson1");
        CoursesService CourseTwo = new CoursesService("Lesson2");
        CoursesService CoursesThree = new CoursesService("Lesson3");


        System.out.println(Courses.ID);
    }
}