package ProgrammingFundamentals.MapsLambda.Exercises;

import java.util.*;

public class P07_StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> students = new LinkedHashMap<>();

        for (int i = 1; i <= numOfStudents; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(name)) {
                students.put(name, new ArrayList<>());
                students.get(name).add(grade);
            } else {
                students.get(name).add(grade);
            }

        }
        Map<String, Double> studentAverageGrade = new LinkedHashMap<>();
        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            String nameStudent = entry.getKey();
            List<Double> grades = entry.getValue();
            double averageGrades = grades.stream().mapToDouble(x -> x).average().getAsDouble();
            if (averageGrades >= 4.50) {
                studentAverageGrade.put(nameStudent, averageGrades);
            }
        }
        /*studentAverageGrade.entrySet().stream().sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .forEach(entry1 -> {
                    System.out.println(String.format("%s -> %.2f", entry1.getKey(), entry1.getValue()));
                });*/
        for (Map.Entry<String, Double> entry : studentAverageGrade.entrySet()) {
            System.out.println(String.format("%s -> %.2f",entry.getKey(),entry.getValue()));
        }


    }

}
