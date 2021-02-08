package com.zzuuung.springboot.service.posts;

import com.zzuuung.springboot.domain.posts.PostsRepository;
import com.zzuuung.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/*
* Service : 트랜젝션 , 도메인 간의 순서만 보장해주는 역할.
*/
@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
}
