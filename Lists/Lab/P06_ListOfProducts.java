package ProgrammingFundamentals.List_Lab;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P06_ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> listOfProducts = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String products = scanner.nextLine();
            listOfProducts.add(products);
        }
        Collections.sort(listOfProducts);
        printingInOrder(listOfProducts);

    }
    public static void  printingInOrder (List<String> array){
        for (int i = 1; i <= array.size(); i++) {
            System.out.printf("%d.%s%n",i,array.get(i-1));
        }
    }
}
