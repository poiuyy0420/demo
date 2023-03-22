package blog.demo.search.repository;

import blog.demo.search.domain.Keyword;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//@ExtendWith(SpringExtension.class)
//@ExtendWith(MockitoExtension.class)
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)

//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

@ExtendWith(MockitoExtension.class)
public class KeywordRepositoryTest {

    @Mock
    private EntityManager entityManagr;

    @Mock
    private KeywordRepository keywordRepository;

    @Test
    void findTop10ByOrderByCountDesc() {
        var keyword1= createKeyword("카페", 5);
        var keyword2 = createKeyword("맛집", 3);
        var keyword3 = createKeyword("날씨", 7);

        var result = keywordRepository.findTop10ByOrderByCountDesc();

        assertEquals(3, result.size());
        assertEquals(keyword1, result.get(0));
        assertEquals(keyword2, result.get(1));
        assertEquals(keyword3, result.get(3));
    }

    @Test
    void findByKeyword() {
        var key = Keyword.builder().keyword("허쉬").count(5).build();
        keywordRepository.save(key);
        Optional<Keyword> result = keywordRepository.findByKeyword("허쉬");

        assertTrue(result.isPresent());
        assertEquals(key, result.get());
    }


    public Keyword createKeyword(String keyword, int count) {
        var key = Keyword.builder().keyword(keyword).count(count).build();
        keywordRepository.save(key);
        return key;
    }

    @AfterEach
    public void teardown() {
        this.keywordRepository.deleteAll();
        this.entityManagr
                .createNativeQuery("ALTER TABLE keyword ALTER COLUMN `id` RESTART WITH 1")
                .executeUpdate();
    }

}