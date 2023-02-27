package Main;

import Main.Repository.CourseRepository;
import Main.Repository.HomeWorkRepository;
import Main.Repository.LectorRepository;


import java.util.Arrays;


public class Main {


    public static void main(String[] args) {
        /*
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
*/
        //__________TASK NINE____________________
        LectorRepository lectorsRepository = new LectorRepository();
        lectorsRepository.addLectors(new Lector("FirstLector"));

        CourseRepository courseRepository = new CourseRepository();
        HomeWorkRepository homeWorkRepository = new HomeWorkRepository();

        courseRepository.addCourse(new Course("FirstCours"));

        homeWorkRepository.addHomeWork(new HomeWork("First HomeWork"));
        homeWorkRepository.addHomeWork(new HomeWork("Second HomeWork"));
        homeWorkRepository.addHomeWork(new HomeWork("Third HomeWork"));
        System.out.println(Arrays.toString(courseRepository.getCourseArrays()));
        System.out.println(Arrays.toString(homeWorkRepository.getHomeWorkArrays()));
        //System.out.println(Arrays.toString(lectorsRepository.getLectorArrays()));




    }
}



