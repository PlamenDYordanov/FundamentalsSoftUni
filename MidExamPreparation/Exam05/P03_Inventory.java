package ProgrammingFundamentals.MidExamPreparation.Exam05;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> listOfItems = Arrays
                .stream(scanner.nextLine().split(", ")).collect(Collectors.toList());
        String item = "";
        String input = scanner.nextLine();

        while (!input.equals("Craft!")){
            String[] commands = input.split(" - ");
            String command = commands[0];
            switch (command){
                case "Collect":
                    item = commands[1];
                    getNewListAfterCollect(listOfItems,item);
                    break;
                case "Drop":
                    item = commands[1];
                    getNewListAfterDrop(listOfItems,item);
                    break;
                case "Combine Items":
                    String[] newAndOldItems = commands[1].split(":");
                    String oldItem = newAndOldItems[0];
                    String newItem= newAndOldItems[1];
                    getNewListAfterDrop(listOfItems, newItem,oldItem);
                    break;
                case "Renew":
                    item = commands[1];
                    getNewListAfterRenew(listOfItems,item);
                    break;
            }

            input = scanner.nextLine();
        }
        System.out.println(String.join(", ",listOfItems));
    }

    private static List<String> getNewListAfterRenew(List<String> listOfItems, String item) {
        boolean isExist = false;
        for (String items : listOfItems) {
            if (items.equals(item)){
                isExist = true;
                break;
            }
        }
        if (isExist){
            listOfItems.remove(item);
            listOfItems.add(item);
        }
        return  listOfItems;
    }

    private static List<String> getNewListAfterDrop(List<String> listOfItems, String newItem, String oldItem) {
        boolean isExist = false;
        int oldItemIndex = 0;
        for (int i = 0; i < listOfItems.size(); i++) {
            if (listOfItems.get(i).equals(oldItem)){
                oldItemIndex = i;
                isExist = true;
                break;
            }
        }
       if (isExist){
           listOfItems.add(oldItemIndex+1,newItem);
       }
       return listOfItems;
    }

    private static List<String> getNewListAfterDrop(List<String> listOfItems, String item) {
        boolean isExist = false;
        for (String items : listOfItems) {
            if (items.equals(item)){
                isExist = true;
                break;
            }
        }
        if (isExist){
            listOfItems.remove(item);
        }
        return  listOfItems;
    }

    private static List<String> getNewListAfterCollect(List<String> listOfItems, String item) {
        boolean isExist = false;
        for (String items : listOfItems) {
            if (items.equals(item)){
                isExist = true;
                break;
            }
        }
        if (!isExist){
            listOfItems.add(item);
        }
        return  listOfItems;
    }
}
