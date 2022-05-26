package com.capstone.gooddayserver.domain.user.entity;


import com.capstone.gooddayserver.configure.entity.BaseTimeEntity;
import com.capstone.gooddayserver.domain.user.dto.request.UserUpdateRequestDto;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="\"User\"")
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

    public void update(UserUpdateRequestDto dto) {
        if (dto.getNickname() != null) {
            this.nickname = dto.getNickname();
        }
        if (dto.getMbti() != null) {
            this.mbti = dto.getMbti();
        }
        if (dto.getWakeUpTime() != null) {
            this.wakeUpTime = dto.getWakeUpTime();
        }
        if (dto.getSleepTime() != null) {
            this.sleepTime = dto.getSleepTime();
        }
        // JPA의 dirty checking(변경 감지)에 의해서 엔티티의 속성값들이 변하면
        // 변경 쿼리를 자동으로 날려줌
    }

}
