package ProgrammingFundamentals.MapsLambda.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P02_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        Map<String, Integer> mapOfResources = new LinkedHashMap<>();

        while (!input.equals("stop")){

            int quantity = Integer.parseInt(scanner.nextLine());

            if (!mapOfResources.containsKey(input)){
                mapOfResources.put(input,quantity);
            }else {
               int currentQuantity = mapOfResources.get(input);
               mapOfResources.put(input,currentQuantity+quantity);
            }


            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : mapOfResources.entrySet()) {
            System.out.printf("%s -> %d%n",entry.getKey(),entry.getValue());
        }

    }
}
