package ProgrammingFundamentals.Methods.Methods_Lab;

import java.util.Scanner;

public class P05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        switch (product){
            case "coffee":
                priceCoffee(quantity,1.50);
                break;
            case "water":
                priceWater(quantity,1.00);
                break;
            case "coke":
                priceCoke(quantity,1.40);
                break;
            case "snacks":
                priceSnacks(quantity,2.00);
                break;
        }
    }
    public static void priceCoffee(int quantity, double price){
        System.out.printf("%.2f",quantity*price);
    }
    public  static void priceWater(int quantity,double price){
        System.out.printf("%.2f",quantity*price);
    }
    public static void priceCoke(int quantity, double price){
        System.out.printf("%.2f",quantity*price);
    }
    public static void priceSnacks(int quantity, double price){
        System.out.printf("%.2f",quantity*price);
    }
}
