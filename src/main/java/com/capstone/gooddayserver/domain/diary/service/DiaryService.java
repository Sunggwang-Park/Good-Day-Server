package com.capstone.gooddayserver.domain.diary.service;


import com.capstone.gooddayserver.domain.diary.dto.request.DiaryCreateRequestDto;
import com.capstone.gooddayserver.domain.diary.dto.request.DiaryUpdateRequestDto;
import com.capstone.gooddayserver.domain.diary.dto.response.DiaryInfoResponseDto;
import com.capstone.gooddayserver.domain.diary.entity.Diary;
import com.capstone.gooddayserver.domain.diary.repository.DiaryRepository;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.repository.UserRepository;
import com.capstone.gooddayserver.exception.CustomException;
import com.capstone.gooddayserver.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DiaryService {

    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;


    @PostMapping
    @Transactional
    public Diary createDiary(DiaryCreateRequestDto dto, User user) {

        Diary diary = Diary.builder()
                .user(user)
                .content(dto.getContent())
                .title(dto.getTitle())
                .imgUrl(dto.getImgUrl())
                .date(dto.getDate())
                .isSuccess(dto.getIsSuccess())
                .location(dto.getLocation())
                .sumScore(dto.getSumScore())
                .build();

        return diaryRepository.save(diary);

    }



    public DiaryInfoResponseDto getDiary(Long diaryId, User user) {
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_DIARY, "diaryId : " + diaryId);
                });

        //일기를 쓴 유저가 아니면 예외
        if (!diary.getUser().equals(user)) {
            throw new CustomException(ErrorCode.DIARY_ACCESS_DENY, "diaryId : " + diaryId + " userId : " + user.getId());
        }

        return DiaryInfoResponseDto.toDto(diary);

    }




    @Transactional
    public void updateDiaryInfo(Long diaryId, DiaryUpdateRequestDto dto, User user) {
        Diary diary = diaryRepository.findById(diaryId)
                .orElseThrow(() -> {
                    throw new CustomException(ErrorCode.NOT_FOUND_DIARY, "diaryId : " + diaryId);
                });

        //일기를 쓴 유저가 아니면 예외
        if (!diary.getUser().equals(user)) {
            throw new CustomException(ErrorCode.DIARY_ACCESS_DENY, "diaryId : " + diaryId + " userId : " + user.getId());
        }

        diary.update(dto);
    }

}
