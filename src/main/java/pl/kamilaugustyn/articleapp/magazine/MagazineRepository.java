package pl.kamilaugustyn.articleapp.magazine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MagazineRepository extends JpaRepository<Magazine, Long> {
}
