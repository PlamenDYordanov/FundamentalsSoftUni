package ProgrammingFundamentals.ExamPreparation.Exam03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targetsList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int index = 0;
        while (!input.equals("End")) {
            String[] commands = input.split(" ");
            String command = commands[0];

            switch (command) {
                case "Shoot":
                    index = Integer.parseInt(commands[1]);
                    int power = Integer.parseInt(commands[2]);
                    getNewListAfterShoot(targetsList, index, power);
                    break;
                case "Add":
                    index = Integer.parseInt(commands[1]);
                    int value = Integer.parseInt(commands[2]);
                    getNewListAfterAdd(targetsList, index, value);
                    break;
                case "Strike":
                    index = Integer.parseInt(commands[1]);
                    int radius = Integer.parseInt(commands[2]);
                    getNewListAfterStrike(targetsList, index, radius);
                    break;
            }


            input = scanner.nextLine();
        }

        List<String> stringList = new ArrayList<>(targetsList.size());
        for (int i = 0; i < targetsList.size(); i++) {
            stringList.add(String.valueOf(targetsList.get(i)));
        }

        System.out.println(String.join("|", stringList));
    }

    private static List<Integer> getNewListAfterStrike(List<Integer> targetsList, int index, int radius) {
        if (index + radius > targetsList.size() || index - radius < 0) {
            System.out.println("Strike missed!");
        } else {
            int firstIndex = index - radius;
            for (int i = firstIndex; i <= index + radius; i++) {
                targetsList.remove(firstIndex);
            }
        }
        return targetsList;
    }

    private static List<Integer> getNewListAfterAdd(List<Integer> targetsList, int index, int value) {
        if (index < 0 || index > targetsList.size() - 1) {
            System.out.println("Invalid placement!");
        } else {
            targetsList.add(index, value);
        }
        return targetsList;
    }

    private static List<Integer> getNewListAfterShoot(List<Integer> targetsList, int index, int power) {

        if (index < 0 || index > targetsList.size() - 1) {
            return targetsList;
        } else {
            targetsList.set(index, targetsList.get(index) - power);
            if (targetsList.get(index) <= 0) {
                targetsList.remove(index);
            }
        }
        return targetsList;
    }
}
