package model;

public class Api {
    private int id;
    private String date;
    private String newsWord;
    private String description;

    public Api(int id, String date, String newsWord, String description) {
        this.id = id;
        this.date = date;
        this.newsWord = newsWord;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getNewsWord() {
        return newsWord;
    }

    public String getDescription() {
        return description;
    }
}
