package Main;

import Service.CoursesService;


public class Main {

    public static void main(String[] args) {
        Courses CourseOne = new Courses("Lesson1");
        Courses CourseTwo = new Courses("Lesson2");
        Courses CourseThree = new Courses("Lesson3");
        Courses CourseFour = new Courses("Lesson4");
        Courses CourseFive = new Courses("Lesson5");
        Courses CourseSix = new Courses("Lesson6");
        System.out.println("County of Courses: " + Courses.ID);
        System.out.println("Lesson Tree with id " + CourseThree.id);
    }
}