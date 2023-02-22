package Main;

import java.security.PublicKey;

public class ChooseClass {

    public void printingChoose() {
        System.out.printf("Choose category: \n");
        System.out.printf("1: Courses\n");
        System.out.printf("2: Lectors\n");
        System.out.printf("3: Students\n");
        System.out.printf("4: Tasks\n");
    }

    public void chooseVar(int a) {

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
