package Main;

import Main.Enum.ResurceType;
import Main.object.*;
import Main.repository.*;
import service.Service;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import Main.object.Person;
import Main.Enum.Role;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        AdditionalMaterialRepository additionalMaterialRepository = new AdditionalMaterialRepository();
        AdditionalMaterial additionalMaterial = new AdditionalMaterial(1,"Material#1", 1, ResurceType.BOOK);
        additionalMaterialRepository.add(additionalMaterial);

        PersonRepository personRepository = new PersonRepository();
        CourseRepository courseRepository = new CourseRepository();
        HomeWorkRepository homeWorkRepository = new HomeWorkRepository();

        HomeWork homeTask1 = new HomeWork( 1, "Second homework for Course 1");
        homeWorkRepository.add(homeTask1);
        courseRepository.addCourse(new Course(1, "FirstCourse"));
        homeWorkRepository.add(new HomeWork( 1, "Second homework for Course 1"));
        homeWorkRepository.add(new HomeWork( 1, "Third homework for Course 1"));
        homeWorkRepository.add(new HomeWork( 2, "Fourth homework for Course 2"));
        courseRepository.addCourse(new Course( "SecondCourse", new HomeWork( 1, "First homework with Course #2")));
        Scanner scanner = new Scanner(System.in);
        int a = 0;

        List<Person> personList = personRepository.getPersonList();


        while (a != -1) {
            System.out.println("__________________________________");
            System.out.print("Enter a number (-1 to exit): ");
            System.out.println();
            System.out.println("Choose category:");
            System.out.println("1: Courses");
            System.out.println("2: Lectors");
            System.out.println("3: Students");
            System.out.println("4: HomeWork");
            System.out.println("5: Additional material");
            System.out.println("6: Service");
            try {
                a = scanner.nextInt();
                if (a < 0 || a > 6) {
                    throw new InputMismatchException("Invalid Category! Please enter a correct category");
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                scanner.nextLine();
            }
            if (a == -1) {
                break;
            }



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
                    List<Person> lecturers = personRepository.getPersonList();
                    for (Person lecturer : lecturers) {
                        if (lecturer.getRole() == Role.TEACHER) {
                            System.out.println(lecturer);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Your choose are Students");
                    List<Person> students = personRepository.getPersonList().stream()
                            .filter(p -> p.getRole() == Role.STUDENT)
                            .collect(Collectors.toList());
                    for (Person student : students) {
                        System.out.println(student);
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
                    System.out.println("Choose category of Additional materials: ");
                    System.out.println(additionalMaterialRepository.getAllAdditionalMaterials().toString());
                    System.out.println("Do you want create new Additional material: Y/N");
                    String scanning5 = scanner.next();
                    while (scanning5.equalsIgnoreCase("y")) {
                        System.out.println("Enter id of the Additional material:");
                        int id = scanner.nextInt();
                        while (additionalMaterialRepository.getAdditionalMaterialById(id) != null) {
                            System.out.println("The id is already taken. Enter a unique id:");
                            id = scanner.nextInt();
                        }
                        System.out.println("Enter name of the Additional material:");
                        String name = scanner.next();
                        System.out.println("Enter lecture id of the Additional material:");
                        int lectureId = scanner.nextInt();
                        System.out.println("Enter resource type of the Additional material (choose from BOOK, URL, VIDEO):");
                        String resourceType = scanner.next().toUpperCase();
                        while (!Arrays.asList("BOOK", "URL", "VIDEO").contains(resourceType)) {
                            System.out.println("Invalid resource type. Choose from BOOK, URL, VIDEO:");
                            resourceType = scanner.next().toUpperCase();
                        }
                        if (resourceType.equals("BOOK")) {
                            additionalMaterialRepository.add(new AdditionalMaterial(id, name, lectureId, ResurceType.BOOK));
                        }
                        if (resourceType.equals("URL")) {
                            additionalMaterialRepository.add(new AdditionalMaterial(id, name, lectureId, ResurceType.URL));
                        }
                        if (resourceType.equals("VIDEO")) {
                            additionalMaterialRepository.add(new AdditionalMaterial(id, name, lectureId, ResurceType.VIDEO));
                        }
                        System.out.println("Do you want create new Additional material: Y/N");
                        scanning5 = scanner.next();
                    }
                    break;
                case 6:
                    System.out.println("Choose category of Service: ");
                    System.out.println("1: Courses");
                    System.out.println("2: Persons");
                    System.out.println("3: Home Work");
                    System.out.println("4: Additional material");


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


                         for (Person person : personList) {
                System.out.println(person);
            }
                        break;
                        case 3:
                            System.out.println(Service.ServicePrinting(homeWorkRepository.get()));
                            break;
                        case 4:
                            System.out.println(additionalMaterialRepository.getAllAdditionalMaterials().toString());
                   break;
                    }

                    break;

                }
            }


        }
        System.out.println("Exit");
    }
}
