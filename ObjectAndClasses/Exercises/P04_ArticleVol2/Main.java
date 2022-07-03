package ProgrammingFundamentals.ObjectAndClasses.Exercises.P04_ArticleVol2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Article> articleList = new ArrayList<>();

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= lines; i++) {

            String input = scanner.nextLine();
            String title = input.split(", ")[0];
            String content = input.split(", ")[1];
            String author = input.split(", ")[2];

            Article articleObj = new Article(title, content, author);

            articleList.add(articleObj);

            System.out.println(articleObj);
        }
        String inputs = (scanner.nextLine());

    }
}
