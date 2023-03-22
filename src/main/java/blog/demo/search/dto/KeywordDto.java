package blog.demo.search.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class KeywordDto {
    @Schema(description = "인기 검색어", example = "카페")
    private String keyword;

    @Schema(description = "검색 횟수", example = "5")
    private int count;

    public KeywordDto(String keyword, int count) {
        this.keyword = keyword;
        this.count = count;
    }

    public KeywordDto() {}
}
