package blog.demo.search.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class KakaoBlogDto {

    private List<Documents> documents;
    private Meta meta;

    public KakaoBlogDto() {}

    @Getter
    @Setter
    public static class Documents {
        private String blogname;
        private String contents;
        private String datetime;
        private String thumbnail;
        private String title;
        private String url;
    }

    @Getter
    @Setter
    public static class Meta {
        private boolean is_end;
        private int pageable_count;
        private int total_count;
    }


}
