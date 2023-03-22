package blog.demo.common.config;

import blog.demo.search.dto.BlogResultDto;
import blog.demo.search.dto.SearchDto;

import java.net.URI;

public interface SearchProvider {
    URI buildUrI(SearchDto searchDto);
    BlogResultDto find(SearchDto searchDto);
}
