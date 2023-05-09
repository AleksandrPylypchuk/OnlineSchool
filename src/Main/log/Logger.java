package Main.log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Log> logs;

    public Logger() {
        this.logs = new ArrayList<>();
    }

    public void log(String name, LogLevel level, String message) {
        Log log = new Log(name, level, message, LocalDateTime.now());
        logs.add(log);
        System.out.println(log.toString());
    }

    public void log(String name, LogLevel level, String message, Throwable throwable) {
        Log log = new Log(name, level, message, LocalDateTime.now(), throwable.toString());
        logs.add(log);
        System.out.println(log.toString());
    }

    public List<Log> getLogs() {
        return logs;
    }
}
