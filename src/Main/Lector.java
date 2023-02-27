package Main;

public class Lector {
    private String name;
   // private long identifier;

    public Lector(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lectors{" +
                "name='" + name + '\'' +
                '}';
    }
}
