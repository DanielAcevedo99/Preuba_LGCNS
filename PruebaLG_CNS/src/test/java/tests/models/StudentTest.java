package tests.models;

import models.Student;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentTest {
    @Test
    public void testStudentInitialization() {
        Student student = new Student("STD01", 90, 85, 80, 75);

        assertEquals("STD01", student.getId());
        assertEquals(90, student.getJavaScore());
        assertEquals(85, student.getSqlScore());
        assertEquals(80, student.getMathScore());
        assertEquals(75, student.getEnglishScore());
        assertEquals(82.5, student.getAverage(), 0.01); 
    }

    @Test
    public void testRankAssignment() {
        Student student = new Student("STD01", 90, 85, 80, 75);
        student.setRank(1);

        assertEquals(1, student.getRank());
    }
}
