package ohtu;

import java.util.List;
import java.util.Arrays;

public class Submission {
    private int week;
    private int hours;
    private List<Integer> exercises;
    private String course;

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

    @Override
    public String toString() {
        String exerciseList = this.exercises.toString();
        exerciseList = exerciseList.substring(1, exerciseList.length() - 1);

        return String.format(
            "%1$s, viikko %2$s, tehtyjä tehtäviä yhteensä %3$s, aikaa kului %4$s, tehdyt tehtävät: %5$s",
            this.course,
            this.week,
            this.exercises.size(),
            this.hours,
            exerciseList
        );
    } 
}