package com.capstone.gooddayserver.controller;


import com.capstone.gooddayserver.domain.user.dto.request.UserIdRequestDto;
import com.capstone.gooddayserver.domain.user.dto.request.UserJoinRequestDto;
import com.capstone.gooddayserver.domain.user.dto.request.UserUpdateRequestDto;
import com.capstone.gooddayserver.domain.user.dto.response.UserInfoResponseDto;
import com.capstone.gooddayserver.domain.user.dto.response.UserJoinResponseDto;
import com.capstone.gooddayserver.domain.user.entity.User;
import com.capstone.gooddayserver.domain.user.repository.UserRepository;
import com.capstone.gooddayserver.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")

public class UserController {

    private final UserService userService;

    @PostMapping("join")
    public UserJoinResponseDto join(@RequestBody UserJoinRequestDto dto) {

        User user = userService.join(dto);
//        UserJoinRequestDto userInfoInDB = UserJoinRequestDto.builder()
//                .nickname(user.getNickname())
//                .mbti(user.getMbti())
//                .wakeUpTime(user.getWakeUpTime())
//                .sleepTime(user.getSleepTime())
//                .build();

        UserJoinResponseDto responseDto = UserJoinResponseDto.builder()
                .msg("success")
                .userId(user.getId())
                .data(dto)
                .build();


        return responseDto;
    }

    @GetMapping("my")
    public UserInfoResponseDto getUserInfo(@RequestBody UserIdRequestDto dto) {
        System.out.println("UserController.getUserInfo");
        return userService.getUserInfo(dto.getUserId());
    }

    @PatchMapping("update")
    public void updateUserInfo(@RequestBody UserUpdateRequestDto dto) {
        userService.updateInfo(dto);
        System.out.println("dto = " + dto);
    }
}
