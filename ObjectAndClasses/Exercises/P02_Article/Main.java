package ProgrammingFundamentals.ObjectAndClasses.Exercises.P02_Article;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String title = input.split(", ")[0];
        String content = input.split(", ")[1];
        String author = input.split(", ")[2];
        Article article = new Article(title,content,author);

        int numberOfManipulation = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfManipulation; i++) {
            String inputLine = scanner.nextLine();
            String command = inputLine.split(": ")[0];
            switch (command){
                case "Edit":
                    String newContent = inputLine.split(": ")[1];
                    getArticleAfterEdit(article, newContent);
                    break;
                case "ChangeAuthor":
                    String newAuthor= inputLine.split(": ")[1];
                    getArticleAfterChangeAuthor(article,newAuthor);
                    break;
                case "Rename":
                    String newTitle = inputLine.split(": ")[1];
                    getArticleAfterRename(article,newTitle);
                    break;
            }
        }
        System.out.println(article.toString());
    }

    private static void getArticleAfterRename(Article article, String newTitle) {
        article.setTitle(newTitle);
    }

    private static void getArticleAfterChangeAuthor(Article article, String newAuthor) {
        article.setAuthor(newAuthor);
    }

    private static void getArticleAfterEdit(Article article, String newContent) {
        article.setContent(newContent);
    }
}
