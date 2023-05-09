package Main.log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTest {
    private Logger logger;

    @BeforeEach
    public void setUp() {
        logger = new Logger();
    }

    @Test
    public void testLogError() {
        logger.logError("Test", "Error message");
        List<Log> logs = logger.getLogs();
        assertEquals(1, logs.size());

        Log log = logs.get(0);
        assertEquals("Test", log.getName());
        assertEquals(LogLevel.ERROR, log.getLevel());
        assertEquals("Error message", log.getMessage());
        assertEquals(LocalDateTime.now().getDayOfYear(), log.getDate().getDayOfYear());
    }

    @Test
    public void testLogWarning() {
        Exception exception = new RuntimeException("Test exception");
        logger.logWarning("Test", "Warning message", exception);
        List<Log> logs = logger.getLogs();
        assertEquals(1, logs.size());

        Log log = logs.get(0);
        assertEquals("Test", log.getName());
        assertEquals(LogLevel.WARNING, log.getLevel());
        assertEquals("Warning message", log.getMessage());
        assertEquals(LocalDateTime.now().getDayOfYear(), log.getDate().getDayOfYear());
        Assertions.assertTrue(log.getStacktrace().contains("Test exception"));
    }

    @Test
    public void testLogInfo() {
        logger.logInfo("Test", "Info message");
        List<Log> logs = logger.getLogs();
        assertEquals(1, logs.size());

        Log log = logs.get(0);
        assertEquals("Test", log.getName());
        assertEquals(LogLevel.INFO, log.getLevel());
        assertEquals("Info message", log.getMessage());
        assertEquals(LocalDateTime.now().getDayOfYear(), log.getDate().getDayOfYear());
    }

    @Test
    public void testLogDebug() {
        String name = "Test";
        String message = "Debug message";
        logger.logDebug(name, message);
        List<Log> logs = logger.getLogs();
        assertEquals(1, logs.size());
        Log log = logs.get(0);
        assertEquals(name, log.getName());
        assertEquals(LogLevel.DEBUG, log.getLevel());
        assertEquals(message, log.getMessage());
    }
}