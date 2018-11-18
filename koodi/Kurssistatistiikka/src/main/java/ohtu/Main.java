package ohtu;

import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String submissionsUrl = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";
        String coursesUrl = "https://studies.cs.helsinki.fi/courses/courseinfo";

        Mapper mapper = new GsonMapper(submissionsUrl);
        Submission[] subs = mapper.getMapped(Submission[].class);

        mapper.setResource(coursesUrl);
        Course[] courses = mapper.getMapped(Course[].class);
        
        // PRINT HERE

        System.out.println("opiskelijanumero: " + studentNr);
        printStats(subs, courses);
    }

    private static void printStats(Submission[] subs, Course[] courses) {
        for (Course course : courses) {
            Submission[] filtered = Stream.of(subs)
                .filter(s -> s.getCourse().equals(course.getName()))
                .toArray(Submission[]::new);

            if (filtered.length > 0) {
                int doneExercises = 0;
                int doneHours = 0;
                int maxExercises = course.getExercises().stream()
                    .mapToInt(i -> i).sum();

                System.out.println("\n" + course);

                for (Submission sub : filtered) {
                    sub.setMaxExercises(course.getExercises().get(sub.getWeek()));
                    System.out.println(sub);
                    doneExercises += sub.getExercises().size();
                    doneHours += sub.getHours();
                }

                System.out.println(
                    "\nyhteensä: " +
                    doneExercises + "/" + maxExercises + " tehtävää " +
                    doneHours + " tuntia"
                );
            }
        }
    }
}