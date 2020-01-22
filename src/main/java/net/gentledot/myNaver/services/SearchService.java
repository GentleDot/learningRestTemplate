package net.gentledot.myNaver.services;

import net.gentledot.myNaver.domains.Search;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.List;

public interface SearchService {
    ResponseEntity<Search> getSearch(String query);
}
