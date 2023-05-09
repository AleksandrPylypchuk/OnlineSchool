package Main.log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogReader {
    public static void main(String[] args) {
        String filePath = "file.log";
        String pattern = ".*(error|exception).*";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern p = Pattern.compile(pattern);
            while ((line = br.readLine()) != null) {
                Matcher m = p.matcher(line);
                if (m.matches()) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
