package net.gentledot.myNaver.services;

import net.gentledot.myNaver.domains.Search;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.http.HttpClient;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class SearchServiceImpl implements SearchService {

    @Override
    public ResponseEntity<Search> getSearch(String query) {
        String clientKey = "";
        String serviceKey = "";
        String url = "https://openapi.naver.com/v1/search/blog?query=" + query;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("X-Naver-Client-Id", clientKey)
                .queryParam("X-Naver-Client-Secret", serviceKey)
                .build();    //자동으로 encode해주는 것을 막기 위해 false

        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, Search.class);



    }
}
