package blog.demo.common.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@OpenAPIDefinition(info = @Info(title = "Blog Search API", description = "블로그 검색 서비스 API 명세서", version = "v1"))
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi chatOpenApi() {
        String[] paths = {"/api/blog/**"};

        return GroupedOpenApi.builder()
                .group("블로그 검색 서비스 API v1")
                .pathsToMatch(paths)
                .build();
    }
}
