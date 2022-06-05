package ProgrammingFundamentals.DataTypesVaribles_Ex;

import java.util.Scanner;

public class P07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countPour = Integer.parseInt(scanner.nextLine());
        int waterTank = 255;
        int sum = 0;
        for (int i = 1; i <= countPour; i++) {
            int quantityOfWater = Integer.parseInt(scanner.nextLine());
            sum += quantityOfWater;
            if (sum > waterTank) {
                sum -= quantityOfWater;
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(sum);
    }
}
