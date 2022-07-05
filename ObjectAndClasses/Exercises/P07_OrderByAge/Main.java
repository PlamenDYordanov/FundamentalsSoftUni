package ProgrammingFundamentals.ObjectAndClasses.Exercises.P07_OrderByAge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Persons> personsList = new ArrayList<>();

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("End")){

            String name = inputLine.split(" ")[0];
            String ID = inputLine.split(" ")[1];
            int age = Integer.parseInt(inputLine.split(" ")[2]);
            Persons personsObj = new Persons(name, ID, age);
            personsList.add(personsObj);


            inputLine = scanner.nextLine();
        }
        personsList.sort(Comparator.comparing(Persons::getAge));

        for (Persons persons : personsList) {
            System.out.println(persons.toString());
        }

    }
}
