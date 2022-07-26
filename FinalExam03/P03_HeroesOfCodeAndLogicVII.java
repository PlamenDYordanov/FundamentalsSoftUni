package ProgrammingFundamentals.FinalExam03;

import java.util.*;

public class P03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> mapHp = new LinkedHashMap<>();
        Map<String, Integer> mapMana = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int hp = Integer.parseInt(input[1]);
            int mana = Integer.parseInt(input[2]);
            if (!mapHp.containsKey(name)) {
                mapHp.put(name, Math.min(hp, 100));
                mapMana.put(name, Math.min(mana, 200));
            } else {
                int currentHp = mapHp.get(name);
                int currentMana = mapMana.get(name);
                mapHp.put(name, Math.min(currentHp + hp, 100));
                mapMana.put(name, Math.min(currentMana + mana, 200));
            }
        }
        String[] command = scanner.nextLine().split("\\s+-\\s+");
        while (!command[0].equals("End")) {
            String heroName = command[1];
            switch (command[0]) {
                case "CastSpell": {
                    int manaNeeded = Integer.parseInt(command[2]);
                    String spellName = command[3];
                    getNewMapAfterCastSpell(manaNeeded, spellName, mapMana, heroName);
                    break;
                }
                case "TakeDamage":
                    int damage = Integer.parseInt(command[2]);
                    String attacker = command[3];
                    getNewMapAfterTakeDown(damage, attacker, mapHp, heroName,mapMana);
                    break;
                case "Recharge": {
                    int restoreMana = Integer.parseInt(command[2]);
                    getNewMapAfterRechargeMana(restoreMana, mapMana, heroName);
                    break;
                }
                case "Heal":
                    int restoreHeal = Integer.parseInt(command[2]);
                     getNewMapAfterHeal(heroName, restoreHeal, mapHp);

                    break;
            }


            command = scanner.nextLine().split("\\s+-\\s+");
        }
        List<Integer> listOfMana = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : mapMana.entrySet()) {
        listOfMana.add(entry.getValue());
        }
        int index = 0;
        for (Map.Entry<String, Integer> entry : mapHp.entrySet()) {
            System.out.printf("%s%n  HP: %d%n  MP: %d%n",entry.getKey(),entry.getValue(),listOfMana.get(index));
            index++;
        }
    }
    private static Map<String, Integer> getNewMapAfterHeal(String heroName, int restoreHeal, Map<String, Integer> mapHp) {
        int currentHeal = mapHp.get(heroName);
        if (currentHeal + restoreHeal <= 100) {
            mapHp.put(heroName, currentHeal + restoreHeal);
            System.out.printf("%s healed for %d HP!%n", heroName, restoreHeal);
        } else {
            mapHp.put(heroName, 100);
            System.out.printf("%s healed for %d HP!%n", heroName, 100 - currentHeal);
        }
        return mapHp;
    }

    private static Map<String, Integer> getNewMapAfterRechargeMana(int restoreMana, Map<String, Integer> mapMana, String heroName) {
        int currentMana = mapMana.get(heroName);
        if (currentMana + restoreMana <= 200) {
            mapMana.put(heroName, currentMana + restoreMana);
            System.out.printf("%s recharged for %d MP!%n", heroName, restoreMana);
        } else {
            mapMana.put(heroName, 200);
            System.out.printf("%s recharged for %d MP!%n", heroName, 200 - currentMana);
        }
        return mapMana;
    }

    private static Map<String, Integer> getNewMapAfterTakeDown(int damage, String attacker, Map<String, Integer> mapHp, String heroName, Map<String, Integer> mapMana) {
        int currentHeal = mapHp.get(heroName);
        if (currentHeal- damage > 0) {
            mapHp.put(heroName, currentHeal - damage);
            System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, mapHp.get(heroName));
        } else {
            mapHp.remove(heroName);
            mapMana.remove(heroName);
            System.out.printf("%s has been killed by %s!%n", heroName, attacker);
        }
        return mapHp;
    }

    private static Map<String, Integer> getNewMapAfterCastSpell(int manaNeeded, String spellName, Map<String, Integer> mapMana, String heroName) {
        int currentMana = mapMana.get(heroName);
        if (currentMana >= manaNeeded) {
            mapMana.put(heroName, currentMana - manaNeeded);
            System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mapMana.get(heroName));
        } else {
            System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
        }
        return mapMana;
    }
}
