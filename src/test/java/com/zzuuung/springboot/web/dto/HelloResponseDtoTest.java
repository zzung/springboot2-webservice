package com.zzuuung.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

/*
* assertThat : assertj 라는 검증 라이브러리의 검증 메소드. 검증하고자 하는 대상을 파라미터로 받음
* isEqualTo  : assertj 의 동등 비교 메소드. assertThat에 있는 값과 isEqualTo의 매개변수 값이 같을때만 성공
*
* assertj의 장점
* - Junit의 assertThat을 사용하게 되면, is()와 같이 추가적인 라이브러리(CoreMatchers)가 필요함
*   But, assertj는 필요 X
* - 확실한 자동 완성 기능 지원
*/

public class HelloResponseDtoTest {

    @Test
    public void lombokTest(){

        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}
