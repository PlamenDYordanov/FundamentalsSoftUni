package ProgrammingFundamentals.ConditionalStatementsLoopsExercises;

import java.util.Scanner;

public class P11_RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetCount = lostGames/2;
        int mouseCount = lostGames/3;
        int keyboardCount = lostGames/6;
        int displayCount = lostGames/12;

        double priceHeadset = headsetCount*headsetPrice;
        double priceMouse = mouseCount*mousePrice;
        double priceKeyboard = keyboardCount*keyboardPrice;
        double priceDisplay = displayCount*displayPrice;
        double totalPrice = priceHeadset+priceMouse+priceKeyboard+priceDisplay;
        System.out.printf("Rage expenses: %.2f lv.",totalPrice);
    }
}
