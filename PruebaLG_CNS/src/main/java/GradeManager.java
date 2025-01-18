import models.Student;
import services.RankingService;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        RankingService rankingService = new RankingService();

        System.out.print("How many students are in this class? : ");
        int numStudents = scanner.nextInt();

        for (int i = 0; i < numStudents; i++) {
            String id = "STD" + String.format("%02d", i + 1);
            System.out.println("Enter scores for " + id);

            System.out.print(id + " Student's Java Score : ");
            int javaScore = scanner.nextInt();
            System.out.print(id + " Student's SQL Score : ");
            int sqlScore = scanner.nextInt();
            System.out.print(id + " Student’s Math. Score : ");
            int mathScore = scanner.nextInt();
            System.out.print(id + " Student’s English Score : ");
            int englishScore = scanner.nextInt();

            Student student = new Student(id, javaScore, sqlScore, mathScore, englishScore);
            students.add(student);

            rankingService.assignRanks(students);

            System.out.println("-------------------------------------------");
            System.out.println("[" + student.getId() + "] Student's Score Status");
            System.out.printf("Java %d, SQL %d, Math. %d, English %d\n",
                    student.getJavaScore(), student.getSqlScore(), student.getMathScore(), student.getEnglishScore());
            System.out.println("-------------------------------------------");
            System.out.printf("Avg. : %.2f, Rank : %d\n", student.getAverage(), student.getRank());
            System.out.println("-------------------------------------------");
        }

        System.out.println("\n===============================");
        for (Student student : students) {
            System.out.printf("%s : => Avg. : %.2f, Rank : %d\n", student.getId(), student.getAverage(), student.getRank());
        }
        System.out.println("===============================");

        System.out.printf("Java Class Avg. : %.2f\n", rankingService.calculateSubjectAverage(students, "java"));
        System.out.printf("SQL Class Avg. : %.2f\n", rankingService.calculateSubjectAverage(students, "sql"));
        System.out.printf("Math. Class Avg. : %.2f\n", rankingService.calculateSubjectAverage(students, "math"));
        System.out.printf("English Class Avg. : %.2f\n", rankingService.calculateSubjectAverage(students, "english"));
        System.out.println("===============================");

        scanner.close();
    }
}
