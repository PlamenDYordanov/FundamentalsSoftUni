package ProgrammingFundamentals.RegularMidExam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Problem03_ChatLogger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> chatList = new ArrayList<>();
       List<String> input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());

       String command = "";
        String message = "";
        command = input.get(0);

       while (!command.equals("end")){

           switch (command){
               case  "Chat":
                   message = input.get(1);
                   chatList.add(message);
               break;
               case "Delete":
                   message = input.get(1);
                   if (chatList.contains(message)){
                       chatList.remove(message);
                   }
                   break;
               case "Edit":
                   message = input.get(1);
                   String edit = input.get(2);
                   if (chatList.contains(message)){
                       int index = chatList.indexOf(message);
                       chatList.set(index,edit);
                   }
                   break;
               case "Pin":
                   message = input.get(1);
                   if (chatList.contains(message)){
                       int index = chatList.indexOf(message);
                       chatList.remove(index);
                       chatList.add(message);
                   }
                   break;
               case "Spam":
                   int length = input.size();
                   for (int i = 1; i < length; i++) {
                       chatList.add(input.get(i));
                   }
                   break;
           }


           input = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
           command = input.get(0);
       }

        for (String elements : chatList) {
            System.out.println(elements);

        }


    }
}
