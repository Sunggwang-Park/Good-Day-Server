package com.capstone.gooddayserver.domain.diary.service;

import com.capstone.gooddayserver.domain.diary.dto.request.DiaryCreateRequestDto;
import com.capstone.gooddayserver.domain.diary.dto.request.DiaryUpdateRequestDto;
import com.capstone.gooddayserver.domain.diary.entity.Diary;
import com.capstone.gooddayserver.domain.diary.repository.DiaryRepository;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DiaryServiceTest {

    @Autowired
    private DiaryService diaryService;
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    @Transactional
    public void 일기_수정() throws Exception {
        //given
        User user = User.builder()
                .nickname("성광")
                .mbti("INTJ")
                .sleepTime(LocalTime.parse("22:00"))
                .wakeUpTime(LocalTime.parse("09:00"))
                .build();
        userRepository.save(user);

        Diary diary = Diary.builder()
                .title("오늘의 일기")
                .content("기분이 좋다")
                .date(LocalDate.parse("2022-05-12"))
                .build();
        diaryRepository.save(diary);

        DiaryUpdateRequestDto dto = DiaryUpdateRequestDto.builder()
                .userId(user.getId())
                .title("바뀐 제목")
                .build();


        //when
        diaryService.updateDiaryInfo(diary.getId(), dto, user);



        //then
        Diary diary1 = diaryRepository.findDiaryByUser(user);
        Assertions.assertThat(diary1.getTitle()).isEqualTo(dto.getTitle());




    }

}