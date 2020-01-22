package net.gentledot.myNaver.common;

import net.gentledot.myNaver.Dto.request.SearchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.nio.charset.StandardCharsets;

@Component
public class NaverServiceApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${naver.key.client}")
    String clientKey;
    @Value("${naver.key.service}")
    String serviceKey;

    public <T> ResponseEntity<T> requestSearchApi(Class<T> responseType, String serviceCategory, SearchRequest query){
        UriComponents requestUrl = UriComponentsBuilder.newInstance()
                            .scheme("https")
                            .host("openapi.naver.com")
                            .path("/v1/search/{category}")
                            .queryParam("query", query.getQuery())
                            .queryParam("display", query.getDisplay())
                            .queryParam("start", query.getStart())
                            .queryParam("sort", query.getSort())
                            .build()
                            .expand(serviceCategory);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        headers.add("X-Naver-Client-Id", clientKey);
        headers.add("X-Naver-Client-Secret", serviceKey);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        logger.info("생성된 URL : {}", requestUrl.toUriString());

        return restTemplate.exchange(requestUrl.toUriString(), HttpMethod.GET, requestEntity, responseType);
    }
}
