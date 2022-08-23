package pl.kamilaugustyn.articleapp.article;

import org.springframework.stereotype.Service;
import pl.kamilaugustyn.articleapp.author.Author;
import pl.kamilaugustyn.articleapp.author.AuthorRepository;
import pl.kamilaugustyn.articleapp.magazine.Magazine;
import pl.kamilaugustyn.articleapp.magazine.MagazineRepository;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final AuthorRepository authorRepository;
    private final MagazineRepository magazineRepository;

    public ArticleService(ArticleRepository articleRepository, AuthorRepository authorRepository, MagazineRepository magazineRepository) {
        this.articleRepository = articleRepository;
        this.authorRepository = authorRepository;
        this.magazineRepository = magazineRepository;
    }

    public Article save(Article article){
        Author author = article.getAuthor();
        Magazine magazine = article.getMagazine();
        if(author.getId() > authorRepository.count()){
            authorRepository.save(author);
        }
        if(magazine.getId() > magazineRepository.count()){
            magazineRepository.save(magazine);
        }
        article.setSaveToPersistenceDate();
        return articleRepository.save(article);
    }
}
