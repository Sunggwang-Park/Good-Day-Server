package com.capstone.gooddayserver.domain.user.dto.response;

import com.capstone.gooddayserver.domain.user.dto.request.UserJoinRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserJoinResponseDto {

    String msg;
    Long userId;
    UserJoinRequestDto data;

}
