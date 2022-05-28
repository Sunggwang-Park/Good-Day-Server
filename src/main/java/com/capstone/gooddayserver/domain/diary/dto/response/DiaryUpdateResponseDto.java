package com.capstone.gooddayserver.domain.diary.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class DiaryUpdateResponseDto {

    String msg;
    Long userId;
    DiaryInfoResponseDto data;

}