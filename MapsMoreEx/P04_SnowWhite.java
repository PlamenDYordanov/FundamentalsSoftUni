package ProgrammingFundamentals.MapsMoreEx;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04_SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> drawMap = new LinkedHashMap<>();
        while (!input.equals("Once upon a time")) {
            String name = input.split(" <:> ")[0];
            String hatColor = input.split(" <:> ")[1];
            int physics = Integer.parseInt(input.split(" <:> ")[2]);

            if (!drawMap.containsKey(hatColor)){
                drawMap.put(hatColor,new LinkedHashMap<>());
                drawMap.get(hatColor).put(name, physics);
            }else if (drawMap.containsKey(hatColor)&&drawMap.get(hatColor).containsKey(name)){
                int currentPhysics = drawMap.get(hatColor).get(name);
                if (currentPhysics<physics){
                    drawMap.get(hatColor).put(name, physics);
                }
            }else {

                if (!drawMap.get(hatColor).containsKey(name)) {
                    if (drawMap.get(hatColor).size() <= 2) {
                        drawMap.get(hatColor).put(name, physics);
                    }


                }
            }



            input = scanner.nextLine();
        }
            Map<String, Integer> sort = new LinkedHashMap<>();

        for (Map.Entry<String, Map<String, Integer>> entry : drawMap.entrySet()) {
            for (Map.Entry<String, Integer> subEntry : entry.getValue().entrySet()) {
                sort.put(entry.getKey() + " " + subEntry.getKey() + " " + entry.getValue().size(),subEntry.getValue());
            }
        }
       sort.entrySet()
               .stream()
               .sorted((e1, e2)->{
                   int res = Integer.compare(e2.getValue(), e1.getValue());
                   if (res == 0){
                       String[] sort1 = e2.getKey().split(" ");
                       String[] sort2 = e1.getKey().split(" ");
                       res = sort1[2].compareTo(sort2[2]);
                   }
                   return res;
               }).forEach(p -> {
                   String[] print = p.getKey().split(" ");
                   System.out.printf("(%s) %s <-> %d%n", print[0], print[1], p.getValue());
               });


    }
}
