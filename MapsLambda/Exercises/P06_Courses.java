package ProgrammingFundamentals.MapsLambda.Exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06_Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, List<String>> courses = new TreeMap<>();


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

        courses.entrySet().stream().sorted((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()))
                .forEach(e -> {
                    System.out.println(String.format("%s: %d", e.getKey(), e.getValue().size()));
                    e.getValue().stream().sorted(String::compareTo).forEach(p -> System.out.println(String.format("-- %s",p)));
                });
    }
}
