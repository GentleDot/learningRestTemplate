package net.gentledot.myNaver.Dto.request;

public class SearchRequest {
    private String query;
    private Integer display = 10;
    private Integer start = 1;
    private String sort = "sim";

    public SearchRequest(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }

    public Integer getDisplay() {
        return display;
    }

    public Integer getStart() {
        return start;
    }

    public String getSort() {
        return sort;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
