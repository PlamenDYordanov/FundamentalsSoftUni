package ProgrammingFundamentals.Methods.Exercise;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.Scanner;

public class P11_ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrayNumbers = scanner.nextLine().split("\\s+");
        String input = scanner.nextLine();


        while (!input.equals("end")) {
            String[] arrInput = input.split("\\s+");
            int elementInt = 0;
            String elements = "";

            switch (arrInput[0]) {
                case "exchange":
                    arrayNumbers = splitTheArrayOfTowPeaces(arrayNumbers, arrInput[1]);
                    break;
                case "max":
                    if (arrInput[1].equals("odd")) {
                        indexOfMaxOddInteger(arrayNumbers);
                    } else if (arrInput[1].equals("even")) {
                        indexOfMaxEvenInteger(arrayNumbers);
                    }
                    break;
                case "min":
                    if (arrInput[1].equals("odd")) {
                        indexOfMinOddInteger(arrayNumbers);
                    } else if (arrInput[1].equals("even")) {
                        indexOfMinEvenInteger(arrayNumbers);
                    }
                    break;
                case "first":

                    if (arrInput[2].equals("odd")) {
                        firstElementsOdd(arrInput, arrayNumbers);
                    } else if (arrInput[2].equals("even")) {
                        firstElementsEven(arrInput, arrayNumbers);
                    }
                    break;
                case "last":

                    if (arrInput[2].equals("odd")) {
                        findLastOdd(arrayNumbers,arrInput[1]);
                    } else if (arrInput[2].equals("even")) {
                        findLastEven(arrayNumbers, arrInput[1]);
                    }
                    break;

            }

            input = scanner.nextLine();

        }
        System.out.print("[");
        for (int i = 0; i < arrayNumbers.length - 1; i++) {
            System.out.print(arrayNumbers[i] + ", ");
        }
        System.out.print(arrayNumbers[arrayNumbers.length - 1] + "]");

    }

    public static String[] splitTheArrayOfTowPeaces(String[] inputAsArray, String token) {
        int index = Integer.parseInt(token);
        String[] newArray = new String[inputAsArray.length];
        if (index < 0 || index >= inputAsArray.length) {
            System.out.println("Invalid index");
            return inputAsArray;
        } else {
            int x = 0;
            for (int newStart = index + 1; newStart < inputAsArray.length; newStart++) {
                newArray[x] = inputAsArray[newStart];
                x++;
            }
            for (int newEnd = 0; newEnd <= index; newEnd++) {
                newArray[x] = inputAsArray[newEnd];
                x++;
            }

        }
        return newArray;
    }

    public static void indexOfMaxOddInteger(String[] array) {
        int maxNumber = Integer.MIN_VALUE;
        int lastIndex = 0;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {

            String currentInt = array[i];
            int currentDig = Integer.parseInt(currentInt);
            if (currentDig % 2 == 0) {
                continue;
            }
            if (currentDig >= maxNumber) {
                maxNumber = currentDig;
                lastIndex = i;
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(lastIndex);
        }
    }

    public static void indexOfMinOddInteger(String[] array) {
        int minNumber = Integer.MAX_VALUE;
        int lastIndex = 0;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            String currentInt = array[i];
            int currentDig = Integer.parseInt(currentInt);
            if (currentDig % 2 == 0) {
                continue;
            }
            if (currentDig <= minNumber) {
                minNumber = currentDig;
                lastIndex = i;
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(lastIndex);
        }
    }

    public static void indexOfMaxEvenInteger(String[] array) {
        int maxValue = Integer.MIN_VALUE;
        int lastIndex = 0;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            String currentInt = array[i];
            int currentDig = Integer.parseInt(currentInt);
            if (currentDig % 2 != 0) {
                continue;
            }
            if (currentDig >= maxValue) {
                maxValue = currentDig;
                lastIndex = i;
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(lastIndex);
        }
    }

    public static void indexOfMinEvenInteger(String[] array) {
        int minNumber = Integer.MAX_VALUE;
        int lastIndex = 0;
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            String currentInt = array[i];
            int currentDig = Integer.parseInt(currentInt);
            if (currentDig % 2 != 0) {
                continue;
            }
            if (currentDig <= minNumber) {
                minNumber = currentDig;
                lastIndex = i;
                counter++;
            }
        }
        if (counter == 0) {
            System.out.println("No matches");
        } else {
            System.out.println(lastIndex);
        }
    }

    public static void firstElementsOdd(String[] input, String[] array) {
        String elements = input[1];
        int intElement = Integer.parseInt(elements);
        String[] newArray = new String[intElement];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            String currentInt = array[i];
            int currentDig = Integer.parseInt(currentInt);
            if (currentDig % 2 != 0) {
                newArray[j] = array[i];
                j++;
            }
            if (j == newArray.length) {
                break;
            }
        }
        if (intElement > array.length) {
            System.out.println("Invalid count");
        } else if (j == 0) {
            System.out.println("[]");
        } else if (j == 1) {
            System.out.print("[" + newArray[j - 1] + "]");
            System.out.println();
        } else {
            System.out.print("[");
            for (int i = 0; i < newArray.length - 1; i++) {
                System.out.print(newArray[i] + ", ");
            }
            System.out.print(newArray[newArray.length - 1] + "]");
            System.out.println();
        }
    }

    public static void firstElementsEven(String[] input, String[] array) {
        String elements = input[1];
        int intElement = Integer.parseInt(elements);
        String[] newArray = new String[intElement];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            String currentInt = array[i];
            int currentDig = Integer.parseInt(currentInt);
            if (currentDig % 2 == 0) {
                newArray[j] = array[i];
                j++;
            }
            if (j == newArray.length) {
                break;
            }
        }
        if (intElement > array.length) {
            System.out.println("Invalid count");
        } else if (j == 0) {
            System.out.println("[]");
        } else if (j == 1) {
            System.out.print("[" + newArray[j - 1] + "]");
            System.out.println();
        } else {
            System.out.print("[");
            for (int i = 0; i < newArray.length - 1; i++) {
                System.out.print(newArray[i] + ", ");
            }
            System.out.print(newArray[newArray.length - 1] + "]");
            System.out.println();
        }
    }

    private static void findLastOdd(String[] inputAsArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount > inputAsArray.length) {
            System.out.println("Invalid count");
        } else {
            int countEven = 0;
            for (int i = 0; i <= inputAsArray.length - 1; i++) {
                if (Integer.parseInt(inputAsArray[i]) % 2 != 0) {
                    countEven++;
                }
            }
            int[] array = new int[Math.min(countEven, neededCount)];
            if (array.length > 0) {
                int index = 0;
                for (int i = inputAsArray.length - 1; i >= 0; i--) {
                    if (Integer.parseInt(inputAsArray[i]) % 2 != 0) {
                        array[index] = Integer.parseInt(inputAsArray[i]);
                        index++;
                        if (index > array.length - 1) {
                            break;
                        }
                    }
                }
                int[] reversedArray = new int[array.length];
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    reversedArray[i] = array[array.length - (i + 1)];
                }

                System.out.print("[");
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    if (i == reversedArray.length - 1) {
                        System.out.print(reversedArray[i]);
                    } else {
                        System.out.print(reversedArray[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }


    private static void findLastEven(String[] inputAsArray, String token) {
        int neededCount = Integer.parseInt(token);
        if (neededCount > inputAsArray.length) {
            System.out.println("Invalid count");
        } else {
            int countEven = 0;
            for (int i = 0; i <= inputAsArray.length - 1; i++) {
                if (Integer.parseInt(inputAsArray[i]) % 2 == 0) {
                    countEven++;
                }
            }
            int[] array = new int[Math.min(countEven, neededCount)];
            if (array.length > 0) {
                int index = 0;
                for (int i = inputAsArray.length - 1; i >= 0; i--) {
                    if (Integer.parseInt(inputAsArray[i]) % 2 == 0) {
                        array[index] = Integer.parseInt(inputAsArray[i]);
                        index++;
                        if (index > array.length - 1) {
                            break;
                        }
                    }
                }
                int[] reversedArray = new int[array.length];
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    reversedArray[i] = array[array.length - (i + 1)];
                }

                System.out.print("[");
                for (int i = 0; i <= reversedArray.length - 1; i++) {
                    if (i == reversedArray.length - 1) {
                        System.out.print(reversedArray[i]);
                    } else {
                        System.out.print(reversedArray[i] + ", ");
                    }
                }
                System.out.println("]");
            } else {
                System.out.println("[]");
            }
        }
    }
}
