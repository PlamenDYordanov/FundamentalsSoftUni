package ProgrammingFundamentals.ExamPreparation.Exam02;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingPeople = Integer.parseInt(scanner.nextLine());

        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        boolean isWaitingPeopleOver = false;
        boolean isEmptyCabin = false;


        for (int i = 0; i < listOfNumbers.size(); i++) {
            int currentPeople = listOfNumbers.get(i);
            if (waitingPeople == 0) {
                isWaitingPeopleOver = true;
                break;
            }
            if (currentPeople>=4){
                continue;
            }
            int getOnLift = 4 - currentPeople;
            if (waitingPeople <= getOnLift) {
                if (waitingPeople+currentPeople<=4){
                    listOfNumbers.set(i, waitingPeople+currentPeople);
                    isWaitingPeopleOver = true;
                    break;
                }else {
                    listOfNumbers.set(i, waitingPeople);
                    isWaitingPeopleOver = true;
                    break;
                }
            } else {
                if (listOfNumbers.get(i) > 0) {
                    listOfNumbers.set(i, getOnLift + currentPeople);
                } else {
                    listOfNumbers.set(i, getOnLift);
                }
                waitingPeople -= getOnLift;
            }

        }
        if (isWaitingPeopleOver) {
            for (Integer listOfNumber : listOfNumbers) {
                if (listOfNumber < 4) {
                    isEmptyCabin = true;
                    break;
                }

            }
        }

        if (isWaitingPeopleOver && !isEmptyCabin) {
            for (int i = 0; i < listOfNumbers.size() - 1; i++) {
                System.out.print(listOfNumbers.get(i));
                System.out.print(" ");
            }
            System.out.println(listOfNumbers.get(listOfNumbers.size() - 1));

        } else if (isWaitingPeopleOver && isEmptyCabin) {
            System.out.println("The lift has empty spots!");
            for (int i = 0; i < listOfNumbers.size() - 1; i++) {
                System.out.print(listOfNumbers.get(i));
                System.out.print(" ");
            }
            System.out.println(listOfNumbers.get(listOfNumbers.size() - 1));
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", waitingPeople);
            for (int i = 0; i < listOfNumbers.size() - 1; i++) {
                System.out.print(listOfNumbers.get(i));
                System.out.print(" ");
            }
            System.out.println(listOfNumbers.get(listOfNumbers.size() - 1));
        }
    }
}

