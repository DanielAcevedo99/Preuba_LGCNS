package tests;

import models.Student;
import services.RankingService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GradeManagerTest {
    @Test
    public void testIntegrationFlow() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("STD01", 85, 90, 78, 88)); // Avg: 85.25
        students.add(new Student("STD02", 75, 80, 70, 65)); // Avg: 72.5
        students.add(new Student("STD03", 95, 92, 89, 91)); // Avg: 91.75

        RankingService rankingService = new RankingService();
        rankingService.assignRanks(students);

        assertEquals(91.75, students.get(0).getAverage(), 0.01);
        assertEquals(1, students.get(0).getRank());
        assertEquals(72.5, students.get(2).getAverage(), 0.01);
        assertEquals(3, students.get(2).getRank());
    }
}
