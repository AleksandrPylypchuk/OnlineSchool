package Main.object;

public class SuperObject {
    private String name;

    private static Integer ID = 0;


    public SuperObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SuperObject{" +
                "name='" + name + '\'' +
                '}';
    }




}

