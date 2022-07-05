package ProgrammingFundamentals.ObjectAndClasses.Exercises.P06_Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        List<Students> listStudents = new ArrayList<>();


        for (int i = 1; i <= numberOfStudents; i++) {
            String input = scanner.nextLine();
            String firstName = input.split(" ")[0];
            String secondName = input.split(" ")[1];
            double grade = Double.parseDouble(input.split(" ")[2]);
            Students studentsObj = new Students(firstName, secondName, grade);
            listStudents.add(studentsObj);


        }
       listStudents.sort(Comparator.comparingDouble(Students::getGrade).reversed());

        for (Students Student : listStudents) {
            System.out.println(Student);
        }

    }
}
