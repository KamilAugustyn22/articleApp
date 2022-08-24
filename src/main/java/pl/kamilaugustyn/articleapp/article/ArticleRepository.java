package pl.kamilaugustyn.articleapp.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT * from article ORDER BY publication_date DESC;", nativeQuery = true)
    List<Article> findAllSortedByPublicationDate();

    @Query("select a from Article a where a.title like %:keyword% or a.content like %:keyword% ")
    List<Article> findAllByKeyword(@Param("keyword") String keyword);

}
