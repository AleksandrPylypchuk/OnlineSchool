import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Exam {
    private static final int NUM_STUDENTS = 10;
    private static final int NUM_QUESTIONS = 10;
    private static final int MIN_TIME = 8;
    private static final int MAX_TIME = 14;
    private static final int EXAM_TIME = 12;

    public static void main(String[] args) throws InterruptedException, IOException {
        // Load logging configuration from file
        LogManager logManager = LogManager.getLogManager();
        FileInputStream configFile = new FileInputStream("logging.properties");
        logManager.readConfiguration(configFile);

        Logger logger = Logger.getLogger(Exam.class.getName());
        logger.log(Level.INFO, "Starting exam");

        List<Integer> questions = new ArrayList<>();
        for (int i = 1; i <= NUM_QUESTIONS; i++) {
            questions.add(i);
        }
        Collections.shuffle(questions, new Random());

        CountDownLatch startLatch = new CountDownLatch(1);
        CountDownLatch finishLatch = new CountDownLatch(NUM_STUDENTS);
        CountDownLatch timeLatch = new CountDownLatch(NUM_STUDENTS);

        List<Integer> onTimeStudents = new ArrayList<>();
        List<Integer> lateStudents = new ArrayList<>();

        for (int i = 1; i <= NUM_STUDENTS; i++) {
            new Thread(new Student(i, questions.remove(0), startLatch, finishLatch, timeLatch, onTimeStudents, lateStudents)).start();
        }

        logger.log(Level.INFO, "Exam starts in 3 seconds");
        Thread.sleep(3000);

        startLatch.countDown();

        logger.log(Level.INFO, "Exam started");
        finishLatch.await();

        timeLatch.await();

        logger.log(Level.INFO, "Exam finished");

        Collections.sort(onTimeStudents);
        Collections.sort(lateStudents);

        logger.log(Level.INFO, "On time students: " + onTimeStudents);
        logger.log(Level.INFO, "Late students: " + lateStudents);

        logger.log(Level.INFO, "Students who finished within exam time:");
        for (int id : onTimeStudents) {
            System.out.println("Student " + id);
        }

        System.out.println("Students who did not finish within exam time:");
        for (int id : lateStudents) {
            System.out.println("Student " + id);
        }
    }

    private static class Student implements Runnable {
        private final int id;
        private final int question;
        private final CountDownLatch startLatch;
        private final CountDownLatch finishLatch;
        private final CountDownLatch timeLatch;
        private final List<Integer> onTimeStudents;
        private final List<Integer> lateStudents;

        public Student(int id, int question, CountDownLatch startLatch, CountDownLatch finishLatch, CountDownLatch timeLatch, List<Integer> onTimeStudents, List<Integer> lateStudents) {
            this.id = id;
            this.question = question;
            this.startLatch = startLatch;
            this.finishLatch = finishLatch;
            this.timeLatch = timeLatch;
            this.onTimeStudents = onTimeStudents;
            this.lateStudents = lateStudents;

        }
        @Override
        public void run() {
            try {
                startLatch.await();

                System.out.println(String.format("Student %d got question %d", id, question));

                int time = new Random().nextInt(MAX_TIME - MIN_TIME) + MIN_TIME;
                Thread.sleep(time * 1000);

                System.out.println(String.format("Student %d finished question %d in %d seconds", id, question, time));

                finishLatch.countDown();

                if (time >= EXAM_TIME) {
                    lateStudents.add(id);
                } else {
                    onTimeStudents.add(id);
                }

                timeLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
