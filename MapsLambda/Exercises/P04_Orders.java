package ProgrammingFundamentals.MapsLambda.Exercises;

import java.util.*;

public class P04_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();
        Map<String, Double> totalPriceProducts = new LinkedHashMap<>();

        String input = scanner.nextLine();
        String product = input.split(" ")[0];
        while (!product.equals("buy")) {
            double price = Double.parseDouble(input.split(" ")[1]);
            int quantity = Integer.parseInt(input.split(" ")[2]);
            if (!totalPriceProducts.containsKey(product)){
                totalPriceProducts.put(product, price * quantity);
                productsPrice.put(product, price);
                productsQuantity.put(product, quantity);
            }else {
                int currentQuantity = productsQuantity.get(product);
                productsQuantity.put(product,currentQuantity+quantity);
                if (productsPrice.get(product)!=price){
                    productsPrice.put(product,price);
                }
                totalPriceProducts.put(product, productsPrice.get(product) * productsQuantity.get(product));
            }


            input = scanner.nextLine();
            product = input.split(" ")[0];

        }
        totalPriceProducts.entrySet().forEach(entry -> System.out.printf("%s -> %.2f%n",entry.getKey(),entry.getValue()));
    }
}
