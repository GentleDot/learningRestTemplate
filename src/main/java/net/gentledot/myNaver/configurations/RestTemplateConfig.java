package net.gentledot.myNaver.configurations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Configuration
public class RestTemplateConfig {
    @Value("${naver.key.client}")
    String clientKey;
    @Value("${naver.key.service}")
    String serviceKey;

    @Bean
    public RestTemplate setRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public HttpEntity<String> setNaverOpenApiHttpEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        headers.add("X-Naver-Client-Id", clientKey);
        headers.add("X-Naver-Client-Secret", serviceKey);
        return new HttpEntity<>(headers);
    }
}
