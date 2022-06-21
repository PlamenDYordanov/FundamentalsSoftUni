package ProgrammingFundamentals.ExamPreparation.Exam02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOFElements = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int moves = 0;
        boolean isWin = false;

        while (!input.equals("end")) {
            String[] inputArr = input.split(" ");
            moves++;
            int firstIndex = Integer.parseInt(inputArr[0]);
            int secondIndex = Integer.parseInt(inputArr[1]);
            int maxIndex = Math.max(firstIndex, secondIndex);
            int minIndex = Math.min(firstIndex, secondIndex);

            if (firstIndex == secondIndex || maxIndex > listOFElements.size() - 1 || minIndex < 0) {
                String currentAddingNum = "-" + moves + "a";
                int middleSize = listOFElements.size() / 2;
                listOFElements.add(middleSize, currentAddingNum);
                listOFElements.add(middleSize + 1, currentAddingNum);
                System.out.println("Invalid input! Adding additional elements to the board");

            } else if (listOFElements.get(firstIndex).equals(listOFElements.get(secondIndex))) {
                System.out.printf("Congrats! You have found matching elements - %s!%n", listOFElements.get(firstIndex));
                listOFElements.remove(maxIndex);
                listOFElements.remove(minIndex);
            } else {
                System.out.println("Try again!");

            }
            if (listOFElements.size() == 0) {
                System.out.printf("You have won in %d turns!%n", moves);
                isWin = true;
                break;
            }


            input = scanner.nextLine();
        }
        if (!isWin) {
            System.out.println("Sorry you lose :(");

            System.out.println(String.join(" ", listOFElements));
        }

    }
}
