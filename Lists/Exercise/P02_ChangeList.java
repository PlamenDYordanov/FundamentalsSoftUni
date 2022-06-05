package ProgrammingFundamentals.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String command = scanner.nextLine();
        Integer parseElement = 0;
        int parseIndex = 0;

        while (!command.equals("end")) {
            String[] tokens = command.split(" ");
            switch (tokens[0]) {
                case "Insert":
                    parseElement = Integer.parseInt(tokens[1]);
                    parseIndex = Integer.parseInt(tokens[2]);
                    listOfNumbers.add(parseIndex, parseElement);
                    break;
                case "Delete":
                    parseElement = Integer.parseInt(tokens[1]);
                    for (int i = 0; i < listOfNumbers.size(); i++) {
                        if (listOfNumbers.get(i).equals(parseElement)) {
                            listOfNumbers.remove(i);
                            i = i - 1;
                        }
                    }
                    break;
            }
            command= scanner.nextLine();
        }
            printingNumbers(listOfNumbers);
    }
    public static void  printingNumbers (List<Integer> listOfNumbers){

        for (int numbers:listOfNumbers) {
            System.out.print(numbers+" ");
        }
    }
}
