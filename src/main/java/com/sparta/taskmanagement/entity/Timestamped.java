package com.sparta.taskmanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 추상클래스의 멤버를 필드로 인식하게 함.
@EntityListeners(AuditingEntityListener.class) // 해당 엔티티 객체의 생성/수정 시간을 자동으로 기록
public abstract class Timestamped {

    @CreatedDate
    @Column(updatable = false) // 최초 생성 시간만 적용하도록
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime created;

    @LastModifiedDate // 변경된 시간
    @Column
    @Temporal(TemporalType.TIMESTAMP) // 날짜 데이터를 매핑할때 사용
    private LocalDateTime modified;
}
