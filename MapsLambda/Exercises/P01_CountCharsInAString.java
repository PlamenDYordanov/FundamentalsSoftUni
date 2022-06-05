package ProgrammingFundamentals.MapsLambda.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P01_CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<Character, Integer> countOfSymbols = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (symbol == ' ') {
                continue;
            }
          if (!countOfSymbols.containsKey(symbol)){
              countOfSymbols.put(symbol,1);
          }else {
              countOfSymbols.put(symbol,countOfSymbols.get(symbol)+1);
          }
        }
        for (Map.Entry<Character, Integer> entry : countOfSymbols.entrySet()) {
            System.out.printf("%c -> %d%n",entry.getKey(),entry.getValue());
        }

    }
}
