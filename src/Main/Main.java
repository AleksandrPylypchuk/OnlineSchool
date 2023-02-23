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

        Scanner scanner = new Scanner(System.in);

//        ChooseClass printing = new ChooseClass();
//        printing.printingChoose();

        //int a = scanner.nextInt();
        ChooseClass chooseClass = new ChooseClass();
        chooseClass.chooseVar(2);


        //______________________________________________

        System.out.println("Do you want create new Course: Y/N");
        String scanning = scanner.next();
        while (scanning.equals("Y") || scanning.equals("y")) {

            CreateCourse createCourse = new CreateCourse(scanning);

            if (Courses.ID == 8){
                System.out.println("Maximum is 8");
                break;
            }
            System.out.println("Do you want create new Course: Y/N");
            scanning = scanner.next();
            if (scanning.equals("N") || scanning.equals("N") ) {
            }



        }
        System.out.println("Good Bye");

    }
}



