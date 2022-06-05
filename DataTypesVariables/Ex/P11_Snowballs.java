package ProgrammingFundamentals.DataTypesVaribles_Ex;

import java.util.Scanner;

public class P11_Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countSnowballs = Integer.parseInt(scanner.nextLine());
        double maxValue = Double.MIN_VALUE;
        int maxSnow = 0;
        int maxTime = 0;
        int maxQuality = 0;

        for (int i = 1; i <=countSnowballs ; i++) {
            int snow = Integer.parseInt(scanner.nextLine());
            int time = Integer.parseInt(scanner.nextLine());
            int quality = Integer.parseInt(scanner.nextLine());

            double value = Math.pow(snow*1.0/time,quality);
            if (value>maxValue){
                maxValue=value;
                maxSnow=snow;
                maxTime=time;
                maxQuality = quality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)",maxSnow,maxTime,maxValue,maxQuality);
    }
}
