package ProgrammingFundamentals.TextProcessing.Exercises;

import javax.print.DocFlavor;
import java.util.Scanner;

public class P05_MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder firstNum = new StringBuilder(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int firstNumLength = firstNum.length();
        for (int i = 0; i < firstNumLength - 1; i++) {
            char symbol = firstNum.charAt(i);
            if (i == 0 && symbol == '0') {
                firstNum.deleteCharAt(i);
                i = i - 1;
                firstNumLength--;
            }
        }
       /* if (firstNum.isEmpty()) {
            firstNum.append(0);
        }*/
        getMultipliedNum(firstNum, secondNum);
        System.out.println(getMultipliedNum(firstNum, secondNum));
    }

    private static StringBuilder getMultipliedNum(StringBuilder firstNum, int secondNum) {

        boolean isRemain = false;
        boolean isZeroLength = false;
        boolean isZero = false;

        StringBuilder remain = new StringBuilder();
        StringBuilder result = new StringBuilder();
        if (secondNum == 0) {

            isZero = true;
        }
        if (firstNum.length() == 1 && !isZero) {
            isZeroLength = true;
            int number = Integer.parseInt(String.valueOf(firstNum.charAt(0)));
            int total = secondNum * number;
            result.append(total);

        }
        if (!isZeroLength) {
            for (int i = firstNum.length() - 1; i >= 0; i--) {
                if (isZero) {
                    result.append(0);
                    break;
                }
                int number = Integer.parseInt(String.valueOf(firstNum.charAt(i)));
                if (number == 0 && i == 0) {
                    continue;
                }
                if (i == 0) {
                    if (isRemain) {
                        int remainFromMultiply = Integer.parseInt(String.valueOf(remain.charAt(0)));
                        int total = (secondNum * number) + remainFromMultiply;
                        if (total < 10) {
                            remain.deleteCharAt(0);
                            remain.append(total);
                            remain.reverse();
                            result.append(remain);
                            result.reverse();
                        } else {
                            remain.deleteCharAt(0);
                            remain.append(total);
                            remain.reverse();
                            result.append(remain);
                            result.reverse();
                        }
                    } else {

                        int total = secondNum * number;
                        remain.deleteCharAt(0);
                        remain.append(total);
                        remain.reverse();
                        result.append(remain);
                        result.reverse();
                    }
                    break;
                }
                if (i < firstNum.length() - 1) {
                    if (isRemain) {

                        int remainFromMultiply = Integer.parseInt(String.valueOf(remain.charAt(0)));
                        int total = (secondNum * number) + remainFromMultiply;
                        if (total < 10) {
                            remain.deleteCharAt(0);
                            remain.append(total);
                            result.append(total);
                            isRemain = false;
                        } else {
                            remain.deleteCharAt(0);
                            remain.append(total);
                            result.append(remain.charAt(1));
                            remain.deleteCharAt(1);
                        }
                    } else {
                        int total = secondNum * number;
                        if (total > 9) {
                            remain.deleteCharAt(0);
                            remain.append(total);
                            result.append(remain.charAt(1));
                            remain.deleteCharAt(1);
                            isRemain = true;
                        } else {
                            remain.deleteCharAt(0);
                            remain.append(total);
                            result.append(remain.charAt(0));
                        }

                    }
                    continue;
                }
                int total = secondNum * number;
                if (total > 9) {
                    remain.append(total);
                    result.append(remain.charAt(1));
                    remain.deleteCharAt(1);
                    isRemain = true;
                } else {
                    remain.append(total);
                    result.append(remain.charAt(0));
                }

            }
        }

        return result;
    }

}
