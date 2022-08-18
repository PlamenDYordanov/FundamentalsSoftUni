package ProgrammingFundamentals.MapsMoreEx;

import java.util.*;

public class P05_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<Double>>> dragonMap = new LinkedHashMap<>();
        Map<String, List<Double>> totalPoints = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String type = input[0];
            String name = input[1];
            String damage = input[2];
            String health = input[3];
            String armor = input[4];
            double damageInt = 0;
            double healthInt = 0;
            double armorInt = 0;

            if (damage.contains("null")) {
                damageInt = 45;
            } else {
                damageInt = Double.parseDouble(input[2]);
            }
            if (health.contains("null")) {
                healthInt = 250;
            } else {
                healthInt = Double.parseDouble(input[3]);

            }
            if (armor.contains("null")) {
                armorInt = 10;
            } else {
                armorInt = Double.parseDouble(input[4]);

            }
            totalPoints.putIfAbsent(type, new ArrayList<>());
            if (totalPoints.get(type).size() > 1) {
                double currentDamage = totalPoints.get(type).get(0);
                double currentHeath = totalPoints.get(type).get(1);
                double currentArmor = totalPoints.get(type).get(2);
                totalPoints.get(type).set(0, damageInt + currentDamage);
                totalPoints.get(type).set(1, healthInt + currentHeath);
                totalPoints.get(type).set(2, armorInt + currentArmor);
            } else {
                totalPoints.get(type).add(0, damageInt);
                totalPoints.get(type).add(1, healthInt);
                totalPoints.get(type).add(2, armorInt);
            }

            dragonMap.putIfAbsent(type, new LinkedHashMap<>());
            dragonMap.get(type).putIfAbsent(name, new ArrayList<>());

            dragonMap.get(type).get(name).add(0, damageInt);
            dragonMap.get(type).get(name).add(1, healthInt);
            dragonMap.get(type).get(name).add(2, armorInt);

        }


        List<Integer> indexs = new ArrayList<>();

        for (Map.Entry<String, Map<String, List<Double>>> entry : dragonMap.entrySet()) {
            indexs.add(entry.getValue().size());
        }
        int index = 0;
        for (Map.Entry<String, List<Double>> entry : totalPoints.entrySet()) {
            for (int i = 0; i < entry.getValue().size(); i++) {

                double currentValue = entry.getValue().get(i);
                entry.getValue().set(i, currentValue / indexs.get(index));
            }
            index++;

        }

        System.out.printf("");
    }
}

