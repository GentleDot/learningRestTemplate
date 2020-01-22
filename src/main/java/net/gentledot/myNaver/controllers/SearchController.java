package net.gentledot.myNaver.controllers;

import net.gentledot.myNaver.domains.Search;
import net.gentledot.myNaver.services.SearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/search")
public class SearchController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/blog")
    public ResponseEntity<Search> searchKeyword(@RequestParam String query){
        return searchService.getSearch(query);
    }

/*    @GetMapping(value = "test")
    public String searchKeywordAndPrintString(HttpServletRequest request, @RequestParam String query) throws IOException {
        String clientKey = "";
        String serviceKey = "";
        String urlStr = "https://openapi.naver.com/v1/search/blog.json?" + request.getQueryString();
        logger.info("URL 확인 : {}", urlStr);

        URL url = new URL(urlStr);
        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("X-Naver-Client-Id", clientKey);
        con.setRequestProperty("X-Naver-Client-Secret", serviceKey);
        int responseCode = con.getResponseCode();

        BufferedReader br;
        if(responseCode==200) { // 정상 호출
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        } else {  // 에러 발생
            br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
        }
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = br.readLine()) != null) {
            response.append(inputLine);
        }
        br.close();
        return response.toString();
    }*/

    /*@GetMapping(value = "/news.json")
    public Search searchNews(HttpServletRequest request, @RequestParam String query){
        return searchService.getSearch(request.getRequestURL().append("?").append(request.getQueryString()).toString(), query);
    }*/
}
