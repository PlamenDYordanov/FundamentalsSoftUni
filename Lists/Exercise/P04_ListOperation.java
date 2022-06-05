package ProgrammingFundamentals.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P04_ListOperation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String command = input.split(" ")[0];
            String[] tokens = input.split(" ");
            int element = 0;
            int index = 0;
            int count = 0;
            switch (command) {
                case "Add":
                    element = Integer.parseInt(tokens[1]);
                    listOfNumbers.add(element);
                    break;
                case "Insert":
                    element = Integer.parseInt(tokens[1]);
                    index = Integer.parseInt(tokens[2]);
                    if (index > listOfNumbers.size() - 1 || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        listOfNumbers.add(index, element);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    if (index > listOfNumbers.size() - 1 || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        listOfNumbers.remove(index);
                    }
                    break;
                case "Shift":
                    String leftOrRight = input.split(" ")[1];
                    count = Integer.parseInt(tokens[2]);
                    if (leftOrRight.equals("left")) {
                        for (int i = 0; i < count; i++) {
                            int currentSymbol = listOfNumbers.get(0);
                            listOfNumbers.remove(0);
                            listOfNumbers.add(currentSymbol);
                        }

                    } else if (leftOrRight.equals("right")) {
                        for (int i = 0; i < count; i++) {
                            int currentSymbol = listOfNumbers.get(listOfNumbers.size() - 1);
                            listOfNumbers.remove(listOfNumbers.size() - 1);
                            listOfNumbers.add(0, currentSymbol);
                        }
                    }
                    break;
                default:

            }

            input = scanner.nextLine();
        }
        PrintingNumbers(listOfNumbers);
    }

    private static void PrintingNumbers(List<Integer> listOfNumbers) {
        for (int numbers : listOfNumbers) {
            System.out.print(numbers + " ");
        }
    }

}
