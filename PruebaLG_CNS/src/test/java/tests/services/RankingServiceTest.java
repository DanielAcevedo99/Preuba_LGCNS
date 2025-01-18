package tests.services;

import models.Student;
import services.RankingService;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class RankingServiceTest {
    @Test
    public void testAssignRanks() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("STD01", 90, 85, 80, 75)); // Avg: 82.5
        students.add(new Student("STD02", 60, 70, 80, 90)); // Avg: 75.0

        RankingService rankingService = new RankingService();
        rankingService.assignRanks(students);

        assertEquals(1, students.get(0).getRank());
        assertEquals(2, students.get(1).getRank());
    }

    @Test
    public void testCalculateSubjectAverage() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("STD01", 90, 85, 80, 75));
        students.add(new Student("STD02", 60, 70, 80, 90));

        RankingService rankingService = new RankingService();

        assertEquals(75.0, rankingService.calculateSubjectAverage(students, "java"), 0.01);
        assertEquals(77.5, rankingService.calculateSubjectAverage(students, "sql"), 0.01);
        assertEquals(80.0, rankingService.calculateSubjectAverage(students, "math"), 0.01);
        assertEquals(82.5, rankingService.calculateSubjectAverage(students, "english"), 0.01);
    }
}
