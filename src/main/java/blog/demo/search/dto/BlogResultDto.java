package blog.demo.search.dto;

import blog.demo.common.page.Pagination;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class BlogResultDto {

    @Schema(description = "블로그 리스트 정보", required = true)
    private List<BlogDocuments> documents;

    @Schema(description = "Pagination 정보", required = true)
    private BlogMeta meta;

    public BlogResultDto() {

    }

    @Getter
    @Setter
    @Builder
    public static class BlogDocuments {

        @Schema(description = "블로그 이름", example = "hj 블로그")
        private String blogname;

        @Schema(description = "블로그 글 요약", example = "블로그 글 요약..")
        private String contents;

        @Schema(description = "블로그 작성날짜", example = "2023-03-30")
        private String postDate;

        @Schema(description = "블로그 썸네일", example = "https://search2.kakaocdn.net/argon/130x130_85_c/H4bzYhipCmw")
        private String thumbnail;

        @Schema(description = "블로그 제목", example = "오늘의 집짓기")
        private String title;

        @Schema(description = "블로그 URL", example = "http://e-depot.kr/1864")
        private String url;

    }

    @Getter
    @Setter
    @Builder
    public static class BlogMeta {
        @Schema(description = "현재 페이지가 마지막 페이지인지 여부", example = "false")
        private boolean isEnd;

        @Schema(description = "검색된 문서 수", example = "120")
        private int totalPage;
    }


    public BlogResultDto(KakaoBlogDto blogDto) {
        this.meta = BlogMeta.builder()
                .isEnd(blogDto.getMeta().is_end())
                .totalPage(blogDto.getMeta().getTotal_count()).build();
        this.documents = blogDto.getDocuments().stream().map(item ->
                BlogDocuments.builder()
                        .blogname(item.getBlogname())
                        .contents(item.getContents())
                        .postDate(item.getDatetime())
                        .thumbnail(item.getThumbnail())
                        .title(item.getTitle())
                        .url(item.getUrl())
                        .build()).collect(Collectors.toList());
    }

    public BlogResultDto(NaverBlogDto blogDto) {
        Pagination pagination = new Pagination(blogDto.getTotal(), blogDto.getStart());
        this.meta = BlogMeta.builder()
                .isEnd(pagination.getEndPage() == blogDto.getTotal())
                .totalPage(blogDto.getTotal()).build();

        this.documents = blogDto.getItems().stream().map(item ->
                BlogDocuments.builder()
                        .blogname(item.getBloggername())
                        .contents(item.getDescription())
                        .postDate(item.getPostdate())
                        .title(item.getTitle())
                        .url(item.getLink())
                        .build()).collect(Collectors.toList());
    }


}
