package com.zzuuung.springboot.web.dto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    // 머스테치 스타터의 역할로 컨트롤러에서 문자열을 반환할때 앞에는 경로, 뒤에는 확장자 자동 지정됨
    @GetMapping("/")
    public String index(){
        return "index"; // src/main/resources/templates/index.mustache 로 전환되서 view resolver가 처리
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
