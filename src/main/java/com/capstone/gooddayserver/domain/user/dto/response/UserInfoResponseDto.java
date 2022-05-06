package com.capstone.gooddayserver.domain.user.dto.response;

import com.capstone.gooddayserver.domain.user.entity.User;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Getter
@Setter
@Builder
//@AllArgsConstructor
public class UserInfoResponseDto {

    private String nickname;
    private String mbti;
    private LocalTime wakeUpTime;
    private LocalTime sleepTime;
    private LocalDateTime creaetdDateTime;
    private LocalDateTime modifiedDateTime;

    public static UserInfoResponseDto toDto(User user) {

        return UserInfoResponseDto.builder()
                .nickname(user.getNickname())
                .mbti(user.getMbti())
                .wakeUpTime(user.getWakeUpTime())
                .sleepTime(user.getSleepTime())
                .creaetdDateTime(user.getCreatedDateTime())
                .modifiedDateTime(user.getModifiedDateTime())
                .build();
    }



}
