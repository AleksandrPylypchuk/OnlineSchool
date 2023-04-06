package main;

import service.Service;
import main.repository.CourseRepository;

import java.util.Scanner;

public class ChooseClass {


    public void chooseVar() {

        int a, b;
        Scanner scanner = new Scanner(System.in);



            do {
                System.out.printf("Choose category: \n");
                System.out.printf("1: Courses\n");
                System.out.printf("2: Lectors\n");
                System.out.printf("3: Students\n");
                System.out.printf("4: Tasks\n");
                System.out.printf("5: Service\n");

                a = scanner.nextInt();
            }


            while (a < 1 || a > 5);
            {

                switch (a) {
                    case 1:
                        System.out.printf("Your choose are Courses\n");
                        break;
                    case 2:
                        System.out.printf("Your choose are Lectors\n");
                        break;
                    case 3:
                        System.out.printf("Your choose are Student\n");
                        break;
                    case 4:
                        System.out.printf("Your choose are Task\n");
                        break;
                    case 5:
                        System.out.printf("Choose category of Service: \n");
                        System.out.printf("1: Courses\n");
                        System.out.printf("2: Lectors\n");
                        System.out.printf("3: Students\n");
                        System.out.printf("4: Tasks\n");


                        b = scanner.nextInt();
                        while (b < 1 || b > 5) ;
                    {
                        switch (b) {

                            case 1:
                                CourseRepository printingCourse = new CourseRepository();
                                System.out.println(Service.ServicePrinting(printingCourse.getCourseArrays()));
                                break;
                            case 2:
                                System.out.printf("Your choose are Lectors\n");
                                break;
                            case 3:
                                System.out.printf("Your choose are Student\n");
                                break;
                            case 4:
                                System.out.printf("Your choose are Task\n");
                                break;
                            case 5:
                                System.out.printf("Your choose are Student\n");
                        }

                        break;

                    }
                }

            }


        }

        }


