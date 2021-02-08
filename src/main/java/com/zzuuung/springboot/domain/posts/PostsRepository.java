package com.zzuuung.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
* 인터페이스 생성 후, JpaRepository<Entity 클래스, PK 타입>을 상속하면 기본적인 CRUD 메소드가 자동으로 생성됨
* @Repository 어노테이션 추가하지 않아도 됨
* Entity 클래스와 기본 Entity Repository 는 함께 위치해야함
* */
public interface PostsRepository extends JpaRepository<Posts,Long> {
}
