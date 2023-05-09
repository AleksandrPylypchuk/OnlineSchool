package service;
import Main.log.Log;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LogService {
    private final String filePath;

    public LogService(String filePath) {
        this.filePath = filePath;
    }

    public void writeLogsToFile(List<Log> logs) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        for (Log log : logs) {
            writer.write(logToString(log));
            writer.newLine();
        }
        writer.close();
    }

    public List<Log> readLogsFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        List<Log> logs = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            Log log = stringToLog(line);
            logs.add(log);
        }
        reader.close();
        return logs;
    }

    private String logToString(Log log) {
        StringBuilder sb = new StringBuilder();
        sb.append(log.getDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        sb.append(", ");
        sb.append(log.getName());
        sb.append(", ");
        sb.append(log.getMessage());
        if (log.getStacktrace() != null) {
            sb.append(", ");
            sb.append(log.getStacktrace());
        }
        return sb.toString();
    }

    private Log stringToLog(String line) {
        String[] parts = line.split(", ");
        LocalDateTime date = LocalDateTime.parse(parts[0], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String name = parts[1];
        String message = parts[2];
        String stacktrace = null;
        if (parts.length == 4) {
            stacktrace = parts[3];
        }
        return new Log(name, null, message, date, stacktrace);
    }
}
