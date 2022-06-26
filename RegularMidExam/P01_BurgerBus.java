package ProgrammingFundamentals.RegularMidExam;

import java.util.Scanner;

public class P01_BurgerBus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfCities = Integer.parseInt(scanner.nextLine());

        int countCities = 0;
        double totalProfit = 0;
        double cityProfit = 0;

        for (int i = 1; i <= numberOfCities; i++) {
            countCities++;
            String nameOfCity = scanner.nextLine();
            double earnedMoney = Double.parseDouble(scanner.nextLine());
            double expenses = Double.parseDouble(scanner.nextLine());

            cityProfit = earnedMoney - expenses;

            if (countCities % 3 == 0) {
                cityProfit = cityProfit - (expenses * 0.50);
            }

            if (countCities % 5 == 0) {
                cityProfit = (earnedMoney * 0.90) - expenses;
            }

            totalProfit = totalProfit + cityProfit;
            System.out.printf("In %s Burger Bus earned %.2f leva.%n", nameOfCity, cityProfit);
        }

        System.out.printf("Burger Bus total profit: %.2f leva.", totalProfit);
    }
}

