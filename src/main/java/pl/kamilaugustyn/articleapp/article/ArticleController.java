package pl.kamilaugustyn.articleapp.article;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }
    @GetMapping("/all")
    public List<Article> findAllSortedByPublicationDate(){
        List<Article> articles = articleRepository.findAllSortedByPublicationDate();
        return articles;
    }
}
