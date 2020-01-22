package net.gentledot.myNaver.services;

import net.gentledot.myNaver.domains.Search;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;

@Service
public class SearchServiceImpl implements SearchService {
    @Value("${naver.key.client}")
    String clientKey;
    @Value("${naver.key.service}")
    String serviceKey;

    @Override
    public ResponseEntity<Search> getSearch(String query) {

        String url = "https://openapi.naver.com/v1/search/blog?query=" + query;

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application","json", StandardCharsets.UTF_8));
        headers.add("X-Naver-Client-Id", clientKey);
        headers.add("X-Naver-Client-Secret", serviceKey);

        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(url, HttpMethod.GET, requestEntity, new ParameterizedTypeReference<Search>(){});
    }
}
