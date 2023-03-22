package blog.demo.common.config.kakao;

import blog.demo.common.config.SearchProvider;
import blog.demo.search.dto.BlogResultDto;
import blog.demo.search.dto.KakaoBlogDto;
import blog.demo.search.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Component
public class KakaoBlogApi implements SearchProvider {

    private final KakaoApiConstant kakaoApiConstant;
    private final WebClient webClient;

    @Override
    public URI buildUrI(SearchDto request) {
        final UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString(kakaoApiConstant.getUrl())
                .queryParam("query", request.getQuery())
                .queryParam("page", Optional.ofNullable(request.getPage()))
                .queryParam("size", Optional.ofNullable(request.getSize()))
                .queryParam("sort", Optional.ofNullable(request.getSort()));

        log.debug("uriComponentsBuilder = {}", uriComponentsBuilder.encode().build().toUri());

        return uriComponentsBuilder.encode().build().toUri();
    }

    @Override
    public BlogResultDto find(SearchDto request) {
        KakaoBlogDto blogResponseFlux = webClient.get()
                .uri(uriBuilder -> buildUrI(request))
                .header(HttpHeaders.AUTHORIZATION, kakaoApiConstant.getToken())
                .retrieve()
                .bodyToMono(KakaoBlogDto.class)
                .block();

        return new BlogResultDto(blogResponseFlux);
    }


}
