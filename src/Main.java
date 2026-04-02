
import model.User;
import repository.NewsApiRepository;
import service.NewsService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        User user = new User(1, "Samreen");
        NewsApiRepository repository = new NewsApiRepository(user);
        NewsService service = new NewsService(repository);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. View by keyword");
            System.out.println("2. View by date");
            System.out.println("3. View all dates");
            System.out.println("4. View all keywords");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int n = scanner.nextInt();
            scanner.nextLine();

            switch (n) {
                case 1:
                    System.out.print("Enter keyword: ");
                    String word = scanner.nextLine();
                    int byWordCount = service.viewByword(word);
                    System.out.println("Matched articles: " + byWordCount);
                    if(byWordCount==0){
                        System.out.println("No Article found");
                    }
                    break;

                case 2:
                    System.out.print("Enter date: ");
                    String date = scanner.nextLine();
                    int byDateCount = service.viewByDate(date);
                    System.out.println("Matched articles: " + byDateCount);
                    if (byDateCount == 0) {
                        System.out.println("No Article found");
                    }
                    break;

                case 3:
                    int dateCount = service.viewDates();
                    System.out.println("Total dates: " + dateCount);
                    break;

                case 4:
                    int keywordCount = service.viewKeywords();
                    System.out.println("Total keywords: " + keywordCount);
                    break;

                case 5:
                    System.out.println("Exit");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option");
            }

            System.out.println();
        }
    }
}
