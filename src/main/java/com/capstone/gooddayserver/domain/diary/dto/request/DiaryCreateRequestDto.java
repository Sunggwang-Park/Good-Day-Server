package com.capstone.gooddayserver.domain.diary.dto.request;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class DiaryCreateRequestDto {

    private Long userId;
    private String title;
    private String content;
    private String imgUrl;
    private LocalDate date;
    private Boolean isSuccess;
    private String location; //지역
    private Integer sumScore;


}
