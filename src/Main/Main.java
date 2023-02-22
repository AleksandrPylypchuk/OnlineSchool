package Main;

import Service.CoursesService;
import Main.ChooseClass;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        Courses CourseOne = new Courses("Lesson1");
        Courses CourseTwo = new Courses("Lesson2");
        Courses CourseThree = new Courses("Lesson3");
        Courses CourseFour = new Courses("Lesson4");
        Courses CourseFive = new Courses("Lesson5");
        Courses CourseSix = new Courses("Lesson6");
      ChooseClass printing = new ChooseClass();
        printing.printingChoose();

        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        ChooseClass chooseClass = new ChooseClass();
        chooseClass.chooseVar(a);
    }
}