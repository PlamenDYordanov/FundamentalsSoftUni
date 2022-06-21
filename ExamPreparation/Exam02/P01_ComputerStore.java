package ProgrammingFundamentals.ExamPreparation.Exam02;

import java.util.Scanner;

public class P01_ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        double price = 0;
        double totalPriceWithOutTax = 0;
        double totalPrice = 0;
        double taxPrice = 0;
        double totalTax =0;

        while (!input.equals("special") && !input.equals("regular")) {
            price = Double.parseDouble(input);

            if (price > 0) {
                taxPrice = 0;
                totalPriceWithOutTax += price;
                taxPrice += price * 0.20;
                totalTax += taxPrice;
                totalPrice += taxPrice + price;
            } else {
                System.out.println("Invalid price!");
            }


            input = scanner.nextLine();
        }
        if (totalPrice == 0) {
            System.out.println("Invalid order!");
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$%n", totalPriceWithOutTax);
            System.out.printf("Taxes: %.2f$%n", totalTax);
            System.out.println("-----------");
            if (input.equals("special")) {
                totalPrice = totalPrice * 0.90;
                System.out.printf("Total price: %.2f$", totalPrice);
            } else {
                System.out.printf("Total price: %.2f$", totalPrice);
            }
        }

    }
}
