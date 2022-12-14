package pl.kamilaugustyn.articleapp.article;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kamilaugustyn.articleapp.author.Author;
import pl.kamilaugustyn.articleapp.magazine.Magazine;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Setter
@Getter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private Date publicationDate;
    @ManyToOne
    private Magazine magazine;
    @ManyToOne
    private Author author;
    private Timestamp saveToPersistenceDate;

    public void setSaveToPersistenceDate() {
        this.saveToPersistenceDate = new Timestamp(System.currentTimeMillis());
    }
}
