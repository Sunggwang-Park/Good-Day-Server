package com.capstone.gooddayserver.domain.user.dto.request;

import com.capstone.gooddayserver.domain.user.entity.User;
import lombok.*;

import java.time.LocalTime;

@Data
@Getter
@Setter
@Builder
public class UserJoinRequestDto {

    private String nickname;
    private String mbti;
    private LocalTime wakeUpTime;
    private LocalTime sleepTime;


    public User toEntity() {
        return User.builder()
                .nickname(nickname)
                .mbti(mbti)
                .wakeUpTime(wakeUpTime)
                .sleepTime(sleepTime)
                .build();
    }




}
