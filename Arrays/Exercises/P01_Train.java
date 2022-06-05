package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countWagons = Integer.parseInt(scanner.nextLine());
        int[] people = new int[countWagons];

        for (int i = 0; i < countWagons; i++) {
            int peopleInWagons = Integer.parseInt(scanner.nextLine());
            people[i] = peopleInWagons;
            System.out.print(people[i] + " ");
        }
        System.out.println();
        System.out.println(Arrays.stream(people).sum());
    }
}
