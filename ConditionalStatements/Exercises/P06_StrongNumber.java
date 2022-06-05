package ProgrammingFundamentals.ConditionalStatementsLoopsExercises;

import java.util.Scanner;

public class P06_StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int totalSum = 0;
        int counter = 0;
        int b =0;
        String numberLength = number + "";
        int length = numberLength.length();
        for (int i = 1; i <= length; i++) {
            char lastNumber = numberLength.charAt(length - i);
            int a = Character.getNumericValue(lastNumber);
            if (a==1||a==0){
                totalSum+=1;
            }
            for (int j = a; j >1 ; j--) {

                counter++;
                if (counter<=1){

                    sum=(a*(j-1));

                }else {

                    sum*=(j-1);
                }
            }

            totalSum+=sum;
            sum=0;
            counter=0;
        }
        if (totalSum==number){
            System.out.println("yes");
        }else {
            System.out.println("no");
        }
    }
}
