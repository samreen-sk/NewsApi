package service;

import repository.NewsApiRepository;

public class NewsService {
    private final NewsApiRepository newsApiRepository;

    public NewsService(NewsApiRepository newsApiRepository) {
        this.newsApiRepository = newsApiRepository;
    }

    public int viewByword(String newsWord) {
        newsApiRepository.loadSampleData();
        return newsApiRepository.viewByWord(newsWord);
    }

    public int viewByDate(String date) {
        newsApiRepository.loadSampleData();
        return newsApiRepository.viewByDate(date);
    }

    public int viewDates() {
        newsApiRepository.loadSampleData();
        return newsApiRepository.viewDates();
    }

    public int viewKeywords() {
        newsApiRepository.loadSampleData();
        return newsApiRepository.viewKeywords();
    }
}
