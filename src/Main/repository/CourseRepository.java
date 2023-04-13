package Main.repository;

import Main.object.Course;

import static service.CoursesService.Counting;
import static service.CoursesService.ID;


public class CourseRepository implements CourseRepositoryInterface {

    private int CAPACITY = 1;
    private Course[] courseArrays = new Course[CAPACITY];


    public void addCourse(Course course) {


        for (int i = 0; i < courseArrays.length; i++) {
            Course existingCourse = courseArrays[i];
            if (existingCourse != null && existingCourse.getLectureID() == course.getLectureID()) {
              return;
            }
            if (existingCourse == null) {
                courseArrays[i] = course;
                int a = Counting();
                Course.setID(a);
                break;
            } else if (i == courseArrays.length - 1) {
                increasingArray();
                addCourse(course);
            }
        }
    }


    private void increasingArray() {
        int tempCapacity = CAPACITY;
        CAPACITY = (CAPACITY * 3) / 2 + 1;
        Course[] tempCourseArrays = new Course[CAPACITY];
        System.arraycopy(courseArrays, 0, tempCourseArrays, 0, tempCapacity);
        courseArrays = tempCourseArrays;

    }

    public Object getByID(Object[] a, int ID) {
        ID--;

        return a[ID];
    }

    public Course[] getCourseArrays() {
        return courseArrays;
    }


    public Object getByID(int ID) {
        ID--;
        return courseArrays[ID];
    }

    public Object deleteByID(int ID) {
        ID--;
        return courseArrays[ID] = null;
    }

    public String getAll(Object[] a) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < a.length; i++) {

            System.out.println(a[i]);
        }
        return b.append("").toString();
    }

}



