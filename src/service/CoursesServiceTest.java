package service;

import Main.object.Course;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CoursesServiceTest {

    @Test
    public void testCounting() {
        Course.setID(10);
        assertEquals(10, Course.getID());

        int count = CoursesService.Counting();
        assertEquals(10, count);
        assertEquals(11, Course.getID());
    }
}
