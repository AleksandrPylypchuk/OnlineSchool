package Main;

import Main.Repository.CourseRepository;
import Main.Repository.HomeWorkRepository;
import Main.Repository.LectorRepository;
import Main.Repository.StudentRepository;
import Service.Service;


import java.util.Arrays;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {


        //__________TASK NINE____________________


        LectorRepository lectorsRepository = new LectorRepository();
        lectorsRepository.addLectors(new Lector("FirstLector"));

        StudentRepository studentRepository = new StudentRepository();
        studentRepository.addStudent(new Student("FirstStudent"));
        studentRepository.addStudent(new Student("SecondStudent"));
        studentRepository.addStudent(new Student("ThirdStudent"));
        studentRepository.addStudent(new Student("FourthStudent"));

        CourseRepository courseRepository = new CourseRepository();
        HomeWorkRepository homeWorkRepository = new HomeWorkRepository();

        courseRepository.addCourse(new Course("FirstCours"));

        homeWorkRepository.addHomeWork(new HomeWork("First HomeWork"));
        homeWorkRepository.addHomeWork(new HomeWork("Second HomeWork"));
        homeWorkRepository.addHomeWork(new HomeWork("Third HomeWork"));

        int a, b;
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.printf("Choose category: \n");
            System.out.printf("1: Courses\n");
            System.out.printf("2: Lectors\n");
            System.out.printf("3: Students\n");
            System.out.printf("4: Tasks\n");
            System.out.printf("5: Service\n");

            a = Integer.parseInt(scanner.next());
        }


        while (a < 1 || a > 5);
        {

            switch (a) {
                case 1:
                    System.out.printf("Your choose are Courses\n");
                    System.out.println("Do you want create new Course: Y/N");
                    String scanning = scanner.next();
                    while (scanning.equals("Y") || scanning.equals("y")) {
                        System.out.println("Add name of Course\n");
                        String scanner1;
                        scanner1 = scanner.next();
                        courseRepository.addCourse(new Course(scanner1));
                        System.out.println("Do you want create new Course: Y/N");
                        scanning = scanner.next();
                        if (scanning.equals("N") || scanning.equals("N")) {
                        }

                    }
                    System.out.println("Good Bye");
                    return;
                case 2:
                    System.out.printf("Your choose are Lectors\n");
                    break;
                case 3:
                    System.out.printf("Your choose are Student\n");
                    break;
                case 4:
                    System.out.printf("Your choose are Home Task\n");
                    break;
                case 5:
                    System.out.printf("Choose category of Service: \n");
                    System.out.printf("1: Courses\n");
                    System.out.printf("2: Lectors\n");
                    System.out.printf("3: Students\n");
                    System.out.printf("4: Home Work\n");


                    b = scanner.nextInt();
                    while (b < 1 || b > 5) ;
                {
                    switch (b) {

                        case 1:
                            System.out.println(Service.ServicePrinting(courseRepository.getCourseArrays()));
                            break;
                        case 2:
                            System.out.println(Service.ServicePrinting(lectorsRepository.getLectorArrays()));
                            break;
                        case 3:
                            System.out.println(Service.ServicePrinting(studentRepository.getStudentArrays()));
                            break;
                        case 4:
                            System.out.println(Service.ServicePrinting(homeWorkRepository.getHomeWorkArrays()));
                            break;
                    }

                    break;

                }
            }

        }





    }
}





