package com.zzuuung.springboot.web.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class IndexControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void loadToMain() {
        //when --> "/"로 호출했을 때 index.mustache에 포함된 코드들이 있나 확인
        String body = this.restTemplate.getForObject("/", String.class);

        //then --> 전체 코드 모두 검증 x, 문자열이 포함되어 있는 지만 비교
        assertThat(body).contains("스프링 부트로 시작하는 웹 서비스");
    }
}
