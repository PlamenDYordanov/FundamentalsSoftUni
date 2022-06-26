package ProgrammingFundamentals.RegularMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem02_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbersList = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        boolean isValid = true;
        for (Integer integer : numbersList) {
            if (integer < -1000 || integer > 1000){
                isValid = false;
                break;
            }
        }


        String input = scanner.nextLine();
        int currentValue = 0;
        while (!input.equals("Finish")&&isValid) {
            String command = input.split("\\s+")[0];
            currentValue = Integer.parseInt(input.split("\\s+")[1]);
            if (currentValue < -1000 || currentValue > 1000) {
                input = scanner.nextLine();
                continue;
            }


            switch (command) {
                case "Add":
                    numbersList.add(currentValue);
                    break;

                case "Remove":
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) == currentValue) {
                            numbersList.remove(i);
                            break;
                        }
                    }
                    break;

                case "Replace":
                    int replacement = Integer.parseInt(input.split("\\s+")[2]);
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) == currentValue) {
                            numbersList.set(i, replacement);
                            break;
                        }
                    }
                    break;

                case "Collapse":
                    for (int i = 0; i < numbersList.size(); i++) {
                        if (numbersList.get(i) < currentValue) {
                            numbersList.remove(i);
                        }

                    }
                    break;
            }
            input = scanner.nextLine();

        }
        for (int number : numbersList) {
            System.out.print(number + " ");
        }
    }
}

