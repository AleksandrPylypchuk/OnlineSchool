package Main.Object;

public class Person extends SuperObject{
    private Role role;
    private int courseId;
    private String name;

    public Person(Role role, String name, int courseId) {
        super(name);
        this.role = role;
        this.courseId = courseId;
        this.name=name;
    }
    @Override
    public String toString() {
        return "Person{" +
                "role=" + role + " Name=" + name +
                '}';
    }


}
