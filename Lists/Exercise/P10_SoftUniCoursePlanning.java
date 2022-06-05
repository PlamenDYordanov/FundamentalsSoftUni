package PlamenListExercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class P10_SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listCourses = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String command = scanner.nextLine();

        int counter = 0;
        while (!command.equals("course start")) {

            List<String> listCommand = Arrays.stream(command.split(":")).collect(Collectors.toList());

            switch (listCommand.get(0)) {
                case "Add":
                    if (listCourses.contains(listCommand.get(1))) {
                        break;
                    } else {
                        listCourses.add(listCommand.get(1));
                    }
                    break;
                case "Insert":
                    if (listCourses.contains(listCommand.get(1))) {
                        break;
                    } else {
                        int index = Integer.parseInt(listCommand.get(2));
                        if (index >= 0 && index <= listCourses.size() - 1) {
                            listCourses.add(index, listCommand.get(1));
                        }
                    }
                    break;
                case "Remove":
                    if (listCourses.contains(listCommand.get(1))) {
                        int indexForRemove = listCourses.indexOf(listCommand.get(1));
                        int indexForRemoveExercise = listCourses.indexOf(listCommand.get(1) + "-Exercise");
                        if (indexForRemoveExercise >= 0) {
                            listCourses.remove(indexForRemoveExercise);
                        }
                        listCourses.remove(indexForRemove);
                    }
                    break;
                case "Swap":
                    if (listCourses.contains(listCommand.get(1)) && listCourses.contains(listCommand.get(2))) {


                        int indexFirstCourse = listCourses.lastIndexOf(listCommand.get(1));
                        int indexSecondCourse = listCourses.lastIndexOf(listCommand.get(2));


                        listCourses.set(indexSecondCourse, listCommand.get(1));
                        listCourses.set(indexFirstCourse, listCommand.get(2));
                        int indexFirstCourseExercise = listCourses.lastIndexOf(listCommand.get(1) + "-Exercise");
                        int indexSecondCourseExercise = listCourses.lastIndexOf(listCommand.get(2) + "-Exercise");
                        if (indexFirstCourseExercise >= 0 && indexSecondCourseExercise >= 0) {
                            String firstExercise = listCourses.get(indexFirstCourseExercise);
                            String secondExercise = listCourses.get(indexSecondCourseExercise);
                            listCourses.remove(indexFirstCourseExercise);
                            indexSecondCourseExercise = listCourses.lastIndexOf(listCommand.get(2) + "-Exercise");
                            listCourses.remove(indexSecondCourseExercise);
                            listCourses.add(indexFirstCourse + 1, secondExercise);
                            listCourses.add(indexSecondCourse + 1, firstExercise);
                        } else if (indexFirstCourseExercise >= 0) {
                            String firstExercise = listCourses.get(indexFirstCourseExercise);
                            listCourses.remove(indexFirstCourseExercise);
                            indexFirstCourse = listCourses.lastIndexOf(listCommand.get(1));
                            listCourses.add(indexFirstCourse + 1, firstExercise);
                        } else if (indexSecondCourseExercise >= 0) {
                            String secondExercise = listCourses.get(indexSecondCourseExercise);
                            listCourses.remove(indexSecondCourseExercise);
                            indexSecondCourse = listCourses.lastIndexOf(listCommand.get(2));
                            listCourses.add(indexSecondCourse + 1, secondExercise);
                        }
                    }
                    break;
                case "Exercise":
                    if (listCourses.contains(listCommand.get(1) + "-Exercise")) {
                        break;
                    }
                    if (listCourses.contains(listCommand.get(1))) {
                        int indexOfCourse = listCourses.indexOf(listCommand.get(1));
                        listCourses.add(indexOfCourse + 1, listCommand.get(1) + "-Exercise");
                    } else {
                        listCourses.add(listCommand.get(1));
                        listCourses.add(listCommand.get(1) + "-Exercise");
                    }


                    break;
            }
            counter = 0;
            command = scanner.nextLine();
        }
        printingOutput(listCourses);
    }

    public static void printingOutput(List<String> listOutput) {
        int counter = 0;
        for (String elements : listOutput) {
            counter++;
            System.out.printf("%d.%s%n", counter, elements);
        }
    }
}
