package Main.object;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Role role;
    private Integer courseId, id;
    private String firstname, lastname, email, phone;
    private static int idCounter = 0;


    public Person(Role role, String firstname, String lastname, String email, String phone, Integer courseId) {
        this.role = role;
        this.courseId = courseId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phone = phone;
        this.id = ++idCounter;

    }

    @Override
    public String toString() {
        return "Person{ ID=" + id +
                " role=" + role +
                ", courseId=" + courseId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Role getRole() {
        return role;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getCourseId() {
        return courseId;
    }

    public Integer getId() {
        return id;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


}
