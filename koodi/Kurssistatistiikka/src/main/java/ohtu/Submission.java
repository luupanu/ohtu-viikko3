package ohtu;

import java.util.List;
import java.util.Arrays;

public class Submission {
    private int week;
    private int hours;
    private List<Integer> exercises;
    private String course;
    private int maxExercises;

    public int getWeek() {
        return this.week;
    }

    public int getHours() {
        return this.hours;
    }

    public List<Integer> getExercises() {
        return this.exercises;
    }

    public String getCourse() {
        return this.course;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setMaxExercises(int maxExercises) {
        this.maxExercises = maxExercises;
    }

    @Override
    public String toString() {
        String exerciseList = this.exercises.toString();
        exerciseList = exerciseList.substring(1, exerciseList.length() - 1);

        return String.format(
            "viikko %1$s:\n  tehtyjä tehtäviä %2$s/%3$s, aikaa kului %4$s, tehdyt tehtävät: %5$s",
            this.week,
            this.exercises.size(),
            this.maxExercises,
            this.hours,
            exerciseList
        );
    } 
}