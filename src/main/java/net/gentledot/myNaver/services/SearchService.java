package net.gentledot.myNaver.services;

import net.gentledot.myNaver.Dto.request.SearchRequest;
import net.gentledot.myNaver.domains.Search;
import org.springframework.http.ResponseEntity;

public interface SearchService {
    ResponseEntity<Search> getSearch(SearchRequest query);
}
