package pl.kamilaugustyn.articleapp.article;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ArticleController {
    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    public ArticleController(ArticleRepository articleRepository, ArticleService articleService) {
        this.articleRepository = articleRepository;
        this.articleService = articleService;
    }
    @GetMapping("/all")
    public List<Article> findAllSortedByPublicationDate(){
        return articleRepository.findAllSortedByPublicationDate();
    }
    @GetMapping
    public Article findById(@RequestParam long id){
        Optional<Article> first = articleRepository.findAll().stream()
                .filter(element -> element.getId() == id).findFirst();
        return first.get();
    }

    @GetMapping("/allWithKeyword/{kw}")
    public List<Article> findAllWithKeyword(@PathVariable("kw") String keyword){
        return articleRepository.findAllByKeyword(keyword);
    }


    @PostMapping
    public Article saveArticle(@RequestBody Article article){
        return articleService.save(article);
    }

    @PutMapping
    public Article updateArticle(@RequestBody Article article){
        return articleRepository.save(article);
    }
    @Transactional
    @DeleteMapping
    public boolean deleteArticle(@RequestParam long id){
        return articleRepository.findAll().removeIf(element -> element.getId() == id);
    }


}
