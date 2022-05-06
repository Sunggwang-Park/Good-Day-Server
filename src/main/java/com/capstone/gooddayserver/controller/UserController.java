package com.capstone.gooddayserver.controller;


import com.capstone.gooddayserver.domain.user.dto.request.UserJoinRequestDto;
import com.capstone.gooddayserver.domain.user.dto.response.UserInfoResponseDto;
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
    public void join(@ModelAttribute UserJoinRequestDto dto) {
        userService.join(dto);
    }

    @GetMapping("my")
    public UserInfoResponseDto getUserInfo(@RequestBody Long userId) {
        return userService.getUserInfo(userId);
    }
}
