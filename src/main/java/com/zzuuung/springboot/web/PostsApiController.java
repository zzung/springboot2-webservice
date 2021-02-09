package com.zzuuung.springboot.web;

import com.zzuuung.springboot.service.posts.PostsService;
import com.zzuuung.springboot.web.dto.PostsResponseDto;
import com.zzuuung.springboot.web.dto.PostsSaveRequestDto;
import com.zzuuung.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/*
* @RequiredArgsConstructor : final 이 선언된 모든 필드를 인자값으로 하는 생성자를 대신 만들어줌.
*  - @Autowired 로 생성자 주입 받는 방법 사용하지 X
*  - 생성자를 직접 안쓰고 롬복 어노테이션을 사용 하는 이유 : 해당 클래스의 의존성 관계가 변경될 때 마다
*    생성자 코드를 계속 수정해야하는 번거로움을 줄여줌
* */

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id) {
        return postsService.findById(id);
    }


}
