package com.zzuuung.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

/*
 * @RunWith : 테스트를 진행할 때 , 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 해줌
 *      --> SpringRunner가 스프링 실행자
 *
 * @WebMvcTest : 여러 테스트 어노테이션중에서 web에 집중 할 수 있는 어노테이션
 *      --> JPA 기능이 작동하지 않음, 외부 연동과 관련된 부분만 활성화됨
 *      --> JPA 기능까지 한번에 테스트 할 때는 @SpringBootTest, @TestRestTemplate 사용 !
 *      --> @Controller, @ControllerAdvice 사용 O
 *      --> @Service, @Component, @Repository 사용 X
 *
 * @Autowired : Bean 주입 받기
 *
 * private MockMvc mvc : 웹 API 테스트할 떄 사용, HTTP GET, POST 등에 대한 테스트 가능
 *
 * mvc.perform(get("/hello")) : MockMvc를 통해 /hello 주소로 get 요청 보냄
 * .andExpect(status().isOk()): mvc.perform의 결과 검증 + Http Header의 상태가 200(OK)인지 확인
 * .andExpect(content().string(hello)) : Controller에서 "hello" 리턴해줌 -> 이 값과 응답 결과가 일치하는지 검증
 * -------------------------------------------------------------------------------------
 *
 * param : API 테스트할 때 사용될 요청 파라미터 설정 , String 만 가능 !
 *         숫자/날짜 등을 사용하고자 할때 문자열로 변경 해야함
 * jsonPath : JSON 응답값을 필드별로 검증할 수 있는 메소드
 *           $ 를 기준으로 필드명 명시 (ex. $.name $.amount)
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void returnHello() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

    @Test
    public void returnHelloDto() throws Exception {
        String name = "hello";
        int amount = 2000;

        mvc.perform(get("/hello/dto")
                .param("name",name)
                .param("amount", String.valueOf(amount)))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.name", is(name)))
                    .andExpect(jsonPath("$.amount", is(amount)));
    }

}
