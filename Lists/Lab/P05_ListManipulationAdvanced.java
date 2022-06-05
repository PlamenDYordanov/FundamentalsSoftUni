package ProgrammingFundamentals.List_Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numberList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("end")) {

            String commandName = command.split(" ")[0];

            switch (commandName) {
                case "Contains":
                    Integer number = Integer.parseInt(command.split(" ")[1]);
                    if (numberList.contains(number)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    String evenOrOdd = command.split(" ")[1];
                    if (evenOrOdd.equals("even")) {
                        for (int i = 0; i < numberList.size(); i++) {
                            if (numberList.get(i) % 2 == 0) {
                                System.out.print(numberList.get(i) + " ");
                            }
                        }
                        System.out.println();
                    } else if (evenOrOdd.equals("odd")) {
                        for (int i = 0; i < numberList.size(); i++) {
                            if (numberList.get(i) % 2 != 0) {
                                System.out.print(numberList.get(i) + " ");
                            }
                        }
                        System.out.println();

                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < numberList.size(); i++) {
                        sum += numberList.get(i);
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = command.split(" ")[1];
                    Integer compareNumber = Integer.parseInt(command.split(" ")[2]);
                    switch (condition) {
                        case "<":
                            for (int i = 0; i < numberList.size(); i++) {
                                if (numberList.get(i) < compareNumber) {
                                    System.out.print(numberList.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">":
                            for (int i = 0; i < numberList.size(); i++) {
                                if (numberList.get(i) > compareNumber) {
                                    System.out.print(numberList.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case ">=":
                            for (int i = 0; i < numberList.size(); i++) {
                                if (numberList.get(i) >= compareNumber) {
                                    System.out.print(numberList.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                        case "<=":
                            for (int i = 0; i < numberList.size(); i++) {
                                if (numberList.get(i) <= compareNumber) {
                                    System.out.print(numberList.get(i) + " ");
                                }
                            }
                            System.out.println();
                            break;
                    }
                    break;
            }

            command = scanner.nextLine();
        }
    }
}
