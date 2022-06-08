package ProgrammingFundamentals.Arrays.Exercises;

import java.util.Scanner;

public class P02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrOne = scanner.nextLine().split(" ");
        String[] arrTwo = scanner.nextLine().split(" ");

        for (int i = 0; i < arrTwo.length; i++) {
            for (int j = 0; j < arrOne.length; j++) {
                if (arrTwo[i].equals(arrOne[j])) {
                    System.out.print(arrTwo[i] + " ");
                }
            }
        }
    }
}
