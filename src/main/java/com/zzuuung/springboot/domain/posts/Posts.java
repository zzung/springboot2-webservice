package com.zzuuung.springboot.domain.posts;

import com.zzuuung.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

/*
* @Entity : 실제 DB의 테이블과 매칭될 클래스
*
* @Id : 해당 테이블의 PK 필드
*
* @GeneratedValue : PK의 생성 규칙을 나타냄
*  - GenerationType.IDENTITY 옵션을 추가해야만 auto_increment 가 가능
*  - PK 로 Long 타입 주로 사용. 유니크 키나 복합키를 PK로 지정하는 경우 수정해야할 상황이 많음
*
* @Column : 테이블 컬럼을 나타냄, 기본값 외에 추가적으로 변경을 하고자 할때 주로 사용
*  - 문자열 기본값인 Varchar(255)를 500으로 늘리고 싶거나, 타입을 변경하고자 할때 사용
*
* @Builder : 해당 클래스의 빌더 패턴 클래스 생성
*  - 생성자 상단에 선언시, 생성자에 포함된 필드만 빌더에 포함
* */
@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }


}
