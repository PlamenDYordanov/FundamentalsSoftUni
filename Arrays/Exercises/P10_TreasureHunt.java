package ProgrammingFundamentals.Arrays.Exercises;

import java.util.Scanner;

public class P10_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String initialItems = scanner.nextLine();
        String[] initialArr = initialItems.split("\\|");
        String[] initialArr2 = initialItems.split("\\|");//use it for item which left after "steal"
        String input = scanner.nextLine();
        boolean isSteelEverything = false;
        int sum = 0;
        int counter = 0;

        while (!input.equals("Yohoho!")) {

            String[] arrInput = input.split(" ");
            int index = 0;
            int counterItems = 0;
            String newItems = "";
            String position = "";
            boolean hasItItem = false;


            if (arrInput[0].equals("Loot")) {
                for (int i = 1; i <= arrInput.length - 1; i++) {

                    for (int k = 0; k <= initialArr.length - 1; k++) {

                        if (arrInput[i].equals(initialArr[k])) { //find whether equals.
                            counter++;// if equals continue searching
                            continue;
                        }
                    }
                    if (counter == 0) {// else add new item
                        newItems += arrInput[i] + " "; //add new items
                        counterItems++;
                        hasItItem = true;
                    }

                    counter = 0;
                }
            } else if (arrInput[0].equals("Drop")) {
                position = arrInput[1];
                int element = Integer.parseInt(position);

                if (element >= 0 && element <= initialArr.length - 1) {//drop items if in our scope
                    String requireElement = initialArr[element];
                    for (int i = element; i < initialArr.length - 1; i++) {
                        initialArr[i] = initialArr[i + 1];//move from  require element to last
                    }
                    initialArr[initialArr.length - 1] = requireElement;
                } else {
                    input = scanner.nextLine();
                    continue;
                }


            } else if (arrInput[0].equals("Steal")) {
                position = arrInput[1];
                int countStolenItems = Integer.parseInt(position);

                if (countStolenItems >= initialArr.length - 1) {//if all items are stolen
                    for (int i = 0; i < initialArr.length - 1; i++) {
                        System.out.print(initialArr[i] + ", ");
                    }
                    System.out.println(initialArr[initialArr.length - 1]);
                    isSteelEverything = true;
                } else {
                    for (int i = countStolenItems - 1; i > 0; i--) {
                        System.out.print(initialArr[initialArr.length - 1 - i] + ", ");//which item are stolen
                    }
                    System.out.println(initialArr[initialArr.length - 1]);
                    initialArr2 = new String[initialArr2.length - countStolenItems];
                    for (int i = 0; i < initialArr2.length; i++) {//which are left
                        initialArr2[i] = initialArr[i];
                    }
                }
            }
            if (hasItItem) {
                String[] newItemsArr = new String[newItems.length() - 1]; //new items array
                newItemsArr = newItems.split(" ");
                initialArr = new String[initialArr.length + counterItems]; //add more space for new items
                for (int i = counterItems; i <= initialArr.length - 1; i++) {

                    initialArr[i] = initialArr2[index];//add old items
                    index += 1;
                }
                for (int i = 0; i <= counterItems; i++) {
                    initialArr[i] = newItemsArr[counterItems - 1]; //add new items left side
                    counterItems--;
                }
                initialArr2 = initialArr;
            }
            index = 0;
            counterItems = 0;
            hasItItem = false;
            newItems = "";

            input = scanner.nextLine();
        }
        if (isSteelEverything) {
            System.out.println("Failed treasure hunt.");
        } else {
            for (int i = 0; i <= initialArr2.length - 1; i++) {
                counter++;
                String item = initialArr2[i];
                int length = item.length();
                sum += length;
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", sum * 1.0 / counter);
        }
    }
}



