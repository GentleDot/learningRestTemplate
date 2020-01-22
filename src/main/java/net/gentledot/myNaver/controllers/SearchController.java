package net.gentledot.myNaver.controllers;

import net.gentledot.myNaver.Dto.request.SearchRequest;
import net.gentledot.myNaver.domains.Search;
import net.gentledot.myNaver.services.SearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping(value = "/blog")
    public ResponseEntity<Search> searchKeyword(SearchRequest query){
        return searchService.getSearch(query);
    }

}
