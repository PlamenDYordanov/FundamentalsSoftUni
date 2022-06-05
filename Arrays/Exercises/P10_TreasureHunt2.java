package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_exercises;

import java.util.*;
import java.util.stream.Collectors;

public class P10_TreasureHunt2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> inputItems = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        List<String> input = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        int counter = 0;
        String inputResult = "";
        String itemResult = "";
        String position = "";
        boolean isSteelEverything = false;
        int sum = 0;

        while (!input.get(0).equals("Yohoho!")) {

            if (input.get(0).equals("Loot")) {
                for (int i = 1; i <= input.size() - 1; i++) {
                    for (int j = 0; j < inputItems.size(); j++) {
                        inputResult = input.get(i);
                        itemResult = inputItems.get(j);
                        if (inputResult.equals(itemResult)) {
                            counter++;
                            break;
                        }

                    }
                    if (counter == 0) {
                        inputItems.add(0, input.get(i));
                    }
                    counter = 0;
                }

            } else if (input.get(0).equals("Drop")) {
                position = input.get(1);
                int element = Integer.parseInt(position);
                if (element>200||element<-200){
                    input = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .collect(Collectors.toList());
                    continue;
                }

                if (element >= 0 && element <= inputItems.size() - 1) {
                    String requireItem = inputItems.get(element);
                    for (int i = element; i < inputItems.size() - 1; i++) {
                        String currentElement = inputItems.get(i + 1);
                        inputItems.set(i, currentElement);
                    }
                    inputItems.remove(inputItems.size() - 1);
                    inputItems.add(inputItems.size(), requireItem);
                }

            } else if (input.get(0).equals("Steal")) {
                position = input.get(1);
                int stolenItems = Integer.parseInt(position);
                if (stolenItems>100||stolenItems<1){
                    input = Arrays
                            .stream(scanner.nextLine().split(" "))
                            .collect(Collectors.toList());
                   continue;
                }
                if (stolenItems > inputItems.size() - 1) {
                    for (int i = 0; i < inputItems.size() - 1; i++) {
                        System.out.print(inputItems.get(i) + ", ");
                    }
                    System.out.print(inputItems.get(inputItems.size() - 1));
                    System.out.println();
                    isSteelEverything = true;
                } else {
                    for (int i = inputItems.size() - stolenItems; i < inputItems.size(); i++) {
                        if (inputItems.size() - 1 == i) {
                            System.out.print(inputItems.get(inputItems.size() - 1));
                            System.out.println();
                        } else {
                            System.out.print(inputItems.get(i) + ", ");


                        }
                    }
                    int diff = inputItems.size()-stolenItems;
                    for (int i = inputItems.size()-1; i >=diff ; i--) {
                        inputItems.remove(i);
                    }
                }
            }

            input = Arrays
                    .stream(scanner.nextLine().split(" "))
                    .collect(Collectors.toList());
        }
        if (isSteelEverything) {
            System.out.println("Failed treasure hunt.");
        } else {
            for (int i = 0; i <= inputItems.size() - 1; i++) {
                counter++;
                String item = inputItems.get(i);
                int length = item.length();
                sum += length;
            }
            System.out.printf("Average treasure gain: %.2f pirate credits.", sum * 1.0 / counter);

        }
    }
}

