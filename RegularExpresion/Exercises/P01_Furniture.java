package ProgrammingFundamentals.RegularExpresion.Exercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P01_Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

       // Map<String, Double> furniture = new LinkedHashMap<>();
        List<String> furniture = new ArrayList<>();
        List<Double> totalPrice = new ArrayList<>();

        String regex = ">>(?<furniture>\\w+)<<(?<price>\\d+[.]?\\d+)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);

        while (!input.equals("Purchase")) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String name = matcher.group("furniture");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                furniture.add(name);
                totalPrice.add(price*quantity);
                //furniture.put(name, price * quantity);

            }

            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furniture.forEach(e-> System.out.println(e));

       /* System.out.println("Bought furniture:");
        for (Map.Entry<String, Double> entry : furniture.entrySet()) {
            System.out.println(entry.getKey());
        }*/

       System.out.println(String.format("Total money spend: %.2f", getSumFromMap(totalPrice)));
    }

    private static double getSumFromMap(List< Double> furniture) {
        double sum = 0;
        for (double entry : furniture) {
            sum += entry;
        }
        return sum;
    }
}
