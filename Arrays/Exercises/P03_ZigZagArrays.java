package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        int[] firstLine = new int[count];
        int[] secondLine = new int[count];
        for (int i = 1; i <= count; i++) {
            int[] numbers = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .mapToInt(e -> Integer.parseInt(e))
                    .toArray();
            if (i % 2 == 0) {
                firstLine[i - 1] = numbers[0];
                secondLine[i - 1] = numbers[1];
            } else {
                firstLine[i - 1] = numbers[1];
                secondLine[i - 1] = numbers[0];
            }
        }
        for (int i = 0; i <= count - 1; i++) {
            System.out.print(secondLine[i] + " ");
        }
        System.out.println();
        for (int i = 0; i <= count - 1; i++) {
            System.out.print(firstLine[i] + " ");
        }

    }
}
