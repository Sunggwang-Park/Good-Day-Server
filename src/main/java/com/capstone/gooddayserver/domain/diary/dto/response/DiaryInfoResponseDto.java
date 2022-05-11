package com.capstone.gooddayserver.domain.diary.dto.response;

import com.capstone.gooddayserver.domain.diary.entity.Diary;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Getter
@Setter
@Builder
public class DiaryInfoResponseDto {
    private Long diaryId;
    private String title;
    private String content;
    private String imgUrl;
    private LocalDate date;
    private Boolean isSuccess;
    private String location; //지역
    private Integer sumScore;

    public static DiaryInfoResponseDto toDto(Diary diary) {
        return DiaryInfoResponseDto.builder()
                .diaryId(diary.getId())
                .title(diary.getTitle())
                .content(diary.getContent())
                .imgUrl(diary.getImgUrl())
                .date(diary.getDate())
                .isSuccess(diary.getIsSuccess())
                .location(diary.getLocation())
                .sumScore(diary.getSumScore())
                .build();
    }

}
