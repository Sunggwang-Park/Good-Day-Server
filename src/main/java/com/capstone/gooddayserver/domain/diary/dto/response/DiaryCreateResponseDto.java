package com.capstone.gooddayserver.domain.diary.dto.response;

import com.capstone.gooddayserver.domain.diary.dto.request.DiaryCreateRequestDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@Builder
public class DiaryCreateResponseDto {

    String msg;
    Long userId;
    DiaryCreateRequestDto data;

}