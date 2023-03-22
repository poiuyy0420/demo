package blog.demo.search.dto;

import blog.demo.common.code.SortingType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class SearchDto {

    @Schema(description = "검색 키워드", example = "카페", required = true)
    private final String query;

    @Schema(description = "결과 페이지 번호, 1~50 사이의 값, 기본 값 1", example = "1", required = false)
    private final Integer page;

    @Schema(description = "한 페이지에 보여질 문서 수, 1~50 사이의 값, 기본 값 10", example = "10", required = false)
    private final Integer size;

    @Schema(description = "정렬 방식, ACC(정확도순) 또는 REC(최신순), 기본 값 ACC", example = "ACC", required = false)
    private final String sort;

    @Builder
    public SearchDto(final String query, final Integer page, final Integer size, final SortingType sort) {
        this.query = query;
        this.page = page == null ? 1 : page;
        this.size = size == null ? 10 : size;
        this.sort = (sort == null) ? SortingType.ACC.getValue() : sort.getValue();
    }


}
