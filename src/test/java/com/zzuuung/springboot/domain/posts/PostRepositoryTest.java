package com.zzuuung.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

/*
* @After : Junit 에서 단위 테스트가 끝날 때 마다 수행되는 메소드 지정
*
* postsRepository.save : posts 테이블에 insert/update 쿼리 실행
*                        id 값이 있으면 -> update, 없으면 -> insert
*
* postsRepository.findAll : posts 테이블에 있는 모든 데이터 조회
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void selectBoardList() {
        //given
        String title = "테스트 게시글 제목 입니다~";
        String content = "테스트 본문 !";

        postsRepository.save(Posts.builder()
            .title(title)
            .content(content)
            .author("zzuuung")
            .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void saveBaseTimeEntity() {
        //given
        LocalDateTime now = LocalDateTime.of(2020,2,9,0,0,0);
        postsRepository.save(Posts.builder()
        .title("title")
        .content("content")
        .author("author")
        .build());

        //when
        List<Posts> postsList = postsRepository.findAll();

        //then
        Posts posts = postsList.get(0);

        System.out.println(">>>>>>> creatdDate = "+posts.getCreatedDate()+", modifiedDate = "+posts.getModifiedDate());

        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
