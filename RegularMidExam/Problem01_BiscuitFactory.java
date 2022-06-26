package ProgrammingFundamentals.RegularMidExam;


import java.util.Scanner;

public class Problem01_BiscuitFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int biscuitsPerWorker = Integer.parseInt(scanner.nextLine());
        int countOfWorkers = Integer.parseInt(scanner.nextLine());
        int biscuitsPerDay = Integer.parseInt(scanner.nextLine());


        double totalBiscuits = 0;
        double productionPerDay = 0;
        for (int i = 1; i <= 30; i++) {
            productionPerDay = biscuitsPerWorker * countOfWorkers;
            if (i % 3 == 0){
                productionPerDay = productionPerDay * 0.75;
                productionPerDay = Math.floor(productionPerDay);
            }
            totalBiscuits+=productionPerDay;

        }
        System.out.printf("You have produced %.0f biscuits for the past month.%n",totalBiscuits);
        if (totalBiscuits>biscuitsPerDay){
            double diff = totalBiscuits-biscuitsPerDay;
            System.out.printf("You produce %.2f percent more biscuits.%n",(diff/ biscuitsPerDay)*100);
        }else if (totalBiscuits<biscuitsPerDay){
            double diff = biscuitsPerDay - totalBiscuits;
            System.out.printf("You produce %.2f percent less biscuits.%n",(diff/biscuitsPerDay)*100);
        }else {
            System.out.printf("You have produced %.0f biscuits for the past month.%n",totalBiscuits);
        }
    }

}
