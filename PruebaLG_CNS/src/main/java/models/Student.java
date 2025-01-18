package models;

public class Student {
    private String id;
    private int javaScore, sqlScore, mathScore, englishScore;
    private double average;
    private int rank;

    public Student(String id, int javaScore, int sqlScore, int mathScore, int englishScore) {
        this.id = id;
        this.javaScore = javaScore;
        this.sqlScore = sqlScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
        calculateAverage();
    }

    private void calculateAverage() {
        this.average = (javaScore + sqlScore + mathScore + englishScore) / 4.0;
    }

    public String getId() {
        return id;
    }

    public double getAverage() {
        return average;
    }

    public int getJavaScore() {
        return javaScore;
    }

    public int getSqlScore() {
        return sqlScore;
    }

    public int getMathScore() {
        return mathScore;
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
}
