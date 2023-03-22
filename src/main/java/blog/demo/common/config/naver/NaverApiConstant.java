package blog.demo.common.config.naver;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
//@PropertySource("classpath:application.yml")
//@ConfigurationProperties(prefix = "kakaoapi")
@Getter
public class NaverApiConstant {

    @Value("${naverapi.url}")
    private String url;

    @Value("${naverapi.id}")
    private String id;

    @Value("${naverapi.secret}")
    private String secret;
}
