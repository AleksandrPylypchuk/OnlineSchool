package Main.Task23;

import java.io.FileWriter;
import java.io.IOException;

public class BlacklistCreator {
    public static void main(String[] args) {
        String[] blacklistedIps = {"192.168.0.25", "192.100.0.2", "192.50.50.5"};
        String filename = "blacklist.txt";
        try {
            FileWriter writer = new FileWriter(filename);
            for (String ip : blacklistedIps) {
                writer.write(ip + "\n");
            }
            writer.close();
            System.out.println("Blacklist file created successfully.");
        } catch (IOException e) {
            System.err.println("Error creating blacklist file: " + e.getMessage());
        }
    }
}
