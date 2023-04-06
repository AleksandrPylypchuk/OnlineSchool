package service;

import Main.object.Course;

public class CoursesService {
    public static Integer ID = 0;


    public static int Counting() {
        Course.setID(Course.getID());
        return ID++;
    }

    }


