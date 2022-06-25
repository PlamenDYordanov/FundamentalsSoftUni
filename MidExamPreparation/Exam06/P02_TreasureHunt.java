package ProgrammingFundamentals.MidExamPreparation.Exam06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfItems = Arrays
                .stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String inputLine = scanner.nextLine();


        while (!inputLine.equals("Yohoho!")) {
            String[] arrInputLine = inputLine.split(" ");
            String command = arrInputLine[0];

            switch (command) {
                case "Loot":
                    getNewItemsAfterLoot(listOfItems, arrInputLine);
                    break;
                case "Drop":
                    int index = Integer.parseInt(arrInputLine[1]);
                    getNewItemsAfterDrop(listOfItems, index);
                    break;
                case "Steal":
                    int count = Integer.parseInt(arrInputLine[1]);
                    getNewItemsAfterSteal(listOfItems, count);
                    break;
            }

            inputLine = scanner.nextLine();
        }
        if (listOfItems.isEmpty()){
            System.out.println("Failed treasure hunt.");
        }else {
            getAverageTreasureGain(listOfItems);
        }
    }

    private static void getAverageTreasureGain(List<String> listOfItems) {
        double sum = 0;
        for (int i = 0; i < listOfItems.size(); i++) {
           String item = listOfItems.get(i);
           int length = item.length();
            sum += length;
        }
        System.out.printf("Average treasure gain: %.2f pirate credits.",sum/listOfItems.size());

    }

    private static List<String> getNewItemsAfterSteal(List<String> listOfItems, int count) {
        List<String> stolenItems = new ArrayList<>();

        if (count > listOfItems.size() - 1) {
            stolenItems.addAll(listOfItems);
            listOfItems.removeAll(listOfItems);
        } else {
            int startIndex = listOfItems.size()  - count;
            for (int i = startIndex; i <= listOfItems.size() - 1; i++) {
                stolenItems.add(listOfItems.get(i));
                listOfItems.remove(i);
                i--;
            }
        }
        System.out.println(String.join(", ", stolenItems));
        return listOfItems;
    }

    private static List<String> getNewItemsAfterDrop(List<String> listOfItems, int index) {
        if (index >= 0 && index <= listOfItems.size() - 1) {
            String removeItem = listOfItems.get(index);
            listOfItems.remove(index);
            listOfItems.add(listOfItems.size(), removeItem);
        }
        return listOfItems;
    }

    private static List<String> getNewItemsAfterLoot(List<String> listOfItems, String[] arrInputLine) {
        String item = "";
        boolean isExist = false;
        for (int i = 1; i < arrInputLine.length; i++) {
            item = arrInputLine[i];
            for (String items : listOfItems) {
                if (item.equals(items)) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                listOfItems.add(0, item);
            }
            isExist = false;

        }
        return listOfItems;
    }
}
