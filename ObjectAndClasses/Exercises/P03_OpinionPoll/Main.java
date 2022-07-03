package ProgrammingFundamentals.ObjectAndClasses.Exercises.P03_OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());

        List<Persons> personsList = new ArrayList<>();
        for (int i = 1; i <= lines ; i++) {

            String input = scanner.nextLine();
            String name = input.split("\\s+")[0];
            int age = Integer.parseInt(input.split("\\s+")[1]);
            Persons persons = new Persons(name,age);
            getAgeMoreThan30(age,persons,name,personsList);


        }
    }

    private static void getAgeMoreThan30(int age, Persons persons, String name, List<Persons> personsList) {
        if (age>30){
            personsList.add(persons);
            System.out.println(persons);
        }
    }
}
