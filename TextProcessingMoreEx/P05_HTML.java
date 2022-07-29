package ProgrammingFundamentals.TextProcessingMoreEx;

import java.util.Scanner;

public class P05_HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println("<h1>");
        System.out.printf("    %s%n",title);
        System.out.println("</h1>");
        System.out.println("<article>");
        String content = scanner.nextLine();
        System.out.printf("    %s%n",content);
        System.out.println("</article>");

        String input = scanner.nextLine();
        while (!input.equals("end of comments")){
            System.out.println("<div>");
            System.out.printf("    %s%n", input);
            System.out.printf("</div>%n");

            input = scanner.nextLine();
        }
    }
}
