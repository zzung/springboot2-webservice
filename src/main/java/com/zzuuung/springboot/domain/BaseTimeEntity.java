package com.zzuuung.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/*
*  @MappedSuperclass : JPA Entity 클래스들이 BasedTimeEntity 를 상속할 경우,
*                      필드들 (createdDate, modifiedDate)도 컬럼으로 인식하도록 해줌
*  @EntityListeners(AuditingEntityListener.class) : BasedTimeEntity 클래스에 Auditing 기능 포함시킴
*  @CreatedDate : Entity가 생성되어 저장될때 시간도 자동 저장
*  @LastModifiedDate : Entity의 값을 변경할 때 변경된 시간도 자동 저장
* */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
