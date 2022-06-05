package ProgrammingFundamentals.ConditionalStatementsLoopsExercises;

import java.util.Scanner;

public class P10_PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double priceLightSabers = Double.parseDouble(scanner.nextLine());
        double priceRobes = Double.parseDouble(scanner.nextLine());
        double priceBelts = Double.parseDouble(scanner.nextLine());

        double totalPriceLightSabers = Math.ceil(countStudents*1.1)*priceLightSabers;
        double totalPriceRobes = priceRobes*countStudents;
        int freeBelts = countStudents/6;
        double totalPriceBelts = (countStudents-freeBelts)*priceBelts;
        double totalPrice = totalPriceBelts+totalPriceRobes+totalPriceLightSabers;
        double diff = totalPrice-budget;
        if (budget>=totalPrice){
            System.out.printf("The money is enough - it would cost %.2flv.",totalPrice);
        }else {
            System.out.printf("George Lucas will need %.2flv more.",diff);
        }
    }
}
