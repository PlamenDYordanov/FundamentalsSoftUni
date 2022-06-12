package ProgrammingFundamentals.TextProcessing.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P07_StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inputList = Arrays
                .stream(scanner.nextLine().split(""))
                .collect(Collectors.toList());

        int power = 0;

        for (int i = 0; i < inputList.size(); i++) {
            String character = inputList.get(i);

            char diffChar = character.charAt(0);
            if (Character.isDigit(diffChar)) {
                power = Integer.parseInt(inputList.get(i));
                for (int j = i; j < j + power; j++) {
                    if (j==inputList.size()){
                        break;
                    }
                    if (!inputList.get(j).equals(">")) {
                        inputList.remove(j);
                        power--;
                        j--;
                    } else {
                        power = power + Integer.parseInt(inputList.get(j + 1));
                        i=j;
                    }
                }
            }

        }

        for (String element : inputList) {
            System.out.print(element);
        }
    }
}
