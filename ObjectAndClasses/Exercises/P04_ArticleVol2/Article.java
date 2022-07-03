package ProgrammingFundamentals.ObjectAndClasses.Exercises.P04_ArticleVol2;

public class Article {
    private String title;
    private String content;
    private String author;

    Article(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return String.format("%s - %s: %s", getTitle(), getContent(), getAuthor());
    }
}
