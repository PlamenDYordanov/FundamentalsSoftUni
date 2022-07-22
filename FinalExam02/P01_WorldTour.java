package ProgrammingFundamentals.FinalExam02;

import java.util.Scanner;

public class P01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String tripText = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Travel")) {
            String command = input.split("\\:")[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(input.split("\\:")[1]);
                    String addText = input.split("\\:")[2];
                    tripText = getNewText(index, addText, tripText);
                    System.out.println(tripText);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(input.split("\\:")[1]);
                    int lastIndex = Integer.parseInt(input.split("\\:")[2]);
                    tripText = getNewTextAfterRemove(tripText, startIndex, lastIndex);
                    System.out.println(tripText);
                    break;
                case "Switch":
                    String oldString = input.split("\\:")[1];
                    String newString = input.split("\\:")[2];
                    tripText = getNewTextAfterSwitch(tripText, oldString, newString);
                    System.out.println(tripText);
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", tripText);
    }

    private static String getNewTextAfterSwitch(String tripText, String oldString, String newString) {
        if (tripText.contains(oldString)) {
            return tripText = tripText.replace(oldString, newString);
        }
        else return tripText;
    }

    private static String getNewTextAfterRemove(String tripText, int startIndex, int lastIndex) {
        if (startIndex >= 0 && startIndex <= tripText.length() && lastIndex <= tripText.length() - 1
                && lastIndex >= 0) {
            String firstPart = tripText.substring(0, startIndex);
            String secondPart = tripText.substring(lastIndex + 1);
            return (firstPart).concat(secondPart);
        }
        return tripText;
    }

    private static String getNewText(int index, String addText, String tripText) {
        if (index >= 0 && index <= tripText.length()) {
            String firstPart = tripText.substring(0, index);
            String secondPart = tripText.substring(index);
            tripText = firstPart.concat(addText).concat(secondPart);

        }
        return tripText;
    }

}
