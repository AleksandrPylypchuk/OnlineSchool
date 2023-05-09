package service;
import Main.log.Log;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

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

    @Test
    public void testWriteLogsToFile() throws IOException {
        // create test data
        List<Log> logs = new ArrayList<>();
        logs.add(new Log("TestLog", null, "Test message", LocalDateTime.now(), null));
        String filePath = "test_logs.txt";

        // write logs to file
        LogService logService = new LogService(filePath);
        logService.writeLogsToFile(logs);

        // read logs from file and compare
        List<Log> readLogs = logService.readLogsFromFile();
        assertEquals(logs.size(), readLogs.size());
        assertEquals(logs.get(0).getName(), readLogs.get(0).getName());
        assertEquals(logs.get(0).getMessage(), readLogs.get(0).getMessage());
        assertNull(readLogs.get(0).getStacktrace());


        File file = new File(filePath);
        file.delete();
    }

    @Test
    public void testReadLogsFromFile() throws IOException {
        // create test data
        List<Log> expectedLogs = new ArrayList<>();
        expectedLogs.add(new Log("TestLog1", null, "Test message 1", LocalDateTime.now(), null));
        expectedLogs.add(new Log("TestLog2", null, "Test message 2", LocalDateTime.now(), "java.lang.NullPointerException: null"));
        String filePath = "test_logs.txt";

        // write logs to file
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (Log log : expectedLogs) {
            writer.write(logToString(log));
            writer.newLine();
        }
        writer.close();


        LogService logService = new LogService(filePath);
        List<Log> readLogs = logService.readLogsFromFile();
        assertEquals(expectedLogs.size(), readLogs.size());
        assertEquals(expectedLogs.get(0).getName(), readLogs.get(0).getName());
        assertEquals(expectedLogs.get(0).getMessage(), readLogs.get(0).getMessage());
        assertNull(readLogs.get(0).getStacktrace());
        assertEquals(expectedLogs.get(1).getName(), readLogs.get(1).getName());


    }
}
