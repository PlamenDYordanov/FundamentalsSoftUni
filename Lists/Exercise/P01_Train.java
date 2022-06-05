package ProgrammingFundamentals.ListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacity = Integer.parseInt(scanner.nextLine());
        int parseInt = 0;

        String input = scanner.nextLine();

        while (!input.equals("end")){

            String[] tokens = new String[input.length()];
            tokens = input.split(" ");

           if (tokens[0].equals("Add")){
               parseInt = Integer.parseInt(tokens[1]);
            listOfNumbers.add(parseInt);
           }else {
               parseInt = Integer.parseInt(tokens[0]);
               for (int i = 0; i < listOfNumbers.size(); i++) {
                   if (parseInt+listOfNumbers.get(i)<=maxCapacity){
                       int currentNum = listOfNumbers.get(i);
                       listOfNumbers.remove(i);
                       listOfNumbers.add(i,parseInt+currentNum);
                       break;
                   }
               }
           }

            input = scanner.nextLine();
        }
        System.out.println(listOfNumbers.toString().replaceAll("[\\[\\],]",""));
    }

    }

