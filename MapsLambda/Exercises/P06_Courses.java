package ProgrammingFundamentals.MapsLambda.Exercises;

import java.util.*;

public class P06_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> courses = new LinkedHashMap<>();


        while (!input.equals("end")) {


            String course = input.split(" : ")[0];
            String name = input.split(" : ")[1];

            if (!courses.containsKey(course)){
                courses.put(course, new ArrayList<>());
                courses.get(course).add(name);

            }else {
                courses.get(course).add(name);
            }

            input = scanner.nextLine();
        }

      /*  for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.println(entry.getKey()+": "+entry.getValue());

        }*/


        for (Map.Entry<String, List<String>> entry : courses.entrySet()) {
            System.out.println(String.format("%s: %d", entry.getKey(), entry.getValue().size()));
            entry.getValue().stream()/*.sorted(String::compareTo)*/.forEach(p -> System.out.println(String.format("-- %s", p)));
        }
    }
}
