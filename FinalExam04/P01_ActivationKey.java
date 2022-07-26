package ProgrammingFundamentals.FinalExam04;

import java.util.Locale;
import java.util.Scanner;

public class P01_ActivationKey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String activationKey = scanner.nextLine();

        String input = scanner.nextLine();

        while (!input.equals("Generate")) {
            String command = input.split(">>>")[0];


            switch (command) {
                case "Contains":
                    String sub = input.split(">>>")[1];
                    boolean isTrue = getNewGenAfterSub(activationKey, sub);

                    if (isTrue) {
                        System.out.printf("%s contains %s%n", activationKey, sub);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip": {
                    String secondCommand = input.split(">>>")[1];
                    int startIndex = Integer.parseInt(input.split(">>>")[2]);
                    int lastIndex = Integer.parseInt(input.split(">>>")[3]);

                    String firstPart = activationKey.substring(0, startIndex);
                    String lastPart = activationKey.substring(lastIndex);

                    if (secondCommand.equals("Upper")) {
                        String toUpper = activationKey.substring(startIndex, lastIndex).toUpperCase();
                        activationKey = firstPart.concat(toUpper).concat(lastPart);

                    } else if (secondCommand.equals("Lower")) {
                        String toUpper = activationKey.substring(startIndex, lastIndex).toLowerCase();
                        activationKey = firstPart.concat(toUpper).concat(lastPart);

                    }
                    System.out.println(activationKey);
                }
                break;
                case "Slice":
                    int startIndex = Integer.parseInt(input.split(">>>")[1]);
                    int lastIndex = Integer.parseInt(input.split(">>>")[2]);

                    String firstPart = activationKey.substring(0,startIndex);
                    String secondPart = activationKey.substring(lastIndex);
                    activationKey = firstPart.concat(secondPart);
                    System.out.println(activationKey);
                    break;
            }


            input = scanner.nextLine();
        }
        System.out.printf("Your activation key is: %s",activationKey);
    }

    private static boolean getNewGenAfterSub(String activationKey, String sub) {
        if (activationKey.contains(sub)) {
            return true;
        }
        return false;
    }
}
