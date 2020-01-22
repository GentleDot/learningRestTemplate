package net.gentledot.myNaver.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Search {
    /*
    lastBuildDate	datetime	검색 결과를 생성한 시간이다.
    total	integer	검색 결과 문서의 총 개수를 의미한다.
    start	integer	검색 결과 문서 중, 문서의 시작점을 의미한다.
    display	integer	검색된 검색 결과의 개수이다.
    item/items	-	XML 포멧에서는 item 태그로, JSON 포멧에서는 items 속성으로 표현된다. 개별 검색 결과이며 title, link, description, bloggername, bloggerlink을 포함한다.
    */

    private Date lastBuildDate;

    private Integer total;

    private Integer start;

    private Integer display;

    private List<Items> items;

    protected Search() {}
}
