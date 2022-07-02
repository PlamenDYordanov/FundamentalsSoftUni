package ProgrammingFundamentals.ObjectAndClasses.Lab.P06_StudentsVol2;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        List<StudentsVol2> studentsList = new ArrayList<>();
        List<String> nameList = new ArrayList<>();
        boolean isExist = false;
        while (!inputLine.equals("end")) {

            String firstName = inputLine.split("\\s+")[0];
            String lastName = inputLine.split("\\s+")[1];
            int age = Integer.parseInt(inputLine.split("\\s+")[2]);
            String homeTown = inputLine.split("\\s+")[3];
            String fullName = firstName + " " + lastName;

            StudentsVol2 student = new StudentsVol2(firstName, lastName, age, homeTown);

            if (nameList.contains(fullName)) {
                isExist = true;
                int index = nameList.indexOf(fullName);
                studentsList.set(index, student);
            }
            nameList.add(fullName);

            if (!isExist) {
                studentsList.add(student);
            }
            isExist = false;
            inputLine = scanner.nextLine();
        }

        String requireCity = scanner.nextLine();

        for (StudentsVol2 students : studentsList) {
            if (students.getHomeTown().equals(requireCity)){
                System.out.println(String.format("%s %s is %d years old",students.getFirstName(),students.getLastName(),students.getAge()));
            }
        }

    }
}
