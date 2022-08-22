package pl.kamilaugustyn.articleapp.article;

import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/findOneByID/{ID}")
    public Article findOne(@PathVariable("ID") long Id){
        Article article = articleRepository.findById(Id);
        return article;
    }

    @GetMapping("/allWithKeyword/{kw}")
    public List<Article> findAllWithKeyword(@PathVariable("kw") String keyword){
        List<Article> allWithKeyword = articleRepository.findAllByKeyword(keyword);
        return allWithKeyword;
    }
}
