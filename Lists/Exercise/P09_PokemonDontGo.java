package ProgrammingFundamentals.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P09_PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (!listOfNumbers.isEmpty()) {
            int indexToRemove = Integer.parseInt(scanner.nextLine());
            boolean isRemovedNum = false;
            int removedNum = 0;
            if (listOfNumbers.size()==1){
                removedNum = listOfNumbers.get(0);
                sum+=removedNum;
                listOfNumbers.remove(0);
                continue;
            }


            if (indexToRemove < 0) {

                removedNum = listOfNumbers.get(0);
                listOfNumbers.remove(0);
                int lastNumber = listOfNumbers.get(listOfNumbers.size() - 1);
                    listOfNumbers.add(0, lastNumber);
                    isRemovedNum = true;

            }
            if (indexToRemove > listOfNumbers.size() - 1) {

                removedNum = listOfNumbers.get(listOfNumbers.size() - 1);
                listOfNumbers.remove(listOfNumbers.size() - 1);
                int firstNum = listOfNumbers.get(0);
                listOfNumbers.add(listOfNumbers.size(), firstNum);
                    isRemovedNum = true;

            }
            for (int i = 0; i < listOfNumbers.size(); i++) {
                if (i == indexToRemove) {
                    removedNum = listOfNumbers.get(i);
                    listOfNumbers.remove(i);
                    isRemovedNum = true;
                }

            }

            if (isRemovedNum) {
                for (int j = 0; j < listOfNumbers.size(); j++) {
                    if (removedNum < listOfNumbers.get(j)) {
                        listOfNumbers.set(j, listOfNumbers.get(j) - removedNum);
                    } else {
                        listOfNumbers.set(j, removedNum + listOfNumbers.get(j));
                    }
                }
            }
            sum += removedNum;
        }

        System.out.print(sum);
    }
}
