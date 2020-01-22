package net.gentledot.myNaver.services;

import net.gentledot.myNaver.Dto.request.SearchRequest;
import net.gentledot.myNaver.common.NaverServiceApi;
import net.gentledot.myNaver.domains.Search;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {

    private final NaverServiceApi naverServiceApi;

    public SearchServiceImpl(NaverServiceApi naverServiceApi) {
        this.naverServiceApi = naverServiceApi;
    }

    @Override
    public ResponseEntity<Search> getSearch(SearchRequest query) {
        return naverServiceApi.requestSearchApi(Search.class, "blog", query);
    }
}
