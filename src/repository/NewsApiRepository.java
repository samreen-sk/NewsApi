package repository;

import model.Api;
import model.User;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class NewsApiRepository {
    private User user;
    private ArrayList<Api> articles;
    private int nextArticleId;

    public NewsApiRepository(User user) {
        this.user = user;
        this.articles = new ArrayList<Api>();
        this.nextArticleId = 1;
    }

    public void add(String date, String newsWord, String description) {
        int i;

        for (i = 0; i < articles.size(); i++) {
            Api oldApi = articles.get(i);

            if (oldApi.getDate().equals(date) && oldApi.getNewsWord().equals(newsWord)) {
                return;
            }
        }

        Api api = new Api(nextArticleId, date, newsWord, description);
        nextArticleId = nextArticleId + 1;
        articles.add(api);
    }

    public void loadSampleData() {
        add("2026-04-02", "Spring", "Spring framework updates were discussed in the engineering meeting.");
        add("2026-04-01", "SpringBoot", "Spring Boot release notes highlighted easier service configuration.");
        add("2026-04-03", "Java", "Java remained the primary language for the sample news API project.");
        add("2026-04-04", "C program", "C language is fundamentals for programming");
        add("2026-04-05", "DBMS", "DBMS becaomes more important for SDE interview");
        add("2026-04-15", "DBMS", "DBMS becaomes round for SDE interview");
    }

    public int viewByWord(String newsWord) {
        int count = 0;
        int i;

        for (i = 0; i < articles.size(); i++) {
            Api api = articles.get(i);

            if (api.getNewsWord().equals(newsWord)) {
                System.out.println("User: " + user.getName());
                System.out.println("Id: " + api.getId());
                System.out.println("Date: " + api.getDate());
                System.out.println("Keyword: " + api.getNewsWord());
                System.out.println("Description: " + api.getDescription());
                System.out.println();
                count = count + 1;
            }
        }

        return count;
    }

    public int viewByDate(String date) {
        int count = 0;
        int i;

        for (i = 0; i < articles.size(); i++) {
            Api api = articles.get(i);

            if (api.getDate().equals(date)) {
                System.out.println("User: " + user.getName());
                System.out.println("Id: " + api.getId());
                System.out.println("Date: " + api.getDate());
                System.out.println("Keyword: " + api.getNewsWord());
                System.out.println("Description: " + api.getDescription());
                System.out.println();
                count = count + 1;
            }
        }

        return count;
    }

    public int viewDates() {
        Set<String> uniqueDates = new LinkedHashSet<String>();
        int i;

        for (i = 0; i < articles.size(); i++) {
            uniqueDates.add(articles.get(i).getDate());
        }

        for (String date : uniqueDates) {
            System.out.println(date);
        }

        return uniqueDates.size();
    }

    public int viewKeywords() {
        Set<String> uniqueKeywords = new LinkedHashSet<String>();
        int i;

        for (i = 0; i < articles.size(); i++) {
            uniqueKeywords.add(articles.get(i).getNewsWord());
        }

        for (String keyword : uniqueKeywords) {
            System.out.println(keyword);
        }

        return uniqueKeywords.size();
    }
}
