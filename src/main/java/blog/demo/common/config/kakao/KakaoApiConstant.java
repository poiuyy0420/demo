package blog.demo.common.config.kakao;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class KakaoApiConstant {

    @Value("${kakaoapi.url}")
    private String url;

    @Value("${kakaoapi.token}")
    private String token;
}
