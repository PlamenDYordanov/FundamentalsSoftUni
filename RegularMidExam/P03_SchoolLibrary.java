package ProgrammingFundamentals.RegularMidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> listOfBooks =
                Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());

        String inputLine = scanner.nextLine();
        String bookName = "";

        while (!inputLine.equals("Done")) {
            String[] commands = inputLine.split(" \\| ");
            String command = commands[0];

            switch (command) {
                case "Add Book":
                    bookName = commands[1];
                    getNewListAfterAdd(listOfBooks, bookName);
                    break;
                case "Take Book":
                    bookName = commands[1];
                    getNewListAfterTake(listOfBooks, bookName);
                    break;
                case "Swap Books":

                    String bookName1 = commands[1];
                    String bookName2 = commands[2];
                    getNewListAfterSwap(listOfBooks, bookName1, bookName2);
                    break;
                case "Insert Book":
                    bookName = commands[1];
                    getNewListAfterInsert(listOfBooks, bookName);
                    break;
                case "Check Book":
                    int index = Integer.parseInt(commands[1]);
                    getNewListAfterCheck(listOfBooks, index);
                    break;
            }


            inputLine = scanner.nextLine();
        }
        System.out.println(String.join(", ", listOfBooks));
    }

    private static List<String> getNewListAfterCheck(List<String> listOfBooks, int index) {
        if (index > 0 && index <= listOfBooks.size() - 1) {
            String bookName = listOfBooks.get(index);
            System.out.println(bookName);
        }
        return listOfBooks;
    }

    private static List<String> getNewListAfterInsert(List<String> listOfBooks, String bookName) {
        boolean isExist = false;
        for (String listOfBook : listOfBooks) {
            if (listOfBook.equals(bookName)) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            listOfBooks.add(bookName);
        }
        return listOfBooks;
    }


    private static List<String> getNewListAfterSwap(List<String> listOfBooks, String bookName1, String bookName2) {
        int counter = 0;
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < listOfBooks.size(); i++) {
            if (listOfBooks.get(i).equals(bookName1)) {
                counter++;
                index1 = i;
            }
            if (listOfBooks.get(i).equals(bookName2)) {
                index2 = i;
                counter++;
            }
        }
        if (counter == 2) {
            listOfBooks.set(index2, bookName1);
            listOfBooks.set(index1, bookName2);
        }
        return listOfBooks;
    }

    private static List<String> getNewListAfterTake(List<String> listOfBooks, String bookName) {
        boolean isExist = false;
        for (String listOfBook : listOfBooks) {
            if (listOfBook.equals(bookName)) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            listOfBooks.remove(bookName);
        }
        return listOfBooks;
    }

    private static List<String> getNewListAfterAdd(List<String> listOfBooks, String bookName) {
        boolean isExist = false;
        for (String listOfBook : listOfBooks) {
            if (listOfBook.equals(bookName)) {
                isExist = true;
                break;
            }
        }
        if (!isExist) {
            listOfBooks.add(0, bookName);
        }
        return listOfBooks;
    }
}
