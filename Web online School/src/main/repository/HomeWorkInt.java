package Main.repository;

import Main.object.HomeWork;

public interface HomeWorkInt {


    HomeWork[] get();

    void add(HomeWork homeWork);
    void update(HomeWork homeWork);
    void remove(int index);
}