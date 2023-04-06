package Main.object;

public class Lector extends SuperObject{
    private String name;


    public Lector(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "name='" + name + '\'' +
                '}';
    }
}
