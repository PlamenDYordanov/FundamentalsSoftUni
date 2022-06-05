package ProgrammingFundamentals.ConditionalStatementsLoopsExercises;

import java.util.Scanner;

public class P07_VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        double insertMoney = 0;
        double price = 0;
        while (!input.equals("Start")) {
            double coins = Double.parseDouble(input);
            if (coins == 1 || coins == 2 || coins == 0.5 ||
                    coins == 0.2 || coins == 0.1) {
                insertMoney += coins;
            } else {
                System.out.printf("Cannot accept %.2f%n", coins);
                input = scanner.nextLine();
                continue;
            }

            input = scanner.nextLine();

        }
        input = scanner.nextLine();
        while (!input.equals("End")) {
            switch (input) {
                case "Nuts":
                    price = 2.0;
                    if (insertMoney < price) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    insertMoney = insertMoney - price;
                    System.out.println("Purchased Nuts");
                    break;
                case "Soda":
                    price = 0.80;
                    if (insertMoney < price) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    insertMoney = insertMoney - price;
                    System.out.println("Purchased Soda");
                    break;
                case "Water":
                    price = 0.70;
                    if (insertMoney < price) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    insertMoney = insertMoney - price;
                    System.out.println("Purchased Water");
                    break;
                case "Crisps":
                    price = 1.5;
                    if (insertMoney < price) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    insertMoney = insertMoney - price;
                    System.out.println("Purchased Crisps");
                    break;
                case "Coke":
                    price = 1;
                    if (insertMoney < price) {
                        System.out.println("Sorry, not enough money");
                        break;
                    }
                    insertMoney = insertMoney - price;
                    System.out.println("Purchased Coke");
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", insertMoney);
    }
}
