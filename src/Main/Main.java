package main;

import main.object.*;
import main.repository.*;
import service.Service;

import java.util.Arrays;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {


        PersonRepository personRepository = new PersonRepository();
        personRepository.addPerson(new Person(Role.TEACHER, "Miroslav", "Bykov", "miroslav@gmail.com", "+3809912345678", 1));
        personRepository.addPerson(new Person(Role.TEACHER, "Mykola", "Petrov", "Mykola@gmail.com", "+3809812345678", 2));
        personRepository.addPerson(new Person(Role.STUDENT, "Taras", "Repitor", "Taras@Gmail.com", "+3809712345678", 1));
        personRepository.addPerson(new Person(Role.STUDENT, "Andrii", "Charlz", "Andrii@gmail.com", "+3805012345678", 2));


        CourseRepository courseRepository = new CourseRepository();
        HomeWorkRepository homeWorkRepository = new HomeWorkRepository();

        courseRepository.addCourse(new Course("FirstCourse"));
        courseRepository.addCourse(new Course("SecondCourse"));
        courseRepository.addCourse(new Course("ThirdCourse"));
        courseRepository.addCourse(new Course("FourthCourse"));
        courseRepository.addCourse(new Course("FifthCourse"));

        homeWorkRepository.addHomeWork(new HomeWork("First HomeWork", "Working with first homework"));
        homeWorkRepository.addHomeWork(new HomeWork("Second HomeWork", "Working with second homework"));
        homeWorkRepository.addHomeWork(new HomeWork("Third HomeWork", "Working with third homework"));


        int a, b, c;
        Scanner scanner = new Scanner(System.in);


        System.out.println();
        System.out.println("Choose category:");
        System.out.println("1: Courses");
        System.out.println("2: Lectors");
        System.out.println("3: Students");
        System.out.println("4: HomeWork");
        System.out.println("5: Service");

        a = scanner.nextInt();


        while (a < 1 || a > 5) ;
        {
            String addName, firstName, lastName, phoneNumber, email,description;
            int addID;

            switch (a) {

                case 1:
                    System.out.printf("Your choose are Courses\n");
                    System.out.println(courseRepository.getAll(courseRepository.getCourseArrays()));
                    System.out.println("Enter ID Course=");
                    c = scanner.nextInt();
                    System.out.println("You choose Course=" + courseRepository.getByID(courseRepository.getCourseArrays(), c));
                    System.out.printf(Arrays.toString(personRepository.getPersonArrays()));
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
                        System.out.println("Add Firstname of Lector\n");
                        firstName = scanner.next();
                        System.out.println("Add Lastname of Lector\n");
                        lastName = scanner.next();
                        System.out.println("Add email of Lector\n");
                        email = scanner.next();
                        System.out.println("Add email of Lector\n");
                        phoneNumber = scanner.next();
                        System.out.println("Add ID of Course\n");
                        addID = Integer.parseInt(scanner.next());
                        System.out.println("Add ID of Course\n");
                        addID = Integer.parseInt(scanner.next());
                        personRepository.addPerson(new Person(Role.TEACHER, firstName, lastName, email, phoneNumber, addID));
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
                        System.out.println("Add Firstname of Student\n");
                        firstName = scanner.next();
                        System.out.println("Add Lastname of Student\n");
                        lastName = scanner.next();
                        System.out.println("Add email of Student\n");
                        email = scanner.next();
                        System.out.println("Add email of Student\n");
                        phoneNumber = scanner.next();
                        System.out.println("Add ID of Student\n");
                        addID = Integer.parseInt(scanner.next());
                        personRepository.addPerson(new Person(Role.STUDENT, firstName, lastName, email, phoneNumber, addID));
                        System.out.println("Do you want create new Student: Y/N");
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
                        System.out.println("Add Name Home Task\n");
                        addName = scanner.next();
                        System.out.println("Add description Home Task\n");
                        description = scanner.next();
                        homeWorkRepository.addHomeWork(new HomeWork(addName, description));
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
                            System.out.println(Service.ServicePrinting(personRepository.getPersonArrays()));
                            break;
                        case 3:
                            System.out.println(Service.ServicePrinting(personRepository.getPersonArrays()));
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
