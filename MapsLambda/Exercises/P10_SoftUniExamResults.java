package ProgrammingFundamentals.MapsLambda.Exercises;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class P10_SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Integer>> mapOfStudents = new LinkedHashMap<>();
        Map<String, Integer> submission = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {
            if (input.contains("banned")) {
                String name = input.split("-")[0];
                mapOfStudents.remove(name);
            } else {
                String name = input.split("-")[0];
                String language = input.split("-")[1];
                if (submission.containsKey(language)){
                    int currentPoint = submission.get(language);
                    submission.put(language,currentPoint+1);
                }
                submission.putIfAbsent(language,1);
                int points = Integer.parseInt(input.split("-")[2]);
                if (!mapOfStudents.containsKey(name)) {
                    mapOfStudents.put(name, new LinkedHashMap<>());
                    mapOfStudents.get(name).put(language, points);
                }
                if (mapOfStudents.containsKey(name)) {
                    if (mapOfStudents.get(name).containsKey(language)) {
                        if (points > mapOfStudents.get(name).get(language)) {
                            mapOfStudents.get(name).put(language, points);
                        }
                    } else {
                        mapOfStudents.get(name).put(language, points);
                    }
                }
            }


            input = scanner.nextLine();
        }
        System.out.println("Results:");
        mapOfStudents
                .forEach((e, e1) -> {
                    e1.forEach((p, p1) ->{
                        System.out.printf("%s | %d%n",e,p1);
                    });


    });
        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> entry : submission.entrySet()) {
            System.out.printf("%s - %d%n",entry.getKey(),entry.getValue());
        }


    }
}
