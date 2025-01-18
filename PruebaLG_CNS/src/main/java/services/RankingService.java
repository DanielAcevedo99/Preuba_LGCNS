package services;

import models.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RankingService {
    public void assignRanks(ArrayList<Student> students) {
        students.sort(Comparator.comparingDouble(Student::getAverage).reversed());
        for (int i = 0; i < students.size(); i++) {
            students.get(i).setRank(i + 1);
        }
    }

    public double calculateSubjectAverage(ArrayList<Student> students, String subject) {
        double total = 0;
        for (Student student : students) {
            switch (subject.toLowerCase()) {
                case "java":
                    total += student.getJavaScore();
                    break;
                case "sql":
                    total += student.getSqlScore();
                    break;
                case "math":
                    total += student.getMathScore();
                    break;
                case "english":
                    total += student.getEnglishScore();
                    break;
            }
        }
        return students.isEmpty() ? 0 : total / students.size();
    }
}
