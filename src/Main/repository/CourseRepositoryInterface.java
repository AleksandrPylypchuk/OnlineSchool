package Main.repository;

import Main.object.Course;

public interface CourseRepositoryInterface {
    public void addCourse(Course course);

    public Object getByID(Object[] a, int ID);

    public Course[] getCourseArrays();

    public Object getByID(int ID);

    public Object deleteByID(int ID);

    public String getAll(Object[] a);
}
