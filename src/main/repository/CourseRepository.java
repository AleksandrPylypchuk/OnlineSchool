package main.repository;

import main.object.Course;

import static service.CoursesService.Counting;


public class CourseRepository extends Repositorium {

    private int CAPACITY = 1;
    private Course[] courseArrays = new Course[CAPACITY];


    public void addCourse(Course course) {

        for (int i = 0; i < courseArrays.length; i++) {
            if (courseArrays[i] == null) {
                courseArrays[i] = course;
                int a = Counting();
                Course.setID(a);
                break;
            } else if (i == courseArrays.length - 1)
                increasingArray();
        }

    }


    private void increasingArray() {
        int tempCapacity = CAPACITY;
        CAPACITY = (CAPACITY * 3) / 2 + 1;
        Course[] tempCourseArrays = new Course[CAPACITY];
        System.arraycopy(courseArrays, 0, tempCourseArrays, 0, tempCapacity);
        courseArrays = tempCourseArrays;

    }


    public Course[] getCourseArrays() {
        return courseArrays;
    }

    @Override
    public Object getByID(Object[] a, int ID) {
        return super.getByID(a, ID);
    }

    @Override
    public Object deleteByID(Object[] a, int ID) {
        return super.deleteByID(a, ID);
    }


}



