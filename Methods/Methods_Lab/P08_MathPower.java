package ProgrammingFundamentals.Methods.Methods_Lab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class P08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());


        double outPut = resultFromPow(number,power);

        DecimalFormat df = new DecimalFormat("0.####");
        System.out.println(df.format(outPut));

    }
    public static double resultFromPow(double number, int power){
        double result =1;
        for (int i = 0; i < power; i++) {
            result*=number;
        }
        return result;
    }

}
