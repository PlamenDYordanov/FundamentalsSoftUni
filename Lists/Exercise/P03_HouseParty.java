package ProgrammingFundamentals.ListExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P03_HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int operations = Integer.parseInt(scanner.nextLine());
        List<String> housePartyList = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < operations; i++) {

            String input = scanner.nextLine();
            String[] tokens = input.split(" ");
            String name = tokens[0];
            boolean isExist = false;

            if (tokens.length==3){
                if (counter==0){
                    housePartyList.add(name);
                    counter++;
                    continue;
                }
                for (int j = 0; j < housePartyList.size() ; j++) {
                    if (housePartyList.get(j).equals(name)) {
                        System.out.printf("%s is already in the list!%n",name);
                        isExist = true;
                        break;
                    }
                }
                if (!isExist){
                    housePartyList.add(name);
                }

            }else if (tokens.length==4){
                for (int j = 0; j < housePartyList.size(); j++) {
                    if (housePartyList.get(j).equals(name)){
                        housePartyList.remove(name);
                        isExist=true;
                        break;
                    }
                }
                if (!isExist){
                    System.out.printf("%s is not in the list!%n",name);
                }
            }

        }
        printingHousePartyNames(housePartyList);
    }
    public static void  printingHousePartyNames (List<String> listOfNames){

        for (String names:listOfNames) {
            System.out.println(names);
        }
    }
}
