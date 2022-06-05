package ProgrammingFundamentals.Arrays.Arrays_Lab.Arrays_MoreEx;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P02_PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Long> array = new ArrayList<>();
        List<Long> arrayNew = new ArrayList<>();

        for (int row = 1; row <= n; row++) {
            if (row == 1) {
                System.out.println(1);
                array.add(0,1L);

                continue;
            } else if (row == 2) {
                System.out.println(1 + " " + 1);
                array.add(1,1L);

                continue;
            }
            arrayNew.removeAll(arrayNew);
            arrayNew.addAll(array);

            for (int j = 1; j < row-1; j++)
            {
                array.set(j,arrayNew.get(j)+arrayNew.get(j-1));

            }
            array.add(1L);
            String numbers = joinElementsByDelimiter(array);
            System.out.println(numbers);



        }
    }
    public static String joinElementsByDelimiter (List<Long> array){
        String output = "";
        for (Long numbers: array) {
            output += numbers+" ";
        }
        return output;
    }

}
