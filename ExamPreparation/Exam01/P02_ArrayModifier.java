package ProgrammingFundamentals.MidExamFirst;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumber = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        String inputLine = scanner.nextLine();
        int firstIndexNumber = 0;
        int secondIndexNumber = 0;

        while (!inputLine.equals("end")) {

            String[] arrCommand = inputLine.split(" ");
            String command = arrCommand[0];

            switch (command) {

                case "swap":
                    String indexOne = arrCommand[1];
                    int parseIntIndexOne = Integer.parseInt(indexOne);
                    String indexTwo = arrCommand[2];
                    int parseIntIndexTwo = Integer.parseInt(indexTwo);
                    firstIndexNumber = listOfNumber.get(parseIntIndexOne);
                    secondIndexNumber = listOfNumber.get(parseIntIndexTwo);
                    listOfNumber.set(parseIntIndexOne, secondIndexNumber);
                    listOfNumber.set(parseIntIndexTwo, firstIndexNumber);
                    break;

                case "multiply":

                    indexOne = arrCommand[1];
                    parseIntIndexOne = Integer.parseInt(indexOne);
                    indexTwo = arrCommand[2];
                    parseIntIndexTwo = Integer.parseInt(indexTwo);
                    firstIndexNumber = listOfNumber.get(parseIntIndexOne);
                    secondIndexNumber = listOfNumber.get(parseIntIndexTwo);
                    int result = firstIndexNumber * secondIndexNumber;
                    listOfNumber.set(parseIntIndexOne, result);
                    break;

                case "decrease":

                    for (int i = 0; i < listOfNumber.size(); i++) {
                        int currentNumberSubtract = listOfNumber.get(i) - 1;
                        listOfNumber.set(i, currentNumberSubtract);
                    }
                    break;


            }
            inputLine = scanner.nextLine();
        }
        printingListNumbers(listOfNumber);
    }

    public static void printingListNumbers(List<Integer> listOfNumbers) {
        int counter = 0;
        for (int i = 0; i < listOfNumbers.size() - 1; i++) {
            System.out.print(listOfNumbers.get(i) + ", ");
            counter++;
        }
        System.out.print(listOfNumbers.get(counter));
    }
}
