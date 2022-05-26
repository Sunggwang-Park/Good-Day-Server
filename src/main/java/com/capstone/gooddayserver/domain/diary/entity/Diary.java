package com.capstone.gooddayserver.domain.diary.entity;


import com.capstone.gooddayserver.configure.entity.BaseTimeEntity;
import com.capstone.gooddayserver.domain.diary.dto.request.DiaryUpdateRequestDto;
import com.capstone.gooddayserver.domain.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Table(name = "diary")
public class Diary extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "diaryId")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    private String title;

    private String content;

    private String imgUrl;

    private Boolean isSuccess;

    private Integer sumScore;

    private LocalDate date; //일기 날짜

    private String location; //지역


    public void update(DiaryUpdateRequestDto dto) {
        if (dto.getTitle() != null) {
            this.title = dto.getTitle();
        }
        if (dto.getContent() != null) {
            this.content = dto.getContent();
        }
        if (dto.getImgUrl() != null) {
            this.imgUrl = dto.getImgUrl();
        }
        if (dto.getDate() != null) {
            this.date = dto.getDate();
        }
        if (dto.getLocation() != null) {
            this.location = dto.getLocation();
        }
    }


}
