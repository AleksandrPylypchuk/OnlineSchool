package Main.Object;

public class HomeWork {
    private String name;
    private long identifier;

    public HomeWork(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return "HomeWork{" +
                "name=" + name +
                '}';
    }
}
