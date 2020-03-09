package net.gentledot.myNaver.common;

import net.gentledot.myNaver.Dto.request.SearchRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Component
public class NaverServiceApi {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final HttpEntity<String> httpEntity;
    private final RestTemplate restTemplate;

    public NaverServiceApi(HttpEntity<String> httpEntity, RestTemplate restTemplate) {
        this.httpEntity = httpEntity;
        this.restTemplate = restTemplate;
    }

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

        logger.debug("생성된 URL : {}", requestUrl.toUriString());
        return restTemplate.exchange(requestUrl.toUriString(), HttpMethod.GET, httpEntity, responseType);
    }
}
