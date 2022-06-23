package ProgrammingFundamentals.MidExamPreparation.Exam04;

import java.util.Scanner;

public class P01_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double quantityFoodGr = Double.parseDouble(scanner.nextLine()) * 1000;
        double quantityHayGr = Double.parseDouble(scanner.nextLine()) * 1000;
        double quantityCoverGr = Double.parseDouble(scanner.nextLine()) * 1000;
        double guineaPigWeight = Double.parseDouble(scanner.nextLine()) * 1000;

        boolean isEnoughSupplies = true;

        for (int i = 1; i <= 30; i++) {
            quantityFoodGr -= 300;
            if (quantityFoodGr<=0||quantityHayGr<=0||quantityCoverGr<=0){
                isEnoughSupplies = false;
                break;
            }
            if (i % 2 == 0) {
                double neededHay = quantityFoodGr * 0.05;
                quantityHayGr -= neededHay;
            }
            if (i % 3 == 0) {
                double neededCover = guineaPigWeight / 3;
                quantityCoverGr-=neededCover;

            }
        }
        if (!isEnoughSupplies){
            System.out.println("Merry must go to the pet store!");
        }else {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.",quantityFoodGr/1000,quantityHayGr/1000,quantityCoverGr/1000);
        }
    }
}
