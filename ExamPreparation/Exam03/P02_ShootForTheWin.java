package ProgrammingFundamentals.ExamPreparation.Exam03;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> targetsList = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();
        int shootTargets = 0;
        while (!input.equals("End")) {
            int targetIndex = Integer.parseInt(input);
            if (targetIndex < 0 || targetIndex > targetsList.size() - 1) {
                input = scanner.nextLine();
                continue;
            } else {
                shootTargets++;
                int valueOfCurrentTarget = targetsList.get(targetIndex);
                targetsList.set(targetIndex, -1);
                for (int i = 0; i < targetsList.size(); i++) {
                    if (targetsList.get(i) == -1){
                        continue;
                    }else {
                        if (targetsList.get(i)>valueOfCurrentTarget){
                            targetsList.set(i,targetsList.get(i)-valueOfCurrentTarget);
                        }else if (targetsList.get(i)<=valueOfCurrentTarget){
                            targetsList.set(i,targetsList.get(i)+valueOfCurrentTarget);
                        }
                    }

                }


            }

            input = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ",shootTargets);
        for (Integer integer : targetsList) {
            System.out.printf("%d ",integer);
        }

    }
}
