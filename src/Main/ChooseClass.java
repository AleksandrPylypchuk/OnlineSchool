package Main;

import java.security.PublicKey;
import java.util.Scanner;

public class ChooseClass {

   // public void printingChoose() {

   // }

    public void  chooseVar(int a) {;
                Scanner scanner = new Scanner(System.in);
do {System.out.printf("Choose category: \n");
    System.out.printf("1: Courses\n");
    System.out.printf("2: Lectors\n");
    System.out.printf("3: Students\n");
    System.out.printf("4: Tasks\n");
    a = scanner.nextInt();}
        while (a<1 || a>4);{

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

        }
        }

    }

}
