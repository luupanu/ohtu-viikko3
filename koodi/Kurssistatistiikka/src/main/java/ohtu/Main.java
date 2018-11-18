package ohtu;

public class Main {

    public static void main(String[] args) {
        String studentNr = "012345678";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String submissionsUrl = "https://studies.cs.helsinki.fi/courses/students/"+studentNr+"/submissions";

        Mapper mapper = new GsonMapper(submissionsUrl);
        Submission[] subs = mapper.getMapped(Submission[].class);
        
        int totalExercises = 0;
        int totalHours = 0;

        System.out.println("opiskelijanumero: " + studentNr + "\n");
        for (Submission submission : subs) {
            System.out.println("  " + submission);
            totalExercises += submission.getExercises().size();
            totalHours += submission.getHours();
        }
        System.out.println("\nyhteensä: " + totalExercises + " tehtävää " + totalHours + " tuntia");
    }
}