package Main.object;

public class Person{
    private Role role;
    private int courseId;
    private String firstname, lastname, email, phone;

    public Person(Role role, String firstname, String lastname, String email, String phone, int courseId) {
        this.role = role;
        this.courseId = courseId;
        this.firstname=firstname;
    }

    @Override
    public String toString() {
        return "Person{" +
                "role=" + role +
                ", courseId=" + courseId +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
