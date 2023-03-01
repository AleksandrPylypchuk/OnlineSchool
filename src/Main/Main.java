package Main;

import Main.Repository.CourseRepository;
import Main.Repository.HomeWorkRepository;
import Main.Repository.LectorRepository;
import Main.Repository.StudentRepository;
import Service.Service;


import java.util.Arrays;
import java.util.Scanner;


public class Main {
    String scanning;

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


        System.out.printf("Choose category: \n");
        System.out.printf("1: Courses\n");
        System.out.printf("2: Lectors\n");
        System.out.printf("3: Students\n");
        System.out.printf("4: HomeWork\n");
        System.out.printf("5: Service\n");

        a = scanner.nextInt();


        while (a < 1 || a > 5) ;
        {
            String addName;

            switch (a) {

                case 1:
                    System.out.printf("Your choose are Courses\n");
                    System.out.println("Do you want create new Course: Y/N");
                    String scanning1 = scanner.next();
                    while (scanning1.equals("Y") || scanning1.equals("y")) {
                        System.out.println("Add name of Course\n");
                        addName = scanner.next();
                        courseRepository.addCourse(new Course(addName));
                        System.out.println("Do you want create new Course: Y/N");
                        scanning1 = scanner.next();
                        if (scanning1.equals("N") || scanning1.equals("n")) {
                            System.out.println(Service.ServicePrinting(courseRepository.getCourseArrays()));
                        }
                    }
                    break;
                case 2:
                    System.out.printf("Your choose are Lectors\n");
                    System.out.println("Do you want create new Lector: Y/N");
                    String scanning2 = scanner.next();
                    while (scanning2.equals("Y") || scanning2.equals("y")) {
                        System.out.println("Add name of Lector\n");
                        addName = scanner.next();
                        lectorsRepository.addLectors(new Lector(addName));
                        System.out.println("Do you want create new Lector: Y/N");
                        scanning2 = scanner.next();
                        if (scanning2.equals("N") || scanning2.equals("N")) {
                        }
                    }
                    break;
                case 3:
                    System.out.printf("Your choose are Student\n");
                    System.out.println("Do you want create new Student: Y/N");
                    String scanning3 = scanner.next();
                    while (scanning3.equals("Y") || scanning3.equals("y")) {
                        System.out.println("Add name of Student\n");
                        addName = scanner.next();
                        studentRepository.addStudent(new Student(addName));
                        System.out.println("Do you want create new Lector: Y/N");
                        scanning2 = scanner.next();
                        if (scanning2.equals("N") || scanning2.equals("N")) {
                        }
                    }
                    break;
                case 4:
                    System.out.printf("Your choose are Home Task\n");
                    System.out.println("Do you want create new Home Task: Y/N");
                    String scanning4 = scanner.next();
                    while (scanning4.equals("Y") || scanning4.equals("y")) {
                        System.out.println("Add Home Task\n");
                        addName = scanner.next();
                        homeWorkRepository.addHomeWork(new HomeWork(addName));
                        System.out.println("Do you want add Home Task: Y/N");
                        scanning2 = scanner.next();
                        if (scanning2.equals("N") || scanning2.equals("N")) {
                        }
                    }
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





