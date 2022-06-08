package ProgrammingFundamentals.Methods.Exercise;

import java.util.Scanner;

public class P05_AddSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int resultOfSum = sumFirstAndSecondNum(firstNum, secondNum);
        int resultOfSubtract = subtractThirdWithSumNum(resultOfSum, thirdNum);
        System.out.println(resultOfSubtract);
    }

    public static int sumFirstAndSecondNum(int firstNum, int secondNum) {
        int sum = firstNum + secondNum;
        return sum;
    }

    public static int subtractThirdWithSumNum(int sum, int thirdNum) {

        int totalSum = sum - thirdNum;
        return totalSum;
    }
}
