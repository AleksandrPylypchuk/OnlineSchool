package Main.log;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private List<Log> logs;

    public Logger() {
        this.logs = new ArrayList<>();
    }

    public void logError(String name, String message) {
        Log log = new Log(name, LogLevel.ERROR, message, LocalDateTime.now());
        logs.add(log);
        System.err.println(log.toString());
    }

    public void logWarning(String name, String message, Throwable throwable) {
        Log log = new Log(name, LogLevel.WARNING, message, LocalDateTime.now(), throwable.toString());
        logs.add(log);
        System.out.println(log.toString());
    }

    public void logInfo(String name, String message) {
        Log log = new Log(name, LogLevel.INFO, message, LocalDateTime.now());
        logs.add(log);
        System.out.println(log.toString());
    }

    public void logDebug(String name, String message) {
        Log log = new Log(name, LogLevel.DEBUG, message, LocalDateTime.now());
        logs.add(log);
        System.out.println(log.toString());
    }

    public void printLogs() {
        for (Log log : logs) {
            System.out.println(log.toString());
        }
    }

    public List<Log> getLogs() {
        return logs;
    }
}
