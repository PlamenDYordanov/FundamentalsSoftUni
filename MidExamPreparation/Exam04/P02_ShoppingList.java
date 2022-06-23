package ProgrammingFundamentals.MidExamPreparation.Exam04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfProducts = Arrays
                .stream(scanner.nextLine().split("!")).collect(Collectors.toList());

        String inputLine = scanner.nextLine();
        String product = "";
        while (!inputLine.equals("Go Shopping!")) {
            String[] commands = inputLine.split(" ");
            String command = commands[0];

            switch (command) {
                case "Urgent":
                    product = commands[1];
                    getNewListOfProductAfterUrgent(listOfProducts, product);
                    break;
                case "Unnecessary":
                    product = commands[1];
                    getNewListOfProductAfterUnnecessary(listOfProducts, product);
                    break;
                case "Correct":
                    String oldItem = commands[1];
                    String newItem = commands[2];
                    getNewListAfterCorrect(listOfProducts, oldItem, newItem);
                    break;
                case "Rearrange":
                    product = commands[1];
                    getNewListOfProductAfterRearrange(listOfProducts, product);
                    break;
            }

            inputLine = scanner.nextLine();
        }

        System.out.println(String.join(", ", listOfProducts));
    }

    private static List<String> getNewListOfProductAfterRearrange(List<String> listOfProducts, String product) {
        boolean isExist = false;
        int indexOfElement = 0;
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).equals(product)) {
                indexOfElement = i;
                isExist = true;
                break;
            }
        }
        if (isExist) {
            listOfProducts.remove(indexOfElement);
            listOfProducts.add(listOfProducts.size(), product);
        }
        return listOfProducts;
    }

    private static List<String> getNewListAfterCorrect(List<String> listOfProducts, String oldItem, String newItem) {
        boolean isExist = false;
        int indexOfElement = 0;
        for (int i = 0; i < listOfProducts.size(); i++) {
            if (listOfProducts.get(i).equals(oldItem)) {
                indexOfElement = i;
                isExist = true;
                break;
            }
        }

        if (isExist) {
            listOfProducts.set(indexOfElement, newItem);
        }
        return listOfProducts;
    }


    private static List<String> getNewListOfProductAfterUnnecessary(List<String> listOfProducts, String product) {
        boolean isExist = false;
        String existingProduct = "";
        for (String element : listOfProducts) {
            if (element.equals(product)) {
                existingProduct = element;
                isExist = true;
                break;
            }
        }
        if (isExist) {
            listOfProducts.remove(existingProduct);
        }
        return listOfProducts;

    }

    private static List<String> getNewListOfProductAfterUrgent(List<String> listOfProducts, String product) {

        boolean isExist = false;

        for (String element : listOfProducts) {
            if (element.equals(product)) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            listOfProducts.add(0, product);
        }
        return listOfProducts;

    }
}
