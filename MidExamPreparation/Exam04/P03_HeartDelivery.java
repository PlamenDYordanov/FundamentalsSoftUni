package ProgrammingFundamentals.MidExamPreparation.Exam04;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listOfNeighborhood = Arrays
                .stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String inputLine = scanner.nextLine();
        int love = 0;
        int currentIndex = 0;
        while (!inputLine.equals("Love!")) {
            String[] arrInput = inputLine.split(" ");
            int length = Integer.parseInt(arrInput[1]);
            currentIndex += length;
            if (currentIndex < 0) {
                inputLine = scanner.nextLine();
                continue;
            }
            if (currentIndex > listOfNeighborhood.size() - 1) {
                currentIndex = 0;
                int currentLove = listOfNeighborhood.get(0);
                if (currentLove == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", 0);
                } else {
                    love = listOfNeighborhood.get(currentIndex);
                    listOfNeighborhood.set(currentIndex, love - 2);
                    if (listOfNeighborhood.get(currentIndex) == 0) {
                        System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                    }
                }
            } else {
                int currentLove = listOfNeighborhood.get(currentIndex);
                if (currentLove == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
                } else {
                    love = listOfNeighborhood.get(currentIndex);
                    listOfNeighborhood.set(currentIndex, love - 2);
                    if (listOfNeighborhood.get(currentIndex) == 0) {
                        System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                    }
                }
            }

            inputLine = scanner.nextLine();

        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        int failedPlaces = 0;

        for (Integer element : listOfNeighborhood) {
            if (element > 0) {
                failedPlaces++;
            }
        }
        if (failedPlaces > 0) {
            System.out.printf("Cupid has failed %d places.%n", failedPlaces);
        }else {
            System.out.println("Mission was successful.");
        }
    }
}
