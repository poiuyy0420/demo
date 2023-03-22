package blog.demo.common.config.naver;

import blog.demo.common.code.SortingType;
import blog.demo.common.config.SearchProvider;
import blog.demo.search.dto.BlogResultDto;
import blog.demo.search.dto.NaverBlogDto;
import blog.demo.search.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class NaverBlogApi implements SearchProvider {

    private final NaverApiConstant naverApiConstant;
    private final WebClient webClient;

    @Override
    public URI buildUrI(SearchDto request) {
        String display;
        if(SortingType.ACC.getValue().equals(request.getSort())) {
            display = SortingType.SIM.getValue();
        } else {
            display = SortingType.DATE.getValue();
        }

        final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(naverApiConstant.getUrl())
                .queryParam("query", request.getQuery())
                .queryParam("start", Optional.ofNullable(request.getPage()))
                .queryParam("display", Optional.ofNullable(request.getSize()))
                .queryParam("sort", Optional.ofNullable(display));

        return uriComponentsBuilder.encode().build().toUri();
    }

    @Override
    public BlogResultDto find(SearchDto request) {
        NaverBlogDto blogResponseFlux = webClient.get()
                .uri(uriBuilder -> buildUrI(request))
                .header("X-Naver-Client-Id1", naverApiConstant.getId())
                .header("X-Naver-Client-Secret", naverApiConstant.getSecret())
                .retrieve()
                .bodyToMono(NaverBlogDto.class)
                .block();

        return new BlogResultDto(blogResponseFlux);
    }

}
