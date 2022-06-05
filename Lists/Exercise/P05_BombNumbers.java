package ProgrammingFundamentals.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05_BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        int[] numberAndPower = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();
        int number = numberAndPower[0];
        int power = numberAndPower[1];
        int specialIndex = 0;
        int whileCounter = 0;
        while (listOfNumbers.contains(number)) {
            whileCounter++;
            int counter = 0;
            for (int i = 0; i < listOfNumbers.size(); i++) {//FindSpecialIndex
                if (listOfNumbers.get(i).equals(number)) {
                    specialIndex = i;
                    break;
                }
            }
            if (specialIndex - power <= 0 && specialIndex > 0) {
                for (int leftSide = specialIndex - 1; leftSide >= 0; leftSide--) {

                    listOfNumbers.remove(leftSide);
                }
            } else if (specialIndex - power <= 0 && specialIndex == 0) {

            } else {
                for (int deleteLeft = specialIndex - power; deleteLeft < specialIndex; deleteLeft++) {
                    if (counter == 0) {
                        listOfNumbers.remove(deleteLeft);
                    } else {
                        deleteLeft--;
                        specialIndex--;
                        listOfNumbers.remove(deleteLeft);
                    }
                    counter++;
                }
            }
            for (int i = 0; i < listOfNumbers.size(); i++) {
                if (listOfNumbers.get(i).equals(number)) {
                    specialIndex = i;
                    break;
                }
            }
            if (specialIndex + power >= listOfNumbers.size()) {
                for (int i = specialIndex; i < listOfNumbers.size(); i++) {
                    listOfNumbers.remove(i);
                    i = i - 1;
                }
            } else {
                for (int i = specialIndex + power; i >= specialIndex; i--) {
                    listOfNumbers.remove(i);

                }
            }
        }
        if (whileCounter > 0) {
            int totalSum = 0;
            for (int sum : listOfNumbers) {
                totalSum += sum;
            }
            System.out.print(totalSum);
        }


    }
}
