package ProgrammingFundamentals.TextProcessingMoreEx;

import java.util.Scanner;

public class P02_AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char firstSymbol = scanner.nextLine().charAt(0);

        char secondSymbol = scanner.nextLine().charAt(0);

        String randomText = scanner.nextLine();

        int minValue = Math.min(firstSymbol, secondSymbol);
        int maxValue = Math.max(firstSymbol, secondSymbol);
        int totalSum = 0;
        for (char symbol : randomText.toCharArray()) {
            if (symbol > minValue && symbol < maxValue){
                totalSum+=symbol;
            }
        }
        System.out.println(totalSum);
    }
}
