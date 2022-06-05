package ProgrammingFundamentals.MapsLambda.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05_SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        Map<String, String> customers = new LinkedHashMap<>();
        Map<String, String> mapRegPlates = new LinkedHashMap<>();

        for (int i = 1; i <= numberOfPeople; i++) {
            String input = scanner.nextLine();
            String command = input.split(" ")[0];

            if (command.equals("register")){
                String customerName = input.split(" ")[1];
                String licensePlate = input.split(" ")[2];
                if (!customers.containsKey(customerName)){
                   customers.put(customerName,licensePlate);
                    System.out.printf("%s registered %s successfully%n",customerName,licensePlate);
                }else {
                    System.out.printf("ERROR: already registered with plate number %s%n",licensePlate);
                }
            }else if (command.equals("unregister")){
                String customerName = input.split(" ")[1];
                if (!customers.containsKey(customerName)){
                    System.out.printf("ERROR: user %s not found%n",customerName);
                }else {
                    System.out.printf("%s unregistered successfully%n",customerName);
                    customers.remove(customerName);
                }
            }
        }
        customers.entrySet().forEach(entry -> System.out.printf("%s => %s%n",entry.getKey(),entry.getValue()));
    }
}
