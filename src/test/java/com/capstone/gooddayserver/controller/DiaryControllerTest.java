package com.capstone.gooddayserver.controller;

import com.capstone.gooddayserver.domain.diary.dto.request.DiaryCreateRequestDto;
import com.capstone.gooddayserver.domain.diary.entity.Diary;
import com.capstone.gooddayserver.domain.diary.repository.DiaryRepository;
import com.capstone.gooddayserver.domain.diary.service.DiaryService;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DiaryControllerTest {

//    @Autowired
//    private DiaryService diaryService;
    @Autowired
    private DiaryController diaryController;
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private UserRepository userRepository;
    
    @Test
    public void 일기_저장() throws Exception {
        //given
        User user = User.builder()
                    .nickname("성광")
                    .mbti("INTJ")
                    .sleepTime(LocalTime.parse("22:00"))
                    .wakeUpTime(LocalTime.parse("09:00"))
                    .build();
        userRepository.save(user);

        DiaryCreateRequestDto dto = DiaryCreateRequestDto.builder()
                                    .userId(user.getId())
                                    .title("오늘의 일기")
                                    .content("기분이 좋다")
                                    .date(LocalDate.parse("2022-05-12"))
                                    .location("전남대학교")
                                    .build();

        //when
        diaryController.createDiary(dto);

        //then
        Diary diary = diaryRepository.findDiaryByUser(user);
        Assertions.assertThat(diary.getTitle()).isEqualTo("오늘의 일기");
    }
    
    

}