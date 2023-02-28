package Main.Repository;

import Main.HomeWork;
import Main.Student;

public class StudentRepository {
    private int CAPACITY = 10;
    private Student[] studentArrays = new Student[CAPACITY];

    public void addStudent(Student student) {

        for (int i = 0; i < studentArrays.length; i++) {
            if (studentArrays[i] == null) {
                //CountingHomework();
                studentArrays[i] = student;
                break;
            } else if (i == studentArrays.length - 1) {
                increasingArray();
            }

        }

    }


    private void increasingArray() {
        int tempCapacity = CAPACITY;
        CAPACITY = (CAPACITY * 3) / 2 + 1;
        Student[] tempStudentArrays = new Student[CAPACITY];
        System.arraycopy(studentArrays, 0, tempStudentArrays, 0, tempCapacity);
        studentArrays = tempStudentArrays;

    }

    public Student[] getStudentArrays() {
        return studentArrays;
    }
}

