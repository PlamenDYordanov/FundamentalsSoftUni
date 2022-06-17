package ProgrammingFundamentals.RegularExpresion.Exercises;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$";
        Pattern pattern = Pattern.compile(regex);
        double totalPrice = 0;

        while (!input.equals("end of shift")) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String productName = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double priceProduct = quantity * price;
                totalPrice += priceProduct;
                System.out.println(String.format("%s: %s - %.2f", name, productName, priceProduct));
            }

            input = scanner.nextLine();

        }
        System.out.printf("Total income: %.2f", totalPrice);
    }
}
