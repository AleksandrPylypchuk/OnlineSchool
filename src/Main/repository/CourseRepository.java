package Main.repository;

import Main.object.Course;
import Main.object.Person;

import java.text.SimpleDateFormat;
import java.util.*;

import static service.CoursesService.Counting;

public class CourseRepository implements CourseRepositoryInterface {

    private int CAPACITY = 1;
    private Course[] courseArrays = new Course[CAPACITY];
    private List<Course> courses = new ArrayList<>();

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
        if (a[ID] != null) {
            return a[ID];
        } else {
            return null;
        }
    }

    public static CourseRepository getInstance() {
        return new CourseRepository();
    }

    public Course[] getCourseArrays() {
        return courseArrays;
    }

    public Object getByID(int ID) {
        ID--;
        if (courseArrays[ID] != null) {
            return courseArrays[ID];
        } else {
            return null;
        }
    }

    public Object deleteByID(int ID) {
        ID--;
        if (courseArrays[ID] != null) {
            return courseArrays[ID] = null;
        } else {
            return null;
        }
    }
    public String getAll(Object[] a) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < a.length; i++) {

            System.out.println(a[i]);
        }
        return b.append("").toString();
    }
    public Course[] sortByName() {
        Course[] courses = getCourseArrays();
        Arrays.sort(courses, Comparator.nullsLast(Comparator.comparing(Course::getName)));
        return courses;
    }
    public void printCoursesStartingFromDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, EEEE HH:mm:ss");
        for (Course course : courses) {
            if (course.getCourseDate() != null && course.getCourseDate().compareTo(date) >= 0) {
                System.out.println(course.getName() + ": " + dateFormat.format(course.getCourseDate()));
            }
        }
    }
    public void printCoursesEndingBeforeDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, EEEE HH:mm:ss");
        for (Course course : courses) {
            if (course.getCourseDate() != null && course.getCourseDate().compareTo(date) <= 0) {
                System.out.println(course.getName() + ": " + dateFormat.format(course.getCourseDate()));
            }
        }
    }
    public void printCoursesBetweenDates(Date startDate, Date endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM d, EEEE HH:mm:ss");
        for (Course course : courses) {
            if (course.getCourseDate() != null &&
                    course.getCourseDate().compareTo(startDate) >= 0 &&
                    course.getCourseDate().compareTo(endDate) <= 0) {
                System.out.println(course.getName() + ": " + dateFormat.format(course.getCourseDate()));
            }
        }
    }
    public void printCoursesGroupedByLecturer() {
        Map<Person, List<Course>> coursesByLecturer = new HashMap<>();
        for (Course course : courses) {
            if (course.getLecturer() != null) {
                List<Course> coursesForLecturer = coursesByLecturer.getOrDefault(course.getLecturer(), new ArrayList<>());
                coursesForLecturer.add(course);
                coursesByLecturer.put(course.getLecturer(), coursesForLecturer);
            }
        }
        for (Map.Entry<Person, List<Course>> entry : coursesByLecturer.entrySet()) {
            System.out.println("Courses taught by " + entry.getKey().getLastname() + ":");
            for (Course course : entry.getValue()) {
                System.out.println("- " + course.getName());
            }
        }
    }



}
