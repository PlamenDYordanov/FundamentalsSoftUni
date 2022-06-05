package ProgrammingFundamentals.List_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P04_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listNumbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            String commandName = command.split(" ")[0];
            int indexDff = Integer.parseInt(command.split(" ")[1]);
            Integer numbers= Integer.parseInt(command.split(" ")[1]);
            switch (commandName) {
                case "Add":
                    listNumbers.add(numbers);
                    break;
                case "Remove":
                   listNumbers.remove(numbers);
                    break;
                case "RemoveAt":
                    listNumbers.remove(indexDff);
                    break;
                case "Insert":
                    int index = Integer.parseInt(command.split(" ")[2]);
                    listNumbers.add(index, numbers);
                    break;
            }

            command = scanner.nextLine();
        }
        System.out.println(listNumbers.toString().replaceAll("[\\[\\],]",""));
    }

    public static void printingArray(List<Integer> array) {

        for (int numbers:array ) {
            System.out.print(numbers+" ");
        }
    }
}
