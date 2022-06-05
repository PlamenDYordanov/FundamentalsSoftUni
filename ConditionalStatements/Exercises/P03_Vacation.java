package ProgrammingFundamentals.ConditionalStatementsLoopsExercises;

import java.util.Scanner;

public class P03_Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int people = Integer.parseInt(scanner.nextLine());
        String typeCustomer = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double price = 0;
        double totalPrice = 0;
        switch (dayOfWeek) {
            case "Friday":
                if (typeCustomer.equals("Students")) {
                    price = 8.45;
                } else if (typeCustomer.equals("Business")) {
                    price = 10.90;
                } else if (typeCustomer.equals("Regular")) {
                    price = 15;
                }

                break;
            case "Saturday":
                if (typeCustomer.equals("Students")) {
                    price = 9.80;
                } else if (typeCustomer.equals("Business")) {
                    price = 15.60;
                } else if (typeCustomer.equals("Regular")) {
                    price = 20;
                }
                break;
            case "Sunday":
                if (typeCustomer.equals("Students")) {
                    price = 10.46;
                } else if (typeCustomer.equals("Business")) {
                    price = 16;
                } else if (typeCustomer.equals("Regular")) {
                    price = 22.50;
                }
                break;
        }
        totalPrice = price * people;
        if (people >= 30 && typeCustomer.equals("Students")) {
            totalPrice = totalPrice * 0.85;
        }
        if (people >= 100 && typeCustomer.equals("Business")) {
            people = people - 10;
            totalPrice = price * people;
        }
        if (people >= 10 && people <= 20&&typeCustomer.equals("Regular")) {
            totalPrice = totalPrice * 0.95;
        }
        System.out.printf("Total price: %.2f",totalPrice);

    }
}