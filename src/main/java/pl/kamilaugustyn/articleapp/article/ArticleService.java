package pl.kamilaugustyn.articleapp.article;

import org.springframework.stereotype.Service;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article save(Article article){
        article.setSaveToPersistenceDate();

        return articleRepository.save(article);
    }
}
