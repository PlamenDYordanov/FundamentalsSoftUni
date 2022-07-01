package ProgrammingFundamentals.ObjectAndClasses.Lab.P05_Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        List<Students> studentsList = new ArrayList<>();

        while (!inputLine.equals("end")) {

            String firstName = inputLine.split("\\s+")[0];
            String lastName = inputLine.split("\\s+")[1];
            int age = Integer.parseInt(inputLine.split("\\s+")[2]);
            String homeTown = inputLine.split("\\s+")[3];

            Students student = new Students(firstName,lastName,age,homeTown);
            studentsList.add(student);


            inputLine = scanner.nextLine();
        }
        String requireHomeTown = scanner.nextLine();
        for (Students students : studentsList) {
            if (requireHomeTown.equals(students.getHomeTown())){
                System.out.println(String.format("%s %s is %d years old",students.getFirstName(),students.getLastName(),students.getAge()));
            }
        }


    }
}
