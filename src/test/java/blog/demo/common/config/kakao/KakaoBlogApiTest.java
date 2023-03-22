package blog.demo.common.config.kakao;

import blog.demo.common.code.SortingType;
import blog.demo.search.dto.SearchDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@WebMvcTest
@ExtendWith(MockitoExtension.class)
@AutoConfigureRestDocs
class KakaoBlogApiTest {

    @MockBean
    private KakaoApiConstant kakaoApiConstant;

    @MockBean
    private WebClient webClient;

    @MockBean
    private MockMvc mockMvc;

    @Test
    void buildUrI() throws Exception {
        SearchDto searchDto = new SearchDto("카페", 1, 10, SortingType.ACC);
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(kakaoApiConstant.getUrl())
                .queryParam("query", searchDto.getQuery())
                .queryParam("page", searchDto.getPage())
                .queryParam("size", searchDto.getSize())
                .queryParam("sort", searchDto.getSort());
    }

    @Test
    void find() {
    }
}