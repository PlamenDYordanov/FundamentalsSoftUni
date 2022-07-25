package ProgrammingFundamentals.FinalExam03;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "[@][@#]+(?<barcodes>[A-Z][A-Za-z0-9]{4,}[A-Z])[@][@#]+";

        Pattern pattern = Pattern.compile(regex);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String barcode = scanner.nextLine();

            Matcher matcher = pattern.matcher(barcode);
            if (matcher.find()) {
                String curBarcode = matcher.group("barcodes");
                String productGroup = "";
                boolean isExistDigit = false;
                for (char curChar : curBarcode.toCharArray()) {

                    if (Character.isDigit(curChar)) {
                        isExistDigit = true;
                        productGroup = productGroup.concat(String.valueOf(curChar));

                    }
                }
                if (!isExistDigit){
                    System.out.println("Product group: 00");
                }else {
                    System.out.printf("Product group: %s%n",productGroup);
                }

            }else {
                System.out.println("Invalid barcode");
            }

        }

    }
}
