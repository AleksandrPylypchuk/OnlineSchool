package Main.log;

import java.time.LocalDateTime;

public class Log {
    private String name;
    private LogLevel level;
    private String message;
    private LocalDateTime date;
    private String stacktrace;

    public Log(String name, LogLevel level, String message, LocalDateTime date) {
        this.name = name;
        this.level = level;
        this.message = message;
        this.date = date;
    }

    public Log(String name, LogLevel level, String message, LocalDateTime date, String stacktrace) {
        this.name = name;
        this.level = level;
        this.message = message;
        this.date = date;
        this.stacktrace = stacktrace;
    }

    public String getName() {
        return name;
    }

    public LogLevel getLevel() {
        return level;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getStacktrace() {
        return stacktrace;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    @Override
    public String toString() {
        String log = String.format("%s [%s] %s - %s", date.toString(), level.toString(), name, message);
        if (stacktrace != null) {
            log += "\n" + stacktrace;
        }
        return log;
    }
}
