package net.gentledot.myNaver.Dto.request;

public class SearchRequest {
    private String query;
    private Integer display = 10;
    private Integer start = 1;
    private String sort = "sim";

    protected SearchRequest() {
    }

    public SearchRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
