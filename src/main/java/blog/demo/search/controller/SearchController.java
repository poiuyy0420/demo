package blog.demo.search.controller;

import blog.demo.common.domain.BaseResult;
import blog.demo.common.domain.BaseResultFactory;
import blog.demo.search.dto.BlogResultDto;
import blog.demo.search.dto.KeywordDto;
import blog.demo.search.dto.SearchDto;
import blog.demo.search.service.SearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Tag(name = "Search", description = "블로그 Search API")
@RestController
@RequestMapping("/api/blog")
@RequiredArgsConstructor
public class SearchController {

    private final SearchService searchService;

    @Operation(summary = "카카오 블로그 검색", description = "카카오 블로그 검색합니다.")
    @GetMapping(value = "/searchKakao")
    public BaseResult<BlogResultDto> searchKakao(@Valid SearchDto searchDto) {
        return BaseResultFactory.create(searchService.searchKakaoBlog(searchDto));
    }

    @Operation(summary = "네이버 블로그 검색", description = "네이버 블로그 검색합니다.")
    @GetMapping(value = "/searchNaver")
    public BaseResult<BlogResultDto> searchNaver(SearchDto searchDto) {
        return BaseResultFactory.create(searchService.searchNaverBlog(searchDto));
    }

    @GetMapping(value = "/keyword")
    @Operation(summary = "네이버 블로그 검색", description = "사용자들이 많이 검색한 순서대로, 최대 10개의 검색 키워드 제공 합니다.")
    public BaseResult<List<KeywordDto>> keyword() {
        return BaseResultFactory.create(searchService.getTopKeyword());
    }

    @Operation(summary = "네이버 블로그 검색", description = "네이버 블로그 검색합니다.")
    @GetMapping(value = "/search")
    public BaseResult<BlogResultDto> search(SearchDto searchDto) {
        return BaseResultFactory.create(searchService.search(searchDto));
    }

}
