package com.capstone.gooddayserver.domain.user.entity;


import com.capstone.gooddayserver.configure.entity.BaseTimeEntity;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "userId")
    private Long id;


    private String nickname;

    private String mbti;

    private LocalTime wakeUpTime;

    private LocalTime sleepTime;

    private int totalScore;

    private String iconUrl;


    //가입일 beginDay : 상속한 BaseTimeEntity 의 createDate

    //최근 업데이트 일시 updDatetime : BaseTimeEntity 의 lastModifiedDate


}
