package blog.demo.search.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class NaverBlogDto {

    private String lastBuildDate;
    private int total;
    private int start;
    private int display;
    private List<NaverDocument> items;
    private Boolean is_end;

    public NaverBlogDto() {}

    @Getter
    @Setter
    public static class NaverDocument {
        private String title;
        private String link;
        private String description;
        private String bloggername;
        private String bloggerlink;
        private String postdate;
    }

}
