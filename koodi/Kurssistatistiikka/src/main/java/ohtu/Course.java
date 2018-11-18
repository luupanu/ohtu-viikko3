package ohtu;

import java.util.List;

public class Course {
    private String fullName;
    private String name;
    private List<Integer> exercises;
    private String term;
    private int year;

    public String getFullName() {
        return this.fullName;
    }

    public String getName() {
        return this.name;
    }

    public List<Integer> getExercises() {
        return this.exercises;
    }

    public String getTerm() {
        return this.term;
    }

    public int getYear() {
        return this.year;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExercises(List<Integer> exercises) {
        this.exercises = exercises;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format(
            "%1$s %2$s %3$s",
            this.fullName,
            this.term,
            this.year
        );
    } 
}