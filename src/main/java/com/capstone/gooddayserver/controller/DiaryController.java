package com.capstone.gooddayserver.controller;


import com.capstone.gooddayserver.domain.diary.dto.request.DiaryCreateRequestDto;
import com.capstone.gooddayserver.domain.diary.dto.request.DiaryUpdateRequestDto;
import com.capstone.gooddayserver.domain.diary.dto.response.DiaryCreateResponseDto;
import com.capstone.gooddayserver.domain.diary.dto.response.DiaryInfoResponseDto;
import com.capstone.gooddayserver.domain.diary.dto.response.DiaryUpdateResponseDto;
import com.capstone.gooddayserver.domain.diary.entity.Diary;
import com.capstone.gooddayserver.domain.diary.service.DiaryService;
import com.capstone.gooddayserver.domain.user.dto.request.UserIdRequestDto;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService diaryService;
    private final UserService userService;


    // 일기 작성
    @PostMapping("join")
    @ResponseBody
    public DiaryCreateResponseDto createDiary(@RequestBody DiaryCreateRequestDto dto) {
        //유저 존재 유무 판단
        System.out.println("dto = " + dto);
        User user = userService.getUser(dto.getUserId());

        Diary diary = diaryService.createDiary(dto, user);

        DiaryCreateRequestDto diaryInfoInDB = DiaryCreateRequestDto.builder()
                .userId(user.getId())
                .title(diary.getTitle())
                .content(diary.getContent())
                .imgUrl(diary.getImgUrl())
                .date(diary.getDate())
                .build();

        DiaryCreateResponseDto responseDto = DiaryCreateResponseDto.builder()
                .msg("success")
                .userId(user.getId())
                .data(diaryInfoInDB)
                .build();

        System.out.println("responseDto = " + responseDto);

        return responseDto;

    }



    // 일기 조회
    @GetMapping("{diaryId}")
    public DiaryInfoResponseDto getDiaryInfo(@PathVariable("diaryId") Long diaryId, @RequestBody UserIdRequestDto dto) {

        User user = userService.getUser(dto.getUserId());
        return diaryService.getDiary(diaryId, user);

    }



    // 일기 수정
    @PatchMapping("{diaryId}")
    @ResponseBody
    public DiaryUpdateResponseDto updateDiaryInfo(@PathVariable("diaryId") Long diaryId, @RequestBody DiaryUpdateRequestDto dto) {

        System.out.println("dto = " + dto);
        User user = userService.getUser(dto.getUserId());

        diaryService.updateDiaryInfo(diaryId, dto, user);

        DiaryInfoResponseDto diaryInfo = diaryService.getDiary(diaryId, user);

        DiaryUpdateResponseDto responseDto = DiaryUpdateResponseDto.builder()
                .msg("success")
                .userId(user.getId())
                .data(diaryInfo)
                .build();

        System.out.println("responseDto = " + responseDto);

        return responseDto;

    }

}
