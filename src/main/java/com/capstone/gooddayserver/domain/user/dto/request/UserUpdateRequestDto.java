package com.capstone.gooddayserver.domain.user.dto.request;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import java.time.LocalTime;

@Data
@Getter
@Setter
@Builder
public class UserUpdateRequestDto {

    private Long userId;
    private String nickname;
    private String mbti;
    private LocalTime wakeUpTime;
    private LocalTime sleepTime;


}
