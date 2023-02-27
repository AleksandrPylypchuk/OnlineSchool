package Main;

public class HomeWork {
    public String name;
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
