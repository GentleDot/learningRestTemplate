package net.gentledot.myNaver.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class Items {
    /*
    title	string	검색 결과 문서의 제목을 나타낸다. 제목에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
    link	string	검색 결과 문서의 하이퍼텍스트 link를 나타낸다.
    description	string	검색 결과 문서의 내용을 요약한 패시지 정보이다. 문서 전체의 내용은 link를 따라가면 읽을 수 있다. 패시지에서 검색어와 일치하는 부분은 태그로 감싸져 있다.
    bloggername	string	검색 결과 블로그 포스트를 작성한 블로거의 이름이다.
    bloggerlink	string	검색 결과 블로그 포스트를 작성한 블로거의 하이퍼텍스트 link이다.
    postdate	datetime	블로그 포스트를 작성한 날짜이다.
    */

    private String title;

    private String link;

    private String description;

    private String bloggername;

    private String bloggerlink;

    private Date postdate;

    protected Items() {}
}
