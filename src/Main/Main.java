package Main;

import Main.object.*;
import Main.repository.*;
import service.Service;

import java.util.Scanner;

import Main.object.Person;
import Main.object.Role;

public class Main {
    public static void main(String[] args) {

        PersonRepository personRepository = new PersonRepository();
        CourseRepository courseRepository = new CourseRepository();
        HomeWorkRepository homeWorkRepository = new HomeWorkRepository();

        personRepository.addPerson(new Person(Role.TEACHER, "Miroslav", "Bykov", "miroslav@gmail.com", "+3809912345678", 1));
        personRepository.addPerson(new Person(Role.TEACHER, "Mykola", "Petrov", "Mykola@gmail.com", "+3809812345678", 2));
        personRepository.addPerson(new Person(Role.STUDENT, "Taras", "Repitor", "Taras@Gmail.com", "+3809712345678", 1));
        personRepository.addPerson(new Person(Role.STUDENT, "Andrii", "Charlz", "Andrii@gmail.com", "+3805012345678", 2));
        HomeWork homeTask1 = new HomeWork(1, 1,"Second homework for Course 1");
        homeWorkRepository.add(homeTask1);
        courseRepository.addCourse(new Course(1,"FirstCourse"));
        homeWorkRepository.add(new HomeWork(2, 1,"Second homework for Course 1"));
        homeWorkRepository.add(new HomeWork(3, 1,"Third homework for Course 1"));
        homeWorkRepository.add(new HomeWork(4, 1,"Fourth homework for Course 1"));
        courseRepository.addCourse(new Course(2,"SecondCourse", new HomeWork(5,1,"First homework with Course #2")));


        int a, b, c;
        Scanner scanner = new Scanner(System.in);
        int input = 0;

        while (input != -1) {
            System.out.print("Enter a number (-1 to exit and 1 for continues ): ");
            input = scanner.nextInt();

            if (input == -1) {
                break;
            }
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
                Person[] persons = personRepository.getPersonArrays();
                HomeWork[] homeWorks = homeWorkRepository.get();
                String addName, firstName, lastName, phoneNumber, email, description, addHomeWork;
                int addID, addlectureID;

                switch (a) {

                    case 1:
                        System.out.printf("Your choose are Courses\n");
                        System.out.println(courseRepository.getAll(courseRepository.getCourseArrays()));
                        System.out.println("Enter ID Course=");
                        c = scanner.nextInt();
                        System.out.println("You choose Course=" + courseRepository.getByID(courseRepository.getCourseArrays(), c));
                        for (HomeWork homeWorkChecked : homeWorks) {
                            if (homeWorkChecked.getLectureID() == c) {
                                System.out.println(homeWorkChecked);
                            }
                        }
                        System.out.println("Do you want create new Course: Y/N");
                        String scanning1 = scanner.next();
                        while (scanning1.equals("Y") || scanning1.equals("y")) {
                            System.out.println("Add id of Course\n");
                            addID = Integer.parseInt(scanner.next());
                            System.out.println("Add name of Course\n");
                            addName = scanner.next();
                            courseRepository.addCourse(new Course(addID, addName));
                            System.out.println("Do you want create new Course: Y/N");
                            scanning1 = scanner.next();
                            if (scanning1.equals("N") || scanning1.equals("n")) {
                                System.out.println(Service.ServicePrinting(courseRepository.getCourseArrays()));
                            }
                        }
                        break;
                    case 2:
                        System.out.printf("Your choose are Lectors\n");
                        for (int i = 0; i < persons.length; i++) {
                            if (persons[i] != null) {
                                if (persons[i].getRole() == Role.TEACHER) {
                                    System.out.println(persons[i]);
                                }
                            }
                        }
                        System.out.println("Do you want create new Lector: Y/N");
                        String scanning2 = scanner.next();
                        while (scanning2.equals("Y") || scanning2.equals("y")) {
                            System.out.println("Add Firstname of Lector\n");
                            firstName = scanner.next();
                            System.out.println("Add Lastname of Lector\n");
                            lastName = scanner.next();
                            System.out.println("Add email of Lector\n");
                            email = scanner.next();
                            System.out.println("Add phone of Lector\n");
                            phoneNumber = scanner.next();
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
                            System.out.println("Add phone of Student\n");
                            phoneNumber = scanner.next();
                            System.out.println("Add ID of Student\n");
                            addID = Integer.parseInt(scanner.next());
                            personRepository.addPerson(new Person(Role.STUDENT, firstName, lastName, email, phoneNumber, addID));
                            System.out.println("Do you want create new Student: Y/N");

                            if (scanning3.equals("N") || scanning3.equals("n")) {
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Your choose are Home Task\n");
                        System.out.println("Do you want create new Home Task: Y/N");
                        String scanning4 = scanner.next();
                        while (scanning4.equals("Y") || scanning4.equals("y")) {
                            System.out.println(courseRepository.getAll(courseRepository.getCourseArrays()));
                            System.out.println("Enter ID Course=");
                            addlectureID = Integer.parseInt(scanner.next());
                            System.out.println("Set number of Task\n");
                            addID = Integer.parseInt(scanner.next());
                            System.out.println("Add Task Home Task\n");
                            description = scanner.next();
                            homeWorkRepository.add(new HomeWork(addID, addlectureID, description));
                            System.out.println("Do you want add Home Task: Y/N");
                            scanning2 = scanner.next();
                            if (scanning2.equals("N") || scanning2.equals("n")) {
                                break;
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
                                for (int i = 0; i < persons.length; i++) {
                                    if (persons[i] != null) {
                                        if (persons[i].getRole() == Role.TEACHER) {
                                            System.out.println(persons[i]);
                                        }
                                    }
                                }
                                break;
                            case 3:
                                for (int i = 0; i < persons.length; i++) {
                                    if (persons[i] != null) {
                                        if (persons[i].getRole() == Role.STUDENT) {
                                            System.out.println(persons[i]);
                                        }
                                    }
                                }
                                break;
                            case 4:
                                System.out.println(Service.ServicePrinting(homeWorkRepository.get()));
                                break;
                        }

                        break;

                    }
                }

            }

        }
        System.out.println("Exit");
    }
}
