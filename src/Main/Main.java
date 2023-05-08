package Main;

import Main.interator.SimpleIterator;
import Main.object.*;
import Main.repository.*;
import service.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

import Main.object.Person;
import Main.object.Role;

import javax.crypto.spec.PSource;

public class Main {
    public static void main(String[] args) {

        PersonRepository personRepository = new PersonRepository();
        CourseRepository courseRepository = new CourseRepository();
        HomeWorkRepository homeWorkRepository = new HomeWorkRepository();

        personRepository.addPerson(new Person(Role.TEACHER, "Miroslav", "Bykov", "miroslav@gmail.com", "+3809912345678", 1));
        personRepository.addPerson(new Person(Role.TEACHER, "Mykola", "Petrov", "Mykola@gmail.com", "+3809812345678", 2));
        personRepository.addPerson(new Person(Role.STUDENT, "Taras", "Repitor", "Taras@Gmail.com", "+3809712345678", 1));
        personRepository.addPerson(new Person(Role.STUDENT, "Andrii", "Charlz", "Andrii@gmail.com", "+3805012345678", 2));
        HomeWork homeTask1 = new HomeWork( 1, "Second homework for Course 1");
        homeWorkRepository.add(homeTask1);
        courseRepository.addCourse(new Course(1, "FirstCourse"));
        homeWorkRepository.add(new HomeWork( 1, "Second homework for Course 1"));
        homeWorkRepository.add(new HomeWork( 1, "Third homework for Course 1"));
        homeWorkRepository.add(new HomeWork( 2, "Fourth homework for Course 2"));
        courseRepository.addCourse(new Course( "SecondCourse", new HomeWork( 1, "First homework with Course #2")));
        Scanner scanner = new Scanner(System.in);
        int a = 0;




        while (a != -1) {
            System.out.println("__________________________________");
            System.out.print("Enter a number (-1 to exit): ");
            System.out.println();
            System.out.println("Choose category:");
            System.out.println("1: Courses");
            System.out.println("2: Lectors");
            System.out.println("3: Students");
            System.out.println("4: HomeWork");
            System.out.println("5: Service");
            try {
                a = scanner.nextInt();
                if (a < 0 || a > 5) {
                    throw new InputMismatchException("Invalid Category! Please enter a correct category");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
            if (a == -1) {
                break;
            }


            Person[] persons = personRepository.getPersonArrays();
            HomeWork[] homeWorks = homeWorkRepository.get();
            String addName, firstName, lastName, phoneNumber, email, description;
            int addID = 0, addlectureID;

            switch (a) {

                case 1:
                    System.out.printf("Your choose are Courses\n");
                    boolean validID = false;
                    while (!validID) {
                        try {
                            System.out.println(courseRepository.getAll(courseRepository.getCourseArrays()));
                            System.out.println("__________________________________");
                            System.out.println("Choose your Course");
                            a = scanner.nextInt();
                            if (a < 1 || a > courseRepository.getCourseArrays().length) {
                                throw new InputMismatchException("Invalid ID! Please enter a correct ID");
                            } else {
                                validID = true;
                            }
                        } catch (InputMismatchException e) {
                            System.out.println(e.getMessage());
                            scanner.nextLine();
                        }
                    }

                    System.out.println("You choose " + courseRepository.getByID(a));
                    for (HomeWork homeWorkChecked : homeWorks) {
                        if (homeWorkChecked.getLectureID() == a) {
                            System.out.println(homeWorkChecked);
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

                    while (true) {
                        System.out.println("Do you want create new Lector: Y/N");
                        String scanning2 = scanner.next();
                        if (scanning2.equalsIgnoreCase("Y")) {
                            System.out.println("Add Firstname of Lector\n");
                            firstName = scanner.next();
                            System.out.println("Add Lastname of Lector\n");
                            lastName = scanner.next();
                            System.out.println("Add email of Lector\n");
                            email = scanner.next();
                            System.out.println("Add phone of Lector\n");
                            phoneNumber = scanner.next();

                            boolean valid = false;
                            while (!valid) {
                                try {
                                    System.out.println("Add ID of Course max is "+ courseRepository.getCourseArrays().length);
                                    addID = scanner.nextInt();
                                    if (addID < 1 || addID > courseRepository.getCourseArrays().length) {
                                        throw new InputMismatchException("Invalid ID! Please enter a correct ID");
                                    } else {
                                        valid = true;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Invalid ID! Please enter a correct ID");
                                    scanner.nextLine();
                                }
                            }
                            personRepository.addPerson(new Person(Role.TEACHER, firstName, lastName, email, phoneNumber, addID));

                        } else if (scanning2.equalsIgnoreCase("N")) {
                             break;
                        } else {
                            System.out.println("Invalid input! Please enter 'Y' or 'N'");

                        }
                    }
                    persons = personRepository.getPersonArrays();
                    for (int i = 0; i < persons.length; i++) {
                        if (persons[i] != null) {
                            if (persons[i].getRole() == Role.TEACHER) {
                                System.out.println(persons[i]);
                            }
                        }
                    }
                    break;
                case 3:
                    System.out.printf("Your choose are Student\n");
                    for (int i = 0; i < persons.length; i++) {
                        if (persons[i] != null) {
                            if (persons[i].getRole() == Role.STUDENT) {
                                System.out.println(persons[i]);
                            }
                        }
                    }

                    while (true) {
                        System.out.println("Do you want create new Student: Y/N");
                        String scanning2 = scanner.next();
                        if (scanning2.equalsIgnoreCase("Y")) {
                            System.out.println("Add Firstname of Student\n");
                            firstName = scanner.next();
                            System.out.println("Add Lastname of Student\n");
                            lastName = scanner.next();
                            System.out.println("Add email of Student\n");
                            email = scanner.next();
                            System.out.println("Add phone of Student\n");
                            phoneNumber = scanner.next();

                            boolean valid = false;
                            while (!valid) {
                                try {
                                    System.out.println("Add ID of Course max is "+ courseRepository.getCourseArrays().length);
                                    addID = scanner.nextInt();
                                    if (addID < 1 || addID > courseRepository.getCourseArrays().length) {
                                        throw new InputMismatchException("Invalid ID! Please enter a correct ID");
                                    } else {
                                        valid = true;
                                    }
                                } catch (InputMismatchException e) {
                                    System.out.println(e.getMessage());
                                    System.out.println("Invalid ID! Please enter a correct ID");
                                    scanner.nextLine();
                                }
                            }
                            personRepository.addPerson(new Person(Role.STUDENT, firstName, lastName, email, phoneNumber, addID));

                        } else if (scanning2.equalsIgnoreCase("N")) {
                            break;
                        } else {
                            System.out.println("Invalid input! Please enter 'Y' or 'N'");

                        }
                    }
                    persons = personRepository.getPersonArrays();
                    for (int i = 0; i < persons.length; i++) {
                        if (persons[i] != null) {
                            if (persons[i].getRole() == Role.STUDENT) {
                                System.out.println(persons[i]);
                            }
                        }
                    }
                    break;
                case 4:
                    System.out.println("Your choose are Home Task\n");
                    System.out.println(Service.ServicePrinting(homeWorkRepository.get()));
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
                        homeWorkRepository.add(new HomeWork(addlectureID, description));
                        System.out.println("Do you want add Home Task: Y/N");
                        scanning4 = scanner.next();
                        if (scanning4.equals("N") || scanning4.equals("n")) {
                            break;
                        }
                    }
                    break;

                case 5:
                    System.out.println("Choose category of Service: ");
                    System.out.println("1: Courses");
                    System.out.println("2: Persons");
                    System.out.println("3: Home Work");


                    a = scanner.nextInt();
                    if (a < 1 || a > 5) ;
                {
                    switch (a) {

                        case 1:
                            System.out.println(Service.ServicePrinting(courseRepository.getCourseArrays()));
                            System.out.println("Do you want create new Course: Y/N");
                            String scanning1 = scanner.next();
                            while (true) {
                                if (scanning1.equalsIgnoreCase("Y")) {
                                    System.out.println("Add id of Course\n");
                                    addID = Integer.parseInt(scanner.next());
                                    System.out.println("Add name of Course\n");
                                    addName = scanner.next();
                                    courseRepository.addCourse(new Course(addID, addName));
                                    System.out.println("Do you want create new Course: Y/N");
                                    scanning1 = scanner.next();
                                } else if (scanning1.equalsIgnoreCase("N")) {
                                    System.out.println(Service.ServicePrinting(courseRepository.getCourseArrays()));
                                    break;
                                } else {
                                    System.out.println("Invalid input! Please enter 'Y' or 'N'");
                                    scanning1 = scanner.next();
                                }
                            }
                            break;
                        case 2:
                            System.out.println("Your choose Persons");
                            SimpleIterator<Person> iterator = personRepository.getAll();
                            while(iterator.hasNext()) {
                                System.out.println(iterator.next());}
                            break;

                        case 3:
                            System.out.println(Service.ServicePrinting(homeWorkRepository.get()));
                            break;
                    }

                    break;

                }
            }


        }
        System.out.println("Exit");
    }
}
