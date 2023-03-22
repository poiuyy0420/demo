package blog.demo.search.repository;


import blog.demo.search.domain.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KeywordRepository extends JpaRepository<Keyword, Long> {

    List<Keyword> findTop10ByOrderByCountDesc();
    Optional<Keyword> findByKeyword(String keyword);


}
