package blog.demo.common.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

@WebMvcTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureRestDocs
class EHCacheTest {

//    @MockBean
//    private SearchService searchService;
//
//    @Test
//    public void EHCache_조회_테스트() {
//
//        IntStream.range(0, 5)
//                .forEach(index -> {
//                    Profiler profiler = new Profiler("EHCache-cacheable-test");
//                    profiler.start(String.format("%d번째 호출 수행시간", index + 1));
//
//                    searchService.evictTopKeyword();
//
//                    profiler.stop().print();
//                });
//    }
}