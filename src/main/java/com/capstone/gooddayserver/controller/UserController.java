package com.capstone.gooddayserver.controller;

import com.capstone.gooddayserver.domain.user.dto.request.UserIdRequestDto;
import com.capstone.gooddayserver.domain.user.dto.request.UserJoinRequestDto;
import com.capstone.gooddayserver.domain.user.dto.request.UserUpdateRequestDto;
import com.capstone.gooddayserver.domain.user.dto.response.UserInfoResponseDto;
import com.capstone.gooddayserver.domain.user.dto.response.UserJoinResponseDto;
import com.capstone.gooddayserver.domain.user.dto.response.UserUpdateResponseDto;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;


    // 회원 가입
    @PostMapping("join")
    @ResponseBody
    public UserJoinResponseDto join(@RequestBody UserJoinRequestDto dto) {

        User user = userService.join(dto);
        UserJoinRequestDto userInfoInDB = UserJoinRequestDto.builder()
                .nickname(user.getNickname())
                .mbti(user.getMbti())
                .wakeUpTime(user.getWakeUpTime())
                .sleepTime(user.getSleepTime())
                .build();

        UserJoinResponseDto responseDto = UserJoinResponseDto.builder()
                .msg("success")
                .userId(user.getId())
                .data(userInfoInDB)
                .build();


        return responseDto;

    }



    // 회원 정보 조회
    @GetMapping("my")
    public UserInfoResponseDto getUserInfo(@RequestBody UserIdRequestDto dto) {

        System.out.println("UserController.getUserInfo");
        return userService.getUserInfo(dto.getUserId());

    }



    // 회원 정보 수정
    @PatchMapping("update")
    @ResponseBody
    public UserUpdateResponseDto updateUserInfo(@RequestBody UserUpdateRequestDto dto) {

        userService.updateInfo(dto);
        System.out.println("dto = " + dto);

        UserInfoResponseDto userInfo = userService.getUserInfo(dto.getUserId());

        UserUpdateResponseDto responseDto = UserUpdateResponseDto.builder()
                .msg("success")
                .userId(dto.getUserId())
                .data(userInfo)
                .build();

        System.out.println("responseDto = " + responseDto);

        return responseDto;

    }
}
