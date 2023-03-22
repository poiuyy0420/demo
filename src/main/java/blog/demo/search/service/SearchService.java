package blog.demo.search.service;

import blog.demo.common.config.kakao.KakaoBlogApi;
import blog.demo.common.config.naver.NaverBlogApi;
import blog.demo.search.domain.Keyword;
import blog.demo.search.dto.BlogResultDto;
import blog.demo.search.dto.KeywordDto;
import blog.demo.search.dto.SearchDto;
import blog.demo.search.repository.KeywordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SearchService {

    public static final String TOP_KEYWORDS_CACHE = "topKeyword";

    private final KakaoBlogApi kakaoBlogApi;
    private final NaverBlogApi naverBlogApi;
    private final KeywordRepository keywordRepository;


    public BlogResultDto searchKakaoBlog (SearchDto searchDto) {
        updateKeyword(searchDto.getQuery());
        return kakaoBlogApi.find(searchDto);
    }

    public BlogResultDto searchNaverBlog (SearchDto searchDto) {
        updateKeyword(searchDto.getQuery());
        return naverBlogApi.find(searchDto);
    }

    @Transactional
    public void updateKeyword(String keyword) {
        Keyword entity;
        Optional<Keyword> keywordEntityOptional = keywordRepository.findByKeyword(keyword);
        if (keywordEntityOptional.isPresent()) {
            entity = keywordEntityOptional.get();
            entity.keywordUpdate();
        } else {
            entity = Keyword.builder()
                    .keyword(keyword).count(1).build();
        }
        keywordRepository.save(entity);
    }

    @Cacheable(value = TOP_KEYWORDS_CACHE, unless = "#result == null || #result.empty")
    public List<KeywordDto> getTopKeyword() {
        List<Keyword> topKeywordList = keywordRepository.findTop10ByOrderByCountDesc();
        return topKeywordList.stream()
                .map(keyword -> new KeywordDto(keyword.getKeyword(), keyword.getCount()))
                .collect(Collectors.toList());
    }

    @Scheduled(fixedRate = 60000)
    @CacheEvict(value = TOP_KEYWORDS_CACHE, allEntries = true)
    public void evictTopKeyword() {
        // 1분마다 캐시를 지운다.
    }

}
