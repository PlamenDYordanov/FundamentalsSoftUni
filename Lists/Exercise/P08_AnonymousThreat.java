package ProgrammingFundamentals.ListExercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P08_AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listInput = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            List<String> listOfCommand = Arrays.stream(command.split(" ")).collect(Collectors.toList());

            switch (listOfCommand.get(0)) {
                case "merge":
                    int startIndex = Integer.parseInt(listOfCommand.get(1));
                    int endIndex = Integer.parseInt(listOfCommand.get(2));


                    if (startIndex < 0) {
                        startIndex = 0;
                    }
                    if (endIndex > listInput.size() - 1) {
                        endIndex = listInput.size() - 1;
                    }
                    int diffStartIndex = startIndex;

                    for (int i = startIndex; i < endIndex; i++) {
                        String concat = listInput.get(diffStartIndex) + listInput.get(diffStartIndex + 1);
                        listInput.set(diffStartIndex, concat);
                        listInput.remove(diffStartIndex + 1);
                    }

                    break;
                case "divide":

                    int index = Integer.parseInt(listOfCommand.get(1));
                    int partitions = Integer.parseInt(listOfCommand.get(2));

                    if (index >= 0 && index < listInput.size() && partitions >= 0 && partitions <= 100) {

                        List<String> newList = new ArrayList<>();
                        int sizeOfIndex = listInput.get(index).length();
                        String currentIndexSplit = listInput.get(index);
                        int elementLength = sizeOfIndex / partitions;

                        int count = 0;


                        if (currentIndexSplit.length() % partitions == 0) {
                            for (int i = 0; i < partitions; i++) {
                                String currentOutput = "";
                                for (int j = 0; j < elementLength; j++) {
                                    char symbol = currentIndexSplit.charAt(count);
                                    currentOutput += symbol;
                                    count++;
                                }
                                newList.add(currentOutput);

                            }
                        } else {
                            for (int i = 0; i < partitions; i++) {
                                String currentOutput = "";
                                if (i == partitions - 1) {
                                    for (int j = count; j < currentIndexSplit.length(); j++) {
                                        char symbol = currentIndexSplit.charAt(count);
                                        currentOutput += symbol;
                                        count++;
                                    }
                                    newList.add(currentOutput);
                                } else {
                                    for (int j = 0; j < elementLength; j++) {
                                        char symbol = currentIndexSplit.charAt(count);
                                        currentOutput += symbol;
                                        count++;

                                    }
                                    newList.add(currentOutput);
                                }
                            }
                        }

                        listInput.remove(index);
                        listInput.addAll(index,newList);
                    }
                    break;
            }
            command = scanner.nextLine();
        }
        printingList(listInput);
    }

    private static void printingList(List<String> listInput) {
        String outPut = "";
        for (String element : listInput) {
            outPut += element + " ";
        }
        outPut.trim();
        System.out.println(outPut);
    }
}