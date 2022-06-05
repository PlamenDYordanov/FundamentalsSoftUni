package ProgrammingFundamentals.DataTypesVaribles_Ex;

import java.util.Scanner;

public class P10_PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());

        int powerDiff = power;
        int counter = 0;

        while (power >= distance) {
            counter++;
            power -= distance;
            if (power == powerDiff * 0.50&&exhaustionFactor>0) {
                power /=  exhaustionFactor;
            }

        }
        System.out.println(power);
        System.out.println(counter);
    }
}
