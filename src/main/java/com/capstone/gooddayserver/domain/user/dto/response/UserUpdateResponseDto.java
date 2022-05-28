package com.capstone.gooddayserver.domain.user.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class UserUpdateResponseDto {

    String msg;
    Long userId;
    UserInfoResponseDto data;

}