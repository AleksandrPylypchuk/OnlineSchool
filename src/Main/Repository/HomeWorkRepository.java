package Main.Repository;

import Main.HomeWork;


public class HomeWorkRepository {

    private int CAPACITY = 2;
    private HomeWork[] homeWorkArrays = new HomeWork[CAPACITY];

    public void addHomeWork(HomeWork homeWork) {

        for (int i = 0; i < homeWorkArrays.length; i++) {
            if (homeWorkArrays[i] == null) {
                //CountingHomework();
                homeWorkArrays[i] = homeWork;
                break;
            } else if (i == homeWorkArrays.length-1) {
                increasingArray();
            }

        }

    }


    private void increasingArray() {
        int tempCapacity = CAPACITY;
        CAPACITY = (CAPACITY * 3) / 2 + 1;
        HomeWork[] temphomeWorkArrays = new HomeWork[CAPACITY];
        System.arraycopy(homeWorkArrays, 0, temphomeWorkArrays, 0, tempCapacity);
        homeWorkArrays = temphomeWorkArrays;

    }


    public HomeWork[] getHomeWorkArrays() {
        return homeWorkArrays;
    }


}

