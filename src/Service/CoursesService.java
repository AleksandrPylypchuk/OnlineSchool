package Service;

import Main.Courses;

public class CoursesService {
        public static Integer ID=0;

    public CoursesService(String name) {
        Courses.name = name;
        Courses.ID++;
        System.out.println(name);

    }



    }

